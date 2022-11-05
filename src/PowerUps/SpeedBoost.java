package PowerUps;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.MapEntityStatus;
import Level.Player;
import Level.PowerUp;
import Utils.Stopwatch;

//Increases player Speed for a period of time 
public class SpeedBoost extends PowerUp {

	public SpeedBoost(Utils.Point point) { 
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("lightningBolt.png"), 20, 20), "FACE_CENTER"); 
	}
	
	@Override 
	public void update(Player player) {
		super.update(player); 
		if(intersects(player)) { 
			player.setWalkSpeed(player.getWalkSpeed()*2.0f); 
			player.setSpeedBoostActive();
			setMapEntityStatus(MapEntityStatus.REMOVED);
		} 
	} 
	
	//Creates one image for the speed boost 
	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[]{
					new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
							 .withScale(1)
	                         .withBounds(2, 0, 13, 19) 
	                         .build()
	        });
	    }}; 
	}
}
