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
		super(ImageLoader.load("TempleTileset.png"), 32, 32, 3);
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

		// Entrance Tile
		Frame entrance = new FrameBuilder(getSubImage(0, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder entranceTile = new MapTileBuilder(entrance)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(entranceTile);

		// Grassy Tile
		Frame grassyBlock = new FrameBuilder(getSubImage(0, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder grassyBlockTile = new MapTileBuilder(grassyBlock)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(grassyBlockTile);

		// Table with Tablecloth Tile
		Frame tableWithTablecloth = new FrameBuilder(getSubImage(1, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder tableWithTableclothTile = new MapTileBuilder(tableWithTablecloth)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(tableWithTableclothTile);

		// Table with skull tile
		Frame skullTable = new FrameBuilder(getSubImage(1, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder skullTableTile = new MapTileBuilder(skullTable)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(skullTableTile);

		// Golden Table Tile
		Frame goldenTable = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder goldenTableTile = new MapTileBuilder(goldenTable)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(goldenTableTile);

		// Dinner Table Tile
		Frame dinnerTable = new FrameBuilder(getSubImage(2, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder dinnerTableTile = new MapTileBuilder(dinnerTable)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(dinnerTableTile);

		// Basic Table Tile
		Frame basicTable = new FrameBuilder(getSubImage(2, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder basicTableTile = new MapTileBuilder(basicTable)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(basicTableTile);

		// Left Torch Tile
		Frame leftTorch = new FrameBuilder(getSubImage(2, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTorchTile = new MapTileBuilder(leftTorch)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(leftTorchTile);

		// Right Torch Tile
		Frame rightTorch = new FrameBuilder(getSubImage(3, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTorchTile = new MapTileBuilder(rightTorch)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(rightTorchTile);

		// Right Wall Tile
		Frame rightWall = new FrameBuilder(getSubImage(3, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightWallTile = new MapTileBuilder(rightWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(rightWallTile);

		// Left Wall Tile
		Frame leftWall = new FrameBuilder(getSubImage(3, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftWallTile = new MapTileBuilder(leftWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(leftWallTile);

		// Bottom Left Corner Tile
		Frame bottomLeftCornerWall = new FrameBuilder(getSubImage(4, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftCornerWallTile = new MapTileBuilder(bottomLeftCornerWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomLeftCornerWallTile);

		// Bottom Right Corner Tile
		Frame bottomRightCornerWall = new FrameBuilder(getSubImage(4, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightCornerWallTile = new MapTileBuilder(bottomRightCornerWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomRightCornerWallTile);

		// Top Right Corner Tile
		Frame topRightCornerWall = new FrameBuilder(getSubImage(4, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightCornerWallTile = new MapTileBuilder(topRightCornerWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topRightCornerWallTile);

		// Top Left Corner Tile
		Frame topLeftCornerWall = new FrameBuilder(getSubImage(5, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftCornerWallTile = new MapTileBuilder(topLeftCornerWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topLeftCornerWallTile);

		// Bottom Wall Tile
		Frame bottomWall = new FrameBuilder(getSubImage(5, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomWallTile = new MapTileBuilder(bottomWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomWallTile);

		// Top Wall Tile
		Frame topWall = new FrameBuilder(getSubImage(5, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallTile = new MapTileBuilder(topWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topWallTile);

		// Top Wall Tile
		Frame skullTableFacingLeft = new FrameBuilder(getSubImage(6, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder skullTableFacingLeftTile = new MapTileBuilder(skullTableFacingLeft)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(skullTableFacingLeftTile);

		// Top Wall With Floor Tile
		Frame topWallWithFloor = new FrameBuilder(getSubImage(6, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallWithFloorTile = new MapTileBuilder(topWallWithFloor)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topWallWithFloorTile);

		// Blank Tile With Floor Tile
		Frame blank = new FrameBuilder(getSubImage(6, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder blankTile = new MapTileBuilder(blank)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(blankTile);

		// L Shaped Wall Tile
		Frame LWall = new FrameBuilder(getSubImage(7, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder LWallTile = new MapTileBuilder(LWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(LWallTile);

		// Reverse L Shaped Wall Tile
		Frame reverseLWall = new FrameBuilder(getSubImage(7, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder reverseLWallTile = new MapTileBuilder(reverseLWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(reverseLWallTile);

		// Left corner dirt tile
		Frame dirtLeftCorner = new FrameBuilder(getSubImage(7, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder dirtLeftCornerTile = new MapTileBuilder(dirtLeftCorner)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(dirtLeftCornerTile);

		// Right corner dirt tile
		Frame dirtRightCorner = new FrameBuilder(getSubImage(8, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder dirtRightCornerTile = new MapTileBuilder(dirtRightCorner)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(dirtRightCornerTile);

		// Left Stairs Tile
		Frame leftStairs = new FrameBuilder(getSubImage(8, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftStairsTile = new MapTileBuilder(leftStairs)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(leftStairsTile);

		// Right Stairs Tile
		Frame rightStairs = new FrameBuilder(getSubImage(8, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightStairsTile = new MapTileBuilder(rightStairs)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(rightStairsTile);

		// Top Floor Water Tile
		Frame topFloorWater = new FrameBuilder(getSubImage(9, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topFloorWaterTile = new MapTileBuilder(topFloorWater)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topFloorWaterTile);

		// Bottom Floor Tile
		Frame bottomWaterFloor = new FrameBuilder(getSubImage(9, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomFloorWaterTile = new MapTileBuilder(bottomWaterFloor)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(bottomFloorWaterTile);

		// Right Floor Tile
		Frame rightWaterFloor = new FrameBuilder(getSubImage(9, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightWaterFloorTile = new MapTileBuilder(rightWaterFloor)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(rightWaterFloorTile);

		// Left Floor Tile
		Frame leftWaterFloor = new FrameBuilder(getSubImage(11, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftWaterFloorTile = new MapTileBuilder(leftWaterFloor)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(leftWaterFloorTile);

		// Top Left Corner Tile
		Frame topLeftWaterCorner = new FrameBuilder(getSubImage(10, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftWaterCornerTile = new MapTileBuilder(topLeftWaterCorner)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topLeftWaterCornerTile);

		// Top Right Corner Tile
		Frame topRightWaterCorner = new FrameBuilder(getSubImage(10, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightWaterCornerTile = new MapTileBuilder(topRightWaterCorner)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(topRightWaterCornerTile);

		// Bottom Right Corner Tile
		Frame bottomRightWaterCorner = new FrameBuilder(getSubImage(10, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightWaterCornerTile = new MapTileBuilder(bottomRightWaterCorner)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(bottomRightWaterCornerTile);

		// Bottom Left Corner Tile
		Frame bottomLeftWaterCorner = new FrameBuilder(getSubImage(11, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftWaterCornerTile = new MapTileBuilder(bottomLeftWaterCorner)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(bottomLeftWaterCornerTile);

		// Water Tile
		Frame waterTile = new FrameBuilder(getSubImage(11, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder waterTilePiece = new MapTileBuilder(waterTile)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(waterTilePiece);

		return templeTiles;
	}

}
