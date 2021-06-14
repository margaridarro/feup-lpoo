package com.g74.rollersplat.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private final List<String> colors;
    private final List<String> levels;
    private int currentEntry = 0;
    private int currentColor = 0;
    private int currentLevel = 0;

    public Menu(){this.entries = Arrays.asList("Normal", "Invisible", "No Repeat", "Levels", "Color", "Exit");
        this.colors = Arrays.asList("Pink", "Cyan", "Green", "Yellow", "Brown");
        this.levels = Arrays.asList("Level1", "Level2", "Level3");}

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public void nextColorEntry() {
        currentColor++;
        if (currentColor > this.colors.size() -1)
            currentColor = 0;
    }

    public void previousColorEntry() {
        currentColor--;
        if (currentColor < 0)
            currentColor = this.colors.size() - 1;
    }

    public void nextLevelEntry() {
        currentLevel++;
        if (currentLevel > this.levels.size() -1)
            currentLevel = 0;
    }

    public void previousLevelEntry() {
        currentLevel--;
        if (currentLevel < 0)
            currentLevel = this.levels.size() - 1;
    }

    public String getEntry(int i) {return entries.get(i);}

    public String getColorEntry(int i) {return colors.get(i);}

    public String getLevelEntry(int i) {return levels.get(i);}

    public boolean isSelected(int i) {return currentEntry == i;}

    public boolean isSelected2(int i) {return currentColor == i;} //used for colors

    public boolean isSelected3(int i) {return currentLevel == i;} // used for levels

    public boolean isSelectedExit(){return isSelected(5);}

    public boolean isSelectedNormal(){return isSelected(0);}

    public boolean isSelectedInvisible(){return isSelected(1);}

    public boolean isSelectedNoRepeat(){return isSelected(2);}

    public boolean isSelectedLevels(){return isSelected(3);}

    public boolean isSelectedColor(){return isSelected(4);}

    public boolean isSelectedBrown() {return isSelected2(4);}

    public boolean isSelectedYellow() {return isSelected2(3);}

    public boolean isSelectedGreen() {return isSelected2(2);}

    public boolean isSelectedCyan() {return isSelected2(1);}

    public boolean isSelectedPink() {return isSelected2(0);}

    public boolean isSelectedLevel1() {return isSelected3(0);}

    public boolean isSelectedLevel2() {return isSelected3(1);}

    public boolean isSelectedLevel3() {return isSelected3(2);}

    public int getNumberEntries(){return this.entries.size();}

    public int getNumberColorEntries() {return this.colors.size();}

    public int getNumberLevelEntries() {return this.levels.size();}
}
