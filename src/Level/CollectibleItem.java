package Level;

import java.awt.image.BufferedImage;

import GameObject.Sprite;
import GameObject.SpriteSheet;
import Utils.Point;

public class CollectibleItem extends MapEntity {

	SpriteSheet spriteSheet; 
	String imageName;
	
	public CollectibleItem(float x, float y, SpriteSheet spriteSheet, String startingAnimation, String name) {
		super(x, y, spriteSheet, startingAnimation);
		this.spriteSheet = spriteSheet;
		imageName = name;
	}

	public void update(Player player) {
		
		super.update();
		
		
	}

	void removeCollectible(CollectibleItem item) {
		item.mapEntityStatus = mapEntityStatus.REMOVED;
		
	} 
	
	public String getImageName() {
		return imageName;
	}

}
