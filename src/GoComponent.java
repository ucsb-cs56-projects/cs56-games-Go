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

public class GoComponent extends JComponent
{
    private GoGame game;
    private GoGrid grid;
    private JTextArea md;
    
    private MyButton [] buttons = new MyButton[362];
    private int gridSize;
    private int gridSideLength;
    
    
    private boolean playSound = true;
    private boolean playMusic = true;
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
    
    public GoComponent(GoGame game, JTextArea md) {
        
        super(); // is this line necessary?  what does it do?
        this.game = game;  // the Go game
        this.md = md;  // a place we can write messages to
        
        gridSize = game.getGridSize();
        gridSideLength = game.getSideLength();


        // note columns ignored when rows are set
        // number of columns is implicit from the number of things added
        
        this.setLayout(new GridLayout(gridSideLength,0));
        
        for(int i=0; i<gridSize; i++) { //Code for adding all the buttons
            MyButton jb = new MyButton();
            buttons[i] = jb;
            Color tan = new Color(210,180,140);
            buttons[i].setBackground(tan);
            buttons[i].setForeground(tan);
            jb.addActionListener(new ButtonListener(i));
            this.add(jb);
        }
    }
    
    //Adds actionlistener for the tiles
    class ButtonListener implements ActionListener {
        
        private int num;
        
        
        public ButtonListener(int i) {
            super();  // is this line necessary? what does it do?
            this.num = i;
            
        }
        
        public void actionPerformed (ActionEvent event) {
            
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
            MyButton jb = buttons[num];
            jb.setFont(new Font("Arial",Font.BOLD,25));
            
            for(int i=0;i<gridSize;i++){
                if(game.charAt(i) == 'W'){ //if element in Array list is W, set background color of JButton to WHITE
		buttons[i].drawSomething(Color.WHITE);
                }
                else if(game.charAt(i) == 'B'){ //if element in ArrayList is B, set background color of JButton to BLACK
                    buttons[i].drawSomething(Color.BLACK);
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
        for(int i = 0;i<gridSize;i++){
            Color tan = new Color(210,180,140);
            buttons[i].setBackground(tan);
            buttons[i].setForeground(tan);
            buttons[i].setOpaque(false); //This line and next line for making tiles show up on mac
            buttons[i].setBorderPainted(true);
        }
    }
    
    //Following two methods are just for making sound playing work
    public void setPlaySound(boolean b){
        playSound = b;
    }
    
    public boolean getPlaySound(){
        return playSound;
    }
}


