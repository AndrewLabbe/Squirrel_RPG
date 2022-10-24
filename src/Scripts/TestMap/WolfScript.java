package Scripts.TestMap;

import Engine.GamePanel;
import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to fox NPC
public class WolfScript extends Script<NPC>{
	GamePanel gamePanel = new GamePanel();
	@Override
	protected void setup() {
        lockPlayer();
        showTextbox();
        //Plays Sound Effect
        gamePanel.playSE(3);
        addTextToTextboxQueue("Hello there squirrel, I see you have some coins there.");
        addTextToTextboxQueue("I will trade you something nice for them! \n1. Buy              2. Sell");
        setFlag("InShop");
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

