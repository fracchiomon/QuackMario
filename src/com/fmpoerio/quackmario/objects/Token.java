package com.fmpoerio.quackmario.objects;

import com.fmpoerio.quackmario.entities.MapObject;
import com.fmpoerio.quackmario.tilemap.TileMap;

public class Token extends MapObject {
    private static final long serialVersionUID = 1L;


    double x, y;
    int width, height;
    boolean consumed;

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public void init(double x, double y, int width, int height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
        setPosition(x, y);
        setConsumed(false);
    }

    public Token(TileMap tm, double x, double y, int width, int height) {
        super(tm);
        init(x,y,width,height);
        System.out.println("Token creato\n");
    }



}
