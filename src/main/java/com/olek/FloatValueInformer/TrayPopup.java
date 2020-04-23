package com.olek.FloatValueInformer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrayPopup extends PopupMenu {

    private MainFrame rak;

    public TrayPopup(MainFrame mainFrame) {

        //TODO tak być nie może
        rak = mainFrame;

        MenuItem showItem = new MenuItem("Show");
        MenuItem getItem = new MenuItem("Get");
        MenuItem exitItem = new MenuItem("Exit");

        showItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rak.setVisible();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        getItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MarketPage page = new MarketPage(MainFrame.driver);
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

        add(showItem);
        add(getItem);
        add(exitItem);
    }
}
