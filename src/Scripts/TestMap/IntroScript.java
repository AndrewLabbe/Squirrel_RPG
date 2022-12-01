package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class IntroScript extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasLostGirlfriend")) {
			addTextToTextboxQueue("I need to find my girlfriend...");
			addTextToTextboxQueue("She is in danger from whatever is lurking out here...");
			addTextToTextboxQueue("You find your girl sitting by the road.");
			// Girlfriend Spawns
			addTextToTextboxQueue("Girlfriend: Hey, where have you been?\nI've been worried.");
			addTextToTextboxQueue("You don't understand how she's alive and safe,\nbut you're thankful.");
			// Enemy Text
			addTextToTextboxQueue("A deep voice in the distance...");
			addTextToTextboxQueue("Stranger: You... squirrel... shall perish...");
			addTextToTextboxQueue("Who are you? What do you want?");
			addTextToTextboxQueue("Stranger: I want to rule this world,\nand you can't stop me!");
			// Enemy Goes Away
			addTextToTextboxQueue("I must find them and stop them before it's too late.");
			addTextToTextboxQueue("Maybe that temple entrance over there is his lair...");
			addTextToTextboxQueue("But how do I get inside?");
			addTextToTextboxQueue("Oh! I see chests, maybe those contain the keys\nto get into the temple.");
			// Before Enemy truly dissapears to the temple, merks Girlfriend
			addTextToTextboxQueue("Before the stranger truly leaves, strikes\nyour girlfriend with a lightning bolt.");
			addTextToTextboxQueue("WHY? WHY WOULD THEY DO THIS...");
			addTextToTextboxQueue("I will have my revenge,\nand take anything out in my way!");
			addTextToTextboxQueue("FEAR ME, MYSTERIOUS ENEMY.\nI SHALL FIND YOU.");
			// Girlfriend Graphic Changes
		}

	}

	@Override
	protected void cleanup() {
		hideTextbox();
		unlockPlayer();
		setFlag("hasLostGirlfriend");

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
