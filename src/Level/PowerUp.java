package Level;

import Engine.Sound;
import GameObject.SpriteSheet;

//All power-ups can extend from this class
public class PowerUp extends MapEntity {
	
	Sound sound = new Sound();
	
	public PowerUp(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation); 
	} 
	
	public void update(Player player, Map map) {
		super.update();
		if(intersects(player)) { 
			playSound(9);
		} 
	} 
	
	//Plays a sound 
	public void playSound(int i) {
		sound.setFile(i);
		sound.play();
	} 
	
}
