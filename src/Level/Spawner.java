package Level;

import java.util.Timer;

import GameObject.SpriteSheet;

//All spawners can extend from this class
public class Spawner extends MapEntity {

	public Spawner(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation); 
	} 

	public void update(Player player) {
		super.update();
	}

	//Override in subclass 
	public void spawnEnemies(int spawnNumber) {
		
	} 

}