package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLevel1_5Script extends Script {

	@Override
	protected void setup() {
		if(!isFlagSet("hasEnteredLevel2")) {
			lockPlayer();
			showTextbox();
			addTextToTextboxQueue("You descend the stairs...");
		}
	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredLevel2");
		hideTextbox();
		unlockPlayer();
	}

	@Override
	protected ScriptState execute() {
		if(!isFlagSet("hasEnteredLevel2")) {
			start();
	        if (!isTextboxQueueEmpty()) {
	            return ScriptState.RUNNING;
	        }
	        end();
		}	
		return ScriptState.COMPLETED;
	}

}
