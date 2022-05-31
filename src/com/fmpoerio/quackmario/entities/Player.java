package com.fmpoerio.quackmario.entities;
//Imports relativi al progetto
import com.fmpoerio.quackmario.game.KeyboardMouseListeners;
import com.fmpoerio.quackmario.gamestate.GameState;
import com.fmpoerio.quackmario.gamestate.GameStateManager;
import com.fmpoerio.quackmario.objects.Block;
import com.fmpoerio.quackmario.tilemap.TileMap;

//Imports relativi a KeyEvents e MouseEvents e AWT
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import java.applet.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//TODO: cambia Rectangle per usare la papera PNG
public class Player extends MapObject {
    private static final long serialVersionUID = 1L;
    //private double x = GamePanel.getWIDTH()/2, y = GamePanel.getHEIGHT()/2;
    private double x = 40, y = 250;
    private final double jumpSpeed = 5;
    private double currJumpSpeed = jumpSpeed;
    private double maxFallSpeed = 5;
    private double currFallSpeed = .1;
    private int width, height;
    private final int xMovSpeed = 10;
    private boolean goesRight = false, goesLeft = false, jumping = false, falling = false, honks = false;
    private final Image playerImage, playerImage_honk;
    // animation actions
    private static final int IDLE = 0;
    private static final int WALKING = 1;
    private static final int JUMPING = 2;
    private static final int FALLING = 3;
    private static final int HONK = 4;
    SoundFX honk;
    String honkPath = "Assets/Music/honk.wav";
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

