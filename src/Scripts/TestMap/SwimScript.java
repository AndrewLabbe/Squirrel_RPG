package Scripts.TestMap;

import Level.Player;
import Level.PlayerState;
import Level.Script;
import Level.ScriptState;
import Players.Squirrel;
import Screens.PlayLevelScreen;

public class SwimScript extends Script {

	@Override
	protected void setup() {
		
//		lockPlayer();
//		showTextbox();
//		addTextToTextboxQueue("You dive into the blue water...");
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasSwam");
		hideTextbox();
		unlockPlayer();
		
	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasSwam")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}
}
