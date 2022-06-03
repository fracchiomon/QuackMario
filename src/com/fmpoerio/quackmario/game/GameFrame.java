package com.fmpoerio.quackmario.game;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame { //Il Frame del Game, la finestra madre
    private GamePanel gamePanel;    //l'istanza del Panel con metodo Get
    private static Menu menu;
    private static Image gameIcon;

    public GamePanel getGamePanel() {
        return gamePanel;
    }


    public GameFrame(String gameName) {
        super(gameName);    //Istanzio il Frame con il nome Gioco passatomi dal Main (v. QuackMario.java)
        //Metodi base del JFrame, uso un BorderLayout
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        gameIcon = new ImageIcon("Assets/Sprites/Player/QuackMario_Player.png").getImage().getScaledInstance(64,64,Image.SCALE_SMOOTH);

        gamePanel = new GamePanel();    //aggiungo il Panel al Frame e con Pack() lo ridimensiono alla sua preferredSize
        add(gamePanel, BorderLayout.CENTER);
        setJMenuBar(gamePanel.getMenuBar());
        setIconImage(gameIcon);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}