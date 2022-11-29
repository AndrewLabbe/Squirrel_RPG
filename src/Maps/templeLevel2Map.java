package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.Spawner;
import Level.Trigger;
import Scripts.TestMap.TempleLandScript;
import Scripts.TestMap.TempleLevel2Script;
import Scripts.TestMap.TempleSwimScript;
import Spawners.BasicSpawner;
import Spawners.WaterSpawner;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel2Map extends Map {

	public templeLevel2Map() {
		super("temple_Level2.txt", new templeTileset());
		this.playerStartPosition = getMapTile(7, 1).getLocation();
	}

	//Adds spawners to the map
	@Override 
	public ArrayList<Spawner> loadSpawners() {
		ArrayList<Spawner> spawners = new ArrayList(); 
			 
		spawners.add(new WaterSpawner(getMapTile(2, 5).getLocation()));
		spawners.add(new WaterSpawner(getMapTile(13, 5).getLocation()));
		spawners.add(new WaterSpawner(getMapTile(2, 10).getLocation()));
		spawners.add(new WaterSpawner(getMapTile(13, 12).getLocation())); 
		spawners.add(new WaterSpawner(getMapTile(8, 9).getLocation()));
			 
		return spawners;
	}
	
	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();
		
		// Trigger Order: Top, Bottom, Left, Right
		// Start & End of Room
		triggers.add(new Trigger(90, 300, 1350, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(90, 1400, 1350, 10, new TempleSwimScript(), "templeSwam"));
		
		// Platform A (Top Left)
		triggers.add(new Trigger(345, 450, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 600, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 450, 1, 150, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(515, 450, 1, 155, new TempleSwimScript(), "templeSwam"));
		
		
		// Platform B (Mid Right)
		triggers.add(new Trigger(1020, 625, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 790, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 625, 1, 170, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1190, 625, 1, 170, new TempleSwimScript(), "templeSwam"));
		
		// Platform C (Mid Left)
		triggers.add(new Trigger(345, 910, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 1080, 175, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 910, 1, 170, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(515, 910, 1, 170, new TempleSwimScript(), "templeSwam"));
		
		// Platform D (bottom Right)
		triggers.add(new Trigger(1020, 1110, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 1275, 170, 1, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 1110, 1, 170, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1190, 1110, 1, 170, new TempleSwimScript(), "templeSwam"));
		
		// Go to Level 3
		triggers.add(new Trigger(670, 1625, 200, 10, new TempleLevel2Script(), "hasEnteredLevel3"));
		
		 for(Trigger trigger : triggers) {
		    	trigger.getTriggerScript().setMap(this); 
		    }
		 
		return triggers;
		
	}

	@Override
	public void loadScripts() {
		// scripts
	} 

}
