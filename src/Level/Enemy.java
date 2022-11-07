package Level;

import GameObject.SpriteSheet;

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
	
	//Remove enemy from the screen
	public void eliminateEnemy(Enemy enemy) {
		enemy.mapEntityStatus = mapEntityStatus.REMOVED; 
		map.addCoins();
	} 
	//Damage enemy 
	public void damageEnemy(Enemy enemy, int damage) {
		eliminateEnemy(enemy);
	}
}
