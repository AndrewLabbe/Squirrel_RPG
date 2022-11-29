package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class SimpleTableScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("It's just a table...");
	}

	@Override
	protected void cleanup() {
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
