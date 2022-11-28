package Scripts.TestMap;

import Utils.Point;

import Collectibles.CollectibleAcorn;
import Collectibles.CollectibleKey;
import Level.Script;
import Level.ScriptState;
import Projectiles.Acorn;

public class ChestUnlockScriptDestiny extends Script {
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasOpenedChestDestiny")) {
			addTextToTextboxQueue("You found the key of DESTINY!"); 
			Point point = new Point(player.getX() - 50f, player.getY()); 
			CollectibleKey key = new CollectibleKey(point, "KEY_DESTINY");
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
		setFlag("hasOpenedChestDestiny");
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
