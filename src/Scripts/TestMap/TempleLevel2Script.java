package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLevel2Script extends Script {

	@Override
	protected void setup() {
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredLevel3");
		
	}

	@Override
	protected ScriptState execute() {
		if(!isFlagSet("hasEnteredLevel3")) {
			start();
	        if (!isTextboxQueueEmpty()) {
	            return ScriptState.RUNNING;
	        }
	        end();
		}	
		return ScriptState.COMPLETED;
	}

}
