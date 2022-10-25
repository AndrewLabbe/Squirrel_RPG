package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleScript extends Script {

	@Override
	protected void setup() {
		if(!isFlagSet("hasEnteredTemple")) {
			lockPlayer();
			showTextbox();
			addTextToTextboxQueue("You are entering the temple...");
		}
	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredTemple");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	protected ScriptState execute() {
		if(!isFlagSet("hasEnteredTemple")) {
			start();
	        if (!isTextboxQueueEmpty()) {
	            return ScriptState.RUNNING;
	        }
	        end();
		}	
		return ScriptState.COMPLETED;
	}

}
