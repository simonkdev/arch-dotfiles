package com.javadevs.gui.game;

//Developer: @simonkdev
//Version: 17/02/2025
//For more information check out INFORMATION.md

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

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

    BoxLayout WINDOW_LAYOUT = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
    getContentPane().setLayout(WINDOW_LAYOUT);
  
    this.add(board);
    this.add(actionBar);
    setTitle("Chessboard");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 600);
    setResizable(false);
    setVisible(true);
  }
}

