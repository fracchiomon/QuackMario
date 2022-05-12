package com.fmpoerio.supermarioquack;

import java.awt.*;

public abstract class GameState {
    protected GameStateManager gameStateManager;
    public GameState(GameStateManager gsm) {
        this.gameStateManager = gsm;
        init();
    }
    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);


}
