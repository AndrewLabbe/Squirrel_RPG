package Level;

import java.awt.Point;
import java.util.ArrayList;

import Engine.GraphicsHandler;
import Engine.ScreenManager;
import GameObject.GameObject;
import GameObject.Rectangle;

// This class represents a Map's "Camera", aka a piece of the map that is currently included in a level's update/draw logic based on what should be shown on screen.
// A majority of its job is just determining which map tiles, enemies, npcs, and enhanced map tiles are "active" each frame (active = included in update/draw cycle)
public class Camera extends Rectangle {

    // the current map this camera is attached to
    private Map map;

    // width and height of each tile in the map (the map's tileset has this info)
    private int tileWidth, tileHeight;

    // if the screen is covered in full length tiles, often there will be some extra room that doesn't quite have enough space for another entire tile
    // this leftover space keeps track of that "extra" space, which is needed to calculate the camera's current "end" position on the screen (in map coordinates, not screen coordinates)
    private int leftoverSpaceX, leftoverSpaceY;

    // current map entities that are to be included in this frame's update/draw cycle
    private ArrayList<EnhancedMapTile> activeEnhancedMapTiles = new ArrayList<>();
    private ArrayList<NPC> activeNPCs = new ArrayList<>();
    private ArrayList<Trigger> activeTriggers = new ArrayList<>(); 
    
    //Active projectile map entities 
    private ArrayList<Projectile> activeProjectiles = new ArrayList<>(); 
    
    //Active enemy map entities 
    private ArrayList<Enemy> activeEnemies = new ArrayList(); 
    
    //Active power-up map entities 
    private ArrayList<PowerUp> activePowerUps = new ArrayList(); 
    
    //Active spawner map entities 
    private ArrayList<Spawner> activeSpawners = new ArrayList();
    
    //Collectible items
    private ArrayList<CollectibleItem> activeCollectibles = new ArrayList(); 
    
    //Unpassable tiles 
    private ArrayList<MapTile> unpassableMapTiles = new ArrayList<>();

    // determines how many tiles off screen an entity can be before it will be deemed inactive and not included in the update/draw cycles until it comes back in range
    private final int UPDATE_OFF_SCREEN_RANGE = 4;

    public Camera(int startX, int startY, int tileWidth, int tileHeight, Map map) {
        super(startX, startY, ScreenManager.getScreenWidth() / tileWidth, ScreenManager.getScreenHeight() / tileHeight);
        this.map = map;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.leftoverSpaceX = ScreenManager.getScreenWidth() % tileWidth;
        this.leftoverSpaceY = ScreenManager.getScreenHeight() % tileHeight;  
        unpassableMapTiles = map.getUnpassableMapTiles();
    }

    // gets the tile index that the camera's x and y values are currently on (top left tile)
    // this is used to determine a starting place for the rectangle of area the camera currently contains on the map
    public Point getTileIndexByCameraPosition() {
        int xIndex = Math.round(getX()) / tileWidth;
        int yIndex = Math.round(getY()) / tileHeight;
        return new Point(xIndex, yIndex);
    }

    public void update(Player player) {
        updateMapTiles();
        updateMapEntities(player);
        updateScripts();
    }

    private void updateMapTiles() {
        for (MapTile tile : map.getAnimatedMapTiles()) {
            // update each animated map tile in order to keep animations consistent
            tile.update();
        }
    }

