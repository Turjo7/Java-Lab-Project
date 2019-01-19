package computer_master_sound;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
public class Sound {
	public static void music(){
		Clip clip;
		try{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("car.wav"));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.start();
			clip.loop(45);
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
