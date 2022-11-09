package Scripts.TestMap;

import Level.Keys;
import Level.Script;
import Level.ScriptState;

public class KeyScript extends Script {

	Keys keyLock = new Keys();

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		addTextToTextboxQueue("You found a key!");
		keyLock.addKeys(1);

	}

	@Override
	protected void cleanup() {
		setFlag("hasFoundKey");
		hideTextbox();
		unlockPlayer();

	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasFoundKey")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		return ScriptState.COMPLETED;
	}

}

