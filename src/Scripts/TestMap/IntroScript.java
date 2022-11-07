package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class IntroScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("I need to find my girlfriend...");
		addTextToTextboxQueue("She is in danger from whatever is lurking out here...");
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasLostGirlfriend");
		hideTextbox();
		unlockPlayer();
		
	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasLostGirlfriend")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}
