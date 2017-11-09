//opening menu
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JMenuBar;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event. ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.text.BadLocationException;

class OpeningMenu extends JComponent
{
	
	JFrame frame;

	public OpeningMenu(){
		
		frame = new JFrame("FrameDemo");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane();

		frame.pack();

		frame.setVisible(true);

		//Action listen for Game Button will Instantiate GoToGme object;

	}
}