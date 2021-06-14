package com.g74.rollersplat;

import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.viewer.gui.LanternaGUI;

import java.io.IOException;

public class Game {
    private GUI gui;
    private StateController stateController;

    public Game()  throws IOException {
        this.gui = new LanternaGUI(53, 27);
        this.stateController = new StateController(this.gui);
    }

    public void start() throws IOException, InterruptedException {
        this.stateController.run(this.gui);
    }

}

