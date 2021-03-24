package com.ramilaiv.tomiatesttasktesteditor.service;

import java.awt.*;


public class MyLabel extends Label implements Changeable {

    public MyLabel()  {
        super();
    }

    public MyLabel(String string) {
        super(string);
    }

    @Override
    public Label undo() {
        return this;
    }

    @Override
    public Label redo() {
        return this;
    }

    @Override
    public Label getLabel() {
        return this;
    }
}
