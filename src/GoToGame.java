import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import java.awt.Font;
import java.awt.Color;

public class GoToGame extends JComponent{

	public GoToGame(int row, int col) {

	//Creation of new frame, set frame to close when x is hit
	JFrame frame = new JFrame() ;
	//TODO:: change this to a button that goes back to main menu
	frame. setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE) ;
	//Initialize no winner and set the surrender states
	char winner=' ';
	boolean surrender1=false;
	boolean surrender2=false;
	        
	        
	// since GoGrid implements the GoGame interface,
	// we can use GoGame on left hand side.
	// Sets layout of the frame, makes a new grid and text area, etc
	frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),0));
	        
	GoGame game = new GoGrid();
	JTextArea  md = new JTextArea(4,4);
	GoComponent gc = new GoComponent(game, md);
	ButtonAndScrollComponent basc = new ButtonAndScrollComponent(game, md, gc);
	        
	//Sets ideal sizes for default construction
	//and font of the texts and other misc. stuff
	gc.setPreferredSize(new Dimension(500,500));
	basc.setPreferredSize(new Dimension(300,150));
	Font f = new Font("Verdana", Font.BOLD, 15);
	md.setFont(f);
	Color gray = new Color(213,216,220);
	md.setForeground(gray);
	        
	Color grayb = new Color(40,55,71);
	basc.getmd().setBackground(grayb);
	        
	        
	frame.getContentPane().add(gc);
	frame.getContentPane().add(basc);
	// to make sure that grids go left to right, no matter what
	        
	frame .applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	frame. setResizable(false);
	frame. setSize(800,650) ;
	frame. setVisible(true) ;
	        
	        
	//so message destination automatically scrolls to the bottom as more is added
	try {
	    md.setCaretPosition(md.getLineStartOffset(md.getLineCount() - 1));
	} catch (BadLocationException e) {
	    e.printStackTrace();
	}

	        
	}

}