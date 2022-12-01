package Collectibles;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.CollectibleItem;
import Level.MapEntityStatus;
import Level.Player;

public class EasterEgg extends  CollectibleItem{

	public EasterEgg(Utils.Point point) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("EasterEgg.png"), 20, 20), "FACE_CENTER", "EasterEgg.png"); 
	}
	
	@Override
	public void update(Player player) {
		
		if(this.intersects(player)) { 
			player.addInvItem("EasterEgg.png");
			this.setMapEntityStatus(MapEntityStatus.REMOVED);
		}

		super.update(); 
		
	} 
	
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("FACE_CENTER", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(0, 0))
							.withScale(2)
	                        .withBounds(4, 1, 12, 14)
	                        .build()
	         }); 
	     }};
	}
	
}

