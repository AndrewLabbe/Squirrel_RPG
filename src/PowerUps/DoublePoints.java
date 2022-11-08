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

public class DoublePoints extends PowerUp {
	
	public DoublePoints(Utils.Point point) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("DoublePoints.png"), 20, 20), "FACE_CENTER");
	} 
	
	@Override 
	public void update(Player player, Map map) {
		super.update(player, map); 
		if(intersects(player)) { 
			map.doublePointsStart(); 
			map.setPowerUpActive();
			setMapEntityStatus(MapEntityStatus.REMOVED);
		} 
	} 
	
	//Creates one image for the double points 
	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[]{
					new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
								.withScale(2)
		                        .withBounds(1, 0, 16, 15) 
		                        .build()
		    });
		 }}; 
	}
}
