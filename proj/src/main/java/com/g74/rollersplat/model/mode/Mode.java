package com.g74.rollersplat.model.mode;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.level.Level;

public abstract class Mode {
    protected Level level;

    public Mode(Level level){
        this.level = level;
    }

    public abstract void visitPosition(Position position);

    public abstract boolean loseGame();

}
