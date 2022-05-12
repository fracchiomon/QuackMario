package com.fmpoerio.quackmario.gamestate;

import com.fmpoerio.quackmario.entities.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Level1State extends GameState{
    private Player player;

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        player = new Player(30,30);

    }

    @Override
    public void tick() {
        player.tick();

    }

    @Override
    public void draw(Graphics g) {
        player.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.kbdMouse.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.kbdMouse.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        player.kbdMouse.mouseClicked(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        player.kbdMouse.mouseMoved(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        player.kbdMouse.mouseExited(e);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        player.kbdMouse.mousePressed(e);
    }

}
