package Scripts.TestMap;

import Utils.Point;

import Collectibles.CollectibleAcorn;
import Level.Script;
import Level.ScriptState;
import Projectiles.Acorn;

public class ChestUnlockScript extends Script {
	
	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasOpenedChest")) {
			addTextToTextboxQueue("You found a key!"); 
			Point point = new Point(player.getX() + 20f, player.getY());
			CollectibleAcorn acorn = new CollectibleAcorn(point);
			map.addCollectibles(acorn); 
		}
		else {
			addTextToTextboxQueue("This chest is empty!"); 
		}
	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
		setFlag("hasOpenedChest");
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
