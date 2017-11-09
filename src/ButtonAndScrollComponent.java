import javax.swing.BoxLayout;
import javax.swing.JComponent;
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


public class ButtonAndScrollComponent extends JComponent
{
    //new gocomponent, textarea, game, frames
    private GoComponent gc;
    private JTextArea md;
    private GoGame game;
    
    private GoGui2 directionFrame;
    
    private boolean playMusic = true; //Default music to be on
    private BackgroundMusic m = new BackgroundMusic();
    
    private JButton sur = new JButton();
    
    public ButtonAndScrollComponent(GoGame game, JTextArea md,GoComponent gc){
        
        super();
        this.game=game;
        this.md = md;
        this.gc = gc;
        
        this.setLayout(new BoxLayout(this,1));
        
        m.playMusic(); //Starts music
        
        sur.addActionListener(new ButtonListener());
        JScrollPane scroller = new JScrollPane(md); //This and next two line set scrollbar if the window needs it
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton sur = new JButton("Surrender"); //Makes the surrender button and adds a listener
        sur.addActionListener(new ButtonListener2());
        JButton directions = new JButton("Directions"); //Makes the directions button and addes a listener
        directions.addActionListener(new ButtonListener());
        JButton skipTurn = new JButton("Skip Turn"); //Makes the skip turn button and adds a listener
        skipTurn.addActionListener(new ButtonListener3());
        JButton restart = new JButton("Restart"); //Makes a restart button and adds a listener
        restart.addActionListener(new ButtonListener4());
        
        JButton sound = new JButton("Sound Effects On/Off"); //Makes a sound effects button and adds a listner
        sound.addActionListener(new PlaySoundButtonListener());
        JButton music = new JButton("Music On/Off"); //Makes a music button and adds a listener
        music.addActionListener(new PlayMusicButtonListener());
        
        //These lines of code add the aforementioned buttons
        this.add(scroller);
        this.add(sur);
        this.add(directions);
        this.add(skipTurn);
        this.add(restart);
        this.add(sound);
        this.add(music);
    }
    
    //Actionlistner for opening directions interface
    class ButtonListener implements ActionListener{
        
        public ButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            GoGui2 direction = new GoGui2();
            
        }
        
    }
    
    //Actionlistener for the surrender button
    class ButtonListener2 implements ActionListener {
        
        public ButtonListener2(){
            
            super();
        }
        
        public void actionPerformed (ActionEvent event) {
            
            char turn = game.getTurn(); //Gets turn
            if(turn==' ')
                return;
            if (turn=='B'){ //Logic for surrender if black's turn
                game.setSurrendering();
                String winner = "White";
                md.append("\n" + winner + " wins! Congratulations!"); //Append output text properly
            }
            if(turn=='W'){ //Logic for surrender if white's turn
                game.setSurrendering();
                String winner = "Black";
                md.append("\n" + winner + " wins! Congratulations!"); //Appends output text properly
            }
            
        }
    }
    
    //Actionlistner for skip turn button
    class ButtonListener3 implements ActionListener {
        
        public ButtonListener3(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            char turn = game.getTurn(); //gets player color of whose turn it is
            
            if (turn == ' ')
                return;
            if(turn == 'B'){ //Logic for black's turn
                boolean gameOver = game.skip(); //For checking if multiple skips in a row
                game.setTurn('W'); //Sets turn to next player
                if(gameOver){
                    game.setWinner('W'); //Check returns true
                    md.append("\nBlack skipped two times consecutively. \n White wins the game!");
                }else{ //else just skip
                    md.append("\nBlack skipped a turn");
                }
                
            }
            
            if(turn == 'W'){ //Logic for white's turn
                boolean gameOver = game.skip(); //For checking if multiple skips in a row
                game.setTurn('B'); //Sets turn to next player
                if(gameOver){
                    game.setWinner('B'); //Check returns true
                    md.append("\nWhite skipped two times consecutively. \n Black wins the game!");
                }else{ //else just skip
                    md.append("\nWhite skipped a turn");
                }
                
            }
            
            
        }
        
    }
    
    //Actionlistner for the restart button
    class ButtonListener4 implements ActionListener {
        
        public ButtonListener4(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            game.restart(); //Restarts gane
            
            md.setText(""); //Refreshes text
            gc.restart();
            
        }
    }
    
    //Actionlistener for play sound button
    class PlaySoundButtonListener implements ActionListener{
        public PlaySoundButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            boolean sound = gc.getPlaySound(); //Checks if sound should be played
            gc.setPlaySound(!sound); //Plays if it the boolean is true
        }
    }
    
    //Actionlistener for music button
    class PlayMusicButtonListener implements ActionListener{
        public PlayMusicButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            if(playMusic){
                playMusic = false; //Check if music button is switched to off
                m.endMusic(); //Ends music
            }else{
                m = new BackgroundMusic(); //Otherwise make new background music
                playMusic = true; //Set true
                m.playMusic(); //Play it
            }
        }
    }
    
    //Text area for the output text
    public JTextArea getmd()
    {
        return md;
    }
    
}
