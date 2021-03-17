package com.ramilaiv.tomiatesttasktesteditor.service;

import java.awt.*;

public interface Changeable {

    Label undo();

    Label redo();

    Label getLabel();
}
