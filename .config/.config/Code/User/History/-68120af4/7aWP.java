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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.javadevs.ChessGameHandler;
import com.javadevs.gui.game.ChessBoard;
import com.javadevs.gui.game.bottomBar;

//für position[][] gilt: position[y][x] (im Array)

public class ChessboardGUI extends JFrame
{
  @SuppressWarnings("unused")
  
  public ChessboardGUI () 
  {
    //board.ChessBoard();

  }

  public void init_main_window()
  {
    ChessBoard board = new ChessBoard();
    ChessGameHandler gameHandler = new ChessGameHandler();
    bottomBar actionBar = new bottomBar();
    topBar topBar = new topBar();

    Dimension BOTTOM_SPACER_SIZE = new Dimension(0, 50); // Space between the board and the action bar
    Dimension TOP_SPACER_SIZE = new Dimension(0, 50); // Space at the top of the window

    setSize(400, 600);

    BoxLayout WINDOW_LAYOUT = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
    getContentPane().setLayout(WINDOW_LAYOUT);
  
    JButton BOTTOM_SPACER = new JButton();
    BOTTOM_SPACER.setPreferredSize(BOTTOM_SPACER_SIZE);
    JButton TOP_SPACER = new JButton();
    TOP_SPACER.setPreferredSize(TOP_SPACER_SIZE);
    BOTTOM_SPACER.setContentAreaFilled(false); // Make the spacer transparent
    TOP_SPACER.setContentAreaFilled(false); // Make the spacer transparent
    BOTTOM_SPACER.setOpaque(false); // Make the spacer transparent
    TOP_SPACER.setOpaque(false); // Make the spacer transparent
    BOTTOM_SPACER.setVisible(true); // Make the spacer visible
    TOP_SPACER.setVisible(true); // Make the spacer visible

    this.add(topBar);
    this.add(TOP_SPACER); // Add some space at the top of the window
    this.add(board);
    this.add(BOTTOM_SPACER); // Add some space between the board and the action bar
    this.add(actionBar);
    setTitle("Chessboard");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    setBackground(Color.BLACK);
    setResizable(false);
    setVisible(true);
  }
}

