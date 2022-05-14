package com.fmpoerio.quackmario.gamestate;

import com.fmpoerio.quackmario.GamePanel;
import com.fmpoerio.quackmario.entities.*;
import com.fmpoerio.quackmario.objects.Block;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/*
Primo livello di QuackMario, teoricamente dovrebbe essere una imitazione del primo livello di SuperMario Bros.
Quivi viene implementato il Player (e successivamente anche il fondale e le altre entities
TODO: TUTTO
COSA FUNZIONA? Player si muove a Sx e Dx e Su, e può passare da una parte all'altra dello schermo
 */
public class Level1State extends GameState{
    private Player player;
    private Block[] blocks;
    private static int playerWidth, playerHeight;

    public int getPlayerWidth() {
        return playerWidth;
    }

    public void setPlayerWidth(int playerWidth) {
        Level1State.playerWidth = playerWidth;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(int playerHeight) {
        Level1State.playerHeight = playerHeight;
    }

    public Level1State(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        setPlayerWidth(100); //imposto le dimensioni di Player per il Livello 1 e le passo al costruttore di Player
        setPlayerHeight(100);
        player = new Player(playerWidth,playerHeight);
        blocks = new Block[3];
        blocks[0] = new Block(100,100);
        blocks[1] = new Block(200,300);
        blocks[2] = new Block(600,400);

    }

    @Override
    public void tick() {
        for (Block b : blocks) {
            b.tick();
        }
        //la tick chiama (per ora?) la tick() di player
        player.tick(blocks);

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0, GamePanel.getWIDTH(), GamePanel.getHEIGHT());
        player.draw(g);
        for(Block b : blocks) {
            b.draw(g);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) { //TORNA AL MENU PRINCIPALE
            //gameStateManager.getSTATES().push(new MenuState(gameStateManager));
            gameStateManager.getSTATES().pop(); //poiché precedentemente vi era il Menu, torniamo ad esso, liberando la
            //memoria del Level1
        }

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
