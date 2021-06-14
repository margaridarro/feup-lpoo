package com.g74.rollersplat.model;

import com.g74.rollersplat.model.elements.*;
import com.g74.rollersplat.model.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class LevelTest {
    private Level level;

    @BeforeEach
    void setUp() {
        level = new Level();
    }

    @Test
    void getFloorPaint() {
        List<FloorPaint> paint = new ArrayList<>();
        paint.add(new FloorPaint(2,2));

        level.addPaint(new Position(2,2));

        assertEquals(paint.contains(new FloorPaint(2,2)), level.getFloorPaint().contains(new FloorPaint(2,2)));
    }

    @Test
    void getVisited() {
        List<Position> visited = new ArrayList<>();
        visited.add(new Position(1,1));

        level.addVisit(new Position(1,1));

        assertEquals(visited, level.getVisited());
    }

    @Test
    void getFloor() { //no add floor method so for now stays like this.
        List<Floor> floor = new ArrayList<>();

        assertEquals(floor, level.getFloor());
    }

    @Test
    void getLetters() {
        List<Letter> letters = new ArrayList<>();

        assertEquals(letters, level.getLetters());
    }

    @Test
    void resetLevel(){
        level.addElement(new Player(5,6));
        level.getPlayer().setPosition(new Position(5,6));
        Position spawnPos = level.getPlayer().getPosition();
        level.getPlayer().setPosition(new Position(8,6));
        level.getFloorPaint().add(new FloorPaint(1,1));
        level.getVisited().add(new Position(1,1));

        level.resetLevel(spawnPos);

        assertEquals(spawnPos, level.getPlayer().getPosition());
        assertEquals(0, level.getFloorPaint().size());
        assertEquals(0, level.getVisited().size());
    }

}
