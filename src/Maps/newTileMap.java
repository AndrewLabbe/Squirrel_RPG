package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import NPCs.Wolf;
import Scripts.TestMap.WolfScript;
import Tilesets.CommonTileset;
import Tilesets.PathingTileset;

// Represents the Map for the Interior of Shopkeeper House
public class newTileMap extends Map {
	
	public newTileMap() {
		super("new_tile_map.txt", new PathingTileset());
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
