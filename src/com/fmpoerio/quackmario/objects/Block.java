package com.fmpoerio.quackmario.objects;

import com.fmpoerio.quackmario.entities.MapObject;
import com.fmpoerio.quackmario.gamestate.GameState;
import com.fmpoerio.quackmario.tilemap.TileMap;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Block extends MapObject {
    private static final long serialVersionUID = 1L;
    private double x,y;
    private Image blockImage;
    private TileMap tm;
    private Rectangle2D blockRect;

    public Rectangle2D getBlockRect() {
        return blockRect;
    }

    private static final int blockSize = 48;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getBlockSize() {
        return blockSize;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Image getBlockImage() {
        return blockImage;
    }

    public void setBlockImage(Image blockImage) {
        this.blockImage = blockImage;
    }

    public void tick() {
        //mapObject.checkTileMapCollision();
        // update position
        setMapPosition();
        checkTileMapCollision();



    }
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        setPosition(x, y);
        g2.drawImage(blockImage, (int)getX()- (int) GameState.xOffset, (int)getY()- (int) GameState.yOffset, null);
        //g2.drawImage(blockImage, (int)getX(), (int)getY(), null);
    }

    public Block(TileMap tm, int x, int y) {
        super(tm);
        setX(x);
        setY(y);
        width = 16;
        height = 16;
        cwidth = 16;
        cheight = 16;
        setBlockImage(new ImageIcon("Assets/Sprites/Objects/QuackMario_Bricks.png").getImage().getScaledInstance(blockSize,
                blockSize, Image.SCALE_SMOOTH));


    }


}
