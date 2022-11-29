package Screens;

import java.awt.Color;

import Engine.Config;
import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;
import Engine.Screen;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

// This is the class for the inventory menu screen
public class InventoryScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentItem = 0; // current item position
    protected SpriteFont inventory;
    protected Map background;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    
    private final Key escKey = Key.ESC;
    protected int yPos, range, itemBoxSize, base;
    protected float space, next;
    protected GameObject.Rectangle box1, box2, box3, box4, box5, invTable
    								,info1, info2, info3, info4, info5;

    public InventoryScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
    	range = Config.GAME_WINDOW_HEIGHT/5; //range for item box and equal spaces
    	itemBoxSize = range * 1/2;
    	space = (range * 1/4) /2;
    	next = itemBoxSize + space;
    	base = range * 3/4;
    	
    	// inventory table
    	invTable = new GameObject.Rectangle(2*space, 2*space, Config.GAME_WINDOW_WIDTH*1/2, Config.GAME_WINDOW_HEIGHT*3/4);
    	invTable.setColor(new Color(77, 75, 115));
    	invTable.setBorderColor(Color.black);
    	invTable.setBorderThickness(3);
    	
        inventory = new SpriteFont("Inventory", itemBoxSize, base*3/4, "Comic Sans", 32, new Color(49, 207, 240));
        inventory.setOutlineColor(Color.black);
        inventory.setOutlineThickness(3);
    	
//    	Rectangle box = new Rectangle(space, yPos+space, itemBoxSize, itemBoxSize);  
    	box1 = new GameObject.Rectangle(itemBoxSize, base, itemBoxSize, itemBoxSize);
    	box2 = new GameObject.Rectangle(itemBoxSize, base+(1*next), itemBoxSize, itemBoxSize);
    	box3 = new GameObject.Rectangle(itemBoxSize, base+(2*next), itemBoxSize, itemBoxSize);
    	box4 = new GameObject.Rectangle(itemBoxSize, base+(3*next), itemBoxSize, itemBoxSize);
    	box5 = new GameObject.Rectangle(itemBoxSize, base+(4*next), itemBoxSize, itemBoxSize);
    	
    	box1.setColor(new Color(90, 89, 110));
    	box1.setBorderColor(Color.black);
    	box1.setBorderThickness(3);
    	
    	box2.setColor(new Color(90, 89, 110));
    	box2.setBorderColor(Color.black);
    	box2.setBorderThickness(3);
    	
    	box3.setColor(new Color(90, 89, 110));
    	box3.setBorderColor(Color.black);
    	box3.setBorderThickness(3);
    	
    	box4.setColor(new Color(90, 89, 110));
    	box4.setBorderColor(Color.black);
    	box4.setBorderThickness(3);
    	
    	box5.setColor(new Color(90, 89, 110));
    	box5.setBorderColor(Color.black);
    	box5.setBorderThickness(3);
    	
    	info1 = new GameObject.Rectangle(next+itemBoxSize, base, itemBoxSize*4, itemBoxSize);
    	info2 = new GameObject.Rectangle(next+itemBoxSize, base+(1*next), itemBoxSize*4, itemBoxSize);
    	info3 = new GameObject.Rectangle(next+itemBoxSize, base+(2*next), itemBoxSize*4, itemBoxSize);
    	info4 = new GameObject.Rectangle(next+itemBoxSize, base+(3*next), itemBoxSize*4, itemBoxSize);
    	info5 = new GameObject.Rectangle(next+itemBoxSize, base+(4*next), itemBoxSize*4, itemBoxSize);
    	
//    	info1.setColor(new Color(90, 89, 110));
    	info1.setBorderColor(Color.black);
    	info1.setBorderThickness(3);
    	
//    	info2.setColor(new Color(90, 89, 110));
    	info2.setBorderColor(Color.black);
    	info2.setBorderThickness(3);
    	
//    	info3.setColor(new Color(90, 89, 110));
    	info3.setBorderColor(Color.black);
    	info3.setBorderThickness(3);
    	
//    	info4.setColor(new Color(90, 89, 110));
    	info4.setBorderColor(Color.black);
    	info4.setBorderThickness(3);
    	
//    	info5.setColor(new Color(90, 89, 110));
    	info5.setBorderColor(Color.black);
    	info5.setBorderThickness(3);
    	
    	
//    	for(yPos = 0; yPos < Config.GAME_WINDOW_HEIGHT; yPos = yPos + range) {
////    		drawFilledRectangle(x, y, width, height, fillColor);
////          drawRectangle(x, y, width, height, borderColor, borderThickness);
//    		
////    		Rectangle box = new Rectangle(space, yPos+space, itemBoxSize, itemBoxSize);
//    		
//    		
//    	}
    	
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyTimer.setWaitTime(200);
//        menuItemSelected = -1;
        keyLocker.lockKey(Key.SPACE);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);

        // if down or up is pressed, change selected item position. avoids currentItem from being out of bounds
        if (Keyboard.isKeyDown(Key.DOWN) && currentItem != 4 && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentItem++;
        } else if (Keyboard.isKeyDown(Key.UP) && currentItem != 0 && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentItem--;
        }


        // sets color of spritefont text based on which menu item is being hovered
        if (currentItem == 0) {
        	box1.setColor(new Color(255, 215, 0)); // selected color
        	box2.setColor(new Color(90, 89, 110)); // natural color

        } else if (currentItem == 1) {
        	box1.setColor(new Color(90, 89, 110));
        	box2.setColor(new Color(255, 215, 0));
        	box3.setColor(new Color(90, 89, 110));

        } else if (currentItem == 2) {
        	box2.setColor(new Color(90, 89, 110));
        	box3.setColor(new Color(255, 215, 0));
        	box4.setColor(new Color(90, 89, 110));

        } else if (currentItem == 3) {
        	box3.setColor(new Color(90, 89, 110));
        	box4.setColor(new Color(255, 215, 0));
        	box5.setColor(new Color(90, 89, 110));

        } else if (currentItem == 4) {
        	box4.setColor(new Color(90, 89, 110));
        	box5.setColor(new Color(255, 215, 0));

        }

        //
        if (Keyboard.isKeyDown(escKey)) {
			screenCoordinator.setGameState(GameState.LEVEL);
			//screenCoordinator.switchBackToLevel();
		}
        
        // if space is pressed, go back to game
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.LEVEL);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        invTable.draw(graphicsHandler);
        inventory.draw(graphicsHandler);
        
        box1.draw(graphicsHandler);
        box2.draw(graphicsHandler);
        box3.draw(graphicsHandler);
        box4.draw(graphicsHandler);
        box5.draw(graphicsHandler);
        
        info1.draw(graphicsHandler);
        info2.draw(graphicsHandler);
        info3.draw(graphicsHandler);
        info4.draw(graphicsHandler);
        info5.draw(graphicsHandler);
    }

//    public int getMenuItemSelected() {
//        return menuItemSelected;
//    }
}