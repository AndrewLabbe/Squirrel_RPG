package MapEditor;

import Level.Map;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.shopInterior;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {{
            add("TestMap");
            add("TitleScreen");
            add("ShopInterior");
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
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
