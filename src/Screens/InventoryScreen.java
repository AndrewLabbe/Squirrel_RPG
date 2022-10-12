package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

// This is the class for the inventory menu screen
public class InventoryScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentItem = 0; // current item position
//    protected int menuItemSelected = -1;
    protected SpriteFont inventory;
    protected Map background;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();
    
    private final Key escKey = Key.ESC;
    protected int yPos, range, itemBoxSize, next;
    protected float space;
    protected GameObject.Rectangle box1, box2, box3, box4, box5;

    public InventoryScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        inventory = new SpriteFont("Inventory", 5, 5, "Comic Sans", 12, new Color(49, 207, 240));
        inventory.setOutlineColor(Color.black);
        inventory.setOutlineThickness(1);

    	
    	range = Config.GAME_WINDOW_HEIGHT/5; //range for item box and equal spaces
    	itemBoxSize = range * 3/4;
    	space = (range * 1/4) /2;
    	
//    	Rectangle box = new Rectangle(space, yPos+space, itemBoxSize, itemBoxSize);  
    	box1 = new GameObject.Rectangle(space, space, itemBoxSize, itemBoxSize);
    	box2 = new GameObject.Rectangle(space, range+space, itemBoxSize, itemBoxSize);
    	box3 = new GameObject.Rectangle(space, (2*range)+space, itemBoxSize, itemBoxSize);
    	box4 = new GameObject.Rectangle(space, (3*range)+space, itemBoxSize, itemBoxSize);
    	box5 = new GameObject.Rectangle(space, (4*range)+space, itemBoxSize, itemBoxSize);
    	
    	
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
        

        	

//        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
//        if (currentItem > 1) {
//            currentItem = 0;
//        } else if (currentItem < 0) {
//            currentItem = 1;
//        }

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
			screenCoordinator.switchBackToLevel();
		}
        
        // if space is pressed, go back to game
        if (!keyLocker.isKeyLocked(Key.SPACE) && Keyboard.isKeyDown(Key.SPACE)) {
            screenCoordinator.setGameState(GameState.LEVEL);
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        inventory.draw(graphicsHandler);
        
        box1.draw(graphicsHandler);
        box2.draw(graphicsHandler);
        box3.draw(graphicsHandler);
        box4.draw(graphicsHandler);
        box5.draw(graphicsHandler);
        
//        graphicsHandler.drawFilledRectangleWithBorder(space, space, itemBoxSize, itemBoxSize, new Color(90, 89, 110), Color.black, 2);
//        graphicsHandler.drawFilledRectangleWithBorder(space, range+space, itemBoxSize, itemBoxSize, new Color(90, 89, 110), Color.black, 2);
//        graphicsHandler.drawFilledRectangleWithBorder(space, (2*range)+space, itemBoxSize, itemBoxSize, new Color(90, 89, 110), Color.black, 2);
//        graphicsHandler.drawFilledRectangleWithBorder(space, (3*range)+space, itemBoxSize, itemBoxSize, new Color(90, 89, 110), Color.black, 2);
//        graphicsHandler.drawFilledRectangleWithBorder(space, (4*range)+space, itemBoxSize, itemBoxSize, new Color(90, 89, 110), Color.black, 2);
    }

//    public int getMenuItemSelected() {
//        return menuItemSelected;
//    }
}