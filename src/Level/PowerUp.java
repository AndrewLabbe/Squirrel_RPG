package Level;

import java.util.Timer;

import GameObject.SpriteSheet;

//All power-ups can extend from this class
public class PowerUp extends MapEntity {
	
	public PowerUp(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation); 
	} 
	
	public void update(Player player) {
		super.update();
	} 
	
}
