package com.fmpoerio.quackmario.game;

//Qui si inizializza il Gioco chiamando a cascata tutti gli oggetti che serviranno
//Abbiamo il Main()
public class QuackMario {
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "QuackMario";   //Nome del Gioco
    private static final String FONT = "Helvetica";     //Font con cui visualizzo il nome



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
