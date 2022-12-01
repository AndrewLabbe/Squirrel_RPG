package JSON;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import JSON.JSONObject;
import JSON.JSONParser;


//This is a rather crap class coded at almost 3 am 
//It is a basic go at implementing .json files to save information between screens 
//It effectively saves the player health between all levels 
//Simply a proof of concept 
//It would have been nice to clean this up and save all kinds of game data 
//Caveat is that Java does not have .json functionality 
//To make this project more accessible I implemented a a simple json library in this project 
//No reference libraries or dependencies are required 
public class SimpleJSON {

	//Player health 
	private int health;
	
	//Game at Launch 
	public SimpleJSON(Boolean initialize) {
		
		health = 250;
		
		//Try to create a json with all of the needed information 
		try {
			writeJSON("Game.json");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	} 
	
	//Used to access the "Game.json" from different places in the game
	public SimpleJSON() {
		
	}

	//Make the .json file 
	public void writeJSON(String filename) throws Exception {
		JSONObject sampleObject = new JSONObject();
		sampleObject.put("Health", health);
		//System.out.println(health);
		Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes()); 
		//System.out.println("I did it");
	} 

	//Return the .json file 
	public static void readJSON(String data) throws Exception {
		if(data == "Health") {
			//jsonObject.get(data); 
			readJSONInt(data);
		}
	} 
	
	//Returns an integer from the .json file which matches the key provided 
	public static int readJSONInt(String data) throws Exception {
		FileReader reader = new FileReader("Game.json");
		JSONParser jsonParser = new JSONParser(); 
		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
		return Integer.valueOf(jsonObject.get(data).toString());
	} 
	
	//Gets the health value in the .json file 
	public int getHealth() {
		try {
			return readJSONInt("Health");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (Integer) null;
	} 
	
	//Sets the health value in the .json file 
	public void setHealth(int health) {
		this.health = health; 
		try {
			writeJSON("Game.json");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
