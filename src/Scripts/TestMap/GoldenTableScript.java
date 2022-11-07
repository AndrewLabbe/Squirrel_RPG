package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class GoldenTableScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(isFlagSet("doneWithPuzzle")) {
			addTextToTextboxQueue("Uhhh why are you still here");
			addTextToTextboxQueue("Go talk to that table dude");
		}
		else if(isFlagSet("hasFoundKey")){
			addTextToTextboxQueue("Hey you found it!");
			addTextToTextboxQueue("Where was it?");
			addTextToTextboxQueue("Over by that table? I never liked that one...");
			addTextToTextboxQueue("Anyways go to that table in the upper\nleft corner and use the key");
		}
		else if(isFlagSet("hasTalkedToTable")) {
			addTextToTextboxQueue("What are you talking to me for?");
			addTextToTextboxQueue("Go find the key");
		}
		else {
			addTextToTextboxQueue("Hello?");
			addTextToTextboxQueue("What are you doing here?");
			addTextToTextboxQueue("Like seriously who in their right mind\nwould enter a big ominous temple?");
			addTextToTextboxQueue("Nevermind. You're here and I am required\nby squirrel law to explain the first puzzle.");
			addTextToTextboxQueue("You see all of these tables?");
			addTextToTextboxQueue("They used to be full of happy and full\nforest creatures...");
			addTextToTextboxQueue("But they all turned to ghosts and ghouls");
			addTextToTextboxQueue("Anyways theres a key under one of these tables.");
			addTextToTextboxQueue("When you find the key, bring it back here\nand I'll send you on your way.");
		}
	}

	@Override
	protected void cleanup() {
		if(isFlagSet("hasFoundKey")) {
			setFlag("doneWithPuzzle");
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
