package com.fmpoerio.supermarioquack;

import java.awt.*;

public class MenuState extends GameState{

    protected static final String[] OPTIONS = {"Nuova Partita", "Help", "Esci"};
    private int currentSelection = 0;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {}

    @Override
    public void tick() {}

    @Override
    public void draw(Graphics g) {
        for(int i = 0; i < OPTIONS.length; i++) {
            if(i == currentSelection) {
                g.setColor(Color.CYAN);
            }
            else {
                g.setColor(Color.BLACK);
            }
            g.setFont(new Font(Game.getFONT(), Font.PLAIN, 48));
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
