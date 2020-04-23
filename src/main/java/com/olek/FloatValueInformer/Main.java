package com.olek.FloatValueInformer;

import com.olek.FloatValueInformer.gui.MainFrame;

import javax.swing.*;

public class Main {

    //public static WebDriver driver;

    public static void main (String [] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });

        /*if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        Image image = Toolkit.getDefaultToolkit().getImage("icon.png");

        final PopupMenu popup = new PopupMenu();
        final TrayIcon trayIcon = new TrayIcon(image, "Float Informer", popup);
        trayIcon.setImageAutoSize(true);
        final SystemTray tray = SystemTray.getSystemTray();

        MenuItem getItem = new MenuItem("GET");
        MenuItem exitItem = new MenuItem("Exit");

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("extension.crx"));
        //options.addArguments("--headless");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        getItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MarketPage page = new MarketPage(driver);
                page.open("https://steamcommunity.com/market/listings/730/AK-47%20%7C%20Redline%20%28Field-Tested%29");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                page.getFloat();
                //JOptionPane.showConfirmDialog(null, "twoja stara");
                System.out.println("Done");
            }
        });

        popup.add(exitItem);
        popup.add(getItem);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
        }
*/
    }
}
