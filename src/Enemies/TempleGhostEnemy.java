package Enemies;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Map;
import Level.Player;

public class TempleGhostEnemy extends Enemy {

	private float direction; 
	
	private int rangeX; 
	private int rangeY; 
	
	private int health;
	
	public TempleGhostEnemy(Utils.Point point, float direction) {
		//Placeholder
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("GhostSprite.png"), 22, 22), "MAX_HEALTH"); 
		this.direction = direction; 
		
		rangeX = 200; 
		rangeY = 200; 
		
		health = 30;
	} 
	
	//Updates enemy location 
	public void update(Player player, Map map) {
		
		//Basic AI tracking system which enables the zombie enemy to move towards the player if the player gets close enough
				if(player.getX() + 4 > this.x) {
					direction = 1.0F;
				} 
				else if(player.getX() + 6 < this.x) {
					direction = -1.0F;
				} 
				else {
					direction = 0.0F; 
				}
				moveX(direction*2); 
				if(player.getY() + 4 > this.y) {
					direction = 1.0F;
				} 
				else if(player.getY() + 6 < this.y) {
					direction = -1.0F;
				} 
				else {
					direction = 0.0F;
				}
				moveY(direction*2);
			//}
		//}
		super.update(player, map);
		
	} 
	
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("MAX_HEALTH", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 2))
                            .withScale(3)
                            .withBounds(1, 3, 20, 19)
                            .build()
            });
            put("TWO_SHOT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 1))
                            .withScale(3)
                            .withBounds(1, 3, 20, 19)
                            .build()
            });
            put("ONE_SHOT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(1, 3, 20, 19)
                            .build()
            });
        }};
    } 
    
    @Override
    public void damageEnemy(Enemy enemy, int damage) {
    	health = health - damage; 
    	//Sets health bar to correct value
    	if(health > 20) {
    		setCurrentAnimationName("MAX_HEALTH");
    	}
    	else if(health > 10 && health <= 20) {
    		setCurrentAnimationName("TWO_SHOT");
    	}
    	else {
    		setCurrentAnimationName("ONE_SHOT");
    	} 
    	//If health is depleted eliminate the enemy 
    	if(health <= 0) { 
    		super.damageEnemy(enemy, damage);
    	}
    }
    
    //Gets health 
    public int getHealth() {
    	return health;
    } 
    //Sets health
    public void setHealth(int health) {
    	this.health = health;
    }
}
