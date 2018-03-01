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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
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
		button3.addActionListener(new LoadGameButtonListener());

		JButton button4 = new JButton("About the Authors");
		panel.add(button4);
		button4.addActionListener(new AuthorBioButtonListener());

		Status start = new Status();

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

	class LoadGameButtonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			try {
				FileInputStream fileStream = new FileInputStream("save.ser");
				ObjectInputStream iStream = new ObjectInputStream(fileStream);

				Object temp = iStream.readObject();
				int size = (int) temp;

				Object temp2 = iStream.readObject();
				ArrayList<String> history = (ArrayList<String>) temp2;

				Object temp3 = iStream.readObject();
				boolean SFX = (boolean) temp3;

				Object temp4 = iStream.readObject();
				boolean Music = (boolean) temp4;

				Object temp5 = iStream.readObject();
				boolean Skip = (boolean) temp5;

				iStream.close();

				GameCreator savedGame = new GameCreator(size, size);
				savedGame.board.restoreGame(history, savedGame.textArea);

				Status.setMoves(history);
				Status.setBoardSize(size);
				Status.setSFXonOrOff(SFX);
				Status.setMusicOnOrOff(Music);
				Status.setSkippedTurn(Skip);
			}
			catch (IOException ex) {
				ex.printStackTrace();
			}
			catch (ClassNotFoundException ex) {
				ex.printStackTrace();
			}
		}
	}

	class AuthorBioButtonListener implements ActionListener{

		public void actionPerformed (ActionEvent e){
			AboutTheAuthors about = new AboutTheAuthors();
		}
	}

}
