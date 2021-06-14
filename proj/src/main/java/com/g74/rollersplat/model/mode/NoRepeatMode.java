package com.g74.rollersplat.model.mode;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.level.Level;

public class NoRepeatMode extends Mode{
    boolean repeat = false;

    public NoRepeatMode(Level level){
        super(level);
    }

    @Override
    public void visitPosition(Position position) {
        if (!level.isVisited(position)) {
            level.addVisit(position);
            level.addPaint(position);
            this.repeat = false;
        }
        else{
            this.repeat = true;
        }
    }

    @Override
    public boolean loseGame() {
        return this.repeat;
    }

}
