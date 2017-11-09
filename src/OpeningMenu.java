//opening menu
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

class OpeningMenu extends JComponent
{
	
	JFrame frame;
	JPanel panel;


	public OpeningMenu(){
		
		frame = new JFrame("FrameDemo");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//frame.getContentPane();
		frame.setSize(300,300);

		frame.setVisible(true);


		panel = new JPanel();
		frame.add(panel);

		JButton button1 = new JButton("Start New Game");
		panel.add(button1);
		button1.addActionListener(new StartGameAction());

		JButton button2 = new JButton("Instructions");

		JButton button3 = new JButton("Load Saved Game");

		JButton button4 = new JButton("About the Authors");
		

	}

	class StartGameAction implements ActionListener{

			public void actionPerformed (ActionEvent e){
				ChooseBoardSize board = new ChooseBoardSize(); 
			}

		}
}