    //public void setJumping(boolean move) {
        //this.jumping = move;
    //}
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
    public void setXpos(double x) {
        this.x = x;
    }
    public void setYpos(double y) {
        this.y = y;
    }
    private void getNextPosition() {

        // movement
        if (isGoingLeft()) {
            facingRight = false;


            dx -= moveSpeed;
            GameState.xOffset = dx;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else if (isGoingRight()) {
            facingRight = true;

            dx += moveSpeed;
            GameState.xOffset = dx;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= stopSpeed;
                GameState.xOffset = dx;
                if (dx < 0) {
                    dx = 0;
                }
            } else if (dx < 0) {
                dx += stopSpeed;
                GameState.xOffset = dx;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }

        // cannot move while attacking, except in air
        if ((currentAction == HONK) && !(jumping || falling)) {
            dx = 0;
            GameState.xOffset = dx;
        }

        // jumping
        if (jumping && !falling) {
            dy = jumpStart;
            falling = true;
        }

        // falling
        if (falling) {

            if (dy > 0){
                dy += fallSpeed;
                jumping = false;
            }

            if (dy < 0 && !jumping)
                dy += stopJumpSpeed;

            if (dy > maxFallSpeed)
                dy = maxFallSpeed;

        }
/*
        if(isGoingRight()) {
            GameState.xOffset += xMovSpeed;

        }
        else if(isGoingLeft()) {
            GameState.xOffset -= xMovSpeed;

        }
        if(isJumping()) {
            GameState.yOffset -= currJumpSpeed;
            currJumpSpeed -= .1;
            if(currJumpSpeed <= 0) {
                currJumpSpeed = jumpSpeed;
                setJumping(false);
                setFalling(true);
            }

        }
        else if (isFalling()) {
            GameState.yOffset += currFallSpeed;
            if (currFallSpeed < maxFallSpeed)
                currFallSpeed += .1;

        }
        if (!isFalling())
            currFallSpeed = .1;
        if (isHonking()) {
            //TODO: IMPLEMENT HONK
        }*/

    }

    public void tick() {


            // update position
            getNextPosition();
            setPosition(xtemp, ytemp);
            checkTileMapCollision();


            /*// set animation
            if (scratching) {
                if (currentAction != SCRATCHING) {
                    currentAction = SCRATCHING;
                    animation.setFrames(sprites.get(SCRATCHING));
                    animation.setDelay(50);
                    width = 60;
                }
            } else if (firing) {
                if (currentAction != FIREBALL) {
                    currentAction = FIREBALL;
                    animation.setFrames(sprites.get(FIREBALL));
                    animation.setDelay(100);
                    width = 30;
                }
            } else if (dy > 0) {
                if (gliding) {
                    if (currentAction != GLIDING) {
                        currentAction = GLIDING;
                        animation.setFrames(sprites.get(GLIDING));
                        animation.setDelay(100);
                        width = 30;
                    }
                } else if (currentAction != FALLING) {
                    currentAction = FALLING;
                    animation.setFrames(sprites.get(FALLING));
                    animation.setDelay(100);
                    width = 30;
                }
            } else if (dy < 0) {
                if (currentAction != JUMPING) {
                    currentAction = JUMPING;
                    animation.setFrames(sprites.get(JUMPING));
                    animation.setDelay(-1);
                    width = 30;
                }
            } else if (left || right) {
                if (currentAction != WALKING) {
                    currentAction = WALKING;
                    animation.setFrames(sprites.get(WALKING));
                    animation.setDelay(40);
                    width = 30;
                }
            } else {
                if (currentAction != IDLE) {
                    currentAction = IDLE;
                    animation.setFrames(sprites.get(IDLE));
                    animation.setDelay(100);
                    width = 30;
                }
            }

            animation.update();

            // set direction
            if (currentAction != SCRATCHING && currentAction != FIREBALL) {
                if (right)
                    facingRight = true;
                if (left)
                    facingRight = false;
            }

        }*/

        /*for (Block b : blocks) {
           if (Collision.playerToBlock(new Point((int) (x + width), (int) y), b) || Collision.playerToBlock(new Point
                   ((int) (x + width), (int) y + height), b));

        }*/




    }
    public void draw(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.fillRect(x,y,getWidthPlayer(),getHeightPlayer());
        //Graphics2D g2 = (Graphics2D) g;
        setMapPosition();
        //g.drawImage(playerImage_right, (int)getXpos(), (int)getYpos(), null);
        // draw player
        /*if (flinching) {
            long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
            if (elapsed / 100 % 2 == 0) {
                return;
            }
        }
*/
        if (facingRight) {
            if (isHonking()) {
                g.drawImage(playerImage_honk, (int) (getXpos() + xmap - width / 2), (int) (getYpos() + ymap - height / 2), null);
            }
            else
                g.drawImage(playerImage, (int) (getXpos() + xmap - width / 2), (int) (getYpos() + ymap - height / 2), null);
        } else {
            if (isHonking()) {
                g.drawImage(playerImage_honk, (int) (getXpos() + xmap - width / 2 + width), (int) (getYpos() + ymap - height / 2),
                        -width, height, null);
            }
            else
                g.drawImage(playerImage, (int) (getXpos() + xmap - width / 2 + width), (int) (getYpos() + ymap - height / 2),
                    -width, height, null);
        }


    }

    public Player(TileMap tm, int widthPlayer, int heightPlayer) {
        super(tm);
        width = widthPlayer;
        height = heightPlayer;
        cwidth = 16;
        cheight = 16;

        moveSpeed = 4;
        maxSpeed = 1.6;
        stopSpeed = 0.4;
        fallSpeed = 0.15;
        maxFallSpeed = 4.0;
        jumpStart = -5.5;
        stopJumpSpeed = 0.3;
        setHeightPlayer(height); //imposto dimensioni di Player e le passo a setBounds()
        setWidthPlayer(width);
        playerImage = new ImageIcon("Assets/Sprites/Player/QuackMario_Player.png").getImage().getScaledInstance(widthPlayer,heightPlayer,Image.SCALE_SMOOTH);
        playerImage_honk = new ImageIcon("Assets/Sprites/Player/QuackMario_Player_Honk.png").getImage().getScaledInstance(widthPlayer, heightPlayer, Image.SCALE_SMOOTH);
        //setBounds(x, y, width, height);
        setXpos(x); setYpos(y);
        setGoesRight(true);

        honk = new SoundFX(honkPath);

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
                    honk.playMusic();
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
                    honk.clip.setFramePosition(0);
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

class SoundFX
{
    File musicPath;
    Clip clip;

    SoundFX(String MusicLocation)
    {
        try
        {
            musicPath = new File (MusicLocation);
            File musicPath = new File (MusicLocation);

            if(musicPath.exists())
            {
                AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioinput);
            }
        }
        catch(Exception Ex)
        {
            Ex.printStackTrace();
        }
    }

    void playMusic()
    {

        if(musicPath.exists())
        {
            clip.start();
            //clip.loop(Clip.LOOP_CONTINUOUSLY);
            //clip.loop(Clip.LOOP_CONTINUOUSLY);

				/*JOptionPane.showMessageDialog(null, "ferma la canzone con ok");
				long clipTimePosition = clip.getMicrosecondPosition();
				clip.stop();

				JOptionPane.showMessageDialog(null,"premi per riprendere");
				clip.setMicrosecondPosition(clipTimePosition);
				clip.start();

				JOptionPane.showMessageDialog(null,"STOP");*/

        }
        else
        {
            System.out.println("Traccia non trovata!!");
        }


    }



    void stopMusic()
    {
        if(musicPath.exists())
        {
            clip.stop();
        }
        else
        {
            System.out.println("Traccia non trovata!!");
        }
    }

}