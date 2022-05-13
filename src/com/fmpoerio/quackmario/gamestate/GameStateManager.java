package com.fmpoerio.quackmario.gamestate;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Stack;

/*
GameStateManager è una Stack di GameState (Livelli), che vengono 'pushati' in essa e renderizzati chiamando la
funzione draw del GameState in cima, tramite la Stack.peek(); stessa cosa per altri metodi, richiamano i metodi del
GameState in Top
 */

public class GameStateManager {
    private Stack<GameState> STATES;

    public Stack<GameState> getSTATES() {
        return STATES;
    }

    public void draw(Graphics g) {
        STATES.peek().draw(g);
    }
    public void tick() {
        STATES.peek().tick();

    }
    public void keyPressed(KeyEvent e) {
        STATES.peek().keyPressed(e);

    }
    public void keyReleased(KeyEvent e) {
        STATES.peek().keyReleased(e);

    }

    public GameStateManager() {
        //Creo la stack e pusho il primo GameState, ovvero il Menu Principale.
        STATES = new Stack<GameState>();
        STATES.push(new MenuState(this));
    }
}
