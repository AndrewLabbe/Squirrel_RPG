package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.Trigger;
import Scripts.TestMap.TempleLevel1_5Script;
import Tilesets.templeTileset;

public class templeLevel1_5Map extends Map{

	public templeLevel1_5Map() {
		super("temple_Level1_5.txt", new templeTileset());
		this.playerStartPosition = getMapTile(6, 0).getLocation();
	}
	
	@Override
    public ArrayList<Trigger> loadTriggers() {
        ArrayList<Trigger> triggers = new ArrayList<>();
        triggers.add(new Trigger(576, 1520, 196, 10, new TempleLevel1_5Script()));
        
        return triggers;
    }
	
}
