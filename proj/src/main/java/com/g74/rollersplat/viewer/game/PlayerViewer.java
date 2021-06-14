package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.viewer.gui.GUI;
import com.g74.rollersplat.model.elements.Element;

public class PlayerViewer implements ElementViewer {
    public void drawElement(Element player, GUI gui) {
        gui.drawPlayer(player.getPosition());
    }
}
