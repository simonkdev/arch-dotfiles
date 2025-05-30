package com.javadevs.gui.game;

import java.awt.Dimension;

import javax.swing.JButton;

public class topBar extends JPanel 
{ 

    JButton backButton;
    JButton settingsButton;
    Dimension BAR_SPACER = new Dimension(200, 50); // Space between the two buttons

    public topBar() {
        backButton = new JButton("Back");
        settingsButton = new JButton("Settings");

        backButton.setSize(100, 50);
        settingsButton.setSize(100, 50);

        backButton.setVisible(true);
        settingsButton.setVisible(true);
    }


}
