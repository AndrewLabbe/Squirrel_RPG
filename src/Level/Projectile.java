package Level;

import GameObject.SpriteSheet;
import java.util.ArrayList; 

//This class is designed so that more than one projectile can be put into the game
public class Projectile extends MapEntity {

	public Projectile(int x, int y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation);
	}

	public void update() {
		super.update(); 
	}
	
}