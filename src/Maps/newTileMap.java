package Maps;

import java.util.ArrayList;

import Collectibles.CollectibleAcorn;
import Level.CollectibleItem;
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
import Scripts.TestMap.KeyScript;
import Scripts.TestMap.LandScript;
import Scripts.TestMap.SwimScript;
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
	        
	     //Swimming triggers
	     triggers.add(new Trigger(0, 780, 220, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(220, 780, 1, 50, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(220, 830, 50, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(270, 830, 1, 50, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(270, 880, 470, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(740, 830, 1, 50, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(740, 830, 50, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(790, 780, 1, 50, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(790, 780, 50, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(840, 520, 1, 260, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(730, 0, 1, 345, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(730, 345, 50, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(780, 345, 1, 60, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(470, 520, 370, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(470, 405, 310, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(470, 330, 1, 75, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(470, 520, 1, 75, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(230, 330, 240, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(230, 595, 240, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(230, 330, 1, 265, new SwimScript(), "hasSwam"));
	     
	     return triggers;
	 }
	 
	 @Override
	 public void loadScripts() {
		 getMapTile(9, 34).setInteractScript(new changeShop());
	        
	     getMapTile(24, 0).setInteractScript(new TempleScript());
	     
	     getMapTile(41, 9).setInteractScript(new KeyScript());
	 } 
	 
	 
	 //Adds spawners to the map
	 @Override 
	 public ArrayList<Spawner> loadSpawners() {
		 ArrayList<Spawner> spawners = new ArrayList(); 
		 
		 spawners.add(new BasicSpawner(getMapTile(10, 20).getLocation()));
		 spawners.add(new BasicSpawner(getMapTile(20, 40).getLocation()));
		 return spawners;
	 }
	 
	 //Adds collectibles to the map
	    @Override 
	    public ArrayList<CollectibleItem> loadCollectibles() {
	    	ArrayList<CollectibleItem> collectibles = new ArrayList(); 
	    	
	    	collectibles.add(new CollectibleAcorn(getMapTile(25, 25).getLocation()));

	    	return collectibles;
	    }
	 
}
