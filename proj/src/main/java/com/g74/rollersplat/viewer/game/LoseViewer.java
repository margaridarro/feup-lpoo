package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class LoseViewer {
    private GUI gui;

    public LoseViewer(GUI gui) throws IOException {
        this.gui = gui;
    }
    public void draw() throws IOException {
        gui.clear();
        String lose = "YOU LOSE";
        String color = "#FF6347";
        Position pos = new Position(19, 10);
        gui.drawBackground();
        gui.drawGivenChar(pos, color, lose);
        gui.refresh();
    }
}
