package com.g74.rollersplat.controller.command;
import com.g74.rollersplat.model.elements.Wall;
import com.g74.rollersplat.model.mode.Mode;
import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.level.Level;

public class PlayerController {
    private Mode mode;
    private Level level;

    public PlayerController(Mode mode, Level level) {
        this.mode = mode;
        this.level = level;
    }

    private void movePlayer(Position position) {
        if (canPlayerMove(position))
            level.getPlayer().setPosition(position);
    }

    public void moveLeft() {
        movePlayer(level.getPlayer().getPosition().getLeft());
    }
    public void moveRight() {
        movePlayer(level.getPlayer().getPosition().getRight());
    }
    public void moveUp() {
        movePlayer(level.getPlayer().getPosition().getUp());
    }
    public void moveDown() {
        movePlayer(level.getPlayer().getPosition().getDown());
    }


    public void move(GUI.POSITION pos) {
        if (pos == GUI.POSITION.UP) {
            while (canPlayerMove(level.getPlayer().getPosition().getUp())) {
                mode.visitPosition(level.getPlayer().getPosition());
                moveUp();
            }

        }
        if (pos == GUI.POSITION.RIGHT) {
            while (canPlayerMove(level.getPlayer().getPosition().getRight())) {
                mode.visitPosition(level.getPlayer().getPosition());
                moveRight();
            }
        }
        if (pos == GUI.POSITION.DOWN) {
            while (canPlayerMove(level.getPlayer().getPosition().getDown())){
                mode.visitPosition(level.getPlayer().getPosition());
                moveDown();
            }
        }
        if (pos == GUI.POSITION.LEFT) {
            while (canPlayerMove(level.getPlayer().getPosition().getLeft())){
                mode.visitPosition(level.getPlayer().getPosition());
                moveLeft();
            }
        }
    }

    public boolean canPlayerMove(Position position) {
        for (Wall wall : level.getWalls()) {
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public Level getLevel() {
        return level;
    }
}
