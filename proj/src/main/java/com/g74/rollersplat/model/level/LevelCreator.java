package com.g74.rollersplat.model.level;

import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.elements.*;
import com.g74.rollersplat.model.mode.Mode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LevelCreator {
    private Level level;
    private Mode mode;
    private Position spawnPos;
    private List<String> lines;

    public LevelCreator(Level level, int levelNum){
        this.level = level;
        try{
            readFile(levelNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(int levelNum) throws IOException {
        this.lines = readLines(levelNum);
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++){
                char c = lines.get(y).charAt(x);
                readChar(c,x,y);
            }
        }
    }

    private void readChar(char ch, int x, int y) {
        switch (ch) {
            case 'W':
                this.level.addElement(new Wall(x, y));
                break;
            case '-':
                this.level.addElement(new Floor(x, y));
                break;
            case 'O':
                this.level.addElement(new Player(x, y));
                this.spawnPos = new Position(x, y);
                break;
            case 'T':
                this.level.addElement(new Letter(x, y));
                break;
            default:
                break;
        }
    }

    private static List<String> readLines(int levelNum) throws IOException {
        String level = String.valueOf(levelNum);
        URL resource = LevelCreator.class.getResource("/mode-normal/" + level + ".lvl");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
        List<String> lines = new ArrayList<>();

        for (String line; (line = reader.readLine()) != null; ){
            lines.add(line);
        }

        return lines;
    }

    public List<String> getLines() {
        return this.lines;
    }

    public Position getSpawnPos() {
        return spawnPos;
    }
}
