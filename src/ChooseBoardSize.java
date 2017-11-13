//choose board size
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

public class ChooseBoardSize extends JComponent
{

	public ChooseBoardSize(){

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
				GoToGame mini = new GoToGame(5,5);
			}
		}

		class SmallBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GoToGame small = new GoToGame(9,9);
			}
		}

		class MediumBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GoToGame medium = new GoToGame(13,13);
			}
		}

		class LargeBoardListener implements ActionListener{

			public void actionPerformed (ActionEvent e){
				GoToGame large = new GoToGame(19,19);
			}
		}

}