package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.viewer.menu.MenuViewer;

import java.io.IOException;

public class MenuState extends State{
    private final GUI gui;
    private final Menu menu;
    private MenuViewer viewer;
    public MenuState (GUI gui, Menu menu) {super(gui); this.gui = gui; this.menu = menu;}

    @Override
    public int run(StateController game) throws IOException {
        this.viewer = new MenuViewer(this.gui);
        //this.com.g74.rollersplat.viewer.drawElements(this.menu, false);
        while (true) {
            this.viewer.drawElements(this.menu, false, false);
            GUI.POSITION pos = this.gui.getNextPosition();
            switch (pos) {
                case UP:
                    menu.previousEntry();
                    break;
                case DOWN:
                    menu.nextEntry();
                    break;
                case SELECT:
                    if (menu.isSelectedExit()) return -2;

                    if (menu.isSelectedInvisible() || menu.isSelectedNormal() || menu.isSelectedNoRepeat())
                        return setState(pos, game);

                    if (menu.isSelectedColor())
                        return selectColors(pos, game);

                    if (menu.isSelectedLevels())
                        return selectLevels(pos, game);

            }
        }
    }

    @Override
    protected int setState(GUI.POSITION pos, StateController game) {
        if (menu.isSelectedNormal()) {
            game.setState(new PlayingState(game.getLevelNum(), gui, 0, game.getChosenColor()));
            game.setModeNum(0);
            return 0;
        }

        if (menu.isSelectedInvisible()) {
            game.setState(new PlayingState(game.getLevelNum(), gui, 1, 1));
            game.setModeNum(1);
            return 1;
        }

        if (menu.isSelectedNoRepeat()) {
            game.setState(new PlayingState(game.getLevelNum(), gui, 2,  game.getChosenColor()));
            game.setModeNum(2);
            return 2;
        }
        return -1;
    }

    protected int setColor(StateController game){
        game.setState(new MenuState(gui, new Menu()));

        if (menu.isSelectedBrown()) return 14;

        if (menu.isSelectedYellow()) return 13;

        if (menu.isSelectedGreen()) return 12;

        if (menu.isSelectedCyan()) return 11;

        if (menu.isSelectedPink()) return 10;

        return 0;
    }

    protected int setLevel(StateController game){
        if (menu.isSelectedLevel3()) {
            game.setLevelNum(3);
            return 22;
        }
        if (menu.isSelectedLevel2()) {
            game.setLevelNum(2);
            return 21;
        }
        if (menu.isSelectedLevel1()) {
            game.setLevelNum(1);
            return 20;
        }
        return 0;
    }

    private int selectLevels(GUI.POSITION pos, StateController game) throws IOException{
        while (true) {
            this.viewer.drawElements(this.menu, false, true);
            pos = this.gui.getNextPosition();
            switch (pos) {
                case UP:
                    menu.previousLevelEntry();
                    break;
                case DOWN:
                    menu.nextLevelEntry();
                    break;
                case SELECT:
                    game.setState(new MenuState(gui, new Menu()));
                    return setLevel(game);
            }
        }
    }

    private int selectColors(GUI.POSITION pos, StateController game) throws IOException {
        while (true) {
            this.viewer.drawElements(this.menu, true, false);
            pos = this.gui.getNextPosition();
            switch (pos) {
                case UP:
                    menu.previousColorEntry();
                    break;
                case DOWN:
                    menu.nextColorEntry();
                    break;
                case SELECT:
                    return setColor(game);
            }
        }
    }

}
