// package edu.ucsb.cs56.S12.dwinkenwerder.lab06;
import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import java.awt.Font;
import java.awt.Color;

/** GoGui01.java is a GUI interface for TicTacToe that uses
    the JTextArea as the destination for messages.

     @author David Winkenwerder and Dustin Henderson
     @author Keith Waldron and Nick Abrahan
     @author Chunqing Liu and Xingyuan Zhang
     @version CS56, Summer 2016, UCSB
*/

public class GoGui1 {

    /** main method to fire up a JFrame on the screen  
          @param args not used
    */

    public static void main (String[] args) {
	JFrame frame = new JFrame() ;
	frame. setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE) ;
	char winner=' ';
	boolean surrender1=false;boolean surrender2=false;


	// since GoGrid implements the GoGame interface,
	// we can use GoGame on left hand side.
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),0));
	GoGame game = new GoGrid();
        JTextArea  md = new JTextArea(4,4);
	GoComponent gc = new GoComponent(game, md);	
	ButtonAndScrollComponent basc = new ButtonAndScrollComponent(game, md, gc);
	
	gc.setPreferredSize(new Dimension(500,500));
	basc.setPreferredSize(new Dimension(200,150));
	Font f = new Font("Verdana", Font.BOLD, 15);
	md.setFont(f);
	Color gray = new Color(213,216,220);
	md.setForeground(gray);

	//basc.setOpaque(false);
	Color grayb = new Color(40,55,71);
	basc.getmd().setBackground(grayb);
	
	
	frame.getContentPane().add(gc);
	frame.getContentPane().add(basc);
	// to make sure that grids go left to right, no matter what

	frame .applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	frame. setResizable(false);
	frame. setSize(700,650) ;
	frame. setVisible(true) ;


	//so message destination automatically scrolls to the bottom as more is added 
	try {
               	md.setCaretPosition(md.getLineStartOffset(md.getLineCount() - 1));
            } catch (BadLocationException e) {
                e.printStackTrace();
	    }




	if(game.getSurrender1() && game.getSurrender2()){
	    game.setSurrendering();
            //winner=game.getWinner();

	  
	}

    }
}
