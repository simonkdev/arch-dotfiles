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
  bottomBar bottomBar;
  topBar topBar;
  BoardSpace spacedBoard;

  Dimension TOP_SPACER_SIZE;
  Dimension BOTTOM_SPACER_SIZE;

  BoxLayout WINDOW_LAYOUT = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
  
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
    window_init();
    init_spacer_sizes();
    setSize(FRAME_SIZE);


    // 2. Set layout on the background panel
    
    getContentPane().setLayout(WINDOW_LAYOUT);

    // 3. Add components to the background panel
    getContentPane().add(topBar);
    getContentPane().add(Box.createRigidArea(TOP_SPACER_SIZE));
    getContentPane().add(SPACED_BOARD);
    getContentPane().add(Box.createRigidArea(BOTTOM_SPACER_SIZE));
    getContentPane().add(actionBar);
  }

  public void init_spacer_sizes()
  {
    int VERTICAL_SPACING = (FRAME_SIZE.height - (board.BOARD_SIZE.height + topBar.BAR_HEIGHT + bottomBar.BAR_HEIGHT)) / 2;

    BOTTOM_SPACER_SIZE = new Dimension(FRAME_SIZE.width, VERTICAL_SPACING);
    TOP_SPACER_SIZE = new Dimension(FRAME_SIZE.width, VERTICAL_SPACING);

  }

  public void window_init()
  {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Spell-Chess");
    setSize(FRAME_SIZE);
    setLayout(WINDOW_LAYOUT);
    setResizable(false);
    setVisible(true);

    BasicBackgroundPanel backgroundPanel = new BasicBackgroundPanel(
        new ImageIcon("src/main/resources/background.png").getImage()
    );
    setContentPane(backgroundPanel);
  }
}

