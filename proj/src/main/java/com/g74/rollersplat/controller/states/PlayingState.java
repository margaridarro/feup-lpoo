package com.g74.rollersplat.controller.states;

import com.g74.rollersplat.controller.command.PlayerController;
import com.g74.rollersplat.controller.command.StateController;
import com.g74.rollersplat.model.level.Level;
import com.g74.rollersplat.model.level.LevelCreator;
import com.g74.rollersplat.model.menu.Menu;
import com.g74.rollersplat.model.mode.InvisibleMode;
import com.g74.rollersplat.model.mode.Mode;
import com.g74.rollersplat.model.mode.NoRepeatMode;
import com.g74.rollersplat.model.mode.NormalMode;
import com.g74.rollersplat.viewer.game.LevelViewer;
import com.g74.rollersplat.viewer.gui.GUI;
import java.io.IOException;

public class PlayingState extends State {
    private LevelCreator levelCreator;
    private GUI gui;
    private Level level;
    private Mode mode;
    private PlayerController playerController;
    private int chosenColor;
    LevelViewer viewer;

    public PlayingState(int levelNum, GUI gui, int modeNum, int chosenColor) {
        super(gui);
        this.level = new Level();
        this.chosenColor = chosenColor;
        this.gui = gui;
        this.levelCreator = new LevelCreator(this.level, levelNum);
        setMode(modeNum);
        this.playerController = new PlayerController(this.mode, this.level);
    }

    public int run(StateController game) throws IOException, InterruptedException {
        this.viewer = new LevelViewer(gui);
        this.viewer.draw(this.level);
        for (int i = 0;i < 10; i++) {
            this.gui.pollInput();
        }
        return play(game);
    }

    public int play(StateController game) throws IOException, InterruptedException {

        while (!level.isFinished() && !mode.loseGame()) {

            if (mode instanceof InvisibleMode)
                this.viewer.updateView(this.level, 1);
            else
                this.viewer.updateView(this.level, this.chosenColor);

            GUI.POSITION pos = this.gui.getNextPosition();

            if (setState(pos, game) == -1) return -1;

            this.playerController.move(pos);
        }

        if (level.isFinished()) {
            if (mode instanceof InvisibleMode)
                this.viewer.updateView(this.level, 1);
            else
                this.viewer.updateView(this.level, this.chosenColor);

            Thread.sleep(1000); // to be able see every floor painted before advancing to next lvl
            game.setState(new WinningState(gui));
        }
        else {
            game.setState(new LosingState(gui));
            setState(GUI.POSITION.RESET, game);
            game.setState(new LosingState(gui));
        }

        return 0;
    }

    private void setMode(int modeNum) {
        switch (modeNum) {
            case 0:
                this.mode = new NormalMode(this.level);
                break;
            case 1:
                this.mode = new InvisibleMode(this.level);
                break;
            case 2:
                this.mode = new NoRepeatMode(this.level);
                break;
        }
    }

    @Override
    protected int setState(GUI.POSITION pos, StateController game) {
        if (pos == GUI.POSITION.QUIT) {
            game.setState(new MenuState(gui, new Menu()));
            return -1;
        }
        if (pos == GUI.POSITION.RESET)
            level.resetLevel(levelCreator.getSpawnPos());
        return 0;
    }
}

