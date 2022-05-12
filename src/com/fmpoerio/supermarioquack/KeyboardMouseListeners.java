package com.fmpoerio.supermarioquack;

import java.awt.event.*;
import java.util.Hashtable;

public abstract class KeyboardMouseListeners implements KeyListener, MouseListener, MouseMotionListener {

    protected static final int[] MOVE_KEYS_CODES = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D,
                                        KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT,
                                     KeyEvent.VK_KP_UP,KeyEvent.VK_KP_DOWN,KeyEvent.VK_KP_LEFT,KeyEvent.VK_KP_RIGHT};
    protected static final String[] MOVE_KEYS_NAME = {
            "UP", "LEFT", "DOWN", "RIGHT", "ARROW_UP", "ARROW_DOWN", "ARROW_LEFT", "ARROW_RIGHT",
            "KEYPAD_UP", "KEYPAD_DOWN", "KEYPAD_LEFT", "KEYPAD_RIGHT"
    };
    protected static int[] ACTION_KEYS_CODES = {KeyEvent.VK_E, KeyEvent.VK_ENTER, MouseEvent.BUTTON1};
    protected static final String[] ACTION_KEYS_NAME = {"E_KEY", "ENTER_KEY", "MOUSE_LEFT_CLICK"};
    private static Hashtable<String, Integer> KEYS_HASHTABLE;

    public static Hashtable<String, Integer> getKeysHashtable() {
        return KEYS_HASHTABLE;
    }

    public boolean click = false;

    public KeyboardMouseListeners() {
        KEYS_HASHTABLE = new Hashtable<String, Integer>();
        for(int i = 0; i < MOVE_KEYS_CODES.length; i++) {
            KEYS_HASHTABLE.put(MOVE_KEYS_NAME[i], MOVE_KEYS_CODES[i]);
        }
        for(int j = 0; j < ACTION_KEYS_CODES.length; j++) {
            KEYS_HASHTABLE.put(ACTION_KEYS_NAME[j],ACTION_KEYS_CODES[j]);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
