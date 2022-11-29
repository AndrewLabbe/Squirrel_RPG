package Tilesets;


import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class temple3Tileset extends Tileset {

	public temple3Tileset() {
		super(ImageLoader.load("TempleLevel3Tileset.png"), 32, 32, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> templeTiles = new ArrayList<>();

		// Blank Tile
		Frame blank = new FrameBuilder(getSubImage(1, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder blankTile = new MapTileBuilder(blank)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(blankTile);

		// left torch
		Frame leftTorch = new FrameBuilder(getSubImage(1, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTorchTile = new MapTileBuilder(leftTorch)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(leftTorchTile);

		// Floor Tile
		Frame floor = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder floorTile = new MapTileBuilder(floor)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(floorTile);

		// Right Torch Tile
		Frame rightTorch = new FrameBuilder(getSubImage(2, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTorchTile = new MapTileBuilder(rightTorch)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(rightTorchTile);

		// rightWall Tile
		Frame rightWall = new FrameBuilder(getSubImage(2, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightWallTile = new MapTileBuilder(rightWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(rightWallTile);

		// leftWall Tile
		Frame leftWall = new FrameBuilder(getSubImage(2, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftWallTile = new MapTileBuilder(leftWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(leftWallTile);

		// bottonLeft Tile
		Frame bottonLeft = new FrameBuilder(getSubImage(3, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottonLeftTile = new MapTileBuilder(bottonLeft)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottonLeftTile);

		// bottonRight Tile
		Frame bottonRight = new FrameBuilder(getSubImage(3, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottonRightTile = new MapTileBuilder(bottonRight)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottonRightTile);

		// Top Right Tile
		Frame topRight = new FrameBuilder(getSubImage(3, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightTile = new MapTileBuilder(topRight)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topRightTile);

		// Top Left Corner Tile
		Frame topLeft = new FrameBuilder(getSubImage(4, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftTile = new MapTileBuilder(topLeft)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topLeftTile);

		// Bottom Wall Tile
		Frame bottomWall = new FrameBuilder(getSubImage(4, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomWallTile = new MapTileBuilder(bottomWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomWallTile);

		// Top Wall Tile
		Frame topWall = new FrameBuilder(getSubImage(4, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallTile = new MapTileBuilder(topWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topWallTile);

		// Top Wall Path Tile
		Frame topWallPath = new FrameBuilder(getSubImage(5, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallPathTile = new MapTileBuilder(topWallPath)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topWallPathTile);

		// bottomLeftCornerWall Tile
		Frame bottomLeftCornerWall = new FrameBuilder(getSubImage(5, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftCornerWallTile = new MapTileBuilder(bottomLeftCornerWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomLeftCornerWallTile);

		// bottomRightCornerWall Tile
		Frame bottomRightCornerWall = new FrameBuilder(getSubImage(5, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightCornerWallTile = new MapTileBuilder(bottomRightCornerWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomRightCornerWallTile);
		
		return templeTiles;
	}

}
