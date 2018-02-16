package Go;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;

public class SoundEffect {

    //Method for the sound effect playing, soundName is the name of the default audio file, looks for that name
    public void playEffect(){
	String soundName = "button.wav";    

	try{
	AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile()); //Attempt to pull the aforementioned file
	Clip clip = AudioSystem.getClip(); //Make a clip from the file if pulled properly from input stream
	clip.open(audioInputStream); //Opens the clip and starts it
	clip.start();
	}catch(Exception e){
	    System.out.println(e.getMessage()); //If file is not found throw exception
	}
    }
}
