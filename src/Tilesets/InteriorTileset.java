package Tilesets;

import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class InteriorTileset extends Tileset {

	public InteriorTileset() {
		super(ImageLoader.load("Interiortileset.png"), 16, 16, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> interiorTiles = new ArrayList<>();

		// Left Corner Wall
		Frame leftCornerWall = new FrameBuilder(getSubImage(0, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftCornerWallTile = new MapTileBuilder(leftCornerWall)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(leftCornerWallTile);

		// Right Corner Wall
		Frame rightCornerWall = new FrameBuilder(getSubImage(0, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightCornerWallTile = new MapTileBuilder(rightCornerWall)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(rightCornerWallTile);

		// Left Pillar Wall
		Frame leftPillarWall = new FrameBuilder(getSubImage(1, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftPillarWallTile = new MapTileBuilder(leftPillarWall)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(leftPillarWallTile);

		// Right Pillar Wall
		Frame rightPillarWall = new FrameBuilder(getSubImage(1, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightPillarWallTile = new MapTileBuilder(rightPillarWall)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(rightPillarWallTile);

		// Floor Tile
		Frame floorTile = new FrameBuilder(getSubImage(2, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder floorFrameTile = new MapTileBuilder(floorTile)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(floorFrameTile);

		// Top Wall
		Frame topWall = new FrameBuilder(getSubImage(2, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallTile = new MapTileBuilder(topWall)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(topWallTile);

		// Void Tile
		Frame voidTile = new FrameBuilder(getSubImage(0, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder voidFrameTile = new MapTileBuilder(voidTile)
				.withTileType(TileType.NOT_PASSABLE);

		interiorTiles.add(voidFrameTile);

		// Wall Tile
		Frame wallTile = new FrameBuilder(getSubImage(0, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder wallFrameTile = new MapTileBuilder(wallTile)
				.withTileType(TileType.PASSABLE);

		interiorTiles.add(wallFrameTile);

		// Right Transparent Wall
		Frame rightTransWall = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTransWallTile = new MapTileBuilder(floorTile)
				.withTileType(TileType.PASSABLE)
				.withTopLayer(rightTransWall);

		interiorTiles.add(rightTransWallTile);

		// Left Transparent Wall
		Frame leftTransWall = new FrameBuilder(getSubImage(1, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTransWallTile = new MapTileBuilder(floorTile)
				.withTileType(TileType.PASSABLE)
				.withTopLayer(leftTransWall);

		interiorTiles.add(leftTransWallTile);

		// Bottom Transparent Wall
		Frame bottomTransWall = new FrameBuilder(getSubImage(2, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomTransWallTile = new MapTileBuilder(floorTile)
				.withTileType(TileType.PASSABLE)
				.withTopLayer(bottomTransWall);

		interiorTiles.add(bottomTransWallTile);

		// Top Transparent Wall
		Frame topTransWall = new FrameBuilder(getSubImage(2, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder topTransWallTile = new MapTileBuilder(floorTile)
				.withTileType(TileType.PASSABLE)
				.withTopLayer(topTransWall);

		interiorTiles.add(topTransWallTile);



		return interiorTiles;
	}

}
