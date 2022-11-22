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
		Frame topMidPath = new FrameBuilder(getSubImage(0, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder topMidPathTile = new MapTileBuilder(topMidPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topMidPathTile);

		// Top Right Path
		Frame topRightPath = new FrameBuilder(getSubImage(0, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder topRightPathTile = new MapTileBuilder(topRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topRightPathTile);

		// Mid Left Path
		Frame midLeftPath = new FrameBuilder(getSubImage(1, 0))
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
		Frame midRightPath = new FrameBuilder(getSubImage(1, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder midRightPathTile = new MapTileBuilder(midRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(midRightPathTile);

		// Bottom Left Path
		Frame bottomLeftPath = new FrameBuilder(getSubImage(2, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftPathTile = new MapTileBuilder(bottomLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bottomLeftPathTile);

		// Bottom Middle Path
		Frame bottomMiddlePath = new FrameBuilder(getSubImage(2, 1))
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
		Frame leftTopCornerPath = new FrameBuilder(getSubImage(0, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTopCornerPathTile = new MapTileBuilder(leftTopCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(leftTopCornerPathTile);

		// Right Top Corner Path
		Frame rightTopCornerPath = new FrameBuilder(getSubImage(0, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTopCornerPathTile = new MapTileBuilder(rightTopCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightTopCornerPathTile);

		// Left Bottom Corner Path
		Frame leftBottomCornerPath = new FrameBuilder(getSubImage(1, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftBottomCornerPathTile = new MapTileBuilder(leftBottomCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(leftBottomCornerPathTile);

		// Left Bottom Corner Path
		Frame rightBottomCornerPath = new FrameBuilder(getSubImage(1, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightBottomCornerPathTile = new MapTileBuilder(rightBottomCornerPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightBottomCornerPathTile);

		// Right Diag Path
		Frame rightDiagPath = new FrameBuilder(getSubImage(2, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightDiagPathTile = new MapTileBuilder(rightDiagPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightDiagPathTile);

		// Left Diag Path
		Frame leftDiagPath = new FrameBuilder(getSubImage(2, 4))
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
		Frame redFlowers = new FrameBuilder(getSubImage(3, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder redFlowersTile = new MapTileBuilder(redFlowers)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(redFlowersTile);

		// Dirt Path
		Frame dirtPath = new FrameBuilder(getSubImage(4, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder dirtPathTile = new MapTileBuilder(dirtPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(dirtPathTile);

		// Lake Top Left
		Frame lakeTopLeftPath = new FrameBuilder(getSubImage(5, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeTopLeftPathTile = new MapTileBuilder(lakeTopLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeTopLeftPathTile);

		// Lake Top Middle
		Frame lakeTopMiddlePath = new FrameBuilder(getSubImage(5, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeTopMiddlePathTile = new MapTileBuilder(lakeTopMiddlePath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeTopMiddlePathTile);

		// Lake Top Right
		Frame lakeTopRightPath = new FrameBuilder(getSubImage(5, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeTopRightPathTile = new MapTileBuilder(lakeTopRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeTopRightPathTile);

		// Lake Mid Left
		Frame lakeMidLeftPath = new FrameBuilder(getSubImage(6, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeMidLeftPathTile = new MapTileBuilder(lakeMidLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeMidLeftPathTile);

		// Lake Tile
		Frame lakePath = new FrameBuilder(getSubImage(6, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakePathTile = new MapTileBuilder(lakePath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakePathTile);

		// Lake Mid Right
		Frame lakeMidRightPath = new FrameBuilder(getSubImage(6, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeMidRightPathTile = new MapTileBuilder(lakeMidRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeMidRightPathTile);

		// Lake Bottom Left
		Frame lakeBottomLeftPath = new FrameBuilder(getSubImage(7, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeBottomLeftPathTile = new MapTileBuilder(lakeBottomLeftPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeBottomLeftPathTile);

		// Lake Bottom Mid
		Frame lakeBottomMidPath = new FrameBuilder(getSubImage(7, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeBottomMidPathTile = new MapTileBuilder(lakeBottomMidPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeBottomMidPathTile);

		// Lake Bottom Mid
		Frame lakeBottomRightPath = new FrameBuilder(getSubImage(7, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeBottomRightPathTile = new MapTileBuilder(lakeBottomRightPath)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeBottomRightPathTile);

		// Lake Top Left Corner
		Frame lakeTopLeftCorner = new FrameBuilder(getSubImage(5, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeTopLeftCornerTile = new MapTileBuilder(lakeTopLeftCorner)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeTopLeftCornerTile);

		// Lake Top Right Corner
		Frame lakeTopRightCorner = new FrameBuilder(getSubImage(5, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeTopRightCornerTile = new MapTileBuilder(lakeTopRightCorner)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeTopRightCornerTile);

		// Lake Bottom Left Corner
		Frame lakeBottomLeftCorner = new FrameBuilder(getSubImage(6, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeBottomLeftCornerTile = new MapTileBuilder(lakeBottomLeftCorner)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeBottomLeftCornerTile);

		// Lake Bottom Right Corner
		Frame lakeBottomRightCorner = new FrameBuilder(getSubImage(6, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder lakeBottomRightCornerTile = new MapTileBuilder(lakeBottomRightCorner)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(lakeBottomRightCornerTile);

		// Crate Tile
		Frame crateTile = new FrameBuilder(getSubImage(4, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder crateTilePiece = new MapTileBuilder(crateTile)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(crateTilePiece);

		// Vase Tile
		Frame vaseTile = new FrameBuilder(getSubImage(4, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder vaseTilePiece = new MapTileBuilder(vaseTile)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(vaseTilePiece);

		// Chest Tile
		Frame chestTile = new FrameBuilder(getSubImage(4, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder chestTilePiece = new MapTileBuilder(grassColorTile)
				.withTopLayer(chestTile)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(chestTilePiece);

		// Barrel Tile
		Frame barrelTile = new FrameBuilder(getSubImage(4, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder barrelTilePiece = new MapTileBuilder(barrelTile)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(barrelTilePiece);

		// Small Shrub
		Frame smallShrubFrame = new FrameBuilder(getSubImage(7, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder smallShrubFrameTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(smallShrubFrame)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(smallShrubFrameTile);

		// Small Tree Top
		Frame smallTreeTop = new FrameBuilder(getSubImage(7, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder smallTreeTopTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(smallTreeTop)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(smallTreeTopTile);

		// Small Tree Bottom
		Frame smallTreeBottom = new FrameBuilder(getSubImage(8, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder smallTreeBottomTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(smallTreeBottom)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(smallTreeBottomTile);

		// Big Tree Top Left
		Frame bigTreeTopLeft = new FrameBuilder(getSubImage(8, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bigTreeTopLeftTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(bigTreeTopLeft)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bigTreeTopLeftTile);

		// Big Tree Top Right
		Frame bigTreeTopRight = new FrameBuilder(getSubImage(8, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bigTreeTopRightTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(bigTreeTopRight)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(bigTreeTopRightTile);

		// Big Tree Bottom Left
		Frame bigTreeBottomLeft = new FrameBuilder(getSubImage(9, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bigTreeBottomLeftTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(bigTreeBottomLeft)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(bigTreeBottomLeftTile);

		// Big Tree Bottom Right
		Frame bigTreeBottomRight = new FrameBuilder(getSubImage(9, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bigTreeBottomRightTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(bigTreeBottomRight)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(bigTreeBottomRightTile);

		// Fountain Top Left
		Frame fountainTopLeft = new FrameBuilder(getSubImage(8, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder fountainTopLeftTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(fountainTopLeft)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(fountainTopLeftTile);

		// Fountain Top Right
		Frame fountainTopRight = new FrameBuilder(getSubImage(8, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder fountainTopRightTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(fountainTopRight)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(fountainTopRightTile);

		// Fountain Bottom Left
		Frame fountainBottomLeft = new FrameBuilder(getSubImage(9, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder fountainBottomLeftTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(fountainBottomLeft)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(fountainBottomLeftTile);

		// Fountain Bottom Right
		Frame fountainBottomRight = new FrameBuilder(getSubImage(9, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder fountainBottomRightTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(fountainBottomRight)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(fountainBottomRightTile);

		// Small Rock
		Frame smallRock = new FrameBuilder(getSubImage(9, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder smallRockTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(smallRock)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(smallRockTile);

		// Top Left Shop Roof
		Frame topLeftShopRoof = new FrameBuilder(getSubImage(10, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder topLeftShopRoofTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(topLeftShopRoof)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topLeftShopRoofTile);

		// Top Middle Shop Roof
		Frame topMiddleShopRoof = new FrameBuilder(getSubImage(10, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder topMiddleShopRoofTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(topMiddleShopRoof)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(topMiddleShopRoofTile);

		// Mid Left Shop Roof
		Frame midLeftShopRoof = new FrameBuilder(getSubImage(11, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder midLeftShopRoofTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(midLeftShopRoof)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(midLeftShopRoofTile);

		// Middle Shop Roof
		Frame middleShopRoof = new FrameBuilder(getSubImage(11, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleShopRoofTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(middleShopRoof)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(middleShopRoofTile);

		// Mid Right Shop Roof
		Frame midRightShopRoof = new FrameBuilder(getSubImage(11, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder midRightShopRoofTile = new MapTileBuilder(grassColorTile)
				.withTopLayer(midRightShopRoof)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(midRightShopRoofTile);

		// Middle Left Shop 
		Frame middleLeftShop = new FrameBuilder(getSubImage(12, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleLeftShopTile = new MapTileBuilder(middleLeftShop)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(middleLeftShopTile);

		// Middle Shop 
		Frame middleShop = new FrameBuilder(getSubImage(12, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleShopTile = new MapTileBuilder(middleShop)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(middleShopTile);

		// Middle Right Shop 
		Frame middleRightShop = new FrameBuilder(getSubImage(12, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleRightShopTile = new MapTileBuilder(middleRightShop)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(middleRightShopTile);

		// Bottom Left Shop 
		Frame bottomLeftShop = new FrameBuilder(getSubImage(13, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomLeftShopTile = new MapTileBuilder(bottomLeftShop)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(bottomLeftShopTile);

		// Bottom Mid Shop 
		Frame bottomMidShop = new FrameBuilder(getSubImage(13, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomMidShopTile = new MapTileBuilder(bottomMidShop)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(bottomMidShopTile);

		// Bottom Right Shop 
		Frame bottomRightShop = new FrameBuilder(getSubImage(13, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder bottomRightShopTile = new MapTileBuilder(bottomRightShop)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(bottomRightShopTile);

		// Left Land Bridge 
		Frame leftLandBridge = new FrameBuilder(getSubImage(10, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftLandBridgeTile = new MapTileBuilder(leftLandBridge)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(leftLandBridgeTile);

		// Middle Water Bridge 
		Frame middleWaterBridge = new FrameBuilder(getSubImage(10, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleWaterBridgeTile = new MapTileBuilder(middleWaterBridge)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(middleWaterBridgeTile);

		// Middle Water Bridge Pole
		Frame middleWaterBridgePole = new FrameBuilder(getSubImage(11, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleWaterBridgePoleTile = new MapTileBuilder(middleWaterBridgePole)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(middleWaterBridgePoleTile);

		// Right Land Bridge 
		Frame rightLandBridge = new FrameBuilder(getSubImage(11, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightLandBridgeTile = new MapTileBuilder(rightLandBridge)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(rightLandBridgeTile);

		// Middle Water Bridge No Tile
		Frame middleBridge = new FrameBuilder(getSubImage(12, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleBridgeTile = new MapTileBuilder(middleBridge)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(middleBridgeTile);

		// Left Temple Entrance
		Frame leftTempleEntrance = new FrameBuilder(getSubImage(14, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTempleEntranceTile = new MapTileBuilder(leftTempleEntrance)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(leftTempleEntranceTile);

		// Middle Temple Entrance
		Frame middleTempleEntrance = new FrameBuilder(getSubImage(14, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder middleTempleEntranceTile = new MapTileBuilder(middleTempleEntrance)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(middleTempleEntranceTile);

		// Right Temple Entrance
		Frame rightTempleEntrance = new FrameBuilder(getSubImage(14, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTempleEntranceTile = new MapTileBuilder(rightTempleEntrance)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(rightTempleEntranceTile);

		// Stair Temple Entrance
		Frame stairTemple = new FrameBuilder(getSubImage(14, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder stairTempleTile = new MapTileBuilder(stairTemple)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(stairTempleTile);

		// Left Temple Corner
		Frame leftTempleCorner = new FrameBuilder(getSubImage(15, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTempleCornerTile = new MapTileBuilder(leftTempleCorner)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(leftTempleCornerTile);

		// Temple Wall
		Frame templeWall = new FrameBuilder(getSubImage(15, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder templeWallTile = new MapTileBuilder(templeWall)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(templeWallTile);

		// Right Temple Corner
		Frame rightTempleCorner = new FrameBuilder(getSubImage(15, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTempleCornerTile = new MapTileBuilder(rightTempleCorner)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(rightTempleCornerTile);

		// Front Raised Tile
		Frame frontRaised = new FrameBuilder(getSubImage(12, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder frontRaisedTile = new MapTileBuilder(frontRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(frontRaisedTile);

		// Front Raised Grass Tile
		Frame frontRaisedGrass = new FrameBuilder(getSubImage(13, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder frontRaisedGrassTile = new MapTileBuilder(frontRaisedGrass)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(frontRaisedGrassTile);

		// Left Raised Tile
		Frame leftRaised = new FrameBuilder(getSubImage(13, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftRaisedTile = new MapTileBuilder(leftRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(leftRaisedTile);

		// Right Raised Tile
		Frame rightRaised = new FrameBuilder(getSubImage(14, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightRaisedTile = new MapTileBuilder(rightRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(rightRaisedTile);

		// Back Raised Tile
		Frame backRaised = new FrameBuilder(getSubImage(15, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder backRaisedTile = new MapTileBuilder(backRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(backRaisedTile);

		// Raised Tile Staircase
		Frame raiseStaircase = new FrameBuilder(getSubImage(15, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder raiseStaircaseTile = new MapTileBuilder(raiseStaircase)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(raiseStaircaseTile);

		// Raised Tile Staircase Grass
		Frame raiseStaircaseGrass = new FrameBuilder(getSubImage(16, 4))
				.withScale(tileScale)
				.build();

		MapTileBuilder raiseStaircaseGrassTile = new MapTileBuilder(raiseStaircaseGrass)
				.withTileType(TileType.PASSABLE);

		pathTiles.add(raiseStaircaseGrassTile);

		// Left Top Corner Raised Tile
		Frame leftTopCornerRaised = new FrameBuilder(getSubImage(16, 0))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftTopCornerRaisedTile = new MapTileBuilder(leftTopCornerRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(leftTopCornerRaisedTile);

		// Right Top Corner Raised Tile
		Frame rightTopCornerRaised = new FrameBuilder(getSubImage(16, 1))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightTopCornerRaisedTile = new MapTileBuilder(rightTopCornerRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(rightTopCornerRaisedTile);

		// Left Bottom Corner Raised Tile
		Frame leftBottomCornerRaised = new FrameBuilder(getSubImage(16, 2))
				.withScale(tileScale)
				.build();

		MapTileBuilder leftBottomCornerRaisedTile = new MapTileBuilder(leftBottomCornerRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(leftBottomCornerRaisedTile);

		// Right Bottom Corner Raised Tile
		Frame rightBottomCornerRaised = new FrameBuilder(getSubImage(16, 3))
				.withScale(tileScale)
				.build();

		MapTileBuilder rightBottomCornerRaisedTile = new MapTileBuilder(rightBottomCornerRaised)
				.withTileType(TileType.NOT_PASSABLE);

		pathTiles.add(rightBottomCornerRaisedTile);



		return pathTiles;
	}
}
