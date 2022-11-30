package Engine;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Music {
	public static Clip clip;
	public static URL music;
	AudioInputStream ais;
	// Music Volume
	private FloatControl fc;
	public static int volumeScale;
	public float volume;

	public void setFile() {
		music = getClass().getResource("/sound/BlueBoyAdventure.wav");
		try {
			// Audio input
			ais = AudioSystem.getAudioInputStream(music);
			// Get the clip
			clip = AudioSystem.getClip();
			// Open clip
			clip.open(ais);
			fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			// System.out.println(fc);
			checkVolume();

		} catch (Exception e) {
			System.out.println("Failed to load audio clip");
			e.printStackTrace();
		}
	}

	public void play() {
		setFile();
		clip.start();

	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void stop() {
		clip.stop();
	}

	public void playMusic() {
		play();
		loop();
	}

	public void stopMusic() {
		stop();
	}

	public void checkVolume() {
		// It enters here and then it breaks
		fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		switch (volumeScale) {
		case 0:
			volume = -80f;
			break;
		case 1:
			volume = -20f;
			break;
		case 2:
			volume = -12f;
			break;
		case 3:
			volume = -5f;
			break;
		case 4:
			volume = 1f;
			break;
		case 5:
			volume = 6f;
			break;
		}
		this.fc.setValue(volume);

	}

}
