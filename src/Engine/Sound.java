package Engine;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Clip clip;
	//Store clips in an array
	URL soundURL[] = new URL [30];
	
	//Constructor
	
	public Sound() {
		//Background Music
		soundURL [0] = getClass().getResource("/sound/BlueBoyAdventure.wav");
		soundURL [1] = getClass().getResource("/sound/Forest.wav");
		//WalrusSE
		soundURL [2] = getClass().getResource("/sound/Walrus.wav");
		//WolfSE
		soundURL [3] = getClass().getResource("/sound/wolf.wav");
		//FoxSE
		soundURL [4] = getClass().getResource("/sound/fox.wav");
		//DinoSE
		soundURL [5] = getClass().getResource("/sound/Dino3.wav");
		soundURL [6] = getClass().getResource("/sound/Roar.wav"); 
		soundURL [7] = getClass().getResource("/sound/blip.wav");
		
	}
	
	public void setFile(int i) {
		try{
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e){
			
		}
	}
	
	public void play(){
		clip.start();
		
	}
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stop() {
		clip.stop();
	}
	
	
	
	

}
