package Engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configurations {

	public static GamePanel gp;

	public Configurations(GamePanel gp) {
		Configurations.gp = gp;
	}

	public void saveConfigurations() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"));

			// Full Screen
			if (GamePanel.fullScreen == true) {
				bw.write("On");
			}
			if (GamePanel.fullScreen == false) {
				bw.write("Off");
			}
			bw.newLine();
			// Music
			bw.write(String.valueOf(Music.volumeScale));
			bw.newLine();

			// Sound Effects Volume
			bw.write(String.valueOf(SoundE.volumeScale));
			bw.newLine();
			
			// Load players stats
			if (GamePanel.save == true) {
				bw.write("Yes");
			}
			if (GamePanel.save == false) {
				bw.write("No");
			}
			

			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadConfigurations() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));
			// Full Screen
			String s = br.readLine();
			System.out.println(s);
			if (s.equals("Off")) {
				GamePanel.fullScreen = false;
				System.out.println("aca");
			}
			else if (s.equals("On")) {
				GamePanel.fullScreen = true;
			}
			// Music Volume
			s = br.readLine();
			System.out.println(s);
			Music.volumeScale = Integer.parseInt(s);
			
			// Sound Effect Volume
			s = br.readLine();
			System.out.println(s);
			SoundE.volumeScale = Integer.parseInt(s);
			
			//Load players stats
			s = br.readLine();
			System.out.println(s);
			if(s.equals("No")) {
				GamePanel.save= false;
			}
			else if (s.equals("Yes")) {
				GamePanel.save = true;
			}

			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}