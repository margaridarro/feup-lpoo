package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.model.elements.Element;

public interface ElementViewer {
    public void drawElement(Element element, GUI gui);
}
