package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class IntroShop extends Script {

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		if(!isFlagSet("hasMetShopkeeper")) {
			addTextToTextboxQueue("Hello, traveler, welcome.");
			addTextToTextboxQueue("I heard you outside, I'm sorry for what happened.");
			addTextToTextboxQueue("It seems that stranger retreated to the temple \nUp North");
			addTextToTextboxQueue("Take a look at what I offer, \n Maybe I can help...");
		}
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasMetShopkeeper");
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
