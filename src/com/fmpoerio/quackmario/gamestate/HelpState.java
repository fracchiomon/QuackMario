package com.fmpoerio.quackmario.gamestate;

import com.fmpoerio.quackmario.game.GamePanel;
import com.fmpoerio.quackmario.game.KeyboardMouseListeners;
import com.fmpoerio.quackmario.game.QuackMario;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelpState extends GameState{

    private static final int width = GamePanel.getWIDTH(), height = GamePanel.getHEIGHT();
    protected final Color bgColor = Color.BLACK;
    private static final String[] text = {
           "Benvenuto!",
            "Premi 'A' o 'D' per andare rispettivamente a sinistra e destra.",
            "Puoi usare anche le Frecce direzionali!",
            "Premi 'Spazio' per saltare.",
            "Premi 'E' o 'Enter' per scatenare l'HONK! Occhio che ha bisogno",
            "di tempo per ricaricarsi!",
            "Premi 'BackSpace' o 'Esc' per tornare indietro."
    };
;
    protected KeyboardMouseListeners kbdMouse;


    public HelpState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
    }

    @Override
    public void tick() {

    }

    @Override
    public void draw(Graphics g) {
        int xText = 10, yText = 100;
        int yTextOffset = 40;
        g.setColor(bgColor);
        g.fillRect(0,0,GamePanel.getWIDTH(), GamePanel.getHEIGHT());
        //g.drawImage(background,GamePanel.getWIDTH()/2 + 100, GamePanel.getHEIGHT()/2 - 100, null);
        /*for(int i = 0; i < OPTIONS.length; i++) {
            if(i == currentSelection) {
                g.setColor(Color.YELLOW);
            }
            else {
                g.setColor(Color.WHITE);
            }
            g.setFont(new Font(QuackMario.getFONT(), Font.PLAIN, 48));
            g.drawString(OPTIONS[i], GamePanel.getWIDTH()/2 - 400, 300 + i * 75 );
        }*/
        for (String s : text) {
            g.setColor(Color.WHITE);
            g.setFont(new Font(QuackMario.getFONT(), Font.PLAIN, 28));
            g.drawString(s, xText, yText);
            yText += yTextOffset;
        }



    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            gameStateManager.getSTATES().pop();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
