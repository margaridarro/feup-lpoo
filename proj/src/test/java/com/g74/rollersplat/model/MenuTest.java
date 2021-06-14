package com.g74.rollersplat.model;

import com.g74.rollersplat.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void nextEntry() {
        menu.nextEntry();
        assertTrue(menu.isSelected(1));
        menu.nextEntry();
        assertTrue(menu.isSelected(2));
        for (int i = 0; i < menu.getNumberEntries() - 2; i++) {
            menu.nextEntry();
        }
        assertTrue(menu.isSelected(0));
    }

    @Test
    void previousEntry() {
        menu.previousEntry();
        assertTrue(menu.isSelected(menu.getNumberEntries()-1));
        menu.previousEntry();
        assertTrue(menu.isSelected(menu.getNumberEntries()-2));

        for (int i = 0; i < menu.getNumberEntries() - 2; i++) {
            menu.previousEntry();
        }
        assertTrue(menu.isSelected(0));
    }

    @Test
    void nextColorEntry() {
        menu.nextColorEntry();
        assertTrue(menu.isSelected2(1));
        menu.nextColorEntry();
        assertTrue(menu.isSelected2(2));
        for (int i = 0; i < menu.getNumberColorEntries() - 2; i++) {
            menu.nextColorEntry();
        }
        assertTrue(menu.isSelected2(0));
    }

    @Test
    void previousColorEntry() {
        menu.previousColorEntry();
        assertTrue(menu.isSelected2(menu.getNumberColorEntries()-1));
        menu.previousColorEntry();
        assertTrue(menu.isSelected2(menu.getNumberColorEntries()-2));

        for (int i = 0; i < menu.getNumberColorEntries() - 2; i++) {
            menu.previousColorEntry();
        }
        assertTrue(menu.isSelected2(0));
    }

    @Test
    void nextLevelEntry() {
        menu.nextLevelEntry();
        assertTrue(menu.isSelected3(1));
        menu.nextLevelEntry();
        assertTrue(menu.isSelected3(2));
        for (int i = 0; i < menu.getNumberLevelEntries() - 2; i++) {
            menu.nextLevelEntry();
        }
        assertTrue(menu.isSelected3(0));
    }

    @Test
    void previousLevelEntry() {
        menu.previousLevelEntry();
        assertTrue(menu.isSelected3(menu.getNumberLevelEntries()-1));
        menu.previousLevelEntry();
        assertTrue(menu.isSelected3(menu.getNumberLevelEntries()-2));

        for (int i = 0; i < menu.getNumberLevelEntries() - 2; i++) {
            menu.previousLevelEntry();
        }
        assertTrue(menu.isSelected3(0));
    }

    /*@Test
    void allGetEntry() {
        assertEquals("Normal", menu.getEntry(0));
        assertEquals("Pink", menu.getColorEntry(0));
        assertEquals("Level1", menu.getLevelEntry(0));
    }*/

    @Test
    void allIsSelected() {
        assertTrue(menu.isSelectedNormal());
        menu.nextEntry();
        assertTrue(menu.isSelectedInvisible());
        menu.nextEntry();
        assertTrue(menu.isSelectedNoRepeat());
        menu.nextEntry();
        assertTrue(menu.isSelectedLevels());
        menu.nextEntry();
        assertTrue(menu.isSelectedColor());
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());

        assertTrue(menu.isSelectedPink());
        menu.nextColorEntry();
        assertTrue(menu.isSelectedCyan());
        menu.nextColorEntry();
        assertTrue(menu.isSelectedGreen());
        menu.nextColorEntry();
        assertTrue(menu.isSelectedYellow());
        menu.nextColorEntry();
        assertTrue(menu.isSelectedBrown());

        assertTrue(menu.isSelectedLevel1());
        menu.nextLevelEntry();
        assertTrue(menu.isSelectedLevel2());
        menu.nextLevelEntry();
        assertTrue(menu.isSelectedLevel3());
    }
}
