package Scripts.TestMap;

import java.util.ArrayList;

import Level.Player;
import Level.PlayerState;
import Level.Script;
import Level.ScriptState;
import Level.Trigger;
import Players.Squirrel;
import Screens.PlayLevelScreen;

public class SwimScript extends Script {

	@Override
	protected void setup() {
		
	}

	@Override
	protected void cleanup() {
		setFlag("hasSwam");
		
	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("hasSwam")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		} 
		//Create a walking trigger and flag
		ArrayList<Trigger> triggers = new ArrayList<>();
		triggers.add(new Trigger(0, 820, 180, 1, new LandScript(), "hasWalked")); 
	    triggers.add(new Trigger(180, 820, 1, 50, new LandScript(), "hasWalked")); 
	    triggers.add(new Trigger(180, 870, 50, 1, new LandScript(), "hasWalked")); 
	    triggers.add(new Trigger(230, 870, 1, 50, new LandScript(), "hasWalked")); 
	    triggers.add(new Trigger(230, 920, 550, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(780, 870, 1, 50, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(780, 870, 50, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(830, 820, 1, 50, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(830, 820, 50, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(880, 470, 1, 350, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(780, 0, 1, 305, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(780, 305, 50, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(830, 305, 1, 135, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(430, 470, 450, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(430, 440, 400, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(430, 380, 1, 60, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(430, 470, 1, 60, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(300, 380, 130, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(300, 530, 130, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(300, 380, 1, 150, new LandScript(), "hasWalked"));
	    for(Trigger trigger : triggers) {
	    	trigger.getTriggerScript().setMap(map); 
	    	trigger.getTriggerScript().setPlayer(player);
	    	map.addTrigger(trigger); 
	    }
		map.getFlagManager().addFlag("hasWalked", false);
		return ScriptState.COMPLETED;
	}
}