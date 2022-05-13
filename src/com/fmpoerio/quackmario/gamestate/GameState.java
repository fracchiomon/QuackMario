package com.fmpoerio.quackmario.gamestate;
import com.fmpoerio.quackmario.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/*
GameState corrisponde al generico Livello, è una classe astratta che contiene i metodi usati dai vari livelli, ovvero
Init(), Tick(), draw(),
 */

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
