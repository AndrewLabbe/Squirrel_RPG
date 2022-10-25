package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import NPCs.Wolf;
import Scripts.TestMap.WolfScript;
import Tilesets.CommonTileset;

// Represents the Map for the Interior of Shopkeeper House
public class shopInterior extends Map {
	
	public shopInterior() {
		super("shop_Interior.txt", new CommonTileset());
		this.playerStartPosition = getMapTile(4, 5).getLocation();
	}
	
	 public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	        
	        Wolf wolf = new Wolf(5, getMapTile(3, 3).getLocation());
	        wolf.setInteractScript(new WolfScript());
	        npcs.add(wolf);
	        
	        return npcs;
	 }
}
