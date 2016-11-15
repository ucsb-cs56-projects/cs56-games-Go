import javax.swing.BoxLayout;
import javax.swing.JComponent;
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


public class ButtonAndScrollComponent extends JComponent
{
    //add new
    private GoComponent gc;
    private JTextArea md;
    private GoGame game;
    
    private GoGui2 directionFrame;
    
    private JButton sur = new JButton();
    
    public ButtonAndScrollComponent(GoGame game, JTextArea md,GoComponent gc){
        
        super();
        this.game=game;
        this.md = md;
        this.gc = gc;
        
        this.setLayout(new BoxLayout(this,1));
        
        
        sur.addActionListener(new ButtonListener());
        JScrollPane scroller = new JScrollPane(md);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton sur = new JButton("Surrender");
        sur.addActionListener(new ButtonListener2());
        JButton directions = new JButton("Directions");
        directions.addActionListener(new ButtonListener());
        JButton skipTurn = new JButton("Skip Turn");
        skipTurn.addActionListener(new ButtonListener3());
        JButton restart = new JButton("Restart");
        restart.addActionListener(new ButtonListener4());
        this.add(scroller);
        this.add(sur);
        this.add(directions);
        this.add(skipTurn);
        this.add(restart);
    }
    
    class ButtonListener implements ActionListener{
        
        public ButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            GoGui2 direction = new GoGui2();
            
        }
        
    }
    
    class ButtonListener2 implements ActionListener {
        
        public ButtonListener2(){
            
            super();
        }
        
        public void actionPerformed (ActionEvent event) {
            
            char turn = game.getTurn();
            if(turn==' ')
                return;
            if (turn=='B'){
                game.setSurrendering();
                String winner = "White";
                md.append("\n" + winner + " wins! Congratulations!");
            }
            if(turn=='W'){
                game.setSurrendering();
                String winner = "Black";
                md.append("\n" + winner + " wins! Congratulations!");
            }
    
        }
    }
    
    class ButtonListener3 implements ActionListener {
        
        public ButtonListener3(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            char turn = game.getTurn(); //gets player color of whose turn it is
            if (turn == ' ')
                return;
            if (turn == 'B'){
		boolean gameOver = game.skip();
                game.setTurn('W');
		if(gameOver){
		    //skipping ended the game
		    game.setWinner('W');
		    md.append("\nBlack skipped two times consecutively.\n  White wins the game!");
		}else{
		    md.append("\nBlack skipped a turn.");
		}
	    }
            if (turn == 'W'){
		boolean gameOver = game.skip();

		if(gameOver){
		    //skipping ended the game
		    game.setWinner('B');
		    md.append("\nWhite skipped two times consecutively. \n Black wins the game!");
		}else{
                game.setTurn('B');
                md.append("\nWhite skipped a turn.");
		}
	    }
        }
        
    }
    
    
    class ButtonListener4 implements ActionListener {
        
        public ButtonListener4(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            game.restart();
            
            md.setText("");
            gc.restart();
            
        }
    }
    
    public JTextArea getmd()
    {
        return md;
    }
    
}
