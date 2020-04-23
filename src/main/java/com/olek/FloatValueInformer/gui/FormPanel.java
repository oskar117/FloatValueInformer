package com.olek.FloatValueInformer.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JButton add;
    private JTextField link;
    private JTextField desiredFloatValue;

    private FormListener formListener;

    public FormPanel() {
        setLayout(new GridLayout());

        add = new JButton("Dodaj");
        link = new JTextField();
        desiredFloatValue = new JTextField(6);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FormEvent ev = new FormEvent(this, link.getText(), Float.parseFloat(desiredFloatValue.getText()));

                if(formListener != null) {
                    formListener.formSent(ev);
                }

            }
        });

        add(link);
        add(desiredFloatValue);
        add(add);

    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }
}
