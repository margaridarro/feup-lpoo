package com.g74.rollersplat.viewer.menu;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class MenuViewer{
    private GUI gui;
    public MenuViewer(GUI gui) {this.gui = gui;}

    public void drawElements(Menu menu, boolean isColorSelected, boolean isLevelsSelected) throws IOException {
        gui.clear();
        gui.drawBackground();
        gui.drawGivenChar(new Position(5,5), "green", "ROLLERSPLAT");

        if (isColorSelected) {
            for (int i = 0; i < menu.getNumberColorEntries(); i++) {
                gui.drawGivenChar(new Position(5, 7 + i), menu.isSelected2(i) ? "#FF69B4" : "blue",
                        menu.getColorEntry(i));
            }
        }

        if (isLevelsSelected) {
            for (int i = 0; i < menu.getNumberLevelEntries(); i++) {
                gui.drawGivenChar(new Position(5, 7 + i), menu.isSelected3(i) ? "#FF69B4" : "blue",
                        menu.getLevelEntry(i));
            }
        }

        if (!isColorSelected && !isLevelsSelected) {
            for (int i = 0; i < menu.getNumberEntries(); i++) {
                gui.drawGivenChar(new Position(5, 7 + i), menu.isSelected(i) ? "#FF69B4" : "blue",
                        menu.getEntry(i));
            }
        }

        gui.refresh();
    }

}
