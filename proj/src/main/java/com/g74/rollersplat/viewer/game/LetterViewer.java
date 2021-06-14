package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Element;
import com.g74.rollersplat.viewer.gui.GUI;

public class LetterViewer implements ElementViewer {
        public void drawElement(Element letter, GUI gui) {
            gui.drawLetter(letter.getPosition());
        }
}
