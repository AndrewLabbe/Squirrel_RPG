package Engine;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

	Clip clip;
	//Store clips in an array
	URL soundURL[] = new URL [30];
	FloatControl fc;
	public int volumeScale = 5;
	public float volume;
	
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
			fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			checkVolume();
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

	public void checkVolume() {
		
		switch(volumeScale) {
		case 0: volume = -80f; break;
		case 1: volume = -20f;break;
		case 2: volume = -12f; break;
		case 3: volume = -5f; break;
		case 4:volume = 1f; break;
		case 5: volume = 6f; break;
		}
		fc.setValue(volume);
		
	}
	
	
	

}
