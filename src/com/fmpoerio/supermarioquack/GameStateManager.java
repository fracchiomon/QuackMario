package com.fmpoerio.supermarioquack;

import com.fmpoerio.supermarioquack.gamestate.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Stack;

public class GameStateManager {
    private Stack<GameState> STATES;
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
        STATES = new Stack<GameState>();
        STATES.push(new MenuState(this));
    }
}
