package com.fmpoerio.quackmario.entities;
//Imports relativi al progetto
import com.fmpoerio.quackmario.GamePanel;
import com.fmpoerio.quackmario.KeyboardMouseListeners;

//Imports relativi a KeyEvents e MouseEvents e AWT
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

//TODO: cambia Rectangle per usare la papera PNG
public class Player extends Rectangle {
    private static final long serialVersionUID = 1L;
    private int x = GamePanel.getWIDTH()/2, y = GamePanel.getHEIGHT()/2, width, height;
    private final int xMovSpeed = 10;
    private final int yMovSpeed = 10;
    private boolean goesRight = false, goesLeft = false, goesUp = false, goesDown = false, honks = false;
    public KeyboardMouseListeners kbdMouse;

    public boolean isGoingRight() {
        return goesRight;
    }
    public boolean isGoingLeft() {
        return goesLeft;
    }
    public boolean isGoingUp() {
        return goesUp;
    }
    public boolean isGoingDown(){
        return goesDown;
    }

    public boolean isHonking() {
        return honks;
    }

    public void setHonks(boolean honks) {
        this.honks = honks;
    }

    public void setGoesUp(boolean move) {
        this.goesUp = move;
    }
    public void setGoesDown(boolean move) {
        this.goesDown = move;
    }

    public void setGoesRight(boolean move) {
        this.goesRight = move;
    }
    public void setGoesLeft(boolean move) {
        this.goesLeft = move;
    }

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
        if(isGoingRight()) {
            x = x + xMovSpeed;
            if (x > GamePanel.getWIDTH()) {
                x = -30;
            }
        }
        else if(isGoingLeft()) {
            x = x - xMovSpeed;
            if(x < 0) {
                x = GamePanel.getWIDTH();
            }
        }
        if(isGoingUp()) {
            y = y - yMovSpeed;
            if(y < 0) {
                y = GamePanel.getHEIGHT();
            }
        }
        else if (isGoingDown()) {
            y = y + yMovSpeed;
            if(y > GamePanel.getHEIGHT()) {
                y = 0;
            }
        }
        if (isHonking()) {
            //TODO: IMPLEMENT HONK
        }


    }
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,getWidthPlayer(),getHeightPlayer());

    }

    public Player(int widthPlayer, int heightPlayer) {
        setHeightPlayer(heightPlayer); //imposto dimensioni di Player e le passo a setBounds()
        setWidthPlayer(widthPlayer);
        setBounds(x, y, width, height);
        //uso kbdMouse per gestire le interazioni da tastiera e mouse
        kbdMouse = new KeyboardMouseListeners() {
            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_KP_RIGHT)){
                    setGoesRight(true);
                }
                else if ((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_KP_LEFT)) {
                    setGoesLeft(true);
                }
                if ((e.getKeyCode() == KeyEvent.VK_SPACE)) {
                    setGoesDown(false);
                    setGoesUp(true);
                }
                /*
                    else if((e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN)) {
                    setGoesUp(false);
                    setGoesDown(true);
                }*/
                if ((e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_ENTER)) {
                    setHonks(true);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_KP_RIGHT)){
                    setGoesRight(false);
                }
                else if ((e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_KP_LEFT)) {
                    setGoesLeft(false);
                }
                if ((e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP)) {
                    setGoesUp(false);
                }
                if ((e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_ENTER)) {
                    setHonks(false);
                }
                /*
                else if((e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN)) {
                    setGoesDown(false);
                }*/
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
