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
		player.setPlayerState(PlayerState.WALKING);
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
		map.getFlagManager().addFlag("hasSwam", false);
		return ScriptState.COMPLETED;
	}
}
