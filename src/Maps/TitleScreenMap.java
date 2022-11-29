package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.PathingTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite squirrel;

    public TitleScreenMap() {
        super("title_screen_map.txt", new PathingTileset());
        Point catLocation = getMapTile(8, 3).getLocation().subtractX(6).subtractY(7);
        squirrel = new Sprite(ImageLoader.loadSubImage("Squirrel.png", Colors.MAGENTA, 0, 0, 24, 24));
        squirrel.setScale(3);
//        cat.setImageEffect(ImageEffect.FLIP_HORIZONTAL);
        squirrel.setLocation(catLocation.x, catLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        squirrel.draw(graphicsHandler);
    }
}
