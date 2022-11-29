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
import Projectiles.Acorn;
import Utils.Point;
import Utils.Stopwatch;

public class WizardEnemy extends Enemy {

	private float directionX; 
	private float directionY;
	
	private int rangeX; 
	private int rangeY; 
	
	private int health;
	
	private Stopwatch projectileCoolDown; 
	
	public WizardEnemy(Utils.Point point, float direction) {
		//Placeholder
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Warlock-1.png.png"), 64, 64), "FACE_CENTER"); 
		this.directionX = direction; 
		this.directionY = direction; 
		
		health = 100; 
		projectileCoolDown = new Stopwatch(); 
		projectileCoolDown.setWaitTime(2000);
	} 
	
	//Updates enemy location 
	public void update(Player player, Map map) {
		
		//Basic AI tracking system which enables the zombie enemy to move towards the player if the player gets close enough
				if(player.getX() + 1 > this.x) {
					directionX = 1.0F;
				} 
				else if(player.getX() + 3 < this.x) {
					directionX = -1.0F;
				} 
				else {
					directionX = 0.0F; 
				}
				moveX(directionX); 
				if(player.getY() + 1 > this.y) {
					directionY = 1.0F;
				} 
				else if(player.getY() + 3 < this.y) {
					directionY = -1.0F;
				} 
				else {
					directionY = 0.0F;
				}
				moveY(directionY);
			//}
		//}
		super.update(player, map);
		
		//Fires a projectile on the current vector towards the players current position periodically
		if(projectileCoolDown.isTimeUp()) { 
			if(directionX < 0) {
				if(directionY == 0) {
					Acorn acorn = new Acorn((int)this.getX(), (int)this.getY() + 50, directionX, directionY, 10, player, "GOLDEN_ACORN");
					map.addProjectiles(acorn); 
				}
				else {
					Acorn acorn = new Acorn((int)this.getX(), (int)this.getY() + 50, directionX, directionY, 10, player, "GOLDEN_ACORN");
					map.addProjectiles(acorn); 
				}
			}
			if (directionX > 0) {
				if(directionY == 0) {
					Acorn acorn = new Acorn((int)this.getX() + 100, (int)this.getY() + 50, directionX, directionY, 10, player, "GOLDEN_ACORN");
					map.addProjectiles(acorn); 
				} 
				else {
					Acorn acorn = new Acorn((int)this.getX() + 100, (int)this.getY() + 50, directionX, directionY, 10, player, "GOLDEN_ACORN");
					map.addProjectiles(acorn); 
				}
			} 
			if (directionX == 0 && directionY != 0) { 
				if(directionY > 0) {
					Acorn acorn = new Acorn((int)this.getX() + 40, (int)this.getY() + 125, directionX, directionY, 10, player, "GOLDEN_ACORN");
					map.addProjectiles(acorn);
				} 
				else {
					Acorn acorn = new Acorn((int)this.getX() + 40, (int)this.getY() - 20, directionX, directionY, 10, player, "GOLDEN_ACORN");
					map.addProjectiles(acorn);
				} 
			}
			projectileCoolDown.reset();
		}
		
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
