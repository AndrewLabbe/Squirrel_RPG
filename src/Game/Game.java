package Game;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import Engine.GameWindow;
import Engine.ScreenManager;
import JSON.JSONObject; 
import JSON.JSONParser;
/*
 * The game starts here
 * This class just starts up a GameWindow and attaches the ScreenCoordinator to the ScreenManager instance in the GameWindow
 * From this point on the ScreenCoordinator c
 */

// Game created by Phil, Andrew L, Andrew K, Alec G, and Mica
public class Game {

	//Create a .json and return it and all of its contents to the terminal 
			/*public static void main(String[] args) throws Exception {
				writeJsonSimpleDemo("example.json"); 
			    JSONObject jsonObject = (JSONObject) readJsonSimpleDemo("example.json");
			    System.out.println(jsonObject);
			    System.out.println(jsonObject.get("Age:")); 
			    System.out.println(jsonObject.get("Name:"));
			}
			
			//Return the .json File 
			public static Object readJsonSimpleDemo(String filename) throws Exception {
			    FileReader reader = new FileReader(filename);
			    JSONParser jsonParser = new JSONParser();
			    return jsonParser.parse(reader);
			}*/	
	
    public static void main(String[] args) {
        new Game();
    }

    public Game() { 
    	try {
			writeJsonSimpleDemo("example.json");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        GameWindow gameWindow = new GameWindow();
        gameWindow.startGame();
        ScreenManager screenManager = gameWindow.getScreenManager();
        screenManager.setCurrentScreen(new ScreenCoordinator());
    } 
    
    //Make the .json File 
	public static void writeJsonSimpleDemo(String filename) throws Exception {
		JSONObject sampleObject = new JSONObject();
		sampleObject.put("HealthBar:", 100);
		//sampleObject.put("Name:", "Philip Caldarella");

		Files.write(Paths.get(filename), sampleObject.toJSONString().getBytes()); 
		System.out.println("I did it");
	} 
	
}
