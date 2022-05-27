package com.fmpoerio.quackmario.game;
import com.fmpoerio.quackmario.gamestate.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Qui si svolge il grosso dell'azione, GamePanel estende JPanel e implementa le interfacce per l'animazione a Loop
 * e per il KeyListening (sicuramente dovrò implementare anche MouseListener, altrimenti potrei usare i metodi di JPanel
 * senza farli ereditare direttamente, andando a estendere la classe astratta KeyBoardMouseListeners.java
 *
 */


public class GamePanel extends JPanel implements Runnable, KeyListener {

    private static int WIDTH = 854, HEIGHT = 480; //Dimensioni della finestra di gioco

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
    //Ho trovato qualcosa che mi permettesse di usare la classe Thread e sto cercando di capirci un po' di più.
    //nel frattempo seguo e noto l'utilizzo delle variabili per i FramesPerSecond e il TargetTime che stabilisce
    //quanto dover aspettare tra un tick e l'altro per poter evitare eventuali drastiche perdite di frames
    private static int FPS = 60;
    private static long targetTime = 1000 / FPS;
    private Thread thread;
    private GameStateManager gameStateManager;
    private Menu menu;

    public Menu getMenuBar() {
        return menu;
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public static boolean getIsRunning() {
        return isRunning;
    }

    public static void setIsRunning(boolean runs) {
        GamePanel.isRunning = runs;
    }

    public Thread getThread() {
        return thread;
    }

    //Metodo start() che serve per inizializzare il Thread con l'oggetto GamePanel e farlo 'partire'
    public void start() {
        setIsRunning(true);
        thread = new Thread(this);
        thread.start();
    }

    //tick() gestisce cosa viene effettuato ad ogni 'iterazione', in questo caso viene chiamata a cascata la
    //tick() di GameStateManager
    public void tick() {
        gameStateManager.tick();
    }
    /*
      run(), Override della funzione Runnable.run(), gestisce il loop del gioco, abbiamo le variabili relativi al tempo
      iniziale del ciclo (startTime)
      quello impiegato (elapsedTime) e il tempo da aspettare prima di procedere alla prossima iterazione (waitTime),
        calcolato come il rapporto tra la differenza fra targetTime e elapsedTime diviso per 10E+6. Se il valore
        risultante fosse <= 0, allora waitTime viene impostato a 5ms.
    */
    @Override
    public void run() {
        long startTime, elapsedTime, waitTime;
        gameStateManager = new GameStateManager();
        menu = new Menu(gameStateManager);



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
                Thread.sleep(waitTime); //sleep for x milliseconds
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }






    //Costructor di GamePanel in cui si imposta la PreferredSize e si aggiunge il KeyListener, dopodiché la si predispo-
    //-ne per poter accettare il Focus, infine si chiama la funzione start().
    public GamePanel() {
        super(new BorderLayout());

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        addKeyListener(this);
        setFocusable(true);
        start();


    }

    //paintComponent disegna il rettangolo di gioco richiamando la funzione draw() di GameStateManager (definito da
    // run())
    //prima di ogni draw viene chiamata la clearRect() che "ripulisce" l'area ad ogni iterazione di Run()
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g ;
        g.clearRect(0,0,getWIDTH(),getHEIGHT());
        gameStateManager.draw(g2);

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