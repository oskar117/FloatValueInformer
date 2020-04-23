package com.olek.FloatValueInformer;

import com.olek.FloatValueInformer.model.Item;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ItemList extends JPanel {

    private List<Item> data;
    private JList list;

    public ItemList() {
        setLayout(new BorderLayout());
        list = new JList();
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("nic tu nie ma");
        list.setModel(listModel);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        add(listScrollPane);
    }

    public void setData(List<Item> items) {
        DefaultListModel listModel = new DefaultListModel();

        for(Item x : items) {
            listModel.addElement(x.getUrl());
        }

        list.setModel(listModel);
    }
}
