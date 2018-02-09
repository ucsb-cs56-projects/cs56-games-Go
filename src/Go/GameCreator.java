package Go;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;

/**
 * Builds UI and starts the game.
 *
 */
public class GameCreator extends JComponent{

    public static final String TITLE = "Japanese Tsumego";
    public static final int BORDER_SIZE = 25;
    int col, row;
    public  JFrame f=null;
    public JPanel goPanel=null;
    public Grid grid = null;
    public GameBoard board = null;
    public JTextArea textArea = null;
    public ButtonAndScrollComponent basc  = null;
    public void Surrender() {
	board.surrender = true;
    }
    public void ReDraw() {
        	System.out.println("GameBoard Redrawing");
                f.getContentPane().removeAll();
		goPanel = new JPanel();
		goPanel.setBackground(Color.GRAY);
		goPanel.setLayout(new BorderLayout());
		goPanel.setBorder(BorderFactory.createEmptyBorder(
			BORDER_SIZE, 
			BORDER_SIZE, 
			BORDER_SIZE, 
			BORDER_SIZE
			)
		);
		grid = new Grid(col,row);
		textArea = new JTextArea(4,4);
		board = new GameBoard(col,row,textArea);
		
	        basc = new ButtonAndScrollComponent(board, textArea, grid, this);

		f.add(goPanel);

		board.setPreferredSize(new Dimension(500,500));
		basc.setPreferredSize(new Dimension(300,150));
		Font font = new Font("Verdana", Font.BOLD, 15);
		textArea.setFont(font);
		Color gray = new Color(213,216,220);
		textArea.setForeground(gray);
		        
		Color grayb = new Color(40,55,71);
		basc.getmd().setBackground(grayb);
		        
		      
		//f.getContentPane().add(board);
		f.getContentPane().add(basc);
		// to make sure that grids go left to right, no matter what
		        
		f.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		
		goPanel.add(board);

		f.pack();
		f.setResizable(false);
		f.setLocationByPlatform(true);
		f.setVisible(true);
		f.getContentPane().repaint();
    }
    public GameCreator(int col, int row) {
                this.col = col;
                this.row = row;
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle(TITLE);

		f.getContentPane().setLayout(new BoxLayout(f.getContentPane(),0));

		goPanel = new JPanel();
		goPanel.setBackground(Color.GRAY);
		goPanel.setLayout(new BorderLayout());
		goPanel.setBorder(BorderFactory.createEmptyBorder(
			BORDER_SIZE, 
			BORDER_SIZE, 
			BORDER_SIZE, 
			BORDER_SIZE
			)
		);

		
		grid = new Grid(col,row);
		textArea = new JTextArea(4,4);
		board = new GameBoard(col,row,textArea);
		
	        basc = new ButtonAndScrollComponent(board, textArea, grid, this);

		f.add(goPanel);

		board.setPreferredSize(new Dimension(500,500));
		basc.setPreferredSize(new Dimension(300,150));
		Font font = new Font("Verdana", Font.BOLD, 15);
		textArea.setFont(font);
		Color gray = new Color(213,216,220);
		textArea.setForeground(gray);
		        
		Color grayb = new Color(40,55,71);
		basc.getmd().setBackground(grayb);
		        
		      
		//f.getContentPane().add(board);
		f.getContentPane().add(basc);
		// to make sure that grids go left to right, no matter what
		        
		f.applyComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		
		goPanel.add(board);

		f.pack();
		f.setResizable(false);
		f.setLocationByPlatform(true);
		f.setVisible(true);
    }
}