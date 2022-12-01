package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class exitShop extends Script {

	@Override
	protected void setup() {
		// If Shop hasn't been entered
		if (!isFlagSet("hasExitedShop")) {
			lockPlayer();
			showTextbox();
			addTextToTextboxQueue("You are exiting the shop...");
		}
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasExitedShop");
		hideTextbox();
		unlockPlayer();

	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasExitedShop")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}


}
