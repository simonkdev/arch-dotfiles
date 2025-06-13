package com.javadevs.gui.game;

//Author: @simonkdev
//Version: 17/2/2025
//ask for more information if needed

import java.awt.Color;

import javax.swing.JButton;

import com.javadevs.ChessGameHandler;

public class chessButton extends JButton
{
    String name;
    String posY;
    String posX;
    int intX;
    int intY;
    public String color;

    Color DARK_PIECE_COLOR = new Color(189, 147, 216);
    Color LIGHT_PIECE_COLOR = new Color(222, 210, 232);
    
    public chessButton(String posXNew, String posYNew)
    {
        name = "button" + posXNew + posYNew;
        posY = posXNew;
        posX = posYNew;
        //2D array position[][] from ChessGameHandler.java has format position[y][x]
    }
    
    public void convertPosition(String pos)                  //CONVERTS POSITION TO NUMERIC VALUE FOR LATER COLOR CALCULATION
    {
        intX = pos.charAt(0) - 'a'; 	        					// Convert column letter to number (0-based), meaning a=0, b=1, c=2, ...
        intY = Character.getNumericValue(pos.charAt(1)) - 0; 	
        System.out.println("Converted intY: " + intY)	;// Convert row number to 0-based index, meaning 1=0, 2=1, 3=2, ...
    }



    public void setSquareColor() 
    {
        convertPosition(posY + posX);                                   // Convert the position to 0-based coordinates
        
        int sum = intX + intY;                                          // Calculate the sum of the coordinates
        
        // Determine the color based on the sum and set the global variable
        if (sum % 2 == 0) 
        {
            color = "black";
            this.setBackground(DARK_PIECE_COLOR); // Set the button background color to black
        } 
        else 
        {
            color = "white";
            this.setBackground(LIGHT_PIECE_COLOR); // Set the button background color to white
        }
    }

    public char getPiece(ChessGameHandler arrayHandler) 
    {
        convertPosition(posY + posX); // Convert the position to numeric values for array access
        System.out.println("Getting piece for position: " + intX + ", " + intY);
        System.out.println("Piece is: " + arrayHandler.position[intX][intY]);
        return arrayHandler.position[intX][intY]; // Get the piece from the game handler's position array
    }
}
