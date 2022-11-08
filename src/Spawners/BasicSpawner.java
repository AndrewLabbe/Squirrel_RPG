package Spawners;

import java.util.HashMap;
import java.util.Random;

import Builders.FrameBuilder;
import Enemies.GhostEnemy;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Enemy;
import Level.Map;
import Level.MapEntityStatus;
import Level.Player;
import Level.Spawner;
import Projectiles.Acorn;
import Utils.Point;

//Basic spawner class 
public class BasicSpawner extends Spawner {

	private Point point; 
	private Random rng; 
	
	public BasicSpawner(Utils.Point point) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Spawner1.png"), 30, 30), "FACE_CENTER"); 
		this.point = point; 
		rng = new Random();
	}

	//Updates the spawners 
	public void update() {
		super.update(); 
	} 
	
	@Override 
	public void spawnEnemies(int spawnNumber) {
		while(spawnNumber >= 1) {
			GhostEnemy enemy = new GhostEnemy(randomSpawn(), 3.0f); 
			map.addEnemies(enemy);
			spawnNumber--;
		}
	} 
	
	//Creates one image for the speed boost 
	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[]{
					new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
								.withScale(2)
		                        .withBounds(2, 0, 25, 28) 
		                        .build()
		    }); 
		}}; 
	} 
	
	//Generates a random spawn location a certain distance from the spawner
	public Point randomSpawn() {
		int randomX = rng.nextInt(200) + 30;
		int randomY = rng.nextInt(200) + 30; 
		if(rng.nextInt(2) == 1) {
			randomX = randomX*-1 - 30;
		} 
		if(rng.nextInt(2) == 1) {
			randomY = randomY*-1 - 30;
		}
		Point spawnPoint = new Point(point.x + randomX, point.y + randomY); 
		
		return spawnPoint;
	}
	
}