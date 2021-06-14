package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class WinViewer {
    private GUI gui;

    public WinViewer(GUI gui) throws IOException {
        this.gui = gui;
    }
    public void draw() throws IOException {
        gui.clear();
        String win = "LEVEL COMPLETE";
        String color = "#FF6347";
        Position pos = new Position(19, 10);
        gui.drawBackground();
        gui.drawGivenChar(pos, color, win);
        /*
        for(int i = 0; i < win.length(); i++){
            char c = win.charAt(i);
            Position pos = new Position(6, 7);
            gui.drawGivenChar(pos, color, c);
        }
        */
        gui.refresh();
    }

}
