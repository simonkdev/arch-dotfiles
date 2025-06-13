package com.javadevs.gui.game;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class BoardSpace extends JPanel
{
    JPanel LEFT_SPACER;
    JPanel RIGHT_SPACER;
    
    Dimension SPACER_SIZE;

    GridLayout SPACED_LAYOUT;

    public BoardSpace(ChessBoard board, ChessboardGUI frame)
    {
        int WIDTH_SPACING = (frame.getWidth() - board.TRUE_BOARD_WIDTH) / 2;
        System.out.println(frame.getWidth());
        SPACER_SIZE = new Dimension(WIDTH_SPACING, board.getHeight());
        
        SPACED_LAYOUT = new GridLayout(1, 3); // 1 row, 3 columns
    
        setLayout(SPACED_LAYOUT);
        setSize(new Dimension(frame.getWidth(), board.getHeight()));
        setOpaque(false);
        setVisible(true);
        build_spacers();
        add_spacers(board);
    }

    public void build_spacers()
    {
        LEFT_SPACER = new JPanel();
        RIGHT_SPACER = new JPanel();

        LEFT_SPACER.setPreferredSize(SPACER_SIZE);
        RIGHT_SPACER.setPreferredSize(SPACER_SIZE);

        LEFT_SPACER.setOpaque(false);
        RIGHT_SPACER.setOpaque(false);

        LEFT_SPACER.setVisible(true);
        RIGHT_SPACER.setVisible(true);
    }

    public void add_spacers(ChessBoard board)
    {
        add(LEFT_SPACER);
        add(board);
        add(RIGHT_SPACER);
    }

}

