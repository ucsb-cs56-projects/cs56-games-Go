//instructions
package Go;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;


import javax.swing.*;
import java.awt.*;


/** GoGui2.java is a Gui interface for the directions JFrame for the Go game.
 
 @author Sophia Mao and Kai Jann
 @author Keith Waldron and Nick Abrahan
 @version CS56, Winter 2014, UCSB
 */

public class GoInstructions{
    
    public GoInstructions(){
        
        //This is what you see in the instructions popup, each line is a instruction line
        String newLine = "\n \n";
        String title = "RULES: \n \n \n";
        String step1 = "1. At the beginning of the game, the board is empty.";
        String step2 = "2. One player takes the black stones, the other player the white ones.";
        String step3 = "3. The player with the black stones, referred to as `Black', makes the first move. The player with the white stones, referred to as `White', makes the second move. Thereafter, they alternate making their moves.";
        String step4 =  "4. A move is made by placing a stone on an interesection.Stones must have liberties (empty adjacent points) to remain on the board. Stones connected by lines are called chains, and share their liberties.";
        String step5 = "5. A player can play on any unoccupied intersection he wants to.When a stone or a chain of stones is surrounded by opponent stones, so that it has no more liberties, it is captured and removed from the board.";
        String step6 = "6. Ko rule: A stone cannot be played on a particular point, if doing so would recreate the board position after the same player's previous turn.";
        String step7 = "7. A player may pass instead of placing a stone. Two consecutive passes end a game, beginning the scoring.";
        String step8 = "8. A player's score is the number of empty points enclosed only by his stones plus the number of points occupied by his stones. The player with the higher score wins. \n \n";
        String step9 = " Source: http://www.kiseido.com/ff.htm ";
        
        //Sets frame to visible and make the frame with the pre-set size and make the text area
        JFrame frame2 = new JFrame("Rules");
        frame2.setVisible(true);
        frame2.setSize(1000,2500);
        JTextArea rules = new JTextArea(500, 400);
    
        //Sets out how the lines of instructions get printed out
        rules.setEditable(false);
        rules.setText(title + step1 + newLine + step2 + newLine + step3 + newLine +step4 + newLine + step5 + newLine + step6 + newLine + step7 + newLine +step8 +step9);
        rules.setLineWrap(true);
        rules.setWrapStyleWord(true);
        rules.setCaretPosition(5);
        Font f = new Font("Arial", Font.PLAIN, 30);
        rules.setFont(f);
        
        //Makes scrollbar if needed
        JScrollPane scroller = new JScrollPane(rules);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        frame2.add(scroller); 
    }
}

