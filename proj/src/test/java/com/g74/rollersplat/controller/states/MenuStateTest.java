package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.viewer.gui.GUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class MenuStateTest {
    private GUI gui;
    private StateController controller;
    private Menu menu;
    private MenuState menuState;

    @BeforeEach
    void setUp() throws IOException {
        gui = Mockito.mock(GUI.class);
        controller = new StateController(gui);
        menu = new Menu();
        menuState = new MenuState(gui, menu);
    }

    @Test
    void setState(){
        int result = menuState.setState(GUI.POSITION.NONE, controller);
        assertEquals(0, result);
        assertTrue(controller.getState() instanceof PlayingState);
        assertEquals(0, controller.getModeNum());

        menu.nextEntry();

        result =  menuState.setState(GUI.POSITION.NONE, controller);
        assertEquals(1, result);
        assertTrue(controller.getState() instanceof PlayingState);
        assertEquals(1, controller.getModeNum());

        menu.nextEntry();

        result =  menuState.setState(GUI.POSITION.NONE, controller);
        assertEquals(2, result);
        assertTrue(controller.getState() instanceof PlayingState);
        assertEquals(2, controller.getModeNum());
    }

    @Test
    void setColor(){
        int result = menuState.setColor(controller);

        assertEquals(10, result);
        assertTrue(controller.getState() instanceof MenuState);

        menu.nextColorEntry();

        result = menuState.setColor( controller);
        assertEquals(11, result);
        assertTrue(controller.getState() instanceof MenuState);

        menu.nextColorEntry();

        result = menuState.setColor( controller);
        assertEquals(12, result);
        assertTrue(controller.getState() instanceof MenuState);

        menu.nextColorEntry();

        result = menuState.setColor( controller);
        assertEquals(13, result);
        assertTrue(controller.getState() instanceof MenuState);

        menu.nextColorEntry();

        result = menuState.setColor( controller);
        assertEquals(14, result);
        assertTrue(controller.getState() instanceof MenuState);
    }

    @Test
    void setLevel() {
        int result = menuState.setLevel(controller);
        assertEquals(20, result);
        assertEquals(1, controller.getLevelNum());

        menu.nextLevelEntry();

        result = menuState.setLevel(controller);
        assertEquals(21, result);
        assertEquals(2, controller.getLevelNum());

        menu.nextLevelEntry();

        result = menuState.setLevel(controller);
        assertEquals(22, result);
        assertEquals(3, controller.getLevelNum());
    }
}
