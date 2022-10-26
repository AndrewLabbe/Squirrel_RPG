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
        addTextToTextboxQueue("I will trade you for those coins! \n1. Buy              2. Sell");
        setFlag("inShop");
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

