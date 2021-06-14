package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.viewer.game.WinViewer;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class WinningState extends State {
    WinViewer viewer;
    GUI gui;
    public WinningState(GUI gui) throws IOException {
        super(gui);
        this.gui = gui;
        this.viewer = new WinViewer(gui);
    }

    @Override
    public int run(StateController game) throws IOException, InterruptedException {
        this.viewer.draw();
        game.setLevelNum(game.getLevelNum() + 1);
        Thread.sleep(2000);
        GUI.POSITION pos = GUI.POSITION.NONE;
        return setState(pos, game);
    }

    @Override
    protected int setState(GUI.POSITION pos, StateController game) {
        if (game.getLevelNum() == 4) {
            game.setLevelNum(1);
            game.setState(new MenuState(gui, new Menu()));
            return -1;
        }
        game.setState(new PlayingState(game.getLevelNum(), gui, game.getModeNum(), game.getChosenColor()));
        return 0;
    }
}
