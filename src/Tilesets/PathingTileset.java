package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class PathingTileset extends Tileset {

	public PathingTileset() {
		super(ImageLoader.load("PathingTileset.png"), 16, 16, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> pathTiles = new ArrayList<>();

		// Top Left Path
		Frame topLeftPath = new FrameBuilder(getSubImage(0, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftPathTile = new MapTileBuilder(topLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topLeftPathTile);

		// Top Left Path
		Frame topMidPath = new FrameBuilder(getSubImage(1, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topMidPathTile = new MapTileBuilder(topMidPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topMidPathTile);

		// Top Right Path
		Frame topRightPath = new FrameBuilder(getSubImage(2, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightPathTile = new MapTileBuilder(topRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topRightPathTile);

		// Mid Left Path
		Frame midLeftPath = new FrameBuilder(getSubImage(0, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder midLeftPathTile = new MapTileBuilder(midLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(midLeftPathTile);

		// Grass Color Tile
		Frame grassColorTile = new FrameBuilder(getSubImage(1, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder grassColorPathTile = new MapTileBuilder(grassColorTile)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(grassColorPathTile);

		// Mid Right Path
		Frame midRightPath = new FrameBuilder(getSubImage(2, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder midRightPathTile = new MapTileBuilder(midRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(midRightPathTile);

		// Bottom Left Path
		Frame bottomLeftPath = new FrameBuilder(getSubImage(0, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftPathTile = new MapTileBuilder(bottomLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bottomLeftPathTile);

		// Bottom Middle Path
		Frame bottomMiddlePath = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomMiddlePathTile = new MapTileBuilder(bottomMiddlePath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bottomMiddlePathTile);

		// Bottom Right Path
		Frame bottomRightPath = new FrameBuilder(getSubImage(2, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightPathTile = new MapTileBuilder(bottomRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bottomRightPathTile);

		// Left Top Corner Path
		Frame leftTopCornerPath = new FrameBuilder(getSubImage(3, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTopCornerPathTile = new MapTileBuilder(leftTopCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(leftTopCornerPathTile);

		// Right Top Corner Path
		Frame rightTopCornerPath = new FrameBuilder(getSubImage(4, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTopCornerPathTile = new MapTileBuilder(rightTopCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightTopCornerPathTile);

		// Left Bottom Corner Path
		Frame leftBottomCornerPath = new FrameBuilder(getSubImage(3, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftBottomCornerPathTile = new MapTileBuilder(leftBottomCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(leftBottomCornerPathTile);

		// Left Bottom Corner Path
		Frame rightBottomCornerPath = new FrameBuilder(getSubImage(4, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightBottomCornerPathTile = new MapTileBuilder(rightBottomCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightBottomCornerPathTile);

		// Right Diag Path
		Frame rightDiagPath = new FrameBuilder(getSubImage(3, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightDiagPathTile = new MapTileBuilder(rightDiagPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightDiagPathTile);

		// Left Diag Path
		Frame leftDiagPath = new FrameBuilder(getSubImage(4, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftDiagPathTile = new MapTileBuilder(leftDiagPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(leftDiagPathTile);

		// Bush Tile
		Frame thickBushTile = new FrameBuilder(getSubImage(3, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bushTile = new MapTileBuilder(thickBushTile)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bushTile);

		// Short Grass Tile
		Frame shortGrassTile = new FrameBuilder(getSubImage(3, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder shortGrassTile1 = new MapTileBuilder(shortGrassTile)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(shortGrassTile1);

		// Pink Flowers
		Frame pinkFlowers = new FrameBuilder(getSubImage(3, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder pinkFlowersTile = new MapTileBuilder(pinkFlowers)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(pinkFlowersTile);

		// Red Flowers
		Frame redFlowers = new FrameBuilder(getSubImage(4, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder redFlowersTile = new MapTileBuilder(redFlowers)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(redFlowersTile);
		
		

		return pathTiles;
	}
}
