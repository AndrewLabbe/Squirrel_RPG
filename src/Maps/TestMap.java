package Maps;

import java.util.ArrayList;

import Collectibles.CollectibleAcorn;
import Enemies.GhostEnemy;
import EnhancedMapTiles.Rock;
import Level.CollectibleItem;
import Level.Enemy;
import Level.EnhancedMapTile;
import Level.Map;
import Level.NPC;
import Level.PowerUp;
import Level.Trigger;
import NPCs.Dinosaur;
import NPCs.Fox;
import NPCs.Walrus;
import PowerUps.DoublePoints;
import PowerUps.InstaElim;
import PowerUps.MaxHealth;
import PowerUps.SpeedBoost;
import Scripts.SimpleTextScript;
import Scripts.TestMap.DinoScript;
import Scripts.TestMap.FoxScript;
import Scripts.TestMap.LostBallScript;
import Scripts.TestMap.TempleScript;
import Scripts.TestMap.TreeScript;
import Scripts.TestMap.WalrusScript;
import Scripts.TestMap.changeShop;
import Tilesets.CommonTileset;

// Represents a test map to be used in a level
public class TestMap extends Map {

    public TestMap() {
        super("test_map.txt", new CommonTileset());
        this.playerStartPosition = getMapTile(17, 20).getLocation();
    }

    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();
        enhancedMapTiles.add(new Rock(getMapTile(2, 7).getLocation()));
        
        return enhancedMapTiles;
    }

    @Override
    public ArrayList<NPC> loadNPCs() {
        ArrayList<NPC> npcs = new ArrayList<>();

        Walrus walrus = new Walrus(1, getMapTile(4, 28).getLocation().subtractY(40));
        walrus.setInteractScript(new WalrusScript());
        npcs.add(walrus);

        Dinosaur dinosaur = new Dinosaur(2, getMapTile(13, 4).getLocation());
        dinosaur.setExistenceFlag("hasTalkedToDinosaur");
        dinosaur.setInteractScript(new DinoScript());
        npcs.add(dinosaur); 
       
        Fox fox = new Fox(3, getMapTile(13, 20).getLocation());
        fox.setInteractScript(new FoxScript());
        npcs.add(fox);

        //Zombie zombie = new Zombie(4, getMapTile(21, 25).getLocation()); 
        //npcs.add(zombie); 
        
//        Wolf wolf = new Wolf(5, getMapTile(1, 18).getLocation());
//        wolf.setInteractScript(new WolfScript());
//        npcs.add(wolf);
        
        return npcs;
    }

    @Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(790, 1030, 100, 10, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(790, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(890, 960, 10, 80, new LostBallScript(), "hasLostBall"));
        triggers.add(new Trigger(525, 0, 48, 48, new TempleScript()));
        
        return triggers;
    }

    @Override
    public void loadScripts() {
        getMapTile(21, 19).setInteractScript(new SimpleTextScript("Cat's house"));

        getMapTile(7, 26).setInteractScript(new SimpleTextScript("Walrus's house"));

        getMapTile(20, 4).setInteractScript(new SimpleTextScript("Dino's house"));

        getMapTile(2, 6).setInteractScript(new TreeScript());
        
        getMapTile(4, 19).setInteractScript(new changeShop());
       
    } 
    
    //Adds enemies to the map
    @Override 
    public ArrayList<Enemy> loadEnemies() {
    	ArrayList<Enemy> enemies = new ArrayList(); 
    	
    	enemies.add(new GhostEnemy(getMapTile(18, 25).getLocation(), (float) 3.00));
    	enemies.add(new GhostEnemy(getMapTile(18, 10).getLocation(), (float) 3.00)); 
    	enemies.add(new GhostEnemy(getMapTile(10, 8).getLocation(), (float) 3.00)); 
    	enemies.add(new GhostEnemy(getMapTile(10, 25).getLocation(), (float) 3.00));
    	return enemies;
    } 
    
    @Override 
    public ArrayList<PowerUp> loadPowerUps() {
    	ArrayList<PowerUp> powerUps = new ArrayList(); 
    	
    	powerUps.add(new SpeedBoost(getMapTile(20,25).getLocation())); 
    	powerUps.add(new MaxHealth(getMapTile(20,24).getLocation())); 
    	powerUps.add(new DoublePoints(getMapTile(21,25).getLocation())); 
    	powerUps.add(new InstaElim(getMapTile(21,24).getLocation()));
    	return powerUps;
    }
    
  
}

