package com.olek.FloatValueInformer.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.olek.FloatValueInformer.DatabaseController;
import com.olek.FloatValueInformer.web.MarketPage;
import com.olek.FloatValueInformer.web.PageHandler;

public class TrayPopup extends PopupMenu {

    private ShowButtonListener listener;

    public TrayPopup() {

        MenuItem showItem = new MenuItem("Show");
        MenuItem getItem = new MenuItem("Get");
        MenuItem exitItem = new MenuItem("Exit");

        showItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listener.showGui();
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
                listener.startWatch();
                /*DatabaseController db = new DatabaseController();
                PageHandler ph = new PageHandler(db.getItems());
                ph.watch();*/
            }
        });

        add(showItem);
        add(getItem);
        add(exitItem);
    }

    public void setShowButtonListener(ShowButtonListener listener) {
        this.listener = listener;
    }
}
