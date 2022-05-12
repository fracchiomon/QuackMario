package com.fmpoerio.supermarioquack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamePanel extends JPanel implements Runnable, KeyListener {

    private static int WIDTH = 854, HEIGHT = 480;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setWIDTH(int WIDTH) {
        GamePanel.WIDTH = WIDTH;
    }

    public static void setHEIGHT(int HEIGHT) {
        GamePanel.HEIGHT = HEIGHT;
    }

    private static boolean isRunning = false;
    private static int FPS = 30;
    private static long targetTime = 1000 / FPS;
    private Thread thread;
    private GameStateManager gameStateManager;


    public static boolean getIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean runs) {
        GamePanel.isRunning = runs;
    }

    public Thread getThread() {
        return thread;
    }

    public void start() {
        setIsRunning(true);
        thread = new Thread(this);
        thread.start();
    }

    public void tick() {
        gameStateManager.tick();
    }

    @Override
    public void run() {
        long startTime, elapsedTime, waitTime;
        gameStateManager = new GameStateManager();


        while (getIsRunning()) {
            startTime = System.nanoTime();
            tick();
            repaint();


            elapsedTime = System.nanoTime() - startTime;
            waitTime = targetTime - elapsedTime / 1000000;

            if (waitTime <= 0) {
                waitTime = 5;
            }

            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }




    public GamePanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        setFocusable(true);
        start();


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0,0,getWIDTH(),getHEIGHT());
        gameStateManager.draw(g);

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        gameStateManager.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gameStateManager.keyReleased(e);
    }
}