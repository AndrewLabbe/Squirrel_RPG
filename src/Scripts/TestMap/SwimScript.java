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
		// Triggers for Top Left lake
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
	    
	    //Swimming triggers for top left pond
	    triggers.add(new Trigger(1000, 50, 1, 190, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(1110, 50, 1, 190, new LandScript(), "hasWalked")); 
	    triggers.add(new Trigger(1000, 240, 110, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(1000, 50, 110, 1, new LandScript(), "hasWalked"));
	    //Swimming triggers for top right pond
	    triggers.add(new Trigger(1240, 50, 1, 190, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(1350, 50, 1, 190, new LandScript(), "hasWalked")); 
	    triggers.add(new Trigger(1240, 240, 110, 1, new LandScript(), "hasWalked"));
	    triggers.add(new Trigger(1240, 50, 110, 1, new LandScript(), "hasWalked"));
	    
	    // Triggers for Top Right Lake
	    triggers.add(new Trigger(2175, 825, 420, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(2175, 825, 1, 50, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(2125, 875, 50, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(2125, 875, 1, 50, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1580, 925, 545, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1580, 875, 1, 50, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1530, 875, 50, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1530, 825, 1, 50, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1480, 825, 50, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1480, 490, 1, 335, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1480, 490, 440, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1920, 490, 1, 40, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1920, 530, 150, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(2070, 380, 1, 150, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1920, 380, 150, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1920, 380, 1, 60, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1500, 440, 420, 1, new LandScript(), "hasWalked")); 
	     triggers.add(new Trigger(1500, 300, 1, 140, new LandScript(), "hasWalked"));
	     triggers.add(new Trigger(1500, 300, 80, 1, new LandScript(), "hasWalked"));
	     triggers.add(new Trigger(1580, 0, 1, 300, new LandScript(), "hasWalked"));
	    
	    for(Trigger trigger : triggers) {
	    	trigger.getTriggerScript().setMap(map); 
	    	trigger.getTriggerScript().setPlayer(player);
	    	map.addTrigger(trigger); 
	    }
		map.getFlagManager().addFlag("hasWalked", false);
		return ScriptState.COMPLETED;
	}
}
