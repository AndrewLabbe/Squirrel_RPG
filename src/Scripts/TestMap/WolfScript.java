package Scripts.TestMap;

import Engine.GamePanel;
import Engine.SoundE;
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
        SoundE soundE = new SoundE();
		//Plays Sound Effect
        soundE.playSE(3);
        addTextToTextboxQueue("Hello, adventurer. Would you like to see my wares?");
        addTextToTextboxQueue("I am able to provide you upgrades that will lead you to exact your revenge ont his stranger you speak of.");
        addTextToTextboxQueue("What part of your squirrel would you like to upgrade?");
        addTextToTextboxQueue("Don't forget, I can only help you with each upgrade once.");
        addTextToTextboxQueue("If I could increase your health to infinity that would be broken, traveler.");
        addTextToTextboxQueue("Press the corresponding number key to purchase.");
        addTextToTextboxQueue("1. Increase Health	2. Increase Damage");
        
        /* If Player Selects 1. (health)
         * Increase Health Bar Length
         * Print out, "Thanks for Shopping"
         * This can be done via a flag, in which the player choice sets a flag which changes the health bar greenRectangleLength and outline
         * If Player Selects 2. (Damage)
         * Unknown, just an idea
         */
        
//        addTextToTextboxQueue("Hi there, my names Wolfy. This is the interactable \nshopkeeper");
//        addTextToTextboxQueue("You can use your coins to either buy items or sell \nitems to get more.");
//        addTextToTextboxQueue("After you decide you can come back at any point to \nmake another exchange!");
//        addTextToTextboxQueue("Which would you like to do? \n1. Buy              2. Sell");
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
