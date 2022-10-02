package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to fox NPC
public class WolfScript extends Script<NPC>{
	
	@Override
	protected void setup() {
        lockPlayer();
        showTextbox();

        addTextToTextboxQueue("Hello there squirrel, I see you have some coins there.");
        addTextToTextboxQueue("I will trade you something nice for them! \nBuy              Sell");
        entity.facePlayer(player);
    }

	@Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();
    }

    @Override
    public ScriptState execute() {
        start();
        if (!isTextboxQueueEmpty()) {
            return ScriptState.RUNNING;
        }
        end();
        return ScriptState.COMPLETED;
    }
}

