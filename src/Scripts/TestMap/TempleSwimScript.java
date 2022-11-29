package Scripts.TestMap;

import java.util.ArrayList;

import Level.Script;
import Level.ScriptState;
import Level.Trigger;

public class TempleSwimScript extends Script {

	@Override
	protected void setup() {

	}

	@Override
	protected void cleanup() {
		setFlag("templeSwam");

	}

	@Override
	protected ScriptState execute() {
		if (!isFlagSet("templeSwam")) {
			start();
			if (!isTextboxQueueEmpty()) {
				return ScriptState.RUNNING;
			}
			end();
		} 

		//Create a walking trigger & flag
		ArrayList<Trigger> triggers = new ArrayList<>();

		// Start & End of Room
		triggers.add(new Trigger(90, 260, 1350, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(90, 1440, 1350, 10, new TempleLandScript(), "templeWalked"));

		// Platform A (Top Left)
		triggers.add(new Trigger(365, 480, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(365, 580, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(382, 480, 1, 105, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(475, 480, 1, 105, new TempleLandScript(), "templeWalked"));

		// Platform B (Mid Right)
		triggers.add(new Trigger(1040, 655, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1040, 760, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1060, 655, 1, 110, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1150, 655, 1, 110, new TempleLandScript(), "templeWalked"));

		// Platform C (Mid Left)
		triggers.add(new Trigger(365, 940, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(365, 1050, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(382, 940, 1, 110, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(475, 940, 1, 110, new TempleLandScript(), "templeWalked"));

		// Platform D (bottom Right)
		triggers.add(new Trigger(1040, 1130, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1040, 1245, 125, 1, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1060, 1130, 1, 115, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1150, 1130, 1, 115, new TempleLandScript(), "templeWalked"));

		for(Trigger trigger : triggers) {
			trigger.getTriggerScript().setMap(map); 
			trigger.getTriggerScript().setPlayer(player);
			map.addTrigger(trigger); 
		}
		map.getFlagManager().addFlag("templeWalked", false);
		return ScriptState.COMPLETED;

	}

}
