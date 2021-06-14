package com.g74.rollersplat.viewer.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import com.g74.rollersplat.model.elements.Position;

import java.io.IOException;

public class LanternaGUI implements GUI {
    private final TerminalScreen screen;
    private TextGraphics graphics;
    private int width;
    private int height;

    public LanternaGUI(TerminalScreen screen) {
        this.screen = screen;
        this.graphics = this.screen.newTextGraphics();
    }
    public LanternaGUI(int width, int height) throws IOException {
        this.height = height;
        this.width = width;
        Terminal terminal = createTerminal(width, height);
        screen = createScreen(terminal);
        graphics = screen.newTextGraphics();
    }

    private TerminalScreen createScreen(Terminal terminal) throws IOException {
        TerminalScreen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); //dont need cursor
        screen.startScreen(); //screens must be started
        screen.doResizeIfNecessary(); //resize screen if necessary
        return screen;
    }

    private Terminal createTerminal(int width, int height) throws IOException {
        DefaultTerminalFactory factory = new DefaultTerminalFactory();
        factory.setInitialTerminalSize(new TerminalSize(width, height));
        Terminal terminal = factory.createTerminal();
        return terminal;
    }

    /*public void drawLevel(com.g74.rollersplat.model.level.Level level) throws IOException{ // probably shouldn't depend on another class
                                                           // will change later :)
        screen.clear();
        level.draw(screen.newTextGraphics());
        screen.refresh();
    }*/

    /*public void readKey(com.g74.rollersplat.model.level.Level level) throws IOException {
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
        {
            System.out.println("Process finished with exit code 0");
            System.exit(0);
        }
        level.processKey(key); // same as above
    }*/

    @Override
    public void drawPlayer(Position position) {
        //TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("black"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "O");
        graphics.disableModifiers(SGR.BOLD);
    }

    @Override
    public void drawWall(Position position) {
        //TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "#");
    }

    public void drawFloorPaint(Position p) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF69B4"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
    }

    public void drawCyanFloorPaint(Position p) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("cyan"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
    }

    public void drawGreenFloorPaint(Position p) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#2CFA1F"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
    }

    public void drawYellowFloorPaint(Position p) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#F9D71C"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
    }

    public void drawBrownFloorPaint(Position p) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#9B673C"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
    }

    public void drawFloor(Position p) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");
    }

    public void drawBackground() {
        //TextGraphics graphics = screen.newTextGraphics();
        graphics.setForegroundColor(TextColor.Factory.fromString("#008000"));
        graphics.setBackgroundColor(TextColor.Factory.fromString("#32CD32"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), '#');
    }

    public void drawLetter(Position p) {
        //TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), " ");

    }

    public void drawGivenChar(Position p, String color, String string){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(new TerminalPosition(p.getX(), p.getY()), string);
    }


    public void clear(){screen.clear();}
    public void refresh() throws IOException {screen.refresh();}

    @Override
    public void close() throws IOException {
        screen.close();
    }

    public POSITION getNextPosition() throws IOException {
        KeyStroke keyStroke = screen.readInput();

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return POSITION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'r') return POSITION.RESET;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return POSITION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return POSITION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return POSITION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return POSITION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Enter) return POSITION.SELECT;

        return POSITION.NONE;
    }

    public void pollInput() throws IOException {
        screen.pollInput();
    }
}
