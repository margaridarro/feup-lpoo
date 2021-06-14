package com.g74.rollersplat.model;//package com.aor.hero.com.g74.rollersplat.model;
import com.g74.rollersplat.model.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(5, 5);
    }


    @Test
    void getRight() {
        assertEquals(6, position.getRight().getX());
    }

    @Test
    void getLeft() {
        assertEquals(4, position.getLeft().getX());
    }

    @Test
    void getUp() {
        assertEquals(4, position.getUp().getY());
    }

    @Test
    void getDown() {
        assertEquals(6, position.getDown().getY());
    }

    @Test
    void equals(){
        Position pos2 = new Position(5,5);
        Position pos3 = new Position(1,2);

        assertEquals(pos2, position);
        assertNotEquals(pos3, position);
    }
}