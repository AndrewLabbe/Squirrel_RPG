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
import Scripts.TestMap.WalrusScript;
import Tilesets.templeTileset;
import Utils.Point;

// Represents the Map for the Temple
public class templeLevel3Map extends Map {
	
	public templeLevel3Map() {
		super("temple_Level3.txt", new temple3Tileset());
		this.playerStartPosition = getMapTile(1, 1).getLocation();
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
	     //enhancedMapTiles.add(new ProjectileTrapTile(getMapTile(6, 20).getLocation()));   
	     enhancedMapTiles.add(new LavaTile(getMapTile(2,4).getLocation(), "LavaTile3.png")); 
	     
	     return enhancedMapTiles;
	 }
	
}
