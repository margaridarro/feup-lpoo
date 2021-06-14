package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

public class PlayerViewerTest {
    private Player player;
    private PlayerViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        player = new Player(5,5);
        viewer = new PlayerViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(player, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(player.getPosition());
    }
}
