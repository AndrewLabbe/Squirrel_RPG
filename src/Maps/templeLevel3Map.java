package Maps;

import java.util.ArrayList;

import Enemies.WizardEnemy;
import Level.Enemy;
import Level.Map;
import Tilesets.temple3Tileset;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel3Map extends Map {
	
	public templeLevel3Map() {
		super("temple_Level3.txt", new temple3Tileset());
		this.playerStartPosition = getMapTile(5, 0).getLocation();
	}
	
}
