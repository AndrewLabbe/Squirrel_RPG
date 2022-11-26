package Maps;

import Level.Map;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel2Map extends Map {
	
	public templeLevel2Map() {
		super("temple_Level2.txt", new templeTileset());
		this.playerStartPosition = getMapTile(1, 9).getLocation();
	}
	
	@Override
    public void loadScripts() {
		// scripts
    } 
	
}
