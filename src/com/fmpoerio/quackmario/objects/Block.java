package com.fmpoerio.quackmario.objects;

import com.fmpoerio.quackmario.gamestate.GameState;

import javax.swing.*;
import java.awt.*;

public class Block {
    private static final long serialVersionUID = 1L;
    private int x,y;
    private Image blockImage;

    private static final int blockSize = 32;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    }
    public void draw(Graphics g) {
        g.drawImage(blockImage, getX()- (int) GameState.xOffset, getY()- (int) GameState.yOffset, null);
    }

    public Block(int x, int y) {
        setX(x);
        setY(y);
        setBlockImage(new ImageIcon("Assets/QuackMario_Bricks.png").getImage().getScaledInstance(blockSize,
                blockSize, Image.SCALE_SMOOTH));

    }

    public boolean contains(Point p) {
        return false;
    }
}
