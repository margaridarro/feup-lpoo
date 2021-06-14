package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.viewer.gui.GUI;

import java.io.IOException;

public abstract class State {
    public State(GUI gui){};

    public abstract int run(StateController game) throws IOException, InterruptedException;

    protected abstract int setState(GUI.POSITION pos, StateController game);
    //public abstract void draw() throws IOException;
}
