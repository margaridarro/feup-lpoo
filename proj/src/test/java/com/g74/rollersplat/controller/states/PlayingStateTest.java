package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.viewer.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class PlayingStateTest {
    private GUI gui;
    private StateController controller;
    private PlayingState playingState;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        controller = new StateController(gui);
        playingState = new PlayingState(1,gui,0,10);
    }

    @Test
    void setState() {
        int result = playingState.setState(GUI.POSITION.NONE, controller);
        assertEquals(0, result);

        result = playingState.setState(GUI.POSITION.RESET, controller);
        assertEquals(0, result);

        result = playingState.setState(GUI.POSITION.QUIT, controller);
        assertEquals(-1, result);
        assertTrue(controller.getState() instanceof MenuState);

    }

}
