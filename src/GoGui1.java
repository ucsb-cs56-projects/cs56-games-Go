// package edu.ucsb.cs56.S12.dwinkenwerder.lab06;
import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import java.awt.Dimension;

/** GoGui01.java is a GUI interface for TicTacToe that uses
    the JTextArea as the destination for messages.

     @author David Winkenwerder and Dustin Henderson
     @version CS56, Spring 2011, UCSB
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
	MessageDestination md = new JTextAreaMessageDestination(4,4);
	ButtonAndScrollComponent basc = new ButtonAndScrollComponent(game, md);
	GoComponent gc = new GoComponent(game, basc.getmd());
	gc.setPreferredSize(new Dimension(1200,800));
	basc.setPreferredSize(new Dimension(600,800));
	frame.getContentPane().add(gc);
	frame.getContentPane().add(basc);
	// to make sure that grids go left to right, no matter what

	frame .applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	frame. setResizable(false);
	frame. setSize(1800,800) ;
	frame. setVisible(true) ;

	if(game.getSurrender1() && game.getSurrender2()){
	    game.setSurrendering();
	    winner=game.getWinner();
	}

    }
}