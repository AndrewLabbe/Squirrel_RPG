package Spawners;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Map;
import Level.MapEntityStatus;
import Level.Player;
import Level.Spawner;

//Basic spawner class 
public class BasicSpawner extends Spawner {

	public BasicSpawner(Utils.Point point) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Spawner1.png"), 30, 30), "FACE_CENTER"); 
		
	}

	//Updates the spawners 
	public void update() {
		super.update(); 
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
	
}
