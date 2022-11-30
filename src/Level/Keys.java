package Level;

import java.awt.Color;

import Engine.GraphicsHandler;
import SpriteFont.SpriteFont;

public class Keys {
	public static int KeyCount;
	protected SpriteFont Key;
	
	public Keys() {
		Key = new SpriteFont("Keys: " + KeyCount, 5, 110, "Comic Sans", 20, new Color(255, 255, 255));
	}
	
	public void setKeys(int Count) {
		KeyCount = Count;
	}
	
	public int getKeys() {
		return KeyCount;
	}
	
	public SpriteFont getKeyString() {
		return Key;
	}
	
	public void addKeys(int Increase) {
		KeyCount += Increase;
		updateKeyText();
	}
	
	public void updateKeyText() {
		Key.setText("Keys: " + KeyCount);
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		Key.draw(graphicsHandler);
	}
	
}
