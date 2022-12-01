package Level; 

import Engine.Sound;
import GameObject.SpriteSheet;
import Utils.Point;

public class Enemy extends MapEntity {

	//Used to call a sound 
	Sound sound = new Sound();

	public Enemy(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x,y,spriteSheet,startingAnimation);
	}

	public void update(Player player, Map map) { 
		if(intersects(player)) {
			map.dealDamage(1); 
		} 
		super.update(); 
	} 

	//Remove enemy from the screen, add coins, spawn a power-up, and play a sound 
	public void eliminateEnemy(Enemy enemy) {
		enemy.mapEntityStatus = mapEntityStatus.REMOVED; 
		map.addCoins(); 
		map.saveCoins();
		Point elimPoint = new Point(this.x, this.y);
		map.spawnPowerUp(elimPoint); 
		playSound(8);
	} 
	//Damage enemy 
	public void damageEnemy(Enemy enemy, int damage) {
		eliminateEnemy(enemy);
	}

	//Plays a sound 
	public void playSound(int i) {
		sound.setFile(i);
		sound.play();
	} 

}


