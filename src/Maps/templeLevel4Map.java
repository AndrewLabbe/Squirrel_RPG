package Maps;

import java.util.ArrayList;

import Enemies.WizardEnemy;
import Level.Enemy;
import Level.Map;
import Level.Spawner;
import Spawners.WaterSpawner;
import Tilesets.templeTileset;

// Represents the Map for the Temple
public class templeLevel4Map extends Map {
	
	public templeLevel4Map() {
		super("temple_Level4.txt", new templeTileset());
		this.playerStartPosition = getMapTile(6, 0).getLocation();
	}
	
	
	@Override 
	public ArrayList<Enemy> loadEnemies() {
		ArrayList<Enemy> enemies = new ArrayList(); 
			 
		enemies.add(new WizardEnemy(getMapTile(6, 7).getLocation(), 1.0f));
			 
		return enemies;
	}
	
}
