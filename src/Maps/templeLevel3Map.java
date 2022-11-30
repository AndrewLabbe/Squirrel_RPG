package Maps;

import java.util.ArrayList;

import Enemies.WizardEnemy;
import EnhancedMapTiles.AcornTile;
import EnhancedMapTiles.LavaTile;
import EnhancedMapTiles.ProjectileTrapTile;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Tilesets.temple3Tileset;
import Level.NPC;
import Level.Trigger;
import NPCs.Chest;
import NPCs.Fox;
import NPCs.Girlfriend;
import NPCs.Walrus;
import Scripts.TestMap.ChestUnlockScriptDestiny;
import Scripts.TestMap.ChestUnlockScriptFate;
import Scripts.TestMap.ChestUnlockScriptGenesis;
import Scripts.TestMap.ChestUnlockScriptRetribution;
import Scripts.TestMap.ChestUnlockScriptTemple;
import Scripts.TestMap.FoxScript;
import Scripts.TestMap.TempleLevel3IntroScript;
import Scripts.TestMap.WalrusScript;
import Tilesets.templeTileset;
import Utils.Point;

// Represents the Map for the Temple
public class templeLevel3Map extends Map {

	public templeLevel3Map() {
		super("temple_Level3.txt", new temple3Tileset());
		this.playerStartPosition = getMapTile(7, 0).getLocation();
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();


		Point point = new Point(getMapTile(2,2).getX() + 30, getMapTile(2,2).getY() + 30);
		Chest chestDestiny = new Chest(3, point, "hasOpenedChestTempleLvl3");  
		chestDestiny.setInteractScript(new ChestUnlockScriptTemple()); 
		chestDestiny.getInteractScript().setMap(this);
		npcs.add(chestDestiny);

		return npcs; 
	} 

	@Override
	public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
		ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
		//Enhanced lava tiles 
		enhancedMapTiles.add(new LavaTile(getMapTile(2,4).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(1,5).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(2,7).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(1,9).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(3,9).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(1,11).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(2,12).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(1,13).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(7,3).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(6,6).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(6,8).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(5,9).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(6,9).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(5,10).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(6,12).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(5,13).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(7,14).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(7,4).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(8,10).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(9,11).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(9,12).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(9,14).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(12,13).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(10,11).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(12,9).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(3,13).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(11,8).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(12,5).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(11,6).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(11,3).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(12,1).getLocation(), "LavaTile3.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(4,12).getLocation(), "LavaTile2.png")); 
		enhancedMapTiles.add(new LavaTile(getMapTile(3,12).getLocation(), "LavaTile3.png")); 

		//Enhanced projectile trap tiles 
		enhancedMapTiles.add(new ProjectileTrapTile(getMapTile(1,7).getLocation())); 
		enhancedMapTiles.add(new ProjectileTrapTile(getMapTile(1,3).getLocation())); 
		enhancedMapTiles.add(new ProjectileTrapTile(getMapTile(10,3).getLocation())); 
		enhancedMapTiles.add(new ProjectileTrapTile(getMapTile(10,7).getLocation())); 

		return enhancedMapTiles;
	}

	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();

		triggers.add(new Trigger(550, 200, 250, 10, new TempleLevel3IntroScript(), "hasEnteredLevel3"));
		
		return triggers;
	}

}
