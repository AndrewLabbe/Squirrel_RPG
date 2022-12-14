package Players;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Map;
import Level.Player;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Squirrel extends Player {

	public Squirrel(float x, float y, Map map) {
		super(new SpriteSheet(ImageLoader.load("Squirrel.png"), 24, 24), x, y, "STAND_RIGHT", map);
		walkSpeed = 2.3f;
	}

	public void update() {
		super.update();
	}

	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
		// drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
	}

	@Override
	public HashMap<String, Frame[]> loadAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {{
			put("STAND_RIGHT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(0, 0), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 1), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 2), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 3), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 4), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 5), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
			});

			put("STAND_LEFT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(0, 0), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 1), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 2), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 3), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 4), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(0, 5), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
			});

			put("WALK_RIGHT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(1, 0), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 1), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 2), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 3), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 4), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 5), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 6), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 7), 100)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
			});

			put("WALK_LEFT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(1, 0), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 1), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 2), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 3), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 4), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 5), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 6), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(1, 7), 100)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
			});
			
			put("SWIM_RIGHT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(2, 0), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(2, 1), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(2, 2), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
			});
			
			put("SWIM_LEFT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(2, 3), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(2, 4), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(2, 5), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
			});
			
			put("IDLE_RIGHT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(3, 0), 400)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 1), 400)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 2), 400)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 3), 400)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 4), 300)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 5), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 6), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 5), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 6), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 5), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 6), 200)
					.withScale(3)
					.withBounds(6, 12, 12, 7)
					.build(),
			});
			
			put("IDLE_LEFT", new Frame[] {
					new FrameBuilder(spriteSheet.getSprite(3, 0), 400)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 1), 400)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 2), 400)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 3), 400)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 4), 300)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 5), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 6), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 5), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 6), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 5), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
					new FrameBuilder(spriteSheet.getSprite(3, 6), 200)
					.withScale(3)
					.withImageEffect(ImageEffect.FLIP_HORIZONTAL)
					.withBounds(6, 12, 12, 7)
					.build(),
			});
		}};
	} 
}