package Tilesets;


import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class templeTileset extends Tileset {
	
	public templeTileset() {
		super(ImageLoader.load("TempleTileset.png"), 48, 48, 1);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> templeTiles = new ArrayList<>();
		
		// Floor Tile
		Frame floorPath = new FrameBuilder(getSubImage(0, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder floorPathTile = new MapTileBuilder(floorPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(floorPathTile);
		
		return templeTiles;
	}

}
