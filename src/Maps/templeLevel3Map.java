package Maps;

import Level.Map;
import Tilesets.temple3Tileset;

// Represents the Map for the Temple
public class templeLevel3Map extends Map {
	
	public templeLevel3Map() {
		super("temple_Level3.txt", new temple3Tileset());
		this.playerStartPosition = getMapTile(6, 0).getLocation();
	}
	
}
