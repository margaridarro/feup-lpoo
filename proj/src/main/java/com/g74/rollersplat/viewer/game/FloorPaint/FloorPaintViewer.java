package com.g74.rollersplat.viewer.game.FloorPaint;

import com.g74.rollersplat.viewer.game.ElementViewer;
import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.model.elements.Element;

public class FloorPaintViewer implements ElementViewer {

    @Override
    public void drawElement(Element FloorPaint, GUI gui) {
        gui.drawFloorPaint(FloorPaint.getPosition()); //add color parameter later?
    }
}
