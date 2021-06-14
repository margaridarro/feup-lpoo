package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

public class WallViewerTest {
    private Wall wall;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new Wall(5,5);
        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}
