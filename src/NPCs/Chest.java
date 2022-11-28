package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

public class Chest extends NPC {

	private String name;
	
	public Chest(int id, Point location, String name) {
		super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Chests.png"), 16, 16), "LOCKED");
		this.name = name;
	}
	
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("LOCKED", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(-2, -2, 17, 17)
                            .build()
            });
            put("UNLOCKED", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 1))
                           .withScale(3)
                           .withBounds(-2, -2, 17, 17)
                           .build()
           });
        }};
    }
	
	@Override
	public void update(Player player) {
		if(player.getMap().getFlagManager().isFlagSet(name)) {
			setCurrentAnimationName("UNLOCKED");
		}
        super.update(player); 
    }

}
