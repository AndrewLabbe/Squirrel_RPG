package Level;

import java.awt.Color;

import Engine.GraphicsHandler;
import SpriteFont.SpriteFont;

public class KillCount {
	public static  int KillNum;
	protected SpriteFont Kill;
	
	public KillCount() {
		Kill = new SpriteFont("Kills: " + KillNum, 5, 70, "Comic Sans", 20, new Color(255, 255, 255));
	}
	
	public void setKill(int Count) {
		KillNum = Count;
	}
	
	public int getKill() {
		return KillNum;
	}
	
	public SpriteFont getKillString() {
		return Kill;
	}
	
	public void addKill(int Increase) {
		KillNum += Increase;
		updateKillText();
	}
	
	
	public void updateKillText() {
		Kill.setText("Kills: " + KillNum);
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		Kill.draw(graphicsHandler);
	}
	
}