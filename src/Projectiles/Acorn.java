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

public class Acorn extends Projectile {

	private Stopwatch despawnTime; 
	private float directionX; 
	private float directionY; 
	private int damage;
	private Player player;
	
	public Acorn(int x, int y, float directionX, float directionY, int damage) {
		super(x, y, damage, new SpriteSheet(ImageLoader.load("Acorn.png"), 29, 20), "FIRE_RIGHT"); 
		despawnTime = new Stopwatch();
		despawnTime.setWaitTime(5000);
		this.directionX = directionX; 
		this.directionY = directionY; 
		this.damage = damage;
	}

	@Override
	public void update(ArrayList<Enemy> enemies) {
		if (despawnTime.isTimeUp()) {
			mapEntityStatus = MapEntityStatus.REMOVED;
		}
		else {
			//Changes acorn velocity --> speed and direction 
			moveX(5*directionX); 
			moveY(5*directionY);
		} 
		
		//Sets animation based on direction the main character is facing
		if(directionX == 1) {
			this.currentAnimationName = "FIRE_RIGHT"; 
		}
		else {
			this.currentAnimationName = "FIRE_LEFT";
		} 
		super.update(enemies);
	} 
	
	//Creates two different animations for the acorn --> one for firing right and one for firing left
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("FIRE_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(1)
                            .withBounds(8, 0, 13, 19) 
                            .build()
            });
            put("FIRE_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(1)
                            .withBounds(8, 0, 13, 19) 
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
        }}; 
    }
        
    //Remove acorn from screen upon collision with enemy
    @Override 
    public void damageEnemy(Enemy enemy) {
        super.damageEnemy(enemy); 
        this.mapEntityStatus = mapEntityStatus.REMOVED;
    }
	
}