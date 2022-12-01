package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLevel2IntroScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasEnteredLevel2")) {
			addTextToTextboxQueue("What is this room?");
			addTextToTextboxQueue("I guess this is another one of this \nStranger's Puzzles...");
			addTextToTextboxQueue("I must keep going...");
			addTextToTextboxQueue("Maybe I need to swim across the water, \nThere seems to be stairs over there...");
		}

	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredLevel2");
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