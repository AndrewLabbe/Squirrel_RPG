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

public class InstaElim extends PowerUp {
	
	public InstaElim(Utils.Point point) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("InstaElim.png"), 20, 20), "FACE_CENTER");
	} 
	
	@Override 
	public void update(Player player, Map map) {
		super.update(player, map); 
		if(intersects(player)) { 
			player.setInstaElimActive();
			setMapEntityStatus(MapEntityStatus.REMOVED);
		} 
	} 
	
	//Creates one image for the insta elim power up
	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[]{
					new FrameBuilder(spriteSheet.getSprite(0, 0), 0)
								.withScale(2)
		                        .withBounds(2, 2, 18, 13) 
		                        .build()
		    });
		 }}; 
	}
}
