package Level;

import Engine.GraphicsHandler;
import GameObject.SpriteSheet;

public class Weapon {
	
	private int damage;
	private int cost;
	private SpriteSheet image;
	
	public Weapon(int d, int c, SpriteSheet s) {
		image = s;
		damage = d;
		cost = c;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public SpriteSheet getImage() {
		return image;
	}

	public void setImage(SpriteSheet image) {
		this.image = image;
	}
	
	public void draw(GraphicsHandler graphicsHandler) {
		//TODO implement draw method
	}
	
}
