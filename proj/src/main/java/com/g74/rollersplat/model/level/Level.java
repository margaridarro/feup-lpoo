package com.g74.rollersplat.model.level;
import com.g74.rollersplat.model.elements.Position;
import com.g74.rollersplat.model.elements.*;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private Player player;
    private List<Wall> walls;
    private List<FloorPaint> floorPaint;
    private List<Position> visited;
    private List<Floor> floors;
    private List<Letter> letters;

    public Level(){
        this.walls = new ArrayList<>();
        this.floorPaint = new ArrayList<>();
        this.floors = new ArrayList<>();
        this.letters = new ArrayList<>();
        this.visited = new ArrayList<>();
    }

    public Player getPlayer(){
        return this.player;
    }

    public void addElement(Element element){
        if (element instanceof Player) this.player = (Player) element;
        else if (element instanceof Wall) this.walls.add((Wall) element);
        else if (element instanceof Floor) this.floors.add((Floor) element);
        else if (element instanceof FloorPaint) this.floorPaint.add((FloorPaint) element);
        else if (element instanceof Letter) this.letters.add((Letter) element);
    }

    public void addVisit(Position position){
        visited.add(position);
    }

    public void addPaint(Position position) {
        floorPaint.add(new FloorPaint(position.getX(), position.getY()));
    }

    public List<Wall> getWalls() {
        return this.walls;
    }

    public List<FloorPaint> getFloorPaint() {
        return this.floorPaint;
    }

    public List<Position> getVisited() {
        return this.visited;
    }

    public List<Floor> getFloor() { return floors; }

    public List<Letter> getLetters() { return letters; }

    public void resetLevel(Position spawnPos) {
        getFloorPaint().clear();
        getVisited().clear();
        getPlayer().setPosition(spawnPos);
    }

    public boolean isVisited(Position pos){
        return visited.contains(pos);
    }


    public boolean isFinished() {
        return (floors.size() <= visited.size());
    }

}
