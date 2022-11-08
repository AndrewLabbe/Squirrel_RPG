package PowerUps;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.Map;
import Level.MapEntityStatus;
import Level.Player;
import Level.PowerUp;

//Increases player Speed for a period of time 
public class SpeedBoost extends PowerUp {

	public SpeedBoost(Utils.Point point) { 
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("LightningBolt.png"), 20, 20), "FACE_CENTER"); 
	}
	
	@Override 
	public void update(Player player, Map map) {
		super.update(player, map); 
		if(intersects(player)) { 
			player.setWalkSpeed(player.getWalkSpeed()*2.0f); 
			player.setSpeedBoostActive();
			map.setPowerUpActive();
			setMapEntityStatus(MapEntityStatus.REMOVED);
		} 
	} 
	
	//Creates one image for the speed boost 
	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[]{
					new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
							 .withScale(2)
	                         .withBounds(3, 0, 12, 19) 
	                         .build()
	        });
	    }}; 
	}
}
