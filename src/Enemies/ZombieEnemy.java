package Enemies;

import java.awt.Point;
import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Player;
import Utils.Stopwatch;

public class ZombieEnemy extends Enemy {

	private float direction; 
	private Stopwatch timer;
	
	public ZombieEnemy(Utils.Point point, float direction) {
		//Placeholder
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Zombie.png"), 25, 30), "STAND_RIGHT"); 
		this.direction = direction; 
		timer = new Stopwatch(); 
		timer.setWaitTime(5000);
	} 
	
	//Updates enemy location 
	public void update(Player player) {
		
		//Moves zombie enemy back and forth on the screen using a timer
		if(timer.isTimeUp() == false) {
			moveX(direction); 
		} 
		else {
			timer.reset(); 
			direction = (float) (direction * -1.00); 
			if(direction > 1) {
				this.currentAnimationName = "STAND_RIGHT"; 
			} 
			else {
				this.currentAnimationName = "STAND_LEFT";
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
                            .withBounds(7, 13, 11, 7)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(7, 13, 11, 7)
                           .build()
           });
        }};
    }
	
}