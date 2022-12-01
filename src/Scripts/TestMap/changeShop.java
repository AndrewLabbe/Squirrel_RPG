package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class changeShop extends Script {

	@Override
	protected void setup() {
		// If Shop hasn't been entered yet
		if (!isFlagSet("hasEnteredShop")) {
			lockPlayer();
			showTextbox();
			addTextToTextboxQueue("You are entering the shop...");
		}

	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredShop");
		hideTextbox();
		unlockPlayer();

	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasEnteredShop")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}


}
