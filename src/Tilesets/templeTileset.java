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

		// Left Wall Tile
		Frame leftWallPath = new FrameBuilder(getSubImage(0, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftWallPathTile = new MapTileBuilder(leftWallPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(leftWallPathTile);

		// Right Wall Tile
		Frame rightWallPath = new FrameBuilder(getSubImage(0, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightWallPathTile = new MapTileBuilder(rightWallPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(rightWallPathTile);

		// Top Wall Tile
		Frame topWallPath = new FrameBuilder(getSubImage(0, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallPathTile = new MapTileBuilder(topWallPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topWallPathTile);

		// Bottom Wall Tile
		Frame bottomWallPath = new FrameBuilder(getSubImage(1, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomWallPathTile = new MapTileBuilder(bottomWallPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(bottomWallPathTile);

		// Bottom Left Corner Tile
		Frame bottomLeftCornerPath = new FrameBuilder(getSubImage(1, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftCornerPathTile = new MapTileBuilder(bottomLeftCornerPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(bottomLeftCornerPathTile);

		// Bottom Right Corner Tile
		Frame bottomRightCornerPath = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightCornerPathTile = new MapTileBuilder(bottomRightCornerPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(bottomRightCornerPathTile);

		// Top Right Corner Tile
		Frame topRightCornerPath = new FrameBuilder(getSubImage(1, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightCornerPathTile = new MapTileBuilder(topRightCornerPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topRightCornerPathTile);

		// Top Left Corner Tile
		Frame topLeftCornerPath = new FrameBuilder(getSubImage(2, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftCornerPathTile = new MapTileBuilder(topLeftCornerPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topLeftCornerPathTile);

		return templeTiles;
	}

}
