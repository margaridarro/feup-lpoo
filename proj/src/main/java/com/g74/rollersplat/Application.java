package com.g74.rollersplat;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game game;
        try {
            game = new Game();
            game.start();
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