    // update map entities currently a part of the update/draw cycle
    // active entities are calculated each frame using the loadActiveEntity methods below
    public void updateMapEntities(Player player) {
        activeEnhancedMapTiles = loadActiveEnhancedMapTiles();
        activeNPCs = loadActiveNPCs(); 
        //Define active projectiles
        activeProjectiles = loadActiveProjectiles(); 
        //Define active enemies 
        activeEnemies = loadActiveEnemies(); 
        //Define active power-ups 
        activePowerUps = loadActivePowerUps(); 
        //Define active spawners 
        activeSpawners = loadActiveSpawners();
        
        activeCollectibles = loadActiveCollectibles();
        
        for (EnhancedMapTile enhancedMapTile : activeEnhancedMapTiles) {
            enhancedMapTile.update(player);
        }

        for (NPC npc : activeNPCs) {
            npc.update(player);
        } 
        
        //For each active projectile call its update method
        for(Projectile projectile : activeProjectiles) {
        	projectile.update(activeEnemies, unpassableMapTiles, activeSpawners, activeNPCs); 
        } 
        
        //For each active enemy call its update method 
        for(Enemy enemy : activeEnemies) {
        	enemy.update(player, map);
        } 
        
        //For each active power-up call its update method 
        for(PowerUp powerUp : activePowerUps) {
        	powerUp.update(player, map);
        } 
        
        //For each active spawner call its update method 
        for(Spawner spawner : activeSpawners) {
        	spawner.update();
        }
        
        for(CollectibleItem collectible : activeCollectibles) {
        	collectible.update(player);
        } 
        
    }

    // updates any currently running script
    // only one script should be able to be running (active) at a time
    private void updateScripts() {
        // if there is an active interact script, update the script
        if (map.getActiveInteractScript() != null) {
            map.getActiveInteractScript().update();
        }

        // if there is an active trigger, update the script
        activeTriggers = loadActiveTriggers();
        for (Trigger trigger : activeTriggers) {
            if (trigger.getTriggerScript() != null && trigger.getTriggerScript().isActive()) {
                trigger.getTriggerScript().update();
            }
        }
    }

    // determine which enhanced map tiles are active (exist and are within range of the camera)
    private ArrayList<EnhancedMapTile> loadActiveEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> activeEnhancedMapTiles = new ArrayList<>();
        for (int i = map.getEnhancedMapTiles().size() - 1; i >= 0; i--) {
            EnhancedMapTile enhancedMapTile = map.getEnhancedMapTiles().get(i);

            if (isMapEntityActive(enhancedMapTile)) {
                activeEnhancedMapTiles.add(enhancedMapTile);
                if (enhancedMapTile.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    enhancedMapTile.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
            } else if (enhancedMapTile.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                enhancedMapTile.setMapEntityStatus(MapEntityStatus.INACTIVE);
            } else if (enhancedMapTile.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getEnhancedMapTiles().remove(i);
            }
        }
        return activeEnhancedMapTiles;
    }

