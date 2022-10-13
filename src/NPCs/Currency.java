package NPCs;

import java.awt.Color;

import Engine.GraphicsHandler;
import SpriteFont.SpriteFont;

public class Currency {
	protected int CoinNum;
	protected SpriteFont Coin;
	
	public Currency() {
		Coin = new SpriteFont("Coins: " + CoinNum, 5, 30, "Comic Sans", 20, new Color(255, 255, 255));
	}
	
	public void setCoin(int Count) {
		CoinNum = Count;
	}
	
	public int getCoin() {
		return CoinNum;
	}
	
	public SpriteFont getCurrencyString() {
		return Coin;
	}
	
	public void addCoin(int Increase) {
		CoinNum += Increase;
	}
	
	//public void loseCoin(int Decrease) {
		//CoinNum -= Decrease;
	//}
	
	public void updateCoin() {
		Coin.setText("Coins: " + CoinNum);
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		Coin.draw(graphicsHandler);
	}
	
}
