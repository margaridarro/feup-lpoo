package com.g74.rollersplat.viewer.gui;

import java.io.IOException;
import com.g74.rollersplat.model.elements.Position;

public interface GUI {
    POSITION getNextPosition() throws IOException;

    void drawPlayer(Position position);

    void drawWall(Position position);

    void drawFloorPaint(Position position);

    void drawCyanFloorPaint(Position position);

    void drawGreenFloorPaint(Position position);

    void drawYellowFloorPaint(Position position);

    void drawBrownFloorPaint(Position position);

    void drawFloor(Position position);

    void drawLetter(Position position);

    void drawGivenChar(Position position, String color, String string);

    void drawBackground();

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void pollInput() throws IOException;

    enum POSITION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, RESET, SELECT} //put both non movement and movement action in same enum?
}
