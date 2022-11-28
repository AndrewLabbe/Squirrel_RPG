package Enemies;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import Game.GameState;
import Game.ScreenCoordinator;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Map;
import Level.Player;
import Utils.Point;

public class WizardEnemy extends Enemy {

	private float direction; 
	
	private int rangeX; 
	private int rangeY; 
	
	private int health;
	
	public WizardEnemy(Utils.Point point, float direction) {
		//Placeholder
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Warlock-1.png.png"), 64, 64), "FACE_CENTER"); 
		this.direction = direction; 
	
		health = 100;
	} 
	
	//Updates enemy location 
	public void update(Player player, Map map) {
		
		//Basic AI tracking system which enables the zombie enemy to move towards the player if the player gets close enough
				if(player.getX() + 1 > this.x) {
					direction = 1.0F;
				} 
				else if(player.getX() + 3 < this.x) {
					direction = -1.0F;
				} 
				else {
					direction = 0.0F; 
				}
				moveX(direction*2); 
				if(player.getY() + 1 > this.y) {
					direction = 1.0F;
				} 
				else if(player.getY() + 3 < this.y) {
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
            put("FACE_CENTER", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
                            .withScale(2)
                            .withBounds(20, 0, 24, 64)
                            .build()
            });
        }};
    } 
    
    @Override
    public void damageEnemy(Enemy enemy, int damage) {
    	health = health - damage; 
    	if(health <= 0) { 
    		eliminateEnemy(enemy);
    	}
    }
    
    @Override
    public void eliminateEnemy(Enemy enemy) {
		this.mapEntityStatus = mapEntityStatus.REMOVED; 
		playSound(8); 
		map.getFlagManager().setFlag("hasBeatenBoss");
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
