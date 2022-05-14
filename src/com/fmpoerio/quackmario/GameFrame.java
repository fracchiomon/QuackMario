package com.fmpoerio.quackmario;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame { //Il Frame del Game, la finestra madre
    private GamePanel gamePanel;    //l'istanza del Panel con metodo Get

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameFrame(String gameName) {
        super(gameName);    //Istanzio il Frame con il nome Gioco passatomi dal Main (v. QuackMario.java)
        //Metodi base del JFrame, uso un BorderLayout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());


        gamePanel = new GamePanel();    //aggiungo il Panel al Frame e con Pack() lo ridimensiono alla sua preferredSize
        add(gamePanel, BorderLayout.CENTER);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}