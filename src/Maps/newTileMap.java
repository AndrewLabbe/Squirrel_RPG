package Maps;

import java.util.ArrayList;

import Collectibles.CollectibleAcorn;
import Collectibles.EasterEgg;
import Level.CollectibleItem;
import Level.Map;
import Level.NPC;
import Level.Spawner;
import Level.Trigger;
import NPCs.Chest;
import NPCs.Dinosaur;
import NPCs.Fox;
import NPCs.Girlfriend;
import NPCs.Walrus;
import Scripts.TestMap.ChestUnlockScriptDestiny;
import Scripts.TestMap.ChestUnlockScriptFate;
import Scripts.TestMap.ChestUnlockScriptGenesis;
import Scripts.TestMap.ChestUnlockScriptRetribution;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.FoxScript;
import Scripts.TestMap.IntroScript;
import Scripts.TestMap.KeyScript;
import Scripts.TestMap.LandScript;
import Scripts.TestMap.SwimScript;
import Scripts.TestMap.TempleLockedScript;
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
	       
	     Fox fox = new Fox(1, getMapTile(14, 21).getLocation());
	     fox.setInteractScript(new FoxScript());
	     npcs.add(fox);
	     
	     Girlfriend girlfriend = new Girlfriend(2, getMapTile(3, 21).getLocation(), "hasLostGirlfriend");
	     npcs.add(girlfriend);

	     Chest chestFate = new Chest(2, getMapTile(7, 9).getLocation(), "hasOpenedChestFate");  
	     chestFate.setInteractScript(new ChestUnlockScriptFate());
	     npcs.add(chestFate);
	     
	     Chest chestDestiny = new Chest(3, getMapTile(9, 40).getLocation(), "hasOpenedChestDestiny");  
	     chestDestiny.setInteractScript(new ChestUnlockScriptDestiny());
	     npcs.add(chestDestiny);
	     
	     Chest chestGenesis = new Chest(4, getMapTile(39, 40).getLocation(), "hasOpenedChestGenesis");  
	     chestGenesis.setInteractScript(new ChestUnlockScriptGenesis());
	     npcs.add(chestGenesis);
	     
	     Chest chestRetribution = new Chest(5, getMapTile(41, 9).getLocation(), "hasOpenedChestRetribution");  
	     chestRetribution.setInteractScript(new ChestUnlockScriptRetribution());
	     npcs.add(chestRetribution); 
	     
	     Walrus walrus = new Walrus(6, getMapTile(17, 17).getLocation());
	     walrus.setInteractScript(new WalrusScript());
	     npcs.add(walrus);
	     
	     return npcs;
	 }
	 
	 @Override
	 public ArrayList<Trigger> loadTriggers() {
	     ArrayList<Trigger> triggers = new ArrayList<>();
	     triggers.add(new Trigger(0, 1160, 120, 10, new IntroScript(), "hasLostGirlfriend"));
	     triggers.add(new Trigger(120, 1160, 10, 130, new IntroScript(), "hasLostGirlfriend"));
	     triggers.add(new Trigger(0, 1280, 120, 10, new IntroScript(), "hasLostGirlfriend"));
	        
	     //Swimming triggers for top left lake
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
	     
	     //Swimming triggers for top left pond
	     triggers.add(new Trigger(1035, 85, 1, 120, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(1075, 85, 1, 120, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1035, 205, 40, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(1035, 85, 40, 1, new SwimScript(), "hasSwam")); 
	     //Swimming triggers for top right pond
	     triggers.add(new Trigger(1275, 85, 1, 120, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(1315, 85, 1, 120, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1275, 205, 40, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(1275, 85, 40, 1, new SwimScript(), "hasSwam"));
	     
	     //Swimming triggers for top right lake
	     triggers.add(new Trigger(2135, 785, 460, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(2135, 785, 1, 50, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(2085, 835, 50, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(2085, 835, 1, 50, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1625, 885, 460, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1625, 835, 1, 50, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1575, 835, 50, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1575, 785, 1, 50, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1515, 785, 60, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1515, 525, 1, 260, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1515, 525, 370, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1885, 525, 1, 50, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(1885, 575, 240, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(2125, 325, 1, 250, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1885, 325, 240, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1885, 325, 1, 85, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1565, 410, 320, 1, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1565, 350, 1, 60, new SwimScript(), "hasSwam")); 
	     triggers.add(new Trigger(1565, 350, 60, 1, new SwimScript(), "hasSwam"));
	     triggers.add(new Trigger(1625, 0, 1, 350, new SwimScript(), "hasSwam"));
	     
	     
	     //If player tries to enter the temple without 4 keys trigger the locked temple script
	     triggers.add(new Trigger(1120, 50, 110, 1, new TempleLockedScript(), "hasTempleUnlocked"));
	     
	     return triggers;
	 }
	 
	 @Override
	 public void loadScripts() {
		 getMapTile(9, 34).setInteractScript(new changeShop());
	        
		 getMapTile(41, 9).setInteractScript(new KeyScript());
	     
	     //getMapTile(24, 0).setInteractScript(new TempleLockedScript()); 
	     
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
	    	
	    	//collectibles.add(new CollectibleAcorn(getMapTile(25, 25).getLocation()));
	    	//collectibles.add(new CollectibleAcorn(getMapTile(24, 25).getLocation()));
	    	
	    	//collectibles.add(new EasterEgg(getMapTile(23,21).getLocation()));
	    	
	    	return collectibles;
	    }
	 
}
