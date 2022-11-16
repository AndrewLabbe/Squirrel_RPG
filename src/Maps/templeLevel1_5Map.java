package Maps;

import Level.Map;
import Tilesets.templeTileset;

public class templeLevel1_5Map extends Map{

	public templeLevel1_5Map() {
		super("temple_Level1_5.txt", new templeTileset());
		this.playerStartPosition = getMapTile(7, 14).getLocation();
	}

}
