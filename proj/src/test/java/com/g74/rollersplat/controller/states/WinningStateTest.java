package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.viewer.game.WinViewer;
import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.viewer.gui.LanternaGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class WinningStateTest {
    private GUI gui;
    private StateController controller;
    private WinningState winstate;
    private WinViewer viewer;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(GUI.class);
        controller = new StateController(gui);
        winstate = new WinningState(gui);
        viewer = new WinViewer(gui);
    }

    @Test
    void run() throws IOException, InterruptedException {
        int result =winstate.run(controller);

        assertEquals(2,controller.getLevelNum());
        assertEquals(0, result);

        result = winstate.run(controller);

        assertEquals(3, controller.getLevelNum());
        assertEquals(0, result);

    }

    @Test
    void setState() {
        controller.setLevelNum(1);

        winstate.setState(GUI.POSITION.NONE, controller);

        assertTrue(controller.getState() instanceof PlayingState);

        controller.setLevelNum(controller.getLevelCount()+1);

        winstate.setState(GUI.POSITION.NONE, controller);

        assertTrue(controller.getState() instanceof MenuState);
    }

}
