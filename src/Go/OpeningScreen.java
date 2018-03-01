//Opening screen
package Go;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.text.BadLocationException;



class OpeningScreen extends JComponent
{
	
	JFrame frame;
	JPanel panel;

	/**
	*Screen seen upon start-up that gives you four options
	*/
	public OpeningScreen(){
		
		frame = new JFrame("Tsumego Menu");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.getContentPane();
		frame.pack();

		frame.setVisible(true);
		frame.setSize(300,300);

		panel = new JPanel();
		frame.add(panel);

		JButton button1 = new JButton("Start New Game");
		panel.add(button1);
		button1.addActionListener(new StartGameButtonListener());

		JButton button2 = new JButton("Instructions");
		panel.add(button2);
		button2.addActionListener(new InstructionsButtonListener());

		JButton button3 = new JButton("Load Saved Game");
		panel.add(button3);
		button3.addActionListener(new SaveGameButtonListener());

		JButton button4 = new JButton("About the Authors");
		panel.add(button4);
		button4.addActionListener(new AuthorBioButtonListener());

		

		//frame.setResizable(false);
		

	}

	class StartGameButtonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			ChooseBoardSizeScreen board = new ChooseBoardSizeScreen();
		}
	}

	class InstructionsButtonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			GoInstructions instruction = new GoInstructions();
		}
	}

	class SaveGameButtonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			//serialize objects
		}
	}

	class AuthorBioButtonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			AboutTheAuthors about = new AboutTheAuthors();
		}
	}

}
