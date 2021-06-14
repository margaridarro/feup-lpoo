package com.g74.rollersplat.controller.command;

import com.g74.rollersplat.controller.states.*;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public class StateController {
    private State state;
    private int levelNum = 1;
    private int modeNum = 0;
    private int chosenColor = 0;
    private final int levelCount = 3; // cuz we have 3 levels

    public StateController(GUI gui) {
        state = new MenuState(gui, new Menu());
    }

    public void run(GUI gui) throws IOException, InterruptedException {
        int result;

        while (true) {
            this.levelNum = 1;

            result = state.run(this);
            if (result == -2) break; // menu exit button was pressed

            while (result >= 10) { //didnt choose a mode yet
                if (result < 20)  //chose a color
                    chosenColor = result;

                result = state.run(this);
            }

            if (result == -2) break; // menu exit button was pressed

            while ((levelNum < levelCount + 1) && result != -1) {
                result = state.run(this);
            }
        }

        gui.close();
    }

    public void setState(State state) {
        this.state = state;
    }
    public int getLevelNum (){
        return this.levelNum;
    }

    public int getChosenColor() {
        return this.chosenColor;
    }

    public void setModeNum(int num) {
        this.modeNum = num;
    }

    public void setLevelNum (int num) {
        this.levelNum = num;
    }

    public int getModeNum() {
        return this.modeNum;
    }

    public int getLevelCount(){
        return this.levelCount;
    }

    public State getState() {
        return state;
    }
}
