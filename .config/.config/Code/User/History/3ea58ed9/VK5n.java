package com.javadevs.gui.game;

import com.javadevs.gui.game.uiButtonListeners;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Icon;

public class bottomBar extends JPanel
{
    JButton ABORT_BUTTON;
    JButton button2;

    Icon NEW_GAME_ICON = new javax.swing.ImageIcon("src/main/resources/icons/new_game.png");
    Icon LOAD_GAME_ICON = new javax.swing.ImageIcon("src/main/resources/icons/load_game.png");

    
    uiButtonListeners LIS_LIB = new uiButtonListeners();

    public bottomBar()
    {
        setSize(400, 50);
        setBackground(Color.black);
        setLayout(new GridLayout(1, 4)); // 1 row, 4 columns
        load_buttons_bar();
        setOpaque(false);
        setVisible(true);
    }
    
    public void load_buttons_bar()
    {
        ABORT_BUTTON = new JButton();
        button2 = new JButton();
        
        ABORT_BUTTON.setSize(200, 50);
        button2.setSize(200, 50);

        ABORT_BUTTON.setIcon(NEW_GAME_ICON);
        button2.setIcon(LOAD_GAME_ICON);

        ABORT_BUTTON.setContentAreaFilled(false);
        ABORT_BUTTON.setOpaque(false);
        
        button2.setContentAreaFilled(false);
        button2.setOpaque(false);

        ABORT_BUTTON.setBorderPainted(false);
        button2.setBorderPainted(false);

        ABORT_BUTTON.setFocusPainted(false);
        button2.setFocusPainted(false);

        ABORT_BUTTON.setVisible(true);
        button2.setVisible(true);

        ABORT_BUTTON.addActionListener(LIS_LIB.NEW_GAME_BUTTON_LISTENER);
        button2.addActionListener(LIS_LIB.LOAD_GAME_BUTTON_LISTENER);

        this.add(ABORT_BUTTON);
        this.add(button2);

    }
}
