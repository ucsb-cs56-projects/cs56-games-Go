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

	String newLine = "\n \n";
	String title = "RULES: \n \n \n";
	String step1 = "1. At the beginning of the game, the board is empty.";
	String step2 = "2. One player takes the black stones, the other player the white ones.";
	String step3 = "3. The player with the black stones, referred to as `Black', makes the first move. The player with the white stones, referred to as `White', makes the second move. Thereafter, they alternate making their moves.";
	String step4 =  "4. A move is made by placing a stone on an interesection.Stones must have liberties (empty adjacent points) to remain on the board. Stones connected by lines are called chains, and share their liberties.";
	String step5 = "5. A player can play on any unoccupied intersection he wants to.When a stone or a chain of stones is surrounded by opponent stones, so that it has no more liberties, it is captured and removed from the board.";
	String step6 = "6. Ko rule: A stone cannot be played on a particular point, if doing so would recreate the board position after the same player's previous turn.";
	String step7 = "7. A player may pass instead of placing a stone. Two consecutive passes end a game, beginning the scoring.";
	String step8 = "8. A player's score is the number of empty points enclosed only by his stones plus the number of points occupied by his stones. The player with the higher score wins.";


        JFrame frame2 = new JFrame("Rules");
	frame2.setVisible(true);
	frame2.setSize(300,500);
	JTextArea rules = new JTextArea(50, 40);

	rules.setEditable(false);
        rules.setText(title + step1 + newLine + step2 + newLine + step3 + newLine +step4 + newLine + step5 + newLine + step6 + newLine + step7 + newLine +step8);
	rules.setLineWrap(true);
	rules.setWrapStyleWord(true);
	JScrollPane scroller = new JScrollPane(rules);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

	frame2.add(scroller); 
    }
}
    
