package com.fmpoerio.quackmario.entities;

import com.fmpoerio.quackmario.GamePanel;
import com.fmpoerio.quackmario.KeyboardMouseListeners;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

//TODO: cambia Rectangle per usare la papera PNG
public class Player extends Rectangle {
    private static final long serialVersionUID = 1L;
    private int x = GamePanel.getWIDTH()/2, y = GamePanel.getHEIGHT()/2, width, height;
    public KeyboardMouseListeners kbdMouse;

    public int getWidthPlayer() {
        return width;
    }
    public int getHeightPlayer() {
        return height;
    }
    public int getXpos() {
        return x;
    }
    public int getYpos() {
        return y;
    }
    public void setHeightPlayer(int height) {
        this.height = height;
    }
    public void setWidthPlayer(int width) {
        this.width = width;
    }
    public void setXpos(int x) {
        this.x = x;
    }
    public void setYpos(int y) {
        this.y = y;
    }

    public void tick() {

    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,getWidthPlayer(),getHeightPlayer());

    }

    public Player(int widthPlayer, int heightPlayer) {
        setHeightPlayer(heightPlayer);
        setWidthPlayer(widthPlayer);
        setBounds(x, y, width, height);

        kbdMouse = new KeyboardMouseListeners() {
            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        };

    }
}
