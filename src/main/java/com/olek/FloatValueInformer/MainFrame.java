package com.olek.FloatValueInformer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainFrame extends JFrame {

    public static final int WIDTH = 380;
    public static final int HEIGHT = 240;
    public static WebDriver driver;

    private DatabaseController databaseController;

    private SystemTray tray;
    private TrayPopup popup;
    private ItemList itemList;
    private FormPanel formPanel;

    public MainFrame() {
        super("FVI by Olek");
        setLayout(new BorderLayout());
        setSize(WIDTH, HEIGHT);

        popup = new TrayPopup(this);
        initFrame();

        itemList = new ItemList();
        formPanel = new FormPanel();
        databaseController = new DatabaseController();

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formSent(FormEvent e) {
                databaseController.addItem(e);
                itemList.setData(databaseController.getItems());
            }
        });

        add(itemList, BorderLayout.CENTER);
        add(formPanel, BorderLayout.PAGE_END);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setResizable(false);
        setVisible(false);
    }

    private void initFrame() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }

        tray = SystemTray.getSystemTray();

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("extension.crx"));
        //options.addArguments("--headless");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Image image = Toolkit.getDefaultToolkit().getImage("icon.png");
        final TrayIcon trayIcon = new TrayIcon(image, "Float Informer", popup);
        trayIcon.setImageAutoSize(true);
        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
    }

    public void setVisible() {
        this.setVisible(true);
    }
}
