package com.g74.rollersplat.controller.command;

import com.g74.rollersplat.controller.command.PlayerController;
import com.g74.rollersplat.model.level.LevelCreator;
import com.g74.rollersplat.model.mode.Mode;
import com.g74.rollersplat.model.mode.NormalMode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.level.Level;
import com.g74.rollersplat.model.elements.Wall;
import com.g74.rollersplat.viewer.gui.GUI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayerControllerTest {
    private PlayerController playerController;
    //private Player player;
    private LevelCreator levelCreator;
    private Level level;
    private Mode mode;

    @BeforeEach
    void setUp() {
        level = new Level();
        mode = new NormalMode(level);
        levelCreator = new LevelCreator(level, 1);
        playerController = new PlayerController(mode, level);
        level.getWalls().clear(); //empty the level works for any level so it doesn't matter which one we use
    }

    @Test
    void movePlayerRightWall() {

        Position result = level.getPlayer().getPosition();
        Wall wall = new Wall(result.getX() + 1, result.getY());

        this.level.addElement(wall);
        playerController.moveRight();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerRightNoWall() {
        Position result = new Position(level.getPlayer().getPosition().getX() + 1, level.getPlayer().getPosition().getY());
        playerController.moveRight();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerLeftWall() {

        Position result = level.getPlayer().getPosition();
        Wall wall = new Wall(result.getX() - 1, result.getY());

        this.level.addElement(wall);
        playerController.moveLeft();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerLeftNoWall() {
        Position result = new Position(level.getPlayer().getPosition().getX() - 1, level.getPlayer().getPosition().getY());
        playerController.moveLeft();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerUpWall() {

        Position result = level.getPlayer().getPosition();
        Wall wall = new Wall(result.getX(), result.getY() - 1);

        this.level.addElement(wall);
        playerController.moveUp();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerUpNoWall() {
        Position result = new Position(level.getPlayer().getPosition().getX(), level.getPlayer().getPosition().getY() - 1);
        playerController.moveUp();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerDownWall() {

        Position result = level.getPlayer().getPosition();
        Wall wall = new Wall(result.getX(), result.getY() + 1);

        this.level.addElement(wall);
        playerController.moveDown();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void movePlayerDownNoWall() {
        Position result = new Position(level.getPlayer().getPosition().getX(), level.getPlayer().getPosition().getY() + 1);
        playerController.moveDown();
        assertEquals(result, level.getPlayer().getPosition());
    }

    @Test
    void generalMove() {
        Position result = new Position(level.getPlayer().getPosition().getX(), level.getPlayer().getPosition().getY() + 4);
        Wall wall = new Wall(result.getX(), result.getY() + 1);
        this.level.addElement(wall);
        playerController.move(GUI.POSITION.DOWN);
        assertEquals(result, level.getPlayer().getPosition());

        level.getWalls().clear();

        result = new Position(level.getPlayer().getPosition().getX(), level.getPlayer().getPosition().getY() - 4);
        wall = new Wall(result.getX(), result.getY() - 1);
        this.level.addElement(wall);
        playerController.move(GUI.POSITION.UP);
        assertEquals(result, level.getPlayer().getPosition());

        level.getWalls().clear();

        result = new Position(level.getPlayer().getPosition().getX() + 4, level.getPlayer().getPosition().getY());
        wall = new Wall(result.getX() + 1, result.getY());
        this.level.addElement(wall);
        playerController.move(GUI.POSITION.RIGHT);
        assertEquals(result, level.getPlayer().getPosition());

        level.getWalls().clear();

        result = new Position(level.getPlayer().getPosition().getX() - 4, level.getPlayer().getPosition().getY());
        wall = new Wall(result.getX() - 1, result.getY());
        this.level.addElement(wall);
        playerController.move(GUI.POSITION.LEFT);
        assertEquals(result, level.getPlayer().getPosition());

    }

    @Test
    void getLevel() {
        Level result = this.level;
        assertEquals(result, playerController.getLevel());
    }

    @Test
    void getSpawnPos() {
        assertEquals(level.getPlayer().getPosition(), levelCreator.getSpawnPos());
    }

}
