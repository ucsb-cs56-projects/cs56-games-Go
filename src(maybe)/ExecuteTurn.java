import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event. ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextArea;
import java.awt.Color;


import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class ExecuteTurn(){

	public ExecuteTurn(){

		char turn=game.getTurn();
            if(playSound){ //If sound is on, play it when the tile is clicked
                SoundEffect effect = new SoundEffect();
                effect.playEffect();
            } //basic stuff for showing who's turn it is and who's turn is next
            String nextTurn = "Black" ;
            if(turn == 'W')
                nextTurn = "Black";
            if(turn == 'B')
                nextTurn = "White";
            
            if (turn==' ')
                return;
            
            if (!game.isBlank(num)) { //This is output for clicking occupied tiles
                md.append("\n\nThat square is already occupied!");
                return;
            }
            
            // makeMove returns true if move is legal, false if move is illegal
            if (!game.makeMove(num)) { //If illegal, returns this
                md.append("\nCannot place tile there, it would be surrounded\n");
                return;
            }
            
            game.changeTurn(); //Changes turn
            JButton jb = buttons[num];
            jb.setFont(new Font("Arial",Font.BOLD,25));
            
            for(int i=1;i<362;i++){
                if(game.charAt(i) == 'W'){ //if element in Array list is W, set background color of JButton to WHITE
                    buttons[i].setBackground(Color.WHITE);
                    buttons[i].setForeground(Color.WHITE); // set font color of JButton to Black for visibility
                    buttons[i].setOpaque(true);
                    buttons[i].setBorderPainted(false);
                }
                else if(game.charAt(i) == 'B'){ //if element in ArrayList is B, set background color of JButton to BLACK
                    buttons[i].setBackground(Color.BLACK);
                    buttons[i].setForeground(Color.BLACK); // set font color of JButton to White for visibility
                    buttons[i].setOpaque(true);
                    buttons[i].setBorderPainted(false);
                }else if(game.charAt(i) == ' '){ //if ' ' element in Arraylist, set background color back to tan.
                    Color tan = new Color(210,180,140);
                    buttons[i].setBackground(tan);
                    buttons[i].setForeground(tan);
                }
                
            }
            
            //prints current score of game and whos turn it is
            md.append("\n\nWhite Score: " + game.getWScore() + "\nBlack Score: " + game.getBScore());
            md.append("\n" + nextTurn +"s turn.");
	}
}
