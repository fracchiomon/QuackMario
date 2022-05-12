package com.fmpoerio.supermarioquack;

public class QuackMario {
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "QuackMario";
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

    public QuackMario() {
        GameFrame frame = new GameFrame(TITLE);

    }


    public static void main(String[] args) {
        QuackMario giochino = new QuackMario();

    }
}
