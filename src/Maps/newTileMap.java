package Maps;

import java.util.ArrayList;

import Enemies.ZombieEnemy;
import Level.Enemy;
import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Fox;
import NPCs.Walrus;
import NPCs.Wolf;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.FoxScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TempleScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.WolfScript;
import Scripts.TestMap.changeShop;
import Tilesets.CommonTileset;
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

	        Walrus walrus = new Walrus(1, getMapTile(27, 34).getLocation().subtractY(40));
	        walrus.setInteractScript(new WalrusScript());
	        npcs.add(walrus);

	        Dinosaur dinosaur = new Dinosaur(2, getMapTile(21, 15).getLocation());
	        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
	        dinosaur.setInteractScript(new DinoScript());
	        npcs.add(dinosaur); 
	       
	        Fox fox = new Fox(3, getMapTile(14, 21).getLocation());
	        fox.setInteractScript(new FoxScript());
	        npcs.add(fox);

	        //Zombie zombie = new Zombie(4, getMapTile(21, 25).getLocation()); 
	        //npcs.add(zombie); 
	        
//	        Wolf wolf = new Wolf(5, getMapTile(1, 18).getLocation());
//	        wolf.setInteractScript(new WolfScript());
//	        npcs.add(wolf);
	        
	        return npcs;
	    }
	 
//	 @Override
//	    public ArrayList<Trigger> loadTriggers() {
//	        ArrayList<Trigger> triggers = new ArrayList<>();
//	        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
//	        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//	        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
//	        triggers.add(new Trigger(525, 0, 48, 48, new TempleScript()));
//	        
//	        return triggers;
//	    }
	 
	 @Override
	    public void loadScripts() {
	        
	        getMapTile(9, 34).setInteractScript(new changeShop());
	    } 
	 
	 //Adds enemies to the map
//	    @Override 
//	    public ArrayList<Enemy> loadEnemies() {
//	    	ArrayList<Enemy> enemies = new ArrayList(); 
//	    	
//	    	enemies.add(new ZombieEnemy(getMapTile(18, 25).getLocation(), (float) 3.00));
//	    	enemies.add(new ZombieEnemy(getMapTile(18, 10).getLocation(), (float) 3.00)); 
//	    	enemies.add(new ZombieEnemy(getMapTile(10, 8).getLocation(), (float) 3.00)); 
//	    	enemies.add(new ZombieEnemy(getMapTile(10, 25).getLocation(), (float) 3.00));
//	    	return enemies;
//	    }
}
