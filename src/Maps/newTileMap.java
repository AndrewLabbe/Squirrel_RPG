package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import Level.Spawner;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Fox;
import NPCs.Walrus;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.FoxScript;
import Scripts.TestMap.IntroScript;
import Scripts.TestMap.TempleScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.changeShop;
import Spawners.BasicSpawner;
import Tilesets.PathingTileset;

// Represents the Map for the Interior of Shopkeeper House
public class newTileMap extends Map {
	
	public newTileMap() {
		super("new_tile_map.txt", new PathingTileset());
		this.playerStartPosition = getMapTile(1, 25).getLocation();
	}
	
	 @Override
	    public ArrayList<NPC> loadNPCs() {
	        ArrayList<NPC> npcs = new ArrayList<>();
	       
	        Fox fox = new Fox(3, getMapTile(14, 21).getLocation());
	        fox.setInteractScript(new FoxScript());
	        npcs.add(fox);

	        
	        return npcs;
	    }
	 
	 @Override
	    public ArrayList<Trigger> loadTriggers() {
	        ArrayList<Trigger> triggers = new ArrayList<>();
	        triggers.add(new Trigger(0, 1160, 120, 10, new IntroScript(), "hasLostGirlfriend"));
	        triggers.add(new Trigger(120, 1160, 10, 130, new IntroScript(), "hasLostGirlfriend"));
	        triggers.add(new Trigger(0, 1280, 120, 10, new IntroScript(), "hasLostGirlfriend"));
	        
	        return triggers;
	    }
	 
	 @Override
	 public void loadScripts() {
		 getMapTile(9, 34).setInteractScript(new changeShop());
	        
	     getMapTile(24, 0).setInteractScript(new TempleScript());
	 } 
	 
	 
	 //Adds spawners to the map
	 @Override 
	 public ArrayList<Spawner> loadSpawners() {
		 ArrayList<Spawner> spawners = new ArrayList(); 
		 
		 spawners.add(new BasicSpawner(getMapTile(10, 5).getLocation()));
		 spawners.add(new BasicSpawner(getMapTile(10, 15).getLocation()));
		 return spawners;
	 }
	 
}
