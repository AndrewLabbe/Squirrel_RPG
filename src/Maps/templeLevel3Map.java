package Maps;

import java.util.ArrayList;

import Enemies.WizardEnemy;
import Level.Enemy;
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
		this.playerStartPosition = getMapTile(6, 0).getLocation();
	}
	
	@Override
	 public ArrayList<NPC> loadNPCs() {
	     ArrayList<NPC> npcs = new ArrayList<>();
	     
	     
	     Point point = new Point(getMapTile(2,1).getX() - 24, getMapTile(2,1).getY() - 10);
	     Chest chestDestiny = new Chest(3, point, "hasOpenedChestTempleLvl3");  
	     chestDestiny.setInteractScript(new ChestUnlockScriptTemple()); 
	     chestDestiny.getInteractScript().setMap(this);
	     //chestDestiny.getInteractScript().setPlayer();
	     npcs.add(chestDestiny);
	     
	     return npcs;
	 }
	
}
