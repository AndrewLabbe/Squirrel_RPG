package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import NPCs.Wolf;
import Scripts.TestMap.WolfScript;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeMap extends Map {
	
	public templeMap() {
		super("temple_Map.txt", new templeTileset());
		this.playerStartPosition = getMapTile(10, 10).getLocation();
	}
	
	 public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	        
	        Wolf wolf = new Wolf(5, getMapTile(3, 3).getLocation());
	        wolf.setInteractScript(new WolfScript());
	        npcs.add(wolf);
	        
	        return npcs;
	 }
}
