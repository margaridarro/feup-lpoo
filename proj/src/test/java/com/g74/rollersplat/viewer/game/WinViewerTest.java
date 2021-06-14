package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class WinViewerTest {
    private WinViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(GUI.class);
        viewer = new WinViewer(gui);
    }

    @Test
    void draw() throws IOException {
        String win = "LEVEL COMPLETE";
        String color = "#FF6347";
        Position pos = new Position(19, 10);

        viewer.draw();
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).drawBackground();
        Mockito.verify(gui, Mockito.times(1)).drawGivenChar(pos, color, win);
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
