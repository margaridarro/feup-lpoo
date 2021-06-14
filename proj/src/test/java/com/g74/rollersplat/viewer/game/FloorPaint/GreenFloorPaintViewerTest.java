package com.g74.rollersplat.viewer.game.FloorPaint;

import com.g74.rollersplat.model.elements.FloorPaint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

public class GreenFloorPaintViewerTest {
    private FloorPaint floorPaint;
    private GreenFloorPaintViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        floorPaint = new FloorPaint(5,5);
        viewer = new GreenFloorPaintViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(floorPaint, gui);
        Mockito.verify(gui, Mockito.times(1)).drawGreenFloorPaint(floorPaint.getPosition());
    }
}
