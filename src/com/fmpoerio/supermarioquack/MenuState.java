package com.fmpoerio.supermarioquack;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MenuState extends GameState{

    protected Image background;
    protected final Color bgColor = Color.BLACK;

    protected static final String[] OPTIONS = {"Nuova Partita", "Help", "Esci"};
    private int currentSelection = 0;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        background = new ImageIcon("Assets/SuperMarioQuack_MarioQuack.png").getImage();

    }

    @Override
    public void init() {}

    @Override
    public void tick() {}

    @Override
    public void draw(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0,0,GamePanel.getWIDTH(), GamePanel.getHEIGHT());
        g.drawImage(background,GamePanel.getWIDTH()/2 + 100, GamePanel.getHEIGHT()/2 - 100, null);
        for(int i = 0; i < OPTIONS.length; i++) {
            if(i == currentSelection) {
                g.setColor(Color.YELLOW);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font(QuackMario.getFONT(), Font.PLAIN, 48));
            g.drawString(OPTIONS[i], GamePanel.getWIDTH()/2 - 400, 300 + i * 75 );
        }
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