    // determine which npcs are active (exist and are within range of the camera)
    private ArrayList<NPC> loadActiveNPCs() {
        ArrayList<NPC> activeNPCs = new ArrayList<>();
        for (int i = map.getNPCs().size() - 1; i >= 0; i--) {
            NPC npc = map.getNPCs().get(i);

            if (isMapEntityActive(npc)) {
                activeNPCs.add(npc);
                if (npc.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    npc.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
            } else if (npc.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                npc.setMapEntityStatus(MapEntityStatus.INACTIVE);
            } else if (npc.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getNPCs().remove(i);
            }
        }
        return activeNPCs;
    }

    // determine which trigger map tiles are active (exist and are within range of the camera)
    private ArrayList<Trigger> loadActiveTriggers() {
        ArrayList<Trigger> activeTriggers = new ArrayList<>();
        for (int i = map.getTriggers().size() - 1; i >= 0; i--) {
            Trigger trigger = map.getTriggers().get(i);

            if (isMapEntityActive(trigger)) {
                activeTriggers.add(trigger);
                if (trigger.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    trigger.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
            } else if (trigger.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                trigger.setMapEntityStatus(MapEntityStatus.INACTIVE);
            } else if (trigger.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getTriggers().remove(i);
            }
        }
        return activeTriggers;
    }

    /*
        determines if map entity (enemy, enhanced map tile, or npc) is active by the camera's standards
        1. if entity's status is REMOVED, it is not active, no questions asked
        2. if an entity is hidden, it is not active
        3. if entity's status is not REMOVED and the entity is not hidden, then there's additional checks that take place:
            1. if entity's isUpdateOffScreen attribute is true, it is active
            2. OR if the camera determines that it is in its boundary range, it is active
     */
    private boolean isMapEntityActive(MapEntity mapEntity) {
        return mapEntity.getMapEntityStatus() != MapEntityStatus.REMOVED && !mapEntity.isHidden() && mapEntity.exists() && (mapEntity.isUpdateOffScreen() || containsUpdate(mapEntity));
    }

    public void draw(GraphicsHandler graphicsHandler) {
        drawMapTilesBottomLayer(graphicsHandler);
        drawMapTilesTopLayer(graphicsHandler);
    }

    public void draw(Player player, GraphicsHandler graphicsHandler) {
        drawMapTilesBottomLayer(graphicsHandler);
        drawMapEntities(player, graphicsHandler);
        drawMapTilesTopLayer(graphicsHandler);
    }

    // draws the bottom layer of visible map tiles to the screen
    // this is different than "active" map tiles as determined in the update method -- there is no reason to actually draw to screen anything that can't be seen
    // so this does not include the extra range granted by the UPDATE_OFF_SCREEN_RANGE value
    public void drawMapTilesBottomLayer(GraphicsHandler graphicsHandler) {
        Point tileIndex = getTileIndexByCameraPosition();
        for (int i = tileIndex.y - 1; i <= tileIndex.y + height + 1; i++) {
            for (int j = tileIndex.x - 1; j <= tileIndex.x + width + 1; j++) {
                MapTile tile = map.getMapTile(j, i);
                if (tile != null) {
                    tile.drawBottomLayer(graphicsHandler);
                }
            }
        }

        for (EnhancedMapTile enhancedMapTile : activeEnhancedMapTiles) {
            if (containsDraw(enhancedMapTile)) {
                enhancedMapTile.drawBottomLayer(graphicsHandler);
            }
        }
    }

    // draws the top layer of visible map tiles to the screen where applicable
    public void drawMapTilesTopLayer(GraphicsHandler graphicsHandler) {
        Point tileIndex = getTileIndexByCameraPosition();
        for (int i = tileIndex.y - 1; i <= tileIndex.y + height + 1; i++) {
            for (int j = tileIndex.x - 1; j <= tileIndex.x + width + 1; j++) {
                MapTile tile = map.getMapTile(j, i);
                if (tile != null && tile.getTopLayer() != null) {
                    tile.drawTopLayer(graphicsHandler);
                }
            }
        }

        for (EnhancedMapTile enhancedMapTile : activeEnhancedMapTiles) {
            if (containsDraw(enhancedMapTile) && enhancedMapTile.getTopLayer() != null) {
                enhancedMapTile.drawTopLayer(graphicsHandler);
            }
        }
    }

    // draws active map entities to the screen
    public void drawMapEntities(Player player, GraphicsHandler graphicsHandler) {
        ArrayList<NPC> drawNpcsAfterPlayer = new ArrayList<>();

        // goes through each active npc and determines if it should be drawn at this time based on their location relative to the player
        // if drawn here, npc will later be "overlapped" by player
        // if drawn later, npc will "cover" player
        for (NPC npc : activeNPCs) {
            if (containsDraw(npc)) {
                if (npc.getBounds().getY() < player.getBounds().getY1()  + (player.getBounds().getHeight() / 2f)) {
                    npc.draw(graphicsHandler);
                }
                else {
                    drawNpcsAfterPlayer.add(npc);
                }
            }
        } 
        //Draws the active projectiles to the screen
        for(Projectile projectile : activeProjectiles ) {
        	if (containsDraw(projectile)) { 
        		projectile.draw(graphicsHandler);
        	}
        } 
        //Draws the active enemies to the screen 
        for(Enemy enemy : activeEnemies) {
        	if(containsDraw(enemy)) {
        		enemy.draw(graphicsHandler);
        	}
        } 
        
        //Draws collectible acorn
        for(CollectibleItem collectible : activeCollectibles) {
        	if(containsDraw(collectible)) {
        		collectible.draw(graphicsHandler);
        	}
        }
        
        //Draws the active power-ups to the screen 
        for(PowerUp powerUp : activePowerUps) {
        	if(containsDraw(powerUp)) {
        		powerUp.draw(graphicsHandler);
        	}
        }
        //Draws the active spawners to the screen 
        for(Spawner spawner : activeSpawners) {
        	if(containsDraw(spawner)) {
        		spawner.draw(graphicsHandler);
        	}
        }
        
        // player is drawn to screen
        player.draw(graphicsHandler);

        // npcs determined to be drawn after player from the above step are drawn here
        for (NPC npc : drawNpcsAfterPlayer) {
            npc.draw(graphicsHandler);
        } 

        // Uncomment this to see triggers drawn on screen
        // helps for placing them in the correct spot/debugging
        
        for (Trigger trigger : activeTriggers) {
            if (containsDraw(trigger)) {
                trigger.draw(graphicsHandler);
            }
        }
        
    }


    // checks if a game object's position falls within the camera's current radius
    public boolean containsUpdate(GameObject gameObject) {
        return getX1() - (tileWidth * UPDATE_OFF_SCREEN_RANGE) < gameObject.getX() + gameObject.getWidth() &&
                getEndBoundX() + (tileWidth * UPDATE_OFF_SCREEN_RANGE) > gameObject.getX() &&
                getY1() - (tileHeight * UPDATE_OFF_SCREEN_RANGE) <  gameObject.getY() + gameObject.getHeight()
                && getEndBoundY() + (tileHeight * UPDATE_OFF_SCREEN_RANGE) > gameObject.getY();
    }

    // checks if a game object's position falls within the camera's current radius
    // this does not include the extra range granted by the UPDATE_OFF_SCREEN_RANGE value, because there is no point to drawing graphics that can't be seen
    public boolean containsDraw(GameObject gameObject) {
        return getX1() - tileWidth < gameObject.getX() + gameObject.getWidth() && getEndBoundX() + tileWidth > gameObject.getX() &&
                getY1() - tileHeight <  gameObject.getY() + gameObject.getHeight() && getEndBoundY() + tileHeight >  gameObject.getY();
    }

    public ArrayList<EnhancedMapTile> getActiveEnhancedMapTiles() {
        return activeEnhancedMapTiles;
    }

    public ArrayList<NPC> getActiveNPCs() {
        return activeNPCs;
    }

    public ArrayList<Trigger> getActiveTriggers() {
        return activeTriggers;
    }

    // gets end bound X position of the camera (start position is always 0)
    public float getEndBoundX() {
        return x + (width * tileWidth) + leftoverSpaceX;
    }

    // gets end bound Y position of the camera (start position is always 0)
    public float getEndBoundY() {
        return y + (height * tileHeight) + leftoverSpaceY;
    }

    public boolean isAtTopOfMap() {
        return this.getY() <= 0;
    }

    public boolean isAtBottomOfMap() {
        return this.getEndBoundY() >= map.getEndBoundY();
    } 
    
    //Determines which projectiles are on screen and return them 
    private ArrayList<Projectile> loadActiveProjectiles() {
        ArrayList<Projectile> activeProjectiles = new ArrayList<>();
        for (int i = map.getProjectiles().size() - 1; i >= 0; i--) {
            Projectile projectile = map.getProjectiles().get(i);

            if (isMapEntityActive(projectile)) {
                activeProjectiles.add(projectile);
                if (projectile.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    projectile.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
                
            } 
            else if (projectile.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                projectile.setMapEntityStatus(MapEntityStatus.INACTIVE);
                
            } 
            else if (projectile.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getProjectiles().remove(i);
            }
        }
        return activeProjectiles;
    } 
    
    //Returns active projectiles 
    public ArrayList<Projectile> getActiveProjectiles() {
    	return activeProjectiles;
    }
    
    //Same as for projectiles 
    //Determines which enemies are on screen and return them 
    private ArrayList<Enemy> loadActiveEnemies() {
        ArrayList<Enemy> activeEnemies = new ArrayList<>();
        for (int i = map.getEnemies().size() - 1; i >= 0; i--) {
            Enemy enemy = map.getEnemies().get(i);

            if (isMapEntityActive(enemy)) {
                activeEnemies.add(enemy);
                if (enemy.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    enemy.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
                
            } 
            else if (enemy.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                enemy.setMapEntityStatus(MapEntityStatus.INACTIVE);
                
            } 
            else if (enemy.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getEnemies().remove(i);
            }
        }
        return activeEnemies;
    } 
    
    //Returns active enemies
    public ArrayList<Enemy> getActiveEnemies() {
    	return activeEnemies;
    } 
    
    //Determines which power-ups are on the screen and returns them 
    private ArrayList<PowerUp> loadActivePowerUps() {
    	ArrayList<PowerUp> activePowerUps = new ArrayList(); 
    	for (int i = map.getPowerUps().size() - 1; i >= 0; i--) {
            PowerUp powerUp = map.getPowerUps().get(i);

            if (isMapEntityActive(powerUp)) {
                activePowerUps.add(powerUp);
                if (powerUp.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    powerUp.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
                
            } 
            else if (powerUp.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                powerUp.setMapEntityStatus(MapEntityStatus.INACTIVE);
                
            } 
            else if (powerUp.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getPowerUps().remove(i);
            }
        }
        return activePowerUps;
    } 
    
    //Returns active power-ups 
    public ArrayList<PowerUp> getActivePowerUps() {
    	return activePowerUps;
    } 
    
    //Determines which spawners are on the screen and returns them 
    private ArrayList<Spawner> loadActiveSpawners() {
    	ArrayList<Spawner> activeSpawners = new ArrayList(); 
    	for (int i = map.getSpawners().size() - 1; i >= 0; i--) {
            Spawner spawner = map.getSpawners().get(i);

            if (isMapEntityActive(spawner)) {
                activeSpawners.add(spawner);
                if (spawner.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    spawner.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
                
            } 
            else if (spawner.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                spawner.setMapEntityStatus(MapEntityStatus.INACTIVE);
                
            } 
            else if (spawner.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getSpawners().remove(i);
            }
        }
        return activeSpawners;
    } 
    
    //Returns active spawners
    public ArrayList<Spawner> getActiveSpawners() {
    	return activeSpawners;
    }
    
    private ArrayList<CollectibleItem> loadActiveCollectibles() {
        ArrayList<CollectibleItem> activeCollectibles = new ArrayList<>();
        for (int i = map.getCollectibles().size() - 1; i >= 0; i--) {
            CollectibleItem collectible = map.getCollectibles().get(i);

            if (isMapEntityActive(collectible)) {
                activeCollectibles.add(collectible);
                if (collectible.mapEntityStatus == MapEntityStatus.INACTIVE) {
                    collectible.setMapEntityStatus(MapEntityStatus.ACTIVE);
                }
                
            } 
            else if (collectible.getMapEntityStatus() == MapEntityStatus.ACTIVE) {
                collectible.setMapEntityStatus(MapEntityStatus.INACTIVE);
                
            } 
            else if (collectible.getMapEntityStatus() == MapEntityStatus.REMOVED) {
                map.getCollectibles().remove(i);
            }
        }
        return activeCollectibles;
    }

	public ArrayList<CollectibleItem> getActiveCollectibles() {
		return activeCollectibles;
	}
}
