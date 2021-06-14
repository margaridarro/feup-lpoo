package com.g74.rollersplat.viewer.game;

import com.g74.rollersplat.model.elements.Letter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.g74.rollersplat.viewer.gui.GUI;

public class LetterViewerTest {
    private Letter letter;
    private LetterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        letter = new Letter(5,5);
        viewer = new LetterViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.drawElement(letter, gui);
        Mockito.verify(gui, Mockito.times(1)).drawLetter(letter.getPosition());
    }
}
