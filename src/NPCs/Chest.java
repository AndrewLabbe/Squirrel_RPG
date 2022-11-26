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

	public Chest(int id, Point location) {
		super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("Chests.png"), 16, 16), "STAND_LEFT");
	}
	
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("STAND_LEFT", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(4, 5, 5, 10)
                            .build()
            });
            put("STAND_RIGHT", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 1))
                           .withScale(3)
                           .withBounds(4, 5, 5, 10)
                           .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                           .build()
           });
        }};
    }
	
	@Override
	public void update(Player player) {
		if(player.getMap().getFlagManager().isFlagSet("hasOpenedChest")) {
			setCurrentAnimationName("STAND_RIGHT");
		}
        super.update(player); 
    }

}
