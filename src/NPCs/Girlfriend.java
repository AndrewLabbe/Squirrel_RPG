package NPCs;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.SpriteSheet;
import Level.NPC;
import Level.Player;
import Utils.Point;

public class Girlfriend extends NPC {
	
	private String name;

	public Girlfriend(int id, Point location, String name) {
		super(id, location.x, location.y, new SpriteSheet(ImageLoader.load("GirlfriendSquirrel.png"), 24, 24), "ALIVE");
		this.name = name;
	}
	
	@Override
    public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
        return new HashMap<String, Frame[]>() {{
            put("ALIVE", new Frame[] {
                    new FrameBuilder(spriteSheet.getSprite(0, 0))
                            .withScale(3)
                            .withBounds(6, 12, 12, 7)
                            .build()
            });
            put("DEAD", new Frame[] {
                   new FrameBuilder(spriteSheet.getSprite(0, 1))
                           .withScale(3)
                           .withBounds(6, 12, 12, 7)
                           .build()
           });
        }};
    }
	
	@Override
	public void update(Player player) {
		if(player.getMap().getFlagManager().isFlagSet(name)) {
			setCurrentAnimationName("DEAD");
		}
        super.update(player); 
    }

}
