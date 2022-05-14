package com.fmpoerio.quackmario.gamestate;

/*
* MenuState è la finestra del Menu Principale di Gioco, dove abbiamo le opzioni per Nuova Partita, Help (dove
* verranno visualizzati i tasti e lo scopo del gioco), e 'Esci' per terminare il programma
* Eredita da GameState, possiede una backgroundImage, dei Color preimpostati (BLACK), e una prima implementazione di
* KeyBoardMouseListeners.java
*
*/

import com.fmpoerio.quackmario.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    protected Image background;
    protected final Color bgColor = Color.BLACK;
    protected KeyboardMouseListeners kbdMouse;

    protected static final String[] OPTIONS = {"Nuova Partita", "Help", "Esci"}; //Nomi delle scelte
    private int currentSelection = 0;   //il 'cursore' che si muoverà nel menu per scegliere ed evidenziare le opzioni

    public MenuState(GameStateManager gsm) {
        super(gsm);
        //nel costruttore viene solo istanziato l'oggetto background per preparare l'immagine di sfondo
        //AL costruttore viene passato l'oggetto GameStateManager da passare al costruttore di GameState
        background = new ImageIcon("Assets/QuackMario_Player.png").getImage();

    }

    @Override
    public void init() {}

    @Override
    public void tick() {}

    /*
    draw() si occupa di renderizzare a schermo i componenti necessari; l'evidenziazione avviene scorrendo in un ciclo
    'currentSelection', e risettando all'occorrenza i colori delle stringhe
    TODO: USARE BUTTONS? COME IMPLEMENTARE LA POSSIBILITA DI SCEGLIERE TRAMITE MOUSE?
    */
    @Override
    public void draw(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0,0,GamePanel.getWIDTH(), GamePanel.getHEIGHT());
        g.drawImage(background,GamePanel.getWIDTH()/2 + 100, GamePanel.getHEIGHT()/2 - 100, null);
        for(int i = 0; i < OPTIONS.length; i++) {
            if(i == currentSelection) {
                g.setColor(Color.YELLOW);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font(QuackMario.getFONT(), Font.PLAIN, 48));
            g.drawString(OPTIONS[i], GamePanel.getWIDTH()/2 - 400, 300 + i * 75 );
        }
    }

    /*
    KeyPressed gestisce lo scorrimento tra le opzioni
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_KP_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) {
            currentSelection++;
            if(currentSelection >= OPTIONS.length)
                currentSelection = 0;
        }
        else if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_KP_UP) || (e.getKeyCode() == KeyEvent.VK_W)) {
            currentSelection--;
            if(currentSelection < 0)
                currentSelection = OPTIONS.length -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_E) {
            switch (currentSelection) {
                case 0:
                    //play
                    gameStateManager.getSTATES().push(new Level1State(gameStateManager));
                    break;
                case 1:
                    //help
                    gameStateManager.getSTATES().push(new HelpState(gameStateManager));
                    break;
                case 2:
                    //ESCE
                    System.exit(0);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            System.exit(0);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
