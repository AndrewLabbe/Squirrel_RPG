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
		triggers.add(new Trigger(345, 480, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(345, 560, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(390, 450, 10, 150, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(470, 450, 10, 150, new TempleLandScript(), "templeWalked"));

		// Platform B (Mid Right)
		triggers.add(new Trigger(1020, 690, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1020, 740, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1065, 625, 10, 170, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1140, 625, 10, 170, new TempleLandScript(), "templeWalked"));

		// Platform C (Mid Left)
		triggers.add(new Trigger(345, 940, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(345, 1050, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(390, 910, 10, 170, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(470, 910, 10, 170, new TempleLandScript(), "templeWalked"));

		// Platform D (bottom Right)
		triggers.add(new Trigger(1020, 1150, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1020, 1235, 170, 10, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1065, 1110, 10, 170, new TempleLandScript(), "templeWalked"));
		triggers.add(new Trigger(1140, 1110, 10, 170, new TempleLandScript(), "templeWalked"));

		for(Trigger trigger : triggers) {
			trigger.getTriggerScript().setMap(map); 
			trigger.getTriggerScript().setPlayer(player);
			map.addTrigger(trigger); 
		}
		map.getFlagManager().addFlag("templeWalked", false);
		return ScriptState.COMPLETED;

	}

}
