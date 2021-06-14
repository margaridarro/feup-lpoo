package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.model.elements.Element;

public class WallViewer implements ElementViewer {
    public void drawElement(Element wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
