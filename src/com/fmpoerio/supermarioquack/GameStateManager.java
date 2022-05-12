package com.fmpoerio.supermarioquack;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {
    private Stack<GameState> STATES;
    public void draw(Graphics g) {
        STATES.peek().draw(g);
    }
    public void tick() {
        STATES.peek().tick();

    }
    public void keyPressed(int k) {
        STATES.peek().keyPressed(k);

    }
    public void keyReleased(int k) {
        STATES.peek().keyReleased(k);

    }

    public GameStateManager() {
        STATES = new Stack<GameState>();
        STATES.push(new MenuState(this));
    }
}
