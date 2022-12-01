package Engine;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundE {
	public static Clip clip;
	public static URL soundURL[] = new URL[10];
	AudioInputStream ais;
	// Music Volume
	private FloatControl fc;
	public static int volumeScale = 3;
	public float volume;

	public SoundE() {
		// WalrusSE
		soundURL[0] = getClass().getResource("/sound/Walrus.wav");
		// WolfSE
		soundURL[1] = getClass().getResource("/sound/wolf.wav");
		// FoxSE
		soundURL[1] = getClass().getResource("/sound/fox.wav");
		// DinoSE
		soundURL[3] = getClass().getResource("/sound/Dino3.wav");
		soundURL[4] = getClass().getResource("/sound/Roar.wav");
		soundURL[5] = getClass().getResource("/sound/blip.wav");
		soundURL[6] = getClass().getResource("/sound/elim.wav");
		soundURL[7] = getClass().getResource("/sound/power-up.wav");

	}

	public void setFile(int i) {

		try {
			// Audio input
			ais = AudioSystem.getAudioInputStream(soundURL[i]);
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

	public void play(int i) {
		setFile(i);
		clip.start();

	}

	public void stop() {
		clip.stop();
	}

	public void playSE(int i) {
		play(i);
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