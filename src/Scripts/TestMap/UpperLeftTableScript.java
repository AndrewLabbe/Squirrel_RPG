package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class UpperLeftTableScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(isFlagSet("doneWithPuzzle")) {
			addTextToTextboxQueue("The key slides into the key hole on\nthe back of the skull..."); 
		}
		else {
			addTextToTextboxQueue("It's just a table, but there seems to be\na keyhole behind the skull...");
		}
	}

	@Override
	protected void cleanup() {
		if(isFlagSet("doneWithPuzzle")) {
			setFlag("hasFinishedFirstLevel");
		}
		hideTextbox();
		unlockPlayer();
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
