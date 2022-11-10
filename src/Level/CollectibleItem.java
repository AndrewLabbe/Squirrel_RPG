package Level;

import java.awt.image.BufferedImage;

import GameObject.Sprite;
import GameObject.SpriteSheet;
import Utils.Point;

public class CollectibleItem extends MapEntity {

	public CollectibleItem(float x, float y, SpriteSheet spriteSheet, String startingAnimation) {
		super(x, y, spriteSheet, startingAnimation);
		
	}

	public void update(Player player) {
		
		super.update();
		
		
	}

	void removeCollectible(CollectibleItem item) {
		item.mapEntityStatus = mapEntityStatus.REMOVED;
		
	}

}
