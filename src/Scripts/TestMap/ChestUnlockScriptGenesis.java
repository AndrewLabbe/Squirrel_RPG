package Scripts.TestMap;

import Utils.Point;

import Collectibles.CollectibleAcorn;
import Collectibles.CollectibleKey;
import Level.Script;
import Level.ScriptState;
import Projectiles.Acorn;

public class ChestUnlockScriptGenesis extends Script {
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasOpenedChestGenesis")) {
			addTextToTextboxQueue("You found the key of GENESIS!"); 
			Point point = new Point(player.getX() - 50f, player.getY()); 
			CollectibleKey key = new CollectibleKey(point, "KEY_GENESIS");
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
		setFlag("hasOpenedChestGenesis");
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
