package Level;

import GameObject.SpriteSheet;

public class Enemy extends MapEntity {
	
	public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x,y,spriteSheet,startingAnimation);
	}
	
	public void update(Player player) {
		super.update();
	}
	
	//Remove enemy from the screen
	public void eliminateEnemy(Enemy enemy) {
		enemy.mapEntityStatus = mapEntityStatus.REMOVED;
	}
}
