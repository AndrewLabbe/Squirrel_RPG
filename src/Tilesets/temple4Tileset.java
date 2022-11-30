package Tilesets;


import java.util.ArrayList;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.TileType;
import Level.Tileset;

public class temple4Tileset extends Tileset {

	public temple4Tileset() {
		super(ImageLoader.load("TempleLevel4Tileset.png"), 32, 32, 3);
	}

	@Override
	public ArrayList<MapTileBuilder> defineTiles() {
		ArrayList<MapTileBuilder> templeTiles = new ArrayList<>();

		// Floor Tile
		Frame floor = new FrameBuilder(getSubImage(0, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder floorTile = new MapTileBuilder(floor)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(floorTile);
		
		// leftTorch Tile
		Frame leftTorch = new FrameBuilder(getSubImage(0, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTorchTile = new MapTileBuilder(leftTorch)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(leftTorchTile);
				
		// rightTorch Tile
		Frame rightTorch = new FrameBuilder(getSubImage(0, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTorchTile = new MapTileBuilder(rightTorch)
				.withTileType(TileType.PASSABLE);

		templeTiles.add(rightTorchTile);
				
		// rightWall Tile
		Frame rightWall = new FrameBuilder(getSubImage(0, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightWallTile = new MapTileBuilder(rightWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(rightWallTile);
				
		// leftWall Tile
		Frame leftWall = new FrameBuilder(getSubImage(0, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftWallTile = new MapTileBuilder(leftWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(leftWallTile);
				
		// bottomLeft Tile
		Frame bottomLeft = new FrameBuilder(getSubImage(0, 5))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftTile = new MapTileBuilder(bottomLeft)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomLeftTile);
				
		// bottomRight Tile
		Frame bottomRight = new FrameBuilder(getSubImage(0, 6))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightTile = new MapTileBuilder(bottomRight)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomRightTile);
				
		// topRight Tile
		Frame topRight = new FrameBuilder(getSubImage(0, 7))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightTile = new MapTileBuilder(topRight)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topRightTile);
				
		// topLeft Tile
		Frame topLeft = new FrameBuilder(getSubImage(0, 8))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftTile = new MapTileBuilder(topLeft)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topLeftTile);
				
		// bottomWall Tile
		Frame bottomWall = new FrameBuilder(getSubImage(1, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomWallTile = new MapTileBuilder(bottomWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bottomWallTile);
				
		// topWall Tile
		Frame topWall = new FrameBuilder(getSubImage(1, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder topWallTile = new MapTileBuilder(topWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(topWallTile);
				
		// LWall Tile
		Frame LWall = new FrameBuilder(getSubImage(1, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder LWallTile = new MapTileBuilder(LWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(LWallTile);
				
		// bLWall Tile
		Frame bLWall = new FrameBuilder(getSubImage(1, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder bLWallTile = new MapTileBuilder(bLWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(bLWallTile);
				
		// lavaExit Tile
		Frame lavaExit = new FrameBuilder(getSubImage(1, 5))
				.withScale(tileScale)
				.build();

		MapTileBuilder lavaExitTile = new MapTileBuilder(lavaExit)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(lavaExitTile);
		
		// boomerangWall Tile
		Frame boomerangWall = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder boomerangWallTile = new MapTileBuilder(boomerangWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(boomerangWallTile);
		
		// reverseBoomerangWall Tile
		Frame reverseBoomerangWall = new FrameBuilder(getSubImage(7, 8))
				.withScale(tileScale)
				.build();

		MapTileBuilder reverseBoomerangWallTile = new MapTileBuilder(reverseBoomerangWall)
				.withTileType(TileType.NOT_PASSABLE);

		templeTiles.add(reverseBoomerangWallTile);

		Frame[] lavaEntrance = new Frame[] {
		        new FrameBuilder(getSubImage(1, 6), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(1, 7), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(1, 8), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 0), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 1), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 2), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 3), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 4), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 5), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 6), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 7), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(2, 8), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 0), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 1), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 2), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 3), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 4), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 5), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 6), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 7), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(3, 8), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 0), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 1), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 2), 100)
		                .withScale(tileScale)
		                .build()
		};
		
		MapTileBuilder lavaEntranceTile = new MapTileBuilder(lavaEntrance)
			.withTileType(TileType.NOT_PASSABLE);
		
		templeTiles.add(lavaEntranceTile);
		
		Frame[] lavaFlowing = new Frame[] {
		        new FrameBuilder(getSubImage(4, 3), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 4), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 5), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 6), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 7), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(4, 8), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 0), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 1), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 2), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 3), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 4), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 5), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 6), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 7), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(5, 8), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 0), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 1), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 2), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 3), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 4), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 5), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 6), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 7), 100)
		                .withScale(tileScale)
		                .build(),
		        new FrameBuilder(getSubImage(6, 8), 100)
		                .withScale(tileScale)
		                .build()
		};
		
		MapTileBuilder lavaFlowingTile = new MapTileBuilder(lavaFlowing)
			.withTileType(TileType.NOT_PASSABLE);
		
		templeTiles.add(lavaFlowingTile);
		
		// blank Tile
		Frame blank = new FrameBuilder(getSubImage(7, 8))
				.withScale(tileScale)
				.build();

		MapTileBuilder blankTile = new MapTileBuilder(blank)
				.withTileType(TileType.NOT_PASSABLE);

				templeTiles.add(blankTile);
		
		return templeTiles;
	}

}
