//about the authors
//this file template was borrowed from Winter 2014's implementation of the instructions file
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
 
 @author Misha Zaied and Gehrig Webber
 @version CS56, Winter 2018, UCSB
 */

public class AboutTheAuthors{
    
    public AboutTheAuthors(){
        
        //This is what you see in the about the authors popup
        String newLine = "\n \n";
        String title = "ABOUT THE AUTHORS: \n \n \n";
        String Misha = "Misha Zaied is a second year CS Major, with a special interest in Unicorn Anatomy and its applications in National Defense. And cuddles.";
	String Gehrig = "Gehrig Weber is a second year CS Major who likes long walks on the beach, romantic poetry, and crying over a box of caramel turtles while watching Marley and Me.";
        
        //Sets frame to visible and make the frame with the pre-set size and make the text area
        JFrame frame2 = new JFrame("About The Authors");
        frame2.setVisible(true);
        frame2.setSize(1000,2500);
        JTextArea rules = new JTextArea(500, 400);
    
        //Sets out how the bios get printed out
        rules.setEditable(false);
        rules.setText(title + Misha + newLine + Gehrig);
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

