package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.viewer.game.FloorPaint.*;
import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.model.level.Level;
import com.g74.rollersplat.model.elements.Element;

import java.io.IOException;
import java.util.List;

public class LevelViewer {
    private GUI gui;

    public LevelViewer(GUI gui){
        this.gui = gui;
    }

    public void draw (Level level) throws IOException {
        gui.clear();
        gui.drawBackground();
        drawElements(level.getLetters(), new LetterViewer());
        drawElements(level.getWalls(), new WallViewer());
        drawElements(level.getFloor(), new FloorViewer());
        drawElement(level.getPlayer(), new PlayerViewer());
        gui.refresh();
    }

    public void updateView (Level level, int chosenColor) throws IOException {
        drawElements(level.getFloor(), new FloorViewer());
        switch (chosenColor) {
            case 10:
                drawElements(level.getFloorPaint(), new FloorPaintViewer());
                break;
            case 11:
                drawElements(level.getFloorPaint(), new CyanFloorPaintViewer());
                break;
            case 12:
                drawElements(level.getFloorPaint(), new GreenFloorPaintViewer());
                break;
            case 13:
                drawElements(level.getFloorPaint(), new YellowFloorPaintViewer());
                break;
            case 14:
                drawElements(level.getFloorPaint(), new BrownFloorPaintViewer());
                break;
            case 1:
                drawElements(level.getFloorPaint(), new FloorViewer());
                break;
            default:
                drawElements(level.getFloorPaint(), new FloorPaintViewer());
                break;
        }
        drawElement(level.getPlayer(), new PlayerViewer());
        gui.refresh();
    }

    private void drawElement(Element element, ElementViewer viewer) {
        viewer.drawElement(element, gui);
    }

    private void drawElements(List<? extends Element> elements, ElementViewer viewer) {
        for (Element element : elements)
            drawElement(element, viewer);
    }
}
