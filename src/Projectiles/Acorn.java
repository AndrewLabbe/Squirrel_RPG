package Projectiles;

import java.util.ArrayList;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.MapEntityStatus;
import Level.Player;
import Level.Projectile;
import Utils.Stopwatch; 
import Level.EnhancedMapTile; 
import Level.MapTile;
import Level.Spawner; 
import Level.NPC;

public class Acorn extends Projectile {

	private Stopwatch despawnTime; 
	private float directionX; 
	private float directionY; 
	private int damage;
	private Player player;
	
	public Acorn(int x, int y, float directionX, float directionY, int damage, Player player, String acorn) {
		super(x, y, damage, new SpriteSheet(ImageLoader.load("Acorns.png"), 20, 20), acorn); 
		despawnTime = new Stopwatch();
		despawnTime.setWaitTime(5000);
		this.directionX = directionX; 
		this.directionY = directionY; 
		this.damage = damage;
		this.player = player;
	}

	@Override
	public void update(ArrayList<Enemy> enemies, ArrayList<MapTile> unpassableMapTiles, ArrayList<Spawner> spawners, ArrayList<NPC> npcs) {
		if (despawnTime.isTimeUp()) {
			mapEntityStatus = MapEntityStatus.REMOVED;
		}
		else {
			//Changes acorn velocity --> speed and direction 
			moveX(5*directionX); 
			moveY(5*directionY);
		} 
		
		//Sets animation based on direction the main character is facing
		/*if(directionX == 1) {
			this.currentAnimationName = "FIRE_RIGHT"; 
		}
		else {
			this.currentAnimationName = "FIRE_LEFT";
		}*/
		if(this.intersects(player)) {
			mapEntityStatus = MapEntityStatus.REMOVED; 
			map.dealDamage(20);
		}
		
		super.update(enemies, unpassableMapTiles, spawners, npcs);
		
	} 
	
	//Creates two different animations for the acorn --> one for firing right and one for firing left
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("NORMAL_ACORN", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(1)
                            .withBounds(4, 4, 13, 16) 
                            .build()
            });
            put("GOLDEN_ACORN", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 1), 0)
                            .withScale(1)
                            .withBounds(4, 4, 13, 16) 
                            //.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
        }}; 
    }
        
    //Remove acorn from screen upon collision with enemy
    @Override 
    public void damageEnemy(Enemy enemy) {
        super.damageEnemy(enemy); 
        if (enemy.getMapEntityStatus() == MapEntityStatus.REMOVED)
        	player.setUpdate(true);
        this.mapEntityStatus = mapEntityStatus.REMOVED;
    }
	
}