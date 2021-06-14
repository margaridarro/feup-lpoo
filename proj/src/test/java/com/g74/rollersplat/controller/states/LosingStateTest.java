package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.viewer.game.WinViewer;
import com.g74.rollersplat.viewer.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LosingStateTest {

    private GUI gui;
    private StateController controller;
    private LosingState losestate;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(GUI.class);
        controller = new StateController(gui);
        losestate = new LosingState(gui);
    }

    @Test
    void run() throws IOException, InterruptedException {
        int result =losestate.run(controller);

        assertEquals(1,controller.getLevelNum());
        assertEquals(0, result);

        result = losestate.run(controller);

        assertEquals(1,controller.getLevelNum());
        assertEquals(0, result);
    }

    @Test
    void setState(){
        losestate.setState(GUI.POSITION.NONE, controller);
        assertTrue(controller.getState() instanceof PlayingState);
    }
}
