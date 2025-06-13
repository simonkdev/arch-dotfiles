package com.javadevs.gui.game;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoardSpace extends JPanel
{
    JPanel LEFT_SPACER;
    JPanel RIGHT_SPACER;
    
    Dimension SPACER_SIZE;

    BoxLayout SPACE_LAYOUT;

    public BoardSpace(ChessBoard board, ChessboardGUI frame)
    {
        int HORIZONTAL_SPACING = (frame.FRAME_SIZE.width - board.BOARD_SIZE.width) / 2;
        SPACER_SIZE = new Dimension(HORIZONTAL_SPACING, board.BOARD_SIZE.width);
        SPACE_LAYOUT = new BoxLayout(this, BoxLayout.X_AXIS);

        setLayout(SPACE_LAYOUT);
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

        LEFT_SPACER.setSize(40, 320);
        RIGHT_SPACER.setSize(40, 320);

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

