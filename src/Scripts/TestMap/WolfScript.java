package Scripts.TestMap;

import Engine.SoundE;
import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to fox NPC
public class WolfScript extends Script<NPC> {
	SoundE se = new SoundE();

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();
		// Plays Sound Effect
		se.playSE(1);
		addTextToTextboxQueue("I will trade you for those coins! \n1. Buy              2. Sell");
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
