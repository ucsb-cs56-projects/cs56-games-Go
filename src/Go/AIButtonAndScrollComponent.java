//side buttons
package Go;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;


public class AIButtonAndScrollComponent extends JComponent
{
    //new gocomponent, textarea, game, frames
    private Grid grid;
    transient private JTextArea textArea;
    private AIGameBoard AIboard;
    private AIGameCreator gCreator;
    transient private GoInstructions directionFrame;

    

    private BackgroundMusic m = new BackgroundMusic();
    
    transient private JButton sur = new JButton();
    public boolean surrender = false;    
    public AIButtonAndScrollComponent(AIGameBoard AIboard, JTextArea textArea, Grid grid, AIGameCreator gCreator){
        
        super();
        this.AIboard=AIboard;
        this.textArea = textArea;
        this.grid = grid;
        this.gCreator = gCreator;
        this.setLayout(new BoxLayout(this,1));

        if (Status.getMusicOnOrOff()) {
            m.playMusic(); //Starts music
        }

        
        sur.addActionListener(new ButtonListener());
        JScrollPane scroller = new JScrollPane(textArea); //This and next two line set scrollbar if the window needs it
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton sur = new JButton("Surrender"); //Makes the surrender button and adds a listener
        sur.addActionListener(new ButtonListener2());
        JButton directions = new JButton("Directions"); //Makes the directions button and adds a listener
        directions.addActionListener(new ButtonListener());
        JButton skipTurn = new JButton("Skip Turn"); //Makes the skip turn button and adds a listener
        skipTurn.addActionListener(new ButtonListener3());
        JButton restart = new JButton("Restart"); //Makes a restart button and adds a listener
        restart.addActionListener(new ButtonListener4());
        
        JButton sound = new JButton("Sound Effects On/Off"); //Makes a sound effects button and adds a listener
        sound.addActionListener(new PlaySoundButtonListener());
        JButton music = new JButton("Music On/Off"); //Makes a music button and adds a listener
        music.addActionListener(new PlayMusicButtonListener());

        JButton save = new JButton("Save Game"); //Makes a save game button and adds a listener
        save.addActionListener(new SaveGameButtonListener());
        
        //These lines of code add the aforementioned buttons
        this.add(scroller);
        this.add(sur);
        this.add(directions);
        this.add(skipTurn);
        this.add(restart);
        this.add(sound);
        this.add(music);
        this.add(save);
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
            if (!Status.getGameIsOver()) {
                surrender = true;
                gCreator.Surrender();

                if (AIboard.getCurrent_player() == State.WHITE) {
                    textArea.append("\nWhite has surrendered.\n");
                    textArea.append("By default, Black has\nwon the match!\n");
                    Status.setWhiteSurrendered(true);
                }

                else if (AIboard.getCurrent_player() == State.BLACK) {
                    textArea.append("\nBlack has surrendered.\n");
                    textArea.append("By default, White has\nwon the match!\n");
                    Status.setBlackSurrendered(true);
                }

                textArea.append("\nPress the restart button\nto play again.\n");
                Status.setGameIsOver(true);
            }

        }
    }
    
    //Actionlistner for skip turn button
    class ButtonListener3 implements ActionListener {
        
        public ButtonListener3(){
            super();
        }
        
        public void actionPerformed (ActionEvent event) {
           if (!Status.getGameIsOver()) {

             if (Status.getSkippedTurn()) {
                 gCreator.Surrender();
                 String Bpoints = "points";
                 String Wpoints = "points";

                if (Status.getBlackScore() == 1) {
                    Bpoints = "point";
                }
                if (Status.getWhiteScore() == 1) {
                    Wpoints = "point";
                }
                textArea.append("\nBoth players have\nskipped their turn.\n");
                textArea.append("A winner will now be calculated.\n");
                textArea.append("\nThe winner is...\n");

                if (Status.getWhiteScore() > Status.getBlackScore()) {
                    textArea.append("White! With " + Status.getWhiteScore() + " " + Wpoints + " to\n");
                    textArea.append("Black's " + Status.getBlackScore() + " " + Bpoints + ",\n");
                    textArea.append("White has won the match!\n");
                } else if (Status.getWhiteScore() < Status.getBlackScore()) {
                    textArea.append("Black! With " + Status.getBlackScore() + " " + Bpoints + " to\n");
                    textArea.append("White's " + Status.getWhiteScore() + " " + Wpoints + ",\n");
                    textArea.append("Black has won the match!\n");
                } else {
                    textArea.append("No one!\nBoth players have " + Status.getWhiteScore() + " " + Bpoints + "!\n");
                    textArea.append("This match is a draw!\n");
                }

                textArea.append("\nPress the restart button\nto play again.\n");
                Status.setGameIsOver(true);

            } else {
                Status.setSkippedTurn(true);
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
	   System.out.println("Restart");
	   m.endMusic();
	   Status.setSkippedTurn(false);
	   Status.setGameIsOver(false);
	   Status.setWhiteSurrendered(false);
	   Status.setBlackSurrendered(false);
	   Status.setWhiteScore(0);
	   Status.setBlackScore(0);
	   Status.setMoves(new ArrayList<String>());
	   gCreator.ReDraw();
        }
    }
    
    //Actionlistener for play sound button
    class PlaySoundButtonListener implements ActionListener{
        public PlaySoundButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            if (Status.getSFXonOrOff()) {
                Status.setSFXonOrOff(false);
            }
            else {
                Status.setSFXonOrOff(true);
            }
        }
    }
    
    //Actionlistener for music button
    class PlayMusicButtonListener implements ActionListener{
        public PlayMusicButtonListener(){
            super();
        }
        
        public void actionPerformed (ActionEvent event){
            if(Status.getMusicOnOrOff()){
                m.endMusic(); //Ends music
                Status.setMusicOnOrOff(false); //For saving and loading, nothing else
            }else{
                m = new BackgroundMusic(); //Otherwise make new background music
                m.playMusic(); //Play it
                Status.setMusicOnOrOff(true); //For saving and loading, nothing else
            }
        }
    }

    //Actionlistener for save game button
    class SaveGameButtonListener implements ActionListener{
        public SaveGameButtonListener(){
            super();
        }

        public void actionPerformed (ActionEvent event){
            Status.storeGame();
        }
    }
    
    //Text area for the output text
    public JTextArea getmd()
    {
        return textArea;
    }
    
}
