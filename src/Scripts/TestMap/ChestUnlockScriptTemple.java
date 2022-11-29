package Scripts.TestMap;

import Utils.Point;

import Collectibles.CollectibleAcorn;
import Collectibles.CollectibleKey;
import Level.Script;
import Level.ScriptState;
import Projectiles.Acorn;

public class ChestUnlockScriptTemple extends Script {
	
	@Override
	protected void setup() {
		//lockPlayer();
		showTextbox();
		if(!isFlagSet("hasOpenedChestTempleLvl3")) {
			addTextToTextboxQueue("You found the key of to escape!"); 
			//Point point = new Point(player.getX() - 100f, player.getY()); 
			//CollectibleKey key = new CollectibleKey(point, "KEY_DESTINY");
			//map.addCollectibles(key);
		}
		else {
			addTextToTextboxQueue("This chest is empty!"); 
		}
	}

	@Override
	protected void cleanup() {
		hideTextbox();
		//unlockPlayer();
		setFlag("hasOpenedChestTempleLvl3");
	}

	@Override
	protected ScriptState execute() {
		start();
		if (!isTextboxQueueEmpty()) {
			return ScriptState.RUNNING;
		}
		end(); 
		return ScriptState.COMPLETED;
	}
	
}
