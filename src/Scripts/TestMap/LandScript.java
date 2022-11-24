package Scripts.TestMap;

import Level.Player;
import Level.PlayerState;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Players.Squirrel;
import Screens.PlayLevelScreen;

public class LandScript extends Script {

	@Override
	protected void setup() {
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasWalked");
	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasWalked")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		//Create swimming trigger/flag
		//Trigger trigger = new Trigger(288, 890, 400, 1, new SwimScript(), "hasSwam");
		//trigger.getTriggerScript().setMap(map); 
		//trigger.getTriggerScript().setPlayer(player);
		map.getFlagManager().addFlag("hasSwam", false);
		//map.addTrigger(trigger); 
		return ScriptState.COMPLETED;
	}
}
