package com.fmpoerio.supermarioquack;


import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameFrame(String gameName) {
        super(gameName);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);
        pack();

        setLocationRelativeTo(null);

        setVisible(true);

    }
}