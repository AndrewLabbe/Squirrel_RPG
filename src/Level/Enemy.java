package Level;

import GameObject.SpriteSheet;
import Utils.Point;

public class Enemy extends MapEntity {
	
	public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x,y,spriteSheet,startingAnimation);
	}
	
	public void update(Player player, Map map) { 
		if(intersects(player)) {
			map.dealDamage(); 
		} 
		super.update(); 
	}
	
	//Remove enemy from the screen, add coins, and spawn a power-up
	public void eliminateEnemy(Enemy enemy) {
		enemy.mapEntityStatus = mapEntityStatus.REMOVED; 
		map.addCoins(); 
		Point elimPoint = new Point(this.x, this.y);
		map.spawnPowerUp(elimPoint);
	} 
	//Damage enemy 
	public void damageEnemy(Enemy enemy, int damage) {
		eliminateEnemy(enemy);
	}
}
