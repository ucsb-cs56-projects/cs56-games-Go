//package edu.ucsb.cs56.S12.dwinkenwerder.go;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event. ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;

public class ButtonAndScrollComponent extends JComponent
{
    private MessageDestination md;
    private GoGame game;
    
    private GoGui2 directionFrame;

    private JButton sur = new JButton();

    public ButtonAndScrollComponent(GoGame game, MessageDestination md){
	super();
	this.game=game;
	this.md = md;
	
	this.setLayout(new BoxLayout(this,1));
	
	sur.addActionListener(new ButtonListener());
        
	//	JTextAreaMessageDestination text = new JTextAreaMessageDestination(10,30);
	JScrollPane scroller = new JScrollPane((JTextAreaMessageDestination)md);
	scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	JButton sur = new JButton("Surrender");
	sur.addActionListener(new ButtonListener2());
	JButton directions = new JButton("Directions");
	directions.addActionListener(new ButtonListener());
        JButton skipTurn = new JButton("Skip Turn");
        skipTurn.addActionListener(new ButtonListener3());
	this.add(scroller);
	this.add(sur);
	this.add(directions);
        this.add(skipTurn);
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
	        game.setSurrender2(true);
		game.setTurn('W');
	    }
	    if(turn=='W'){
		game.setSurrender1(true);
		game.setTurn('B');
	    }
	    if(game.getSurrender1() && game.getSurrender2()){
		game.setSurrendering();
		char winner = game.getWinner();
		game.setWinner(winner);
		if(winner == ' ')
		    md.append("shoot, it's a draw!");
		else
		    md.append(winner + " wins! Congratulations!");
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
                    game.setTurn('W');
                }
                if (turn == 'W'){
                    game.setTurn('B');
                }
        }

    }





    public MessageDestination getmd()
    {
	return md;
    }
}
