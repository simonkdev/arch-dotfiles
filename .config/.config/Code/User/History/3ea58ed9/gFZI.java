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
    JButton UNDO_BUTTON;

    Icon ABORT_ICON = new javax.swing.ImageIcon("src/main/resources/icons/abort_button.png");
    Icon UNDO_ICON = new javax.swing.ImageIcon("src/main/resources/icons/undo_button.png");

    
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
        UNDO_BUTTON = new JButton();
        
        ABORT_BUTTON.setSize(200, 50);
        UNDO_BUTTON.setSize(200, 50);

        ABORT_BUTTON.setIcon(ABORT_ICON);
        UNDO_BUTTON.setIcon(UNDO_ICON);

        ABORT_BUTTON.setContentAreaFilled(false);
        ABORT_BUTTON.setOpaque(false);
        
        UNDO_BUTTON.setContentAreaFilled(false);
        UNDO_BUTTON.setOpaque(false);

        ABORT_BUTTON.setBorderPainted(false);
        UNDO_BUTTON.setBorderPainted(false);

        ABORT_BUTTON.setFocusPainted(false);
        UNDO_BUTTON.setFocusPainted(false);

        ABORT_BUTTON.setVisible(true);
        UNDO_BUTTON.setVisible(true);

        ABORT_BUTTON.addActionListener(LIS_LIB.NEW_GAME_BUTTON_LISTENER);
        UNDO_BUTTON.addActionListener(LIS_LIB.LOAD_GAME_BUTTON_LISTENER);

        this.add(ABORT_BUTTON);
        this.add(UNDO_BUTTON);

    }
}
