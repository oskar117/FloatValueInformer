package com.olek.FloatValueInformer.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MarketPage {

    private WebDriver driver;
    private String name;

    public MarketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public boolean isFloatReached(float val) {
        List<WebElement> elementList = driver.findElements(By.className("floatDropTarget"));

        for(WebElement element : elementList) {
            System.out.println(Float.parseFloat(element.getText()) + " : " + val);
            if (Float.parseFloat(element.getText()) <= val) return true;
        }

        return false;
    }

    public void getFloat() {
        List<WebElement> test = driver.findElements(By.className("floatDropTarget"));

        for(WebElement x : test) {
            System.out.println("Float: " + x.getText());
        }
    }
}
