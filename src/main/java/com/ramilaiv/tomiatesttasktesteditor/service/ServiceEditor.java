package com.ramilaiv.tomiatesttasktesteditor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceEditor {

    @Autowired
    ChangeManager manager;

    public void add(String string) {
        manager.addChangeable(new MyLabel(manager.getChangable().getLabel().getText().concat(string)));
    }

    public void addWithPosition(String s, int position) {
        StringBuilder stringBuilder = new StringBuilder(manager.getChangable().getLabel()
            .getText());
        if (position > stringBuilder.length())
            position = stringBuilder.length();
        stringBuilder.insert(position, s);
         manager.addChangeable(new MyLabel(stringBuilder.toString()));
    }

    public void remove(int fromPosition, int toPosition) {
        StringBuilder stringBuilder = new StringBuilder(manager.getChangable().getLabel()
            .getText()).delete(fromPosition, toPosition);
         manager.addChangeable(new MyLabel(stringBuilder.toString()));
    }

    public void italic() {
        StringBuilder stringBuilder = new StringBuilder(manager.getChangable().getLabel()
            .getText());
        MyLabel label = new MyLabel();
        label.setText(stringBuilder.toString());
        label.setFont(new Font("TimesRoman", Font.ITALIC, 18));
        manager.addChangeable(label);
    }

    public void bold() {
        StringBuilder stringBuilder = new StringBuilder(manager.getChangable().getLabel()
            .getText());
        MyLabel label = new MyLabel();
        label.setText(stringBuilder.toString());
        label.setFont(new Font("TimesRoman", Font.BOLD, 18));
        manager.addChangeable(label);
    }

    public void underline() {
        StringBuilder stringBuilder = new StringBuilder(manager.getChangable().getLabel()
            .getText());
        Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
        fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        MyLabel label = new MyLabel();
        label.setText(stringBuilder.toString());
        label.setFont(new Font("TimesRoman", Font.PLAIN, 18).deriveFont(fontAttributes));
        manager.addChangeable(label);
    }

    public void redo() {
         manager.redo();
    }

    public void undo() {
         manager.undo();
    }

    public void print() {
        JFrame frame = new JFrame("Text Editor");
        frame.setVisible(true);
        frame.setSize(420, 240);
        frame.add((Component) manager.getChangable());
    }
}
