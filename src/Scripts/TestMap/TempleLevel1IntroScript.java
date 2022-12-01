package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLevel1IntroScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasEnteredLevel1")) {
			addTextToTextboxQueue("So this is the temple...");
			addTextToTextboxQueue("I need to find the stranger...");
			addTextToTextboxQueue("They can't get away with this...");
			addTextToTextboxQueue("I wonder if I need to talk to the \nTable up there");
			addTextToTextboxQueue("Guess I'll have to find out...");
		}

	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredLevel1");
		unlockPlayer();
		hideTextbox();

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