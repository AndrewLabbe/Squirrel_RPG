package Scripts.TestMap;

import Engine.SoundE;
import Level.NPC;
import Level.Script;
import Level.ScriptState;

// script for talking to walrus npc
public class WalrusScript extends Script<NPC> {
	SoundE se = new SoundE();

	@Override
	protected void setup() {
		lockPlayer();
		showTextbox();

		// changes what walrus says when talking to him the first time (flag is not set)
		// vs talking to him afterwards (flag is set)
		if (!isFlagSet("hasTalkedToWalrus")) {
			// Plays Sound Effect
			se.playSE(0);
			addTextToTextboxQueue("Hi Cat!");
			addTextToTextboxQueue("...oh, you lost your ball?");
			addTextToTextboxQueue(
					"Hmmm...my walrus brain remembers seeing Dino with\nit last. Maybe you can check with him?");
		} else {
			se.playSE(0);
			addTextToTextboxQueue("I sure love doing walrus things!");
		}
		entity.facePlayer(player);
	}

	@Override
	protected void cleanup() {
		unlockPlayer();
		hideTextbox();

		// set flag so that if walrus is talked to again after the first time, what he
		// says changes
		setFlag("hasTalkedToWalrus");
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
