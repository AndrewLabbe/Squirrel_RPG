package Maps;

import Level.Map;
import Scripts.TestMap.CorrectTableScript;
import Scripts.TestMap.GoldenTableScript;
import Scripts.TestMap.SimpleTableScript;
import Scripts.TestMap.TempleScript;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeMap extends Map {
	
	public templeMap() {
		super("temple_Map.txt", new templeTileset());
		this.playerStartPosition = getMapTile(7, 14).getLocation();
	}
	
	@Override
    public void loadScripts() {
		//Golden Table
        getMapTile(7, 1).setInteractScript(new GoldenTableScript());
        
        //Trap Door Table
        getMapTile(2, 2).setInteractScript(new CorrectTableScript());
        
        //Middle Tables
        getMapTile(6, 13).setInteractScript(new SimpleTableScript());
        getMapTile(8, 13).setInteractScript(new SimpleTableScript());
        getMapTile(6, 11).setInteractScript(new SimpleTableScript());
        getMapTile(8, 11).setInteractScript(new SimpleTableScript());
        getMapTile(6, 9).setInteractScript(new SimpleTableScript());
        getMapTile(8, 9).setInteractScript(new SimpleTableScript());
        getMapTile(6, 7).setInteractScript(new SimpleTableScript());
        getMapTile(8, 7).setInteractScript(new SimpleTableScript());
        getMapTile(6, 5).setInteractScript(new SimpleTableScript());
        getMapTile(8, 5).setInteractScript(new SimpleTableScript());
        getMapTile(6, 3).setInteractScript(new SimpleTableScript());
        getMapTile(8, 3).setInteractScript(new SimpleTableScript());
        
        //Left Tables
        getMapTile(2, 4).setInteractScript(new SimpleTableScript());
        getMapTile(4, 4).setInteractScript(new SimpleTableScript());
        getMapTile(2, 6).setInteractScript(new SimpleTableScript());
        getMapTile(4, 6).setInteractScript(new SimpleTableScript());
        getMapTile(2, 8).setInteractScript(new SimpleTableScript());
        getMapTile(4, 8).setInteractScript(new SimpleTableScript());
        getMapTile(2, 10).setInteractScript(new SimpleTableScript());
        getMapTile(4, 10).setInteractScript(new SimpleTableScript());
        getMapTile(4, 12).setInteractScript(new SimpleTableScript());
        getMapTile(2, 14).setInteractScript(new SimpleTableScript());
        getMapTile(4, 14).setInteractScript(new SimpleTableScript());
        
        //Right Tables
        getMapTile(10, 4).setInteractScript(new SimpleTableScript());
        getMapTile(12, 4).setInteractScript(new SimpleTableScript());
        getMapTile(10, 6).setInteractScript(new SimpleTableScript());
        getMapTile(12, 6).setInteractScript(new SimpleTableScript());
        getMapTile(10, 8).setInteractScript(new SimpleTableScript());
        getMapTile(12, 8).setInteractScript(new SimpleTableScript());
        getMapTile(10, 10).setInteractScript(new SimpleTableScript());
        getMapTile(12, 10).setInteractScript(new SimpleTableScript());
        getMapTile(10, 12).setInteractScript(new SimpleTableScript());
        getMapTile(12, 12).setInteractScript(new SimpleTableScript());
        getMapTile(10, 14).setInteractScript(new SimpleTableScript());
        getMapTile(12, 14).setInteractScript(new SimpleTableScript());
        
        //Key Table
        getMapTile(2, 12).setInteractScript(new CorrectTableScript());
    } 
	
}
