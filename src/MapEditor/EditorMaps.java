package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.newTileMap;
import Maps.shopInterior;
import Maps.templeMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("ShopInterior");
            add("NewTileMap");
            add("TempleMap");
        }};
    }

    public static Map getMapByName(String mapName) {
        switch(mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "ShopInterior":
            	return new shopInterior();
            case "NewTileMap":
            	return new newTileMap();
            case "TempleMap":
            	return new templeMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
