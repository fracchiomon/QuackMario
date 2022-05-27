package com.fmpoerio.quackmario.gamestate;
import com.fmpoerio.quackmario.game.KeyboardMouseListeners;

import java.awt.*;
import java.awt.event.KeyEvent;

/*
GameState corrisponde al generico Livello, è una classe astratta che contiene i metodi usati dai vari livelli, ovvero
Init(), Tick(), draw(),
 */

public abstract class GameState extends KeyboardMouseListeners {
    protected GameStateManager gameStateManager;
    public static double xOffset, yOffset;

    public GameState(GameStateManager gsm) {
        this.gameStateManager = gsm;
        xOffset = 0;
        yOffset = 0;
        init();
    }
    public abstract void init();
    public abstract void tick();
    public abstract void draw(Graphics g);
    public abstract void keyPressed(KeyEvent e);
    public abstract void keyReleased(KeyEvent e);


}
