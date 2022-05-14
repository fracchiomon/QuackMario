package com.fmpoerio.quackmario.entities;
//Imports relativi al progetto
import com.fmpoerio.quackmario.GamePanel;
import com.fmpoerio.quackmario.KeyboardMouseListeners;

//Imports relativi a KeyEvents e MouseEvents e AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

//TODO: cambia Rectangle per usare la papera PNG
public class Player {
    private static final long serialVersionUID = 1L;
    private double x = GamePanel.getWIDTH()/2, y = GamePanel.getHEIGHT()/2;
    private double jumpSpeed = 5, currJumpSpeed = jumpSpeed;
    private double maxFallSpeed = 5, currFallSpeed = .1;
    private int width, height;
    private final int xMovSpeed = 10;
    private final int yMovSpeed = 10;
    private boolean goesRight = false, goesLeft = false, jumping = false, falling = false, honks = false;
    private final Image playerImage;
    public KeyboardMouseListeners kbdMouse;


    public boolean isGoingRight() {
        return goesRight;
    }
    public boolean isGoingLeft() {
        return goesLeft;
    }
    public boolean isJumping() {
        return jumping;
    }
    public boolean isFalling(){
        return falling;
    }

    public boolean isHonking() {
        return honks;
    }

    public void setHonks(boolean honks) {
        this.honks = honks;
    }

    public void setJumping(boolean move) {
        this.jumping = move;
    }
    public void setFalling(boolean move) {
        this.falling = move;
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
    public double getXpos() {
        return x;
    }
    public double getYpos() {
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
        if(isJumping()) {
            y = y - currJumpSpeed;
            currJumpSpeed -= .1;
            if(currJumpSpeed <= 0) {
                currJumpSpeed = jumpSpeed;
                setJumping(false);
                setFalling(true);
            }
            if(y < 0) {
                y = GamePanel.getHEIGHT();
            }
        }
        else if (isFalling()) {
            y = y + currFallSpeed;
            if (currFallSpeed < maxFallSpeed)
                currFallSpeed += .1;
            if(y > GamePanel.getHEIGHT()) {
                y = 0;
            }
        }
        if (!isFalling())
            currFallSpeed = .1;
        if (isHonking()) {
            //TODO: IMPLEMENT HONK
        }


    }
    public void draw(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.fillRect(x,y,getWidthPlayer(),getHeightPlayer());
        g.drawImage(playerImage, (int)getXpos(), (int)getYpos(), null);

    }

    public Player(int widthPlayer, int heightPlayer) {
        setHeightPlayer(heightPlayer); //imposto dimensioni di Player e le passo a setBounds()
        setWidthPlayer(widthPlayer);
        playerImage = new ImageIcon("Assets/QuackMario_Player.png").getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
        //setBounds(x, y, width, height);
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
                    //setFalling(false);
                    setJumping(true);
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
                /*if ((e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP)) {
                    setJumping(false);
                }*/
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
