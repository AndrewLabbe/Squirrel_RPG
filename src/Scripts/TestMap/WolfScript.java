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
        addTextToTextboxQueue("Hi there, my names Wolfy. This is the interactable \nshopkeeper");
        addTextToTextboxQueue("You can use your coins to either buy items or sell \nitems to get more.");
        addTextToTextboxQueue("After you decide you can come back at any point to \nmake another exchange!");
        addTextToTextboxQueue("Which would you like to do? \n1. Buy              2. Sell");
        setFlag("inShop");
        entity.facePlayer(player);
    }

	@Override
    protected void cleanup() {
		setFlag("leftShop");
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

