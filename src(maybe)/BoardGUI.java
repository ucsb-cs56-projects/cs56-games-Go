//board gui
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
/**
 * An Swing component for playing go
 
 @author David Winkenwerder, Dustin Henderson
 @author Keith Waldron, Nick Abrahan
 @author Jeffrey Liu and Lauren Dumapias
 @author Dong He and Margaret Schmit
 @version CS56 2/21/16
 
 */

public class BoardGUI extends JComponent
{
    private TsumegoGameBoard game;
    private JTextArea md;
    
    private JButton [][] buttons = new JButton[19][19];
    
    
    /** Constructor
     
     @param game an object that implements the GoGame interface to keep track
     of the moves in each game, ensuring the rules are followed and detecting
     when someone has won.
     @param md an object that implements the MessageDestination interface.  This is just
     a place to send any messages that need to be communicated to the user.
     Making this separate allows a user of this components to decide to
     send those messages to the console, or to a variety of different
     swing Widgets, or even to a web page, as needed.
     */
    
    public BoardGUI(TsumegoGameBoard game, JTextArea md) {
        
        super(); // is this line necessary?  what does it do?
        this.game = game;  // the Go game
        this.md = md;  // a place we can write messages to
        
        // note columns ignored when rows are set
        // number of columns is implicit from the number of things added
        
        this.setLayout(new GridLayout(19,0));
        
        for(int rows=1; rows<=19; rows++) { //Code for adding all the buttons
        	for(int cols=1; cols<=19; cols++)

            JButton jb = new JButton("");
            buttons[rows][cols] = jb;
            Color tan = new Color(210,180,140);
            buttons[rows][cols].setBackground(tan);
            buttons[rows][cols].setForeground(tan);
            jb.addActionListener(new PlayTurnListener(rows,cols));
            this.add(jb);
        }
        
        
    }

    //Adds actionlistener for the tiles
    class PlayTurnListener implements ActionListener {
        
        private int[2] position;
        
        
        public PlayTurnListener(int row, int col) {
            super();  // is this line necessary? what does it do?
            this.position[0] = row;
            this.position[1] = col;
            
        }
        
        public void actionPerformed (ActionEvent event) {
            
            Player playerInTurn=game.getTurn();
          
            if (game.positionIsOccupied(position)) { //This is output for clicking occupied tiles
                md.append("\n\nThat square is already occupied!");
                return;
            }
            
            // makeMove returns true if move is legal, false if move is illegal
            if (!game.makeMove(num)) { //If illegal, returns this
                md.append("\nCannot place tile there, it would be surrounded\n");
                return;
            }
            
            game.switchTurn(); //Changes turn
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
    
    
    public void restart(){
        
        //Resets colors of the tiles on restart
        for(int i = 1;i<=361;i++){
            Color tan = new Color(210,180,140);
            buttons[i].setBackground(tan);
            buttons[i].setForeground(tan);
            buttons[i].setOpaque(false); //This line and next line for making tiles show up on mac
            buttons[i].setBorderPainted(true);
        }
    }
