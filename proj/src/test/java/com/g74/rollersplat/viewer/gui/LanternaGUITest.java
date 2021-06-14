package com.g74.rollersplat.viewer.gui;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.g74.rollersplat.model.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class LanternaGUITest {
    private TerminalScreen screen;
    private TextGraphics graphics;
    private LanternaGUI gui;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(TerminalScreen.class);
        graphics = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(graphics);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawPlayer() {
        gui.drawPlayer(new Position(1, 1));

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("black"));
        Mockito.verify(graphics, Mockito.times(1)).enableModifiers(SGR.BOLD);
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), "O");
        Mockito.verify(graphics, Mockito.times(1)).disableModifiers(SGR.BOLD);
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), "#");
    }

    @Test
    void drawFloorPaint(){
        gui.drawFloorPaint(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FF69B4"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

    @Test
    void drawCyanFloorPaint(){
        gui.drawCyanFloorPaint(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("cyan"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

    @Test
    void drawGreenFloorPaint(){
        gui.drawGreenFloorPaint(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#2CFA1F"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

    @Test
    void drawYellowFloorPaint(){
        gui.drawYellowFloorPaint(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#F9D71C"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

    @Test
    void drawBrownFloorPaint(){
        gui.drawBrownFloorPaint(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#9B673C"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

    @Test
    void drawFloor(){
        gui.drawFloor(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("white"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

   /* void drawBackground() {
        gui.drawBackground();

        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#008000"));
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#32CD32"));
    }
    */

    @Test
    void drawLetter() {
        gui.drawLetter(new Position(1,1));

        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));

        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), " ");
    }

    @Test
    void drawGivenChar() {
        gui.drawGivenChar(new Position(1,1), "cyan", "hello");
        Mockito.verify(graphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(graphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("cyan"));
        Mockito.verify(graphics, Mockito.times(1)).putString(new TerminalPosition(1, 1), "hello");
    }

    @Test
    void clear() {
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refresh() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void close() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }

}
