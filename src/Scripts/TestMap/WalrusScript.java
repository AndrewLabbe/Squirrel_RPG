package Scripts.TestMap;

import Collectibles.EasterEgg;
//import Engine.GamePanel;
import Engine.SoundE;
//import Level.CollectibleItem;
import Level.NPC;
import Level.Script;
import Level.ScriptState;
import Utils.Point;

// script for talking to walrus npc
public class WalrusScript extends Script<NPC> {
	SoundE se = new SoundE();
    @Override
    protected void setup() {
        lockPlayer();
        showTextbox();

        // changes what walrus says when talking to him the first time (flag is not set) vs talking to him afterwards (flag is set)
        if (!isFlagSet("hasTalkedToWalrus")) {
        	//Plays Sound Effect
        	se.playSE(2);
            addTextToTextboxQueue( "Greetings Mr. Squirrel!");
            addTextToTextboxQueue( "Let me help you on your Quest!");
            addTextToTextboxQueue( "I have summoned a mystical egg for you to find!"); 
            Point point = new Point(100f, 100f);
            EasterEgg easterEgg = new EasterEgg(point); 
            map.addCollectibles(easterEgg);
        }
        else {
        	se.playSE(2);
            addTextToTextboxQueue( "Hello again Mr. Squirrel! I do not have anymore tricks for you sadly.");
        }
        entity.facePlayer(player);
    }

    @Override
    protected void cleanup() {
        unlockPlayer();
        hideTextbox();

        // set flag so that if walrus is talked to again after the first time, what he says changes
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