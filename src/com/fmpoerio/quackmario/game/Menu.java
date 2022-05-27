package com.fmpoerio.quackmario.game;

import com.fmpoerio.quackmario.gamestate.GameStateManager;
import com.fmpoerio.quackmario.gamestate.HelpState;
import com.fmpoerio.quackmario.gamestate.Level1State;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JMenuBar implements ActionListener {
    private JMenu menu[];
    private final static String menuText[] = {"Game", "About"};
    private JMenuItem menuItem[];
    private final static String menuItemText[] = {"Nuova Partita", "Help", "Esci"};
    private GameStateManager gsm;

    public Menu(GameStateManager gameStateManager) {
        super();
        gsm = gameStateManager;
        menu = new JMenu[2];
        menuItem = new JMenuItem[3];

        for (int m = 0; m < menu.length; m++) {
            menu[m] = new JMenu(menuText[m]);
            add(menu[m]);
        }
        for (int m = 0; m < menuItem.length; m++) {
            menuItem[m] = new JMenuItem(menuItemText[m]);
            menuItem[m].addActionListener(this);
            menu[0].add(menuItem[m]);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (menuItem[0].equals(e.getSource())) {
            gsm.getSTATES().push(new Level1State(gsm));
        }
        else if (menuItem[1].equals(e.getSource())) {
            gsm.getSTATES().push(new HelpState(gsm));
        }
        else if (menuItem[2].equals(e.getSource())) {
            gsm.getSTATES().clear();
            System.exit(0);
        }
    }
}
