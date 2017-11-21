package Go;

import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;

public class BackgroundMusic {

    Clip clip1;
    AudioInputStream as1;

    public BackgroundMusic(){
	try{
	    as1 = AudioSystem.getAudioInputStream(new File("medley.wav").getAbsoluteFile()); //Sets input stream
	    clip1 = AudioSystem.getClip(); //Gets the clip from the input stream
	}catch(Exception e){
	    System.out.println(e.getMessage()); //Throws exception if fail
	}
    }

    public void playMusic(){ //method for starting music

	try{
	    clip1.open(as1); //Opens music clip
     	    clip1.loop(Clip.LOOP_CONTINUOUSLY); //Sets music to loop
       	    clip1.start(); //Starts
		
	}catch(Exception e){
	    System.out.println(e.getMessage()); //exception for failure to open clip
	}
    }

    public void endMusic(){ //method for stopping music
	clip1.close();
    }

}
