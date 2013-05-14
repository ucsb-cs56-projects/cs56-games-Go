import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

/** GoGui2.java is a Gui interface for the directions JFrame for the Go game.
    
    @author Sophia Mao and Kai Jann
    @version CS56, Spring 2013, UCSB
*/

public class GoGui2{

    public GoGui2(){
	

        JFrame frame2 = new JFrame("Rules");
	frame2.setVisible(true);
	frame2.setSize(300,500);


	JTextArea rules = new JTextArea(50, 40);


	rules.setEditable(false);
        rules.setText("RULES:" + "\n \n \n" + "1. At the beginning of the game, the board is empty." + "\n \n" + "2. One player takes the black stones, the other player the white ones." + "\n \n" + "3. The player with the black stones, referred to as `Black', makes the first move. The player with the white stones, referred to as `White', makes the second move. Thereafter, they alternate making their moves." + "\n \n" + "4. A move is made by placing a stone on an interesection." + "\n \n" + "5. A player can play on any unoccupied intersection he wants to." + "\n \n" + "6. A stone does not move after being played, unless it is captured and taken off the board." );
	rules.setLineWrap(true);
	rules.setWrapStyleWord(true);
	JScrollPane scroller = new JScrollPane(rules);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	//JPanel panel = new JPanel();
	frame2.add(scroller); 
    }
}
    
