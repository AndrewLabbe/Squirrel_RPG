package Level;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.Key;
import Engine.KeyLocker;
import Engine.Keyboard;

public class HealthBar {
    protected boolean isActive;
    protected final int x = 550;
    protected final int bottomY = 500;
    protected final int topY = 22;
    protected final int fontX = 35;
    protected final int fontBottomY = 500;
    protected final int fontTopY = 62;
    protected final int width = 500;
    protected final int height = 50;
    protected final int halfway = 250;
	protected int greenBarWidth = 250;
	protected final int healthActualWidth = 250;
    
  

    private KeyLocker keyLocker = new KeyLocker();
    private Map map;
    private Key interactKey = Key.Q;
    
    
    public HealthBar(Map map) {
        this.map = map;
        
    }
    

    public void update() {
    	
    	 if (Keyboard.isKeyDown(interactKey) && !keyLocker.isKeyLocked(interactKey)) {
             keyLocker.lockKey(interactKey);
         }
    	 else if (Keyboard.isKeyUp(interactKey)) {
             keyLocker.unlockKey(interactKey);
         }
  
         
    }

    public void draw(GraphicsHandler graphicsHandler) {
        // if camera is at bottom of screen, textbox is drawn at top of screen instead of the bottom like usual
        // to prevent it from covering the player
    
    		
    		
    
    		
    	
            if (!map.getCamera().isAtBottomOfMap()) {
				graphicsHandler.drawFilledRectangleWithBorder(x,0, healthActualWidth, 50, Color.red, Color.black, 2);
				graphicsHandler.drawFilledRectangleWithBorder(x,0, greenBarWidth, 50, Color.green, Color.black, 2);
            }
            else {
				graphicsHandler.drawFilledRectangleWithBorder(x,0, healthActualWidth, 50, Color.red, Color.black, 2);
				graphicsHandler.drawFilledRectangleWithBorder(x,0, greenBarWidth, 50, Color.green, Color.black, 2);
            }
            
    
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setInteractKey(Key interactKey) {
        this.interactKey = interactKey;
    }
    
    public Key getInteractKey()
    {
    	return this.interactKey;
    }

    public KeyLocker getKeyLocker()
    {
    	return keyLocker;
    }

	public int getGreenBarWidth(){
		return greenBarWidth;
	}
    public void setGreenBarWidth(int w){
		this.greenBarWidth = w;
	}

	public int getActualHealthBarWidth(){
		return healthActualWidth;
	}

}
