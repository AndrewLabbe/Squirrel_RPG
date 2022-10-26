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
import Level.Projectile;
import Utils.Stopwatch;

public class Acorn extends Projectile {

	private Stopwatch despawnTime; 
	private int direction;
	
	public Acorn(int x, int y, int direction) {
		super(x, y, new SpriteSheet(ImageLoader.load("Acorn.png"), 29, 20), "FIRE_RIGHT"); 
		despawnTime = new Stopwatch();
		despawnTime.setWaitTime(5000);
		this.direction = direction; 
	}

	@Override
	public void update(ArrayList<Enemy> enemies) {
		if (despawnTime.isTimeUp()) {
			mapEntityStatus = MapEntityStatus.REMOVED;
		}
		else {
			//Changes acorn velocity --> speed and direction 
			moveX(5*direction);
		} 
		
		//Sets animation based on direction the main character is facing
		if(direction == 1) {
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
    public void eliminateEnemy(Enemy enemy) {
        super.eliminateEnemy(enemy); 
        this.mapEntityStatus = mapEntityStatus.REMOVED;
    }
	
}