package Collectibles;

import java.awt.image.BufferedImage;
import java.util.HashMap;


import Builders.FrameBuilder;
import Engine.ImageLoader;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.ImageEffect;
import GameObject.Sprite;
import GameObject.SpriteSheet;
import Level.CollectibleItem;

import Level.Map;

import Level.Player;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Screens.InventoryScreen;

public class CollectibleAcorn extends CollectibleItem {
	
	private final Key e = Key.E;
//	protected InventoryScreen invScreen;
	private float direction; 
	
	private Sprite sprite;
	private KeyLocker keyLocker = new KeyLocker();
//	private GameObject gObject;
//	private Map map;
	
	private int rangeX; 
	private int rangeY;

	
	public CollectibleAcorn(Utils.Point point) {
		//, Sprite sprite
		super(point.x, point.y, new SpriteSheet(ImageLoader.load("Acorn.png"), 29, 20), "STAND_RIGHT");
		//, new Sprite(ImageLoader.load("Acorn.png"))
		rangeX = 50; 
		rangeY = 50;
	}
	
//	public void initialize() {
//		map = new TitleScreenMap();
//	}
	
	public void update(Player player) {
//		map.update(player);
//		invScreen = invScreen.getInvScreen();
		sprite = new Sprite(ImageLoader.load("Acorn.png"));
		
		if (player.getX() < this.x + rangeX && player.getX() > this.x - rangeX) {
			if (player.getY() < this.y + rangeY && player.getY() > this.y - rangeY && Keyboard.isKeyDown(e) && !keyLocker.isKeyLocked(e)) {
				System.out.println("New Item added to inv");
				player.addInvItem("Acorn.png");
//				player.removeCollectibles("Acorn.png");
				keyLocker.lockKey(e);
				
			}
			
			if (Keyboard.isKeyUp(e)) {
				keyLocker.unlockKey(e);
			}
		
		}

		super.update();
	}

	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_RIGHT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(3, 2, 20, 26)
                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 0))
                           .withScale(3)
                           .withBounds(2, 2, 20, 26)
                           .build()
           });
        }};
    }


//	public CollectibleAcorn loadAcorn() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}
