package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLevel3IntroScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasEnteredLevel3")) {
			addTextToTextboxQueue("I tihink I'm close...");
			addTextToTextboxQueue("I will find this stranger and \n make them pay.");
			addTextToTextboxQueue("Is this room littered with traps?");
			addTextToTextboxQueue("I need to be careful...");
			addTextToTextboxQueue("I need to get to that chest and \nEnter the last room...");
		}

	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredLevel3");
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