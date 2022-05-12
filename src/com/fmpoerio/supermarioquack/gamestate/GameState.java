package com.fmpoerio.supermarioquack.gamestate;
import com.fmpoerio.supermarioquack.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameState extends KeyboardMouseListeners {
    protected GameStateManager gameStateManager;
    public GameState(GameStateManager gsm) {
        this.gameStateManager = gsm;
        init();
    }
    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(KeyEvent e);
    public abstract void keyReleased(KeyEvent e);


}
