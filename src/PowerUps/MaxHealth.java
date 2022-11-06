package PowerUps;

import java.util.HashMap;
import Level.Map;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.MapEntityStatus;
import Level.Player;
import Level.PowerUp;

public class MaxHealth extends PowerUp {
	
	public MaxHealth(Utils.Point point) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("MaxHealth.png"), 20, 20), "FACE_CENTER");
	} 
	
	@Override 
	public void update(Player player, Map map) {
		super.update(player, map); 
		if(intersects(player)) { 
			map.resetHealthBar();
			setMapEntityStatus(MapEntityStatus.REMOVED);
		} 
	} 
	
	//Creates one image for the max health 
	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[]{
					new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
								.withScale(2)
		                        .withBounds(1, 2, 15, 12) 
		                        .build()
		    });
		 }}; 
	}
}
