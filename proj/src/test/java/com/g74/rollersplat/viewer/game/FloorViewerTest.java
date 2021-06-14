package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Floor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

public class FloorViewerTest {
    private Floor floor;
    private FloorViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        floor = new Floor(5,5);
        viewer = new FloorViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(floor, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFloor(floor.getPosition());
    }
}
