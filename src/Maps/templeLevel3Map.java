package Maps;

import Level.Map;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel3Map extends Map {
	
	public templeLevel3Map() {
		super("temple_Level3.txt", new templeTileset());
		this.playerStartPosition = getMapTile(5, 0).getLocation();
	}
	
}
