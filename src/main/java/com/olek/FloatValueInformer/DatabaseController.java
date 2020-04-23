package com.olek.FloatValueInformer;

import com.olek.FloatValueInformer.gui.FormEvent;
import com.olek.FloatValueInformer.model.Item;

import java.util.List;

public class DatabaseController {

    private Database db;

    public DatabaseController() {
        db = new Database();
    }

    public List<Item> getItems() {
        return db.getItemList();
    }

    public void addItem(FormEvent ev) {
        String url = ev.getUrl();
        float fv = ev.getFloatValue();

        db.save(new Item(url, fv));
    }
}
