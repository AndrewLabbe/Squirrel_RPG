package Scripts.TestMap;

import Level.Script;
import Level.ScriptState;

public class TempleLevel3Script extends Script {

	@Override
	protected void setup() {
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasEnteredLevel4");
		
	}

	@Override
	protected ScriptState execute() {
		if(!isFlagSet("hasEnteredLevel4")) {
			start();
	        if (!isTextboxQueueEmpty()) {
	            return ScriptState.RUNNING;
	        }
	        end();
		}	
		return ScriptState.COMPLETED;
	}

}
