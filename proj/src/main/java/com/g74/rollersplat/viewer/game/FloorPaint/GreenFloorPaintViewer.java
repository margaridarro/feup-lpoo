package com.g74.rollersplat.viewer.game.FloorPaint;

import com.g74.rollersplat.model.elements.Element;
import com.g74.rollersplat.viewer.game.ElementViewer;
import com.g74.rollersplat.viewer.gui.GUI;

public class GreenFloorPaintViewer implements ElementViewer {
    @Override
    public void drawElement(Element FloorPaint, GUI gui) {
        gui.drawGreenFloorPaint(FloorPaint.getPosition()); //add color parameter later?
    }
}
