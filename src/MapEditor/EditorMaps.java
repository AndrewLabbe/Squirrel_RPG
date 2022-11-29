package MapEditor;

import java.util.ArrayList;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.newTileMap;
import Maps.shopInterior;
import Maps.templeLevel1Map;
import Maps.templeLevel1_5Map;
import Maps.templeLevel2Map;
import Maps.templeLevel3Map;
import Maps.templeLevel4Map;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("ShopInterior");
            add("NewTileMap");
            add("TempleLevel1");
            add("TempleLevel1.5");
            add("TempleLevel2");
            add("TempleLevel3");
            add("TempleLevel4");
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
            case "TempleLevel1":
            	return new templeLevel1Map();
            case "TempleLevel1.5":
            	return new templeLevel1_5Map();
            case "TempleLevel2":
            	return new templeLevel2Map();
            case "TempleLevel3":
            	return new templeLevel3Map();
            case "TempleLevel4":
            	return new templeLevel4Map();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
