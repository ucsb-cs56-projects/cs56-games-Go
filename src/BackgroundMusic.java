import javax.sound.sampled.*;
import java.io.*;
import javax.swing.*;

public class BackgroundMusic {

    Clip clip1;
    AudioInputStream as1;

    public BackgroundMusic(){
	try{
	    as1 = AudioSystem.getAudioInputStream(new File("medley.wav").getAbsoluteFile());
	    clip1 = AudioSystem.getClip();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
    }

    public void playMusic(){

	try{
	    //AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("medley.wav").getAbsoluteFile());
	    //clip1 = AudioSystem.getClip();
	    
	
	    clip1.open(as1);
     	    clip1.loop(Clip.LOOP_CONTINUOUSLY);
       	    clip1.start();
		
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
    }

    public void endMusic(){
	clip1.close();
    }

}
