package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.viewer.game.LoseViewer;
import com.g74.rollersplat.viewer.game.WinViewer;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class LosingState  extends State{
    LoseViewer viewer;
    GUI gui;
    public LosingState(GUI gui) throws IOException {
        super(gui);
        this.gui = gui;
        this.viewer = new LoseViewer(gui);
    }

    @Override
    public int run(StateController game) throws IOException, InterruptedException {
        this.viewer.draw();
        Thread.sleep(2000);
        GUI.POSITION pos = GUI.POSITION.NONE;
        return setState(pos, game);
    }

    @Override
    protected int setState(GUI.POSITION pos, StateController game) {
        game.setState(new PlayingState(game.getLevelNum(), gui, game.getModeNum(), game.getChosenColor()));
        return 0;
    }
}
