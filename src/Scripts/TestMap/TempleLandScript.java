package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLandScript extends Script {

	@Override
	protected void setup() {
		
	}

	@Override
	protected void cleanup() {
		setFlag("templeWalked");
		
	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("templeWalked")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		}
		//Create swimming trigger/flag
		map.getFlagManager().addFlag("templeSwam", false);
		return ScriptState.COMPLETED;
	}

}
