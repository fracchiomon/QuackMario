package com.fmpoerio.quackmario.gamestate;

import com.fmpoerio.quackmario.game.GamePanel;
import com.fmpoerio.quackmario.tilemap.*;
import com.fmpoerio.quackmario.entities.*;
import com.fmpoerio.quackmario.objects.Block;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

/*
Primo livello di QuackMario, teoricamente dovrebbe essere una imitazione del primo livello di SuperMario Bros.
Quivi viene implementato il Player (e successivamente anche il fondale e le altre entities
TODO: TUTTO
COSA FUNZIONA? Player si muove a Sx e Dx e Su, e può passare da una parte all'altra dello schermo
 */
public class Level1State extends GameState{
    private TileMap tileMap;
    public Background bg;
    private Player player;
    private ArrayList<Block> blocks;
    private static int playerWidth, playerHeight;
    Random rng;


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
        setPlayerWidth(96); //imposto le dimensioni di Player per il Livello 1 e le passo al costruttore di Player
        setPlayerHeight(96);
        //player = new Player(playerWidth,playerHeight);


        tileMap = new TileMap(32);
        tileMap.loadTiles("Assets/Tilesets/QuackMario_Tile.png");
        tileMap.loadMap("Assets/Maps/testmap.map");
        tileMap.setPosition(0, 0);
        tileMap.setTween(1);

        bg = new Background("Assets/Backgrounds/back.png", 0.1);

        player = new Player(tileMap, playerWidth, playerHeight, 50, 350);
        blocks = new ArrayList<Block>(3);
        rng = new Random();
        int Offset[] = {16, -16}, randOffset, randX = -1, randY = -1, prevRandX = -1, prevRandY = -1;

        for(int i = 0; i < 3; i++) {
            prevRandX = randX;
            prevRandY = randY;
            randX = rng.nextInt(200, 400);
            randY = rng.nextInt(200, 400);
            randOffset = rng.nextInt(2);
            if (randX == randY || prevRandX == randX || prevRandY == randY) {
                i--;
            }
            else
                blocks.add(new Block(tileMap,randX + Offset[randOffset], randY + Offset[randOffset]));
        }
    }

    @Override
    public void tick() {
        //la tick chiama (per ora?) la tick() di player
        player.tick();
        tileMap.setPosition(GamePanel.getWIDTH() / 2 - player.getx(), GamePanel.getHEIGHT() / 2 - player.gety());

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g ;
        //g.setColor(Color.CYAN);
        //g.fillRect(0,0, GamePanel.getWIDTH(), GamePanel.getHEIGHT());
        bg.draw(g2);
        player.draw(g2);
        tileMap.draw(g2);


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
