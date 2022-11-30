package Maps;

import java.util.ArrayList;

import Level.Map;
import Level.NPC;
import Level.Trigger;
import NPCs.Wolf;
import Scripts.TestMap.IntroShop;
import Scripts.TestMap.WolfScript;
import Scripts.TestMap.exitShop;
import Tilesets.InteriorTileset;

// Represents the Map for the Interior of Shopkeeper House
public class shopInterior extends Map {

	public shopInterior() {
		super("shop_Interior.txt", new InteriorTileset());
		this.playerStartPosition = getMapTile(6, 13).getLocation();
	}

	@Override
	public ArrayList<NPC> loadNPCs() {
		ArrayList<NPC> npcs = new ArrayList<>();

		Wolf wolf = new Wolf(5, getMapTile(4, 10).getLocation());
		wolf.setInteractScript(new WolfScript());
		npcs.add(wolf);

		return npcs;
	}

	@Override
	public void loadScripts() {
		getMapTile(5, 14).setInteractScript(new exitShop());

		getMapTile(6, 15).setInteractScript(new exitShop());
	}

	public ArrayList<Trigger> loadTriggers() {
		ArrayList<Trigger> triggers = new ArrayList<>();
		
		triggers.add(new Trigger(235, 610, 100, 10, new IntroShop(), "hasMetShopkeeper"));
		
		return triggers;
	}
}
