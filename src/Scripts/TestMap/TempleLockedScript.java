package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLockedScript extends Script {

	@Override
	protected void setup() {
		if(!isFlagSet("hasTempleUnlocked")) {
			lockPlayer();
			showTextbox();
			addTextToTextboxQueue("You Must Find the FOUR Keys to Enter the Temple...");
		}
	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
	}

	@Override
	protected ScriptState execute() {
		if(!isFlagSet("hasTempleUnlocked")) {
			start();
	        if (!isTextboxQueueEmpty()) {
	            return ScriptState.RUNNING;
	        }
	        end();
		}	
		return ScriptState.COMPLETED;
	}

}
