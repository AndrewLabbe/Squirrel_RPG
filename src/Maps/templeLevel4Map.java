package Maps;

import Level.Map;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel4Map extends Map {
	
	public templeLevel4Map() {
		super("temple_Level4.txt", new templeTileset());
		this.playerStartPosition = getMapTile(5, 0).getLocation();
	}
	
}
