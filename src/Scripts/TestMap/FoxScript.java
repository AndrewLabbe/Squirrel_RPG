package Scripts.TestMap;

import Level.NPC;
import Level.Script;
import Level.ScriptState;

//script for talking to fox NPC
public class FoxScript extends Script<NPC>{
	
	@Override
	protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what fox says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToFox")) {
            addTextToTextboxQueue("Hey you, squirrel over there!");
            addTextToTextboxQueue("This place seems to be ridden with zombies,\nI don't know how they got there but they don't belong.");
            addTextToTextboxQueue("Say, if you could rid them from the forest,\nI would be forever greatful :)");
            addTextToTextboxQueue("What says you to that?");
            addTextToTextboxQueue("You're in? Terrific! You should start by clearing\nsome of these guys out with that weapon of yours.");
            addTextToTextboxQueue("Oh I forgot to mention, if you want to permanetly\nrid the forest of these vile creatures, remember this.");
            addTextToTextboxQueue("At the top of the tallest mountain, where no creature\nhas set foot before");
            addTextToTextboxQueue("A lost temple will purify the forest...");
        }
        else {
            addTextToTextboxQueue("Why are you bothering me for? Go defeat these things\nand don't forget what I said.");
            addTextToTextboxQueue("At the top of the tallest mountain, where no\ncreature set foot before,");
            addTextToTextboxQueue("A lost temple will purify the forest...");
        }
        entity.facePlayer(player);
    }

	@Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if the fox is talked to again after the first time, what he says changes
        setFlag("hasTalkedToFox");
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

