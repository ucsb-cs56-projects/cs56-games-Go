//side buttons
package Go;

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
    private Grid grid;
    private JTextArea textArea;
    private GameBoard board;
    private GameCreator gCreator;
    private GoInstructions directionFrame;
    
    private boolean playMusic = true; //Default music to be on
    private BackgroundMusic m = new BackgroundMusic();
    
    private JButton sur = new JButton();
    public boolean surrender = false;    
    public ButtonAndScrollComponent(GameBoard board, JTextArea textArea, Grid grid, GameCreator gCreator){
        
        super();
        this.board=board;
        this.textArea = textArea;
        this.grid = grid;
        this.gCreator = gCreator;
        this.setLayout(new BoxLayout(this,1));
        
        m.playMusic(); //Starts music
        
        sur.addActionListener(new ButtonListener());
        JScrollPane scroller = new JScrollPane(textArea); //This and next two line set scrollbar if the window needs it
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
            GoInstructions direction = new GoInstructions();
            
        }
        
    }
    
    //Actionlistener for the surrender button
    class ButtonListener2 implements ActionListener {
        
        public ButtonListener2(){
            
            super();
        }
        
        public void actionPerformed (ActionEvent event) {
            surrender = true;
	    gCreator.Surrender();
        }
    }
    
    //Actionlistner for skip turn button
    class ButtonListener3 implements ActionListener {
        
        public ButtonListener3(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
        }
        
    }
    
    //Actionlistner for the restart button
    class ButtonListener4 implements ActionListener {
        
        public ButtonListener4(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
	   System.out.println("Restart");
           gCreator.ReDraw();
        }
    }
    
    //Actionlistener for play sound button
    class PlaySoundButtonListener implements ActionListener{
        public PlaySoundButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            //boolean sound = grid.getPlaySound(); //Checks if sound should be played
            //gc.setPlaySound(!sound); //Plays if it the boolean is true
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
        return textArea;
    }
    
}
