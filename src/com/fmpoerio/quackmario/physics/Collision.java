package com.fmpoerio.quackmario.physics;

import com.fmpoerio.quackmario.objects.Block;

import java.awt.*;

public class Collision {
    public static boolean playerToBlock(Point p, Block b) {
        return b.contains(p);
    }
}
