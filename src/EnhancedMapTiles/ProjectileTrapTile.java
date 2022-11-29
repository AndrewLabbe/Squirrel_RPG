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
import Projectiles.Acorn;
import Utils.Direction;
import Utils.Point;
import Utils.Stopwatch;

//Lava enhanced tiles that deal damage when the player walks across them 
public class ProjectileTrapTile extends EnhancedMapTile { 
	
	private Stopwatch projectileCoolDown;
	
    public ProjectileTrapTile(Point location) {
        super(location.x, location.y, new SpriteSheet(ImageLoader.load("Acorns.png"), 20, 20), TileType.PASSABLE); 
        
        projectileCoolDown = new Stopwatch();
        projectileCoolDown.setWaitTime(1000);
    }

    @Override
    public void update(Player player) {
        super.update(player); 
        if(this.overlaps(player)) {
        	if(projectileCoolDown.isTimeUp()) {
        		Acorn acorn = new Acorn((int)this.getX() + 100, (int)this.getY() + 10, 1.0f, 0.0f, 10, player, "NORMAL_ACORN");
        		map.addProjectiles(acorn); 
        		projectileCoolDown.reset();
        	}
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
