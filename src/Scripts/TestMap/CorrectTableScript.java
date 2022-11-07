package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class CorrectTableScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(isFlagSet("hasTalkedToTable")) {
			addTextToTextboxQueue("You found the correct table!");
			addTextToTextboxQueue("Take this key");
		}
		else {
			addTextToTextboxQueue("It's just a table...");
		}
	}

	@Override
	protected void cleanup() {
		setFlag("hasFoundKey");
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
