package com.g74.rollersplat.model.mode;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.level.Level;

public class InvisibleMode extends Mode{
    public InvisibleMode(Level level){
        super(level);
    }
    @Override
    public void visitPosition(Position position) {
        if (!level.isVisited(position)) {
            level.addVisit(position);
            level.addPaint(position);
        }
    }

    @Override
    public boolean loseGame() {
        return false;
    }
}
