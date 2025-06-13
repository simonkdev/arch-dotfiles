package com.javadevs.gui.game;

import com.javadevs.ChessGameHandler;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessBoard extends JPanel
{
    List<chessButton> BUTTON_LIST;
    int BUTTON_COUNT;
    int CURRENT_ROW;
    int BUTTON_SIZE;

    public Dimension BOARD_SIZE;

    int BOARD_WIDTH;

    public ChessBoard(ChessGameHandler arrayHandler) 
    {
        BUTTON_LIST = new ArrayList<>();
        
        BUTTON_COUNT = 0;
        CURRENT_ROW = 1; // Reset countRow for the first column
        
        BOARD_SIZE = new Dimension(320, 320); // Set the size of the board
        BOARD_WIDTH = BOARD_SIZE.width; // Store the true width of the board
        
        setBackground(Color.LIGHT_GRAY);
        setSize(new Dimension(BOARD_SIZE)); // Set preferred size for the panel
        setVisible(true);
        setOpaque(false); // Make sure the panel is opaque
        setFocusable(true); // Make the panel focusable
        setLayout(new GridLayout(8, 8));

        BUTTON_SIZE = BOARD_WIDTH / 8; // Since it's an 8x8 grid, divide the panel size by 8
        boardInit();

        //set_debug_board_labels(arrayHandler); // Set debug labels for the buttons
    }
    
    public void boardInit()
    {
      BUTTON_COUNT = 0;
      columnInit("a");
      columnInit("b");
      columnInit("c");
      columnInit("d");
      columnInit("e");
      columnInit("f");
      columnInit("g");
      columnInit("h");
    }

  public void columnInit(String column)
    {
      for(int i=0; i<8; i++)
    {
      chessButton button = new chessButton( column, String.valueOf(countRow));
      buttonConfig(button);
      BUTTON_LIST.add(button);
      this.add(button);
      CURRENT_ROW++;
      BUTTON_COUNT++;
    }
    CURRENT_ROW = 1;
  }

  @SuppressWarnings("deprecation")
  public void button_config(chessButton target)
  {
    target.setSize(new Dimension(BUTTON_COUNT, BUTTON_SIZE));
    ActionListener ON_BUTTON_CLICK = new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println(target.posY + target.posX); // Print the position of the button
            }
        };
    target.addActionListener(ON_BUTTON_CLICK);
    target.setSquareColor();
    target.setFocusPainted(false);
    target.setBorderPainted(false);    
  }

  public void set_debug_button_labels(ChessGameHandler arrayHandler, chessButton button)
  {
    String piece = arrayHandler.position[button.intX][button.intY];
    
    button.setText(piece); // Set the button label to the piece name
  
  }

  public void set_global_debug_labels(ChessGameHandler arrayHandler) // WRAPPER FOR SETTING DEBUG LABELS
  {
    for (chessButton button : BUTTON_LIST) 
    {
      set_debug_button_labels(arrayHandler, button);
    }
  }


}