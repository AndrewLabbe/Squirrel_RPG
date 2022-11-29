package Scripts.TestMap;

import Utils.Point;

import Collectibles.CollectibleAcorn;
import Collectibles.CollectibleKey;
import Level.Script;
import Level.ScriptState;
import Projectiles.Acorn;

public class ChestUnlockScriptRetribution extends Script {
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasOpenedChestRetribution")) {
			addTextToTextboxQueue("You found the key of RETRIBUTION!"); 
			Point point = new Point(player.getX() - 100f, player.getY() - 100f); 
			CollectibleKey key = new CollectibleKey(point, "KEY_RETRIBUTION");
			map.addCollectibles(key);
		}
		else {
			addTextToTextboxQueue("This chest is empty!"); 
		}
	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
		setFlag("hasOpenedChestRetribution");
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
