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

				Object temp6 = iStream.readObject();
				boolean GameOver = (boolean) temp6;

				Object temp7 = iStream.readObject();
				boolean BlackSurrendered = (boolean) temp7;

				Object temp8 = iStream.readObject();
				boolean WhiteSurrendered = (boolean) temp8;

				iStream.close();

				Status.setSFXonOrOff(SFX);
				Status.setMusicOnOrOff(Music);

				GameCreator savedGame = new GameCreator(size, size);
				savedGame.board.restoreGame(history, savedGame.textArea);

				Status.setMoves(history);
				Status.setBoardSize(size);
				Status.setSkippedTurn(Skip);
				Status.setGameIsOver(GameOver);
				Status.setBlackSurrendered(BlackSurrendered);
				Status.setWhiteSurrendered(WhiteSurrendered);

				//If the game is over because someone has won
				if (Status.getGameIsOver() && !Status.getBlackSurrendered() && !Status.getWhiteSurrendered()) {
					savedGame.Surrender();
					String Bpoints = "points";
					String Wpoints = "points";

					if (Status.getBlackScore() == 1) {
						Bpoints = "point";
					}
					if (Status.getWhiteScore() == 1) {
						Wpoints = "point";
					}
					savedGame.textArea.append("\nBoth players have\nskipped their turn.\n");
					savedGame.textArea.append("A winner will now be calculated.\n");
					savedGame.textArea.append("\nThe winner is...\n");

					if (Status.getWhiteScore() > Status.getBlackScore()) {
						savedGame.textArea.append("White! With " + Status.getWhiteScore() + " " + Wpoints + " to\n");
						savedGame.textArea.append("Black's " + Status.getBlackScore() + " " + Bpoints + ",\n");
						savedGame.textArea.append("White has won the match!\n");
					} else if (Status.getWhiteScore() < Status.getBlackScore()) {
						savedGame.textArea.append("Black! With " + Status.getBlackScore() + " " + Bpoints + " to\n");
						savedGame.textArea.append("White's " + Status.getWhiteScore() + " " + Wpoints + ",\n");
						savedGame.textArea.append("Black has won the match!\n");
					} else {
						savedGame.textArea.append("No one!\nBoth players have " + Status.getWhiteScore() + " " + Bpoints + "!\n");
						savedGame.textArea.append("This match is a draw!\n");
					}

					savedGame.textArea.append("\nPress the restart button\nto play again.\n");
				}

				//If the game is over because someone has surrendered
				if (Status.getGameIsOver() && (Status.getBlackSurrendered() || Status.getWhiteSurrendered())) {
					savedGame.Surrender();

					if (Status.getWhiteSurrendered()) {
						savedGame.textArea.append("\nWhite has surrendered.\n");
						savedGame.textArea.append("By default, Black has\nwon the match!\n");
					}

					else if (Status.getBlackSurrendered()) {
						savedGame.textArea.append("\nBlack has surrendered.\n");
						savedGame.textArea.append("By default, White has\nwon the match!\n");
					}

					savedGame.textArea.append("\nPress the restart button\nto play again.\n");
				}
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
			//insert bios
		}
	}

}
