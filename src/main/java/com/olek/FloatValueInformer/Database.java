package com.olek.FloatValueInformer;

import com.olek.FloatValueInformer.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Item> itemList;

    public Database() {
        this.itemList = new ArrayList<Item>();
    }

    public void save(Item item) {
        itemList.add(item);
        System.out.println(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
