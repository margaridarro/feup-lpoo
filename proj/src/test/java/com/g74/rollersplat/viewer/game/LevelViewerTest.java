package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.level.Level;
import com.g74.rollersplat.viewer.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LevelViewerTest {
    private LevelViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        viewer = new LevelViewer(gui);
    }

    /*@Test
    void draw() throws IOException {
        viewer.draw(new Level());


    }*/
}
