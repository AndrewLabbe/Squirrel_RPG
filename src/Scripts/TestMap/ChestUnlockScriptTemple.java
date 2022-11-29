package Scripts.TestMap;

import Utils.Point;

import Collectibles.CollectibleAcorn;
import Collectibles.CollectibleKey;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Projectiles.Acorn;

public class ChestUnlockScriptTemple extends Script {
	
	@Override
	protected void setup() {
		//lockPlayer();
		showTextbox();
		if(!isFlagSet("hasOpenedChestTempleLvl3")) {
			addTextToTextboxQueue("You found the key of to escape!"); 
			Trigger trigger = new Trigger(850, 50, 225, 10, new TempleLevel3Script());
		    trigger.getTriggerScript().setMap(map); 
		    map.addTrigger(trigger);
		}
		else {
			addTextToTextboxQueue("This chest is empty!"); 
		}
	}

	@Override
	protected void cleanup() {
		hideTextbox();
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
