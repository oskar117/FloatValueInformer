package com.olek.FloatValueInformer.gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String url;
    private float floatValue;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String url, float floatValue) {
        super(source);
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
}
