package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.Trigger;
import Scripts.TestMap.TempleSwimScript;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel2Map extends Map {

	public templeLevel2Map() {
		super("temple_Level2.txt", new templeTileset());
		this.playerStartPosition = getMapTile(7, 1).getLocation();
	}

	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();
		
		// Trigger Order: Top, Bottom, Left, Right
		// Start & End of Room
		triggers.add(new Trigger(90, 300, 1350, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(90, 1400, 1350, 10, new TempleSwimScript(), "templeSwam"));
		
		// Platform A (Top Left)
		triggers.add(new Trigger(345, 450, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 600, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 450, 10, 150, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(515, 450, 10, 150, new TempleSwimScript(), "templeSwam"));
		
		// Platform B (Mid Right)
		triggers.add(new Trigger(1020, 625, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 785, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 625, 10, 170, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1190, 625, 10, 170, new TempleSwimScript(), "templeSwam"));
		
		// Platform C (Mid Left)
		triggers.add(new Trigger(345, 910, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 1080, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(345, 910, 10, 170, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(515, 910, 10, 170, new TempleSwimScript(), "templeSwam"));
		
		// Platform D (bottom Right)
		triggers.add(new Trigger(1020, 1110, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 1275, 170, 10, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1020, 1110, 10, 170, new TempleSwimScript(), "templeSwam"));
		triggers.add(new Trigger(1190, 1110, 10, 170, new TempleSwimScript(), "templeSwam"));
		
		return triggers;
	}

	@Override
	public void loadScripts() {
		// scripts
	} 

}
