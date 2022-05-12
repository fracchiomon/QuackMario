package com.fmpoerio.supermarioquack;

import javax.swing.*;

public class Game {
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Super Mario Quack";
    private static final String FONT = "Helvetica";



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static String getFONT() {
        return FONT;
    }

    public Game() {
        GameFrame frame = new GameFrame(TITLE);

    }


    public static void main(String[] args) {
        Game giochino = new Game();

    }
}
