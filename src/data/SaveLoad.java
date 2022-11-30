package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import Engine.GamePanel;
import Level.Keys;
import Level.KillCount;
import NPCs.Currency;
import Screens.PlayLevelScreen;

public class SaveLoad {

	GamePanel gamePanel;
	//KillCount killCount;
	//Keys keycount;
	
	
	/*public SaveLoad(GamePanel gamePanel, KillCount killCount,Keys keyCount) {
		this.gamePanel = gamePanel;
		this.killCount = killCount;
		this.keycount = keyCount;
	}*/
	
	public SaveLoad(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public void save () {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
			//Initialize data storage class
			DataStorage ds= new DataStorage();
			
			//Store the players 
			ds.Killnum = KillCount.KillNum;
			System.out.println( KillCount.KillNum);
			ds.currNum= Currency.CoinNum;
			System.out.println(Currency.CoinNum);
			ds.x = PlayLevelScreen.player.getX();
			ds.y= PlayLevelScreen.player.getY();
			
			//Write the DataStorage object
			os.writeObject(ds);
					

		}
		catch(Exception e){
			System.out.println("Save Exception");
			
		}
	}
	
	public void load() {
		try {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
			
			//Read the DataStorage Object
			DataStorage ds = (DataStorage)ois.readObject();
			
			//Pass recorded data to the game data
			KillCount.KillNum = ds.Killnum;
			Currency.CoinNum = ds.currNum;
			//PlayLevelScreen.player.setX(ds.x);
			//PlayLevelScreen.player.setY(ds.y);
			System.out.println("load" +  KillCount.KillNum);
			System.out.println("load" +  Currency.CoinNum );
		}
		catch(Exception e) {
			System.out.println("Load Exception");
		}
	}
}
