package com.olek.FloatValueInformer.web;

import com.olek.FloatValueInformer.gui.MainFrame;
import com.olek.FloatValueInformer.model.Item;
import org.openqa.selenium.WebDriver;

import javax.swing.*;
import java.util.List;

public class PageHandler {

    //private WebDriver driver;
   // private List<MarketPage> pages;
    private List<Item> items;

    public PageHandler(List<Item> items) {
        this.items = items;
    }

    public void watch() {

        boolean keepRunning = true;
        MarketPage page = new MarketPage(MainFrame.driver);

        while (keepRunning) {

            for(Item x : items) {
                page.open(x.getUrl());

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (page.isFloatReached(x.getFloatValue())) {
                    JOptionPane.showMessageDialog(null, "Znaleziono item w" + x.getUrl(), "O!", JOptionPane.WARNING_MESSAGE);
                    keepRunning = false;
                    break;
                }
                System.out.println("Done");
            }
        }

    }

}
