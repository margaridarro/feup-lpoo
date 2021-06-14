package com.g74.rollersplat.viewer.game.FloorPaint;

import com.g74.rollersplat.model.elements.Element;
import com.g74.rollersplat.viewer.game.ElementViewer;
import com.g74.rollersplat.viewer.gui.GUI;

public class BrownFloorPaintViewer implements ElementViewer {
    @Override
    public void drawElement(Element FloorPaint, GUI gui) {
        gui.drawBrownFloorPaint(FloorPaint.getPosition()); //add color parameter later?
    }
}
