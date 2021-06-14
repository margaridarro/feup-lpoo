package com.g74.rollersplat.viewer.menu;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class MenuViewerTest {
    private MenuViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        viewer = new MenuViewer(gui);
    }

    @Test
    void drawElements() throws IOException {
        Menu menu = new Menu();

        Position pos = new Position(5, 5);
        String color = "green";
        String title = "ROLLERSPLAT";

        viewer.drawElements(new Menu(), false, false);


        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).drawBackground();
        Mockito.verify(gui, Mockito.times(1)).drawGivenChar(pos, color, title);

        for (int i = 0; i < menu.getNumberEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawGivenChar(new Position(5, 7 + i), menu.isSelected(i) ? "#FF69B4" : "blue", menu.getEntry(i));
        }

    }

    @Test
    void drawElementsColor() throws IOException {
        Menu menu = new Menu();

        Position pos = new Position(5, 5);
        String color = "green";
        String title = "ROLLERSPLAT";

        viewer.drawElements(new Menu(), true, false);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).drawBackground();
        Mockito.verify(gui, Mockito.times(1)).drawGivenChar(pos, color, title);

        for (int i = 0; i < menu.getNumberColorEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawGivenChar(new Position(5, 7 + i), menu.isSelected2(i) ? "#FF69B4" : "blue", menu.getColorEntry(i));
        }
    }

    @Test
    void drawElementsLevels() throws IOException {
        Menu menu = new Menu();

        Position pos = new Position(5, 5);
        String color = "green";
        String title = "ROLLERSPLAT";

        viewer.drawElements(new Menu(), false, true);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).drawBackground();
        Mockito.verify(gui, Mockito.times(1)).drawGivenChar(pos, color, title);

        for (int i = 0; i < menu.getNumberLevelEntries(); i++) {
            Mockito.verify(gui, Mockito.times(1)).drawGivenChar(new Position(5, 7 + i), menu.isSelected3(i) ? "#FF69B4" : "blue", menu.getLevelEntry(i));
        }
    }
}
