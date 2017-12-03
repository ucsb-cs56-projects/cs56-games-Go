//choose board
package Go;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ChooseBoardSizeScreen extends JComponent
{

	/**
	*Screen seen after pressing 'Start game' on opening screen. ]
	*Lets you choose one of four board sizes to play off of
	*/
	public ChooseBoardSizeScreen(){

		JFrame frame = new JFrame("Choose Board Size");
		frame.setVisible(true);
		frame.setSize(300,300);

		JPanel panel =  new JPanel();
		frame.add(panel);

		JButton button1 = new JButton("5X5");
		panel.add(button1);
		button1.addActionListener(new MiniBoardListener());

		JButton button2 = new JButton("9X9");
		panel.add(button2);
		button2.addActionListener(new SmallBoardListener());

		JButton button3 = new JButton("13X13");
		panel.add(button3);
		button3.addActionListener(new MediumBoardListener());

		JButton button4 = new JButton("19x19");
		panel.add(button4);
		button4.addActionListener(new LargeBoardListener());

		
	}

	class MiniBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GameCreator mini = new GameCreator(5,5);
			}
		}

		class SmallBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GameCreator small = new GameCreator(9,9);
			}
		}

		class MediumBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GameCreator medium = new GameCreator(13,13);
			}
		}

		class LargeBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GameCreator large = new GameCreator(19,19);
			}
		}

}