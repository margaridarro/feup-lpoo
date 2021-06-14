package com.g74.rollersplat;

import com.g74.rollersplat.controller.command.PlayerController;

import com.g74.rollersplat.model.level.LevelCreator;
import com.g74.rollersplat.model.mode.InvisibleMode;
import com.g74.rollersplat.model.mode.Mode;
import com.g74.rollersplat.model.mode.NoRepeatMode;
import com.g74.rollersplat.model.mode.NormalMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.g74.rollersplat.model.level.Level;

import com.g74.rollersplat.viewer.gui.GUI;

import static org.junit.jupiter.api.Assertions.*;

public class WinTest {
    private PlayerController playerController;
    private Level level;
    private LevelCreator levelCreator;
    private Mode mode;

    @BeforeEach
    void setUp() {
        level = new Level();
        levelCreator = new LevelCreator(level, 1); //testing for level 1 //all levels follow same rules though
        playerController = new PlayerController(new NormalMode(level), level);
        mode = new NormalMode(level);
    }

    @Test
    void movePlayerWin() {

        playerController.move(GUI.POSITION.RIGHT);
        playerController.move(GUI.POSITION.DOWN);
        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.UP);

        assertTrue(level.isFinished());
        assertFalse(mode.loseGame());

        level = new Level();
        levelCreator = new LevelCreator(level, 1);
        playerController = new PlayerController(new NoRepeatMode(level), level);
        mode = new NoRepeatMode(level);

        playerController.move(GUI.POSITION.RIGHT);
        playerController.move(GUI.POSITION.DOWN);
        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.UP);

        assertTrue(level.isFinished());
        assertFalse(mode.loseGame());

        level = new Level();
        levelCreator = new LevelCreator(level, 1);
        playerController = new PlayerController(new InvisibleMode(level), level);
        mode = new InvisibleMode(level);

        playerController.move(GUI.POSITION.RIGHT);
        playerController.move(GUI.POSITION.DOWN);
        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.UP);

        assertTrue(level.isFinished());
        assertFalse(mode.loseGame());
    }

    @Test
    void movePlayerNoWin() {

        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.DOWN);
        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.UP);

        assertFalse(level.isFinished());

        level = new Level();
        levelCreator = new LevelCreator(level, 1);
        playerController = new PlayerController(new NoRepeatMode(level), level);
        mode = new NoRepeatMode(level);

        playerController.move(GUI.POSITION.RIGHT);
        playerController.move(GUI.POSITION.DOWN);
        playerController.move(GUI.POSITION.UP);
        playerController.move(GUI.POSITION.UP);

        assertFalse(level.isFinished());

        level = new Level();
        levelCreator = new LevelCreator(level, 1);
        playerController = new PlayerController(new InvisibleMode(level), level);

        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.DOWN);
        playerController.move(GUI.POSITION.LEFT);
        playerController.move(GUI.POSITION.UP);

        assertFalse(level.isFinished());
    }

}
