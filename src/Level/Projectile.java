package Level;

import GameObject.SpriteSheet;
import java.util.ArrayList; 

//This class is designed so that more than one projectile can be put into the game
public class Projectile extends MapEntity {

	public Projectile(int x, int y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation);
	}

	public void update(ArrayList<Enemy> enemies) {
		super.update(); 
		//Eliminate enemy if a projectile collides with it
		for(Enemy enemy : enemies) {
			if(this.intersects(enemy)) {
				eliminateEnemy(enemy); 
			}
		}
	} 
	//Eliminate enemy
	public void eliminateEnemy(Enemy enemy) {
		enemy.eliminateEnemy(enemy); 
	}
	
}