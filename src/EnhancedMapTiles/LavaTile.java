package EnhancedMapTiles;

import Builders.FrameBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.GameObject;
import GameObject.SpriteSheet;
import Level.EnhancedMapTile;
import Level.Player;
import Level.PlayerState;
import Level.TileType;
import Utils.Direction;
import Utils.Point;

//Lava enhanced tiles that deal damage when the player walks across them 
public class LavaTile extends EnhancedMapTile {
    public LavaTile(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Acorns.png"), 20, 20), TileType.PASSABLE);
    }

    @Override
    public void update(Player player) {
        super.update(player); 
        if(this.overlaps(player)) {
        	map.dealDamage(1);
        }
     
    }

    @Override
    protected GameObject loadBottomLayer(SpriteSheet spriteSheet) {
        Frame frame = new FrameBuilder(spriteSheet.getSubImage(0, 0))
                .withScale(3)
                .build();
        return new GameObject(x, y, frame);
    }
}
