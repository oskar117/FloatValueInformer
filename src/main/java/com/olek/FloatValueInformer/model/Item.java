package com.olek.FloatValueInformer.model;

public class Item {

    private String url;
    private float floatValue;

    public Item(String url, float floatValue) {
        this.url = url;
        this.floatValue = floatValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "url='" + url + '\'' +
                ", floatValue=" + floatValue +
                '}';
    }
}
