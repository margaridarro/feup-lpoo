package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Element;
import com.g74.rollersplat.viewer.gui.GUI;

public class FloorViewer implements ElementViewer {
    @Override
    public void drawElement(Element Floor, GUI gui) {
        gui.drawFloor(Floor.getPosition()); //add color parameter later?
    }
}
