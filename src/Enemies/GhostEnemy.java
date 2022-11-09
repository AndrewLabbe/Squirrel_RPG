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

public class GhostEnemy extends Enemy {

	private float direction; 
	
	private int rangeX; 
	private int rangeY; 
	
	private int health;
	
	public GhostEnemy(Utils.Point point, float direction) {
		//Placeholder
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Ghost.png"), 20, 20), "STAND_CENTER"); 
		this.direction = direction; 
		
		rangeX = 200; 
		rangeY = 200; 
		
		health = 30;
	} 
	
	//Updates enemy location 
	public void update(Player player, Map map) {
		
		//Basic AI tracking system which enables the zombie enemy to move towards the player if the player gets close enough
		if(player.getX() < this.x + rangeX && player.getX() > this.x - rangeX) { 
			if(player.getY() < this.y + rangeY && player.getY() > this.y - rangeY) {
				if(player.getX() + 4 > this.x) {
					direction = 1.0F;
				} 
				else if(player.getX() + 6 < this.x) {
					direction = -1.0F;
				} 
				else {
					direction = 0.0F; 
				}
				moveX(direction); 
				if(player.getY() + 4 > this.y) {
					direction = 1.0F;
				} 
				else if(player.getY() + 6 < this.y) {
					direction = -1.0F;
				} 
				else {
					direction = 0.0F;
				}
				moveY(direction);
			}
		}
		super.update(player, map);
		
	} 
	
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_CENTER", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(3, 1, 15, 18)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
        }};
    } 
    
    @Override
    public void damageEnemy(Enemy enemy, int damage) {
    	health = health - damage;
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
