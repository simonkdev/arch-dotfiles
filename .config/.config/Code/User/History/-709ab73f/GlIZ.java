package com.javadevs.gui.game;



import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class topBar extends JPanel 
{ 
    Icon BACK_ICON = new ImageIcon("src/main/resources/icons/back.png");
    Icon SETTINGS_ICON = new ImageIcon("src/main/resources/icons/settings.png");
    Icon TOP_LOGO_ICON = new ImageIcon("src/main/resources/icons/top_logo.png");


    JButton backButton = new JButton();
    JButton settingsButton = new JButton();
    JButton TOP_LOGO_PLACEHOLDER = new JButton();
    JPanel SPACER_PANEL; // Spacer panel for future logo

    int BUTTON_SIZE = 30; // Size of the buttons
    int BAR_HEIGHT = 30; // Height of the top bar

    Dimension BAR_SPACER = new Dimension(260, 0); // Space between the two buttons

    BoxLayout BAR_LAYOUT = new BoxLayout(this, BoxLayout.X_AXIS); // Layout for the top bar

    public topBar(ChessboardGUI frame) {
        setSize(frame.FRAME_SIZE.width, BAR_HEIGHT);                 //(new Dimension(400, 30));
        setLayout(BAR_LAYOUT); // Use BoxLayout for proper spacing
        init_buttons();
        setOpaque(false); // Make sure background is transparent for future-proofing
        setVisible(true);
    }

    public void init_buttons() 
    {
        backButton.setSize(BUTTON_SIZE, BUTTON_SIZE);             //(new Dimension(30, 30));
        settingsButton.setSize(BUTTON_SIZE, BUTTON_SIZE);             //(new Dimension(30, 30));

        backButton.setIcon(BACK_ICON);
        settingsButton.setIcon(SETTINGS_ICON);

        backButton.setContentAreaFilled(false);
        backButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setOpaque(false);

        backButton.setBorderPainted(false);
        settingsButton.setBorderPainted(false);

        backButton.setFocusPainted(false);
        settingsButton.setFocusPainted(false);

        backButton.setBorderPainted(false);
        settingsButton.setBorderPainted(false);

        // backButton.addActionListener(LIS_LIB.BACK_BUTTON_LISTENER);
        // settingsButton.addActionListener(LIS_LIB.SETTINGS_BUTTON_LISTENER);
    }

    public void init_spacer_panel()
    {
        SPACER_PANEL = new JPanel();
        SPACER_PANEL.setSize(260, 0);
        SPACER_PANEL.setOpaque(false); // Make sure the spacer is transparent
        SPACER_PANEL.setVisible(true);
        SPACER_PANEL.setLayout(new GridLayout());

        init_logo_holder();
        SPACER_PANEL.add(TOP_LOGO_PLACEHOLDER); // Add a placeholder for future logo
    }

    public void init_logo_holder()
    {
        TOP_LOGO_PLACEHOLDER.setContentAreaFilled(false);
        TOP_LOGO_PLACEHOLDER.setOpaque(false);
        TOP_LOGO_PLACEHOLDER.setBorderPainted(false);
        TOP_LOGO_PLACEHOLDER.setFocusPainted(false);
        TOP_LOGO_PLACEHOLDER.setVisible(true); // Placeholder for future logo
        TOP_LOGO_PLACEHOLDER.setIcon(TOP_LOGO_ICON);
    }

    public void load_buttons()
    {

        this.add(backButton);
        this.add(SPACER_PANEL); // Invisible, future-proof spacer
        this.add(settingsButton);
    }
}
