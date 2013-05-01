//package edu.ucsb.cs56.S12.dwinkenwerder.go;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event. ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * An Swing component for playing go

  
   @author David Winkenwerder and Dustin Henderson
*/

public class GoComponent extends JComponent
{
    private GoGame game;
    private MessageDestination md;

    private JButton [] buttons = new JButton[362];

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
       
    public GoComponent(GoGame game, MessageDestination md) {
	super(); // is this line necessary?  what does it do?
	
	this.game = game;  // the Go game
	this.md = md;  // a place we can write messages to

	// note columns ignored when rows are set
	// number of columns is implicit from the number of things added

	this.setLayout(new GridLayout(19,0)); 
	for(int i=1; i<=361; i++) {
	    JButton jb = new JButton("");
	    buttons[i] = jb;
	    jb.addActionListener(new ButtonListener(i));
	    this.add(jb);
	}
	
    }    


    class ButtonListener implements ActionListener {
	private int num;

	public ButtonListener(int i) {
	    super();  // is this line necessary? what does it do?
	    this.num = i;
	}

	public void actionPerformed (ActionEvent event) {
	    char turn=game.getTurn();
	    if (turn==' ')
		return;
	    if (!game.isBlank(num)) {
		md.append("That square is already occupied!\n");
		return;
	    }  
	    game.setGrid(num,turn);
	    if(game.checkSurrounded(num)){
		md.append("Cannot place tile there, it would be surrounded\n");
		return;
		    }
	    game.setGrid(num,' ');
	    char winner=game.move(num);
	    JButton jb = buttons[num];
	    jb.setFont(new Font("sansserif",Font.BOLD,12));
	    jb.setText(Character.toString(turn)); // this is how we convert char to String
	    for(int i=1;i<362;i++){
		if(game.charAt(i)!=' '){
		    buttons[i].setText(Character.toString(game.charAt(i)));
		    }
		else
		    buttons[i].setText("");
	    }
		
	    // check for a winner
	    if (winner=='D')
		md.append("Phooey.  It's a draw.\n");
	    else if (winner!=' ')
		md.append(winner + " wins!\n");
	}
    }

}
