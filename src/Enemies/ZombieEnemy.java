package Enemies;

import java.awt.Point;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Map;
import Level.Player;
import Utils.Stopwatch;

public class ZombieEnemy extends Enemy {

	private float direction; 
	
	private int rangeX; 
	private int rangeY;
	
	public ZombieEnemy(Utils.Point point, float direction) {
		//Placeholder
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Zombie.png"), 25, 30), "STAND_RIGHT"); 
		this.direction = direction; 
		
		rangeX = 200; 
		rangeY = 200;
	} 
	
	//Updates enemy location 
	public void update(Player player, Map map) {
		
		//Basic AI tracking system which enables the zombie enemy to move towards the player if the player gets close enough
		if(player.getX() < this.x + rangeX && player.getX() > this.x - rangeX) { 
			if(player.getY() < this.y + rangeY && player.getY() > this.y - rangeY) {
				if(player.getX() > this.x) {
					direction = 1.0F;
				} 
				if(player.getX() < this.x) {
					direction = -1.0F;
				}
				moveX(direction); 
				if(direction > 0) {
					this.currentAnimationName = "STAND_RIGHT"; 
				} 
				else {
					this.currentAnimationName = "STAND_LEFT";
				}
				if(player.getY() > this.y) {
					direction = 1.0F;
				} 
				if(player.getY() < this.y) {
					direction = -1.0F;
				}
				moveY(direction);
			}
		}
		super.update();
		
	} 
	
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(3, 2, 20, 26)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(2, 2, 20, 26)
                           .build()
           });
        }};
    }
	
}
