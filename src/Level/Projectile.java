package Level;

import java.util.ArrayList;

import GameObject.SpriteSheet; 

//This class is designed so that more than one projectile can be put into the game
public class Projectile extends MapEntity {

	private int damage;
	
	public Projectile(int x, int y, int damage, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation); 
		this.damage = damage;
	}

	public void update(ArrayList<Enemy> enemies, ArrayList<MapTile> unpassableMapTiles, ArrayList<Spawner> spawners, ArrayList<NPC> npcs) {
		super.update(); 
		//Eliminate enemy if a projectile collides with it
		for(Enemy enemy : enemies) {
			if(this.intersects(enemy)) {
				//eliminateEnemy(enemy); 
				damageEnemy(enemy);
			}
		}
		//Remove projectile if it intersects an unpassable map tile 
		for(MapTile unpassableMapTile : unpassableMapTiles) {
			if(this.intersects(unpassableMapTile)) {
				this.setMapEntityStatus(MapEntityStatus.REMOVED);
			}
		} 
		//Remove projectile if it intersects a spawner 
		for(Spawner spawner : spawners) {
			if(this.intersects(spawner)) {
				this.setMapEntityStatus(MapEntityStatus.REMOVED);
			}
		} 
		//Remove projectile if it intersects an active NPC 
		for(NPC npc : npcs) {
			if(this.intersects(npc)) {
				this.setMapEntityStatus(MapEntityStatus.REMOVED);
			}
		}
	} 
	//Eliminate enemy
	public void eliminateEnemy(Enemy enemy) {
		enemy.eliminateEnemy(enemy); 
	} 
	
	//Damage enemy 
	public void damageEnemy(Enemy enemy) {
		enemy.damageEnemy(enemy, damage);
	}
}