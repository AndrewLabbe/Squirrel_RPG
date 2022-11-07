/* I made this bullet class to represent a bullet object which is a subclass of Projectile 
 * but I am currently using the acorn as the only projectile in game 
 * Perhaps it might be used as another projectile which can be implemented later on with a power-up
 */

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

public class Bullet extends Projectile {

	private Stopwatch despawnTime; 
	private int direction; 
	private int damage;
	
	public Bullet(int x, int y, int direction, int damage) {
		super(x, y, damage, new SpriteSheet(ImageLoader.load("Bullet.png"), 15, 7), "FIRE_RIGHT"); 
		despawnTime = new Stopwatch();
		despawnTime.setWaitTime(5000);
		this.direction = direction; 
		this.damage = damage;
	}

	@Override
	public void update(ArrayList<Enemy> enemies) {
		if (despawnTime.isTimeUp()) {
			mapEntityStatus = MapEntityStatus.REMOVED;
		}
		else {
			//Changes bullet velocity --> speed and direction 
			moveX(4*direction);
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
	
	//Creates two different animations for the bullet --> one for firing right and one for firing left
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("FIRE_RIGHT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(1)
                            .withBounds(1, 1, 7, 15) 
                            .build()
            });
            put("FIRE_LEFT", new Frame[]{
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(1)
                            .withBounds(1, 1, 7, 15) 
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
        }};
    } 
    
    //Removes bullet from screen if it hits an enemy
    @Override 
    public void eliminateEnemy(Enemy enemy) {
        super.eliminateEnemy(enemy); 
        this.mapEntityStatus = mapEntityStatus.REMOVED;
    }
	
}
