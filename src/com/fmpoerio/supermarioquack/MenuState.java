package com.fmpoerio.supermarioquack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;

public class MenuState extends GameState{

    protected Image background;
    protected final Color bgColor = Color.BLACK;
    protected KeyboardMouseListeners kbdMouse;

    protected static final String[] OPTIONS = {"Nuova Partita", "Help", "Esci"};
    private int currentSelection = 0;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        background = new ImageIcon("Assets/SuperMarioQuack_MarioQuack.png").getImage();

    }

    @Override
    public void init() {}

    @Override
    public void tick() {}

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
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            switch (currentSelection) {
                case 0:
                    //play
                    break;
                case 1:
                    //help
                    break;
                case 2:
                    //ESCE
                    System.exit(0);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
