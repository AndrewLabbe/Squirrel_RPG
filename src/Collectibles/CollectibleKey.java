package Collectibles;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.CollectibleItem;
import Level.MapEntityStatus;
import Level.Player;

public class CollectibleKey extends CollectibleItem {
	
	private String keyName;
	
	public CollectibleKey(Utils.Point point, String keyName) {
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Keys.png"), 16, 16), keyName, "Keys.png"); 		
		this.keyName = keyName;
	}
	
	@Override
	public void update(Player player) {
		
		if(this.intersects(player)) { 
			player.addInvItem(keyName);
			player.setKeyCounter(player.getKeyCounter() + 1);
			this.setMapEntityStatus(MapEntityStatus.REMOVED);
		}

		super.update(); 
		
	}

	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("KEY_FATE", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(2)
                            .withBounds(0, 0, 16, 16)
                            .build()
            }); 
            put("KEY_DESTINY", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 1))
                            .withScale(2)
                            .withBounds(0, 0, 16, 16)
                            .build()
            });
            put("KEY_GENESIS", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 2))
                            .withScale(2)
                            .withBounds(0, 0, 16, 16)
                            .build()
            });
            put("KEY_RETRIBUTION", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 3))
                            .withScale(2)
                            .withBounds(0, 0, 16, 16)
                            .build()
            });
        }};
    }
	
}
