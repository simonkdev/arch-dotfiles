package com.javadevs.gui.game;

import java.awt.Color;
import java.awt.Dimension;

//Developer: @simonkdev
//Version: 17/02/2025
//For more information check out INFORMATION.md

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.javadevs.ChessGameHandler;
import com.javadevs.gui.game.ChessBoard;
import com.javadevs.gui.game.bottomBar;
import com.javadevs.gui.game.topBar;
import com.javadevs.gui.game.BoardSpace;

import javax.swing.ImageIcon;
import com.javadevs.gui.BasicBackgroundPanel;

//für position[][] gilt: position[y][x] (im Array)

public class ChessboardGUI extends JFrame
{
  @SuppressWarnings("unused")
  public Dimension FRAME_SIZE = new Dimension(400, 600);

  ChessGameHandler gameHandler;
  ChessBoard board;
  bottomBar actionBar;
  topBar topBar;
  BoardSpace spacedBoard;
  
  public ChessboardGUI () 
  {
     gameHandler = new ChessGameHandler();
     board = new ChessBoard(gameHandler);
     bottomBar = new bottomBar(this);
     topBar = new topBar();
     spacedBoard = new BoardSpace(board, this);
  }

  public void init_main_window()
  {
    int VERTICAL_SPACING = FRAME_SIZE - (board.BOARD_SIZE.height + actionBar.getHeight() + bottomBar.BAR_HEIGHT);

    Dimension BOTTOM_SPACER_SIZE = new Dimension(0, 50);
    Dimension TOP_SPACER_SIZE = new Dimension(0, 50);
=======
    Dimension BOTTOM_SPACER_SIZE = new Dimension(0, 50);
    Dimension TOP_SPACER_SIZE = new Dimension(0, 50);
>>>>>>> parent of b80bc00 (something broke idfk)

    setSize(FRAME_SIZE);

        // 1. Set the background panel as content pane FIRST
    BasicBackgroundPanel backgroundPanel = new BasicBackgroundPanel(
        new ImageIcon("src/main/resources/background.png").getImage()
    );
    setContentPane(backgroundPanel);

    getContentPane().setBackground(Color.BLACK);

    // 2. Set layout on the background panel
    BoxLayout WINDOW_LAYOUT = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
    getContentPane().setLayout(WINDOW_LAYOUT);

    // 3. Add components to the background panel
    getContentPane().add(topBar);
    getContentPane().add(Box.createRigidArea(TOP_SPACER_SIZE));
    getContentPane().add(SPACED_BOARD);
    getContentPane().add(Box.createRigidArea(BOTTOM_SPACER_SIZE));
    getContentPane().add(actionBar);

    setTitle("Chessboard");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setVisible(true);

    int TOTAL_CONTENT_SIZE = board.getHeight() + actionBar.getHeight() + topBar.getHeight() + SPACER_HEIGHT * 2;
    System.out.println("Total content size: " + TOTAL_CONTENT_SIZE);

    System.out.println("Action Bar Height: " + actionBar.getSize());
  }

  public void init_spacer_sizes();
  {

  }
}

