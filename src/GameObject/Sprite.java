package GameObject;

import java.awt.Color;
import java.awt.image.BufferedImage;

import Engine.GraphicsHandler;
import Engine.ImageLoader;

// This class is for representing a Sprite, which is essentially a Rectangle with an image attached
// it also includes an attribute for "bounds", which can be thought of a sub rectangle on the image where it can be interacted with (like for collisions)
public class Sprite extends Rectangle implements IntersectableRectangle {
	protected BufferedImage image;
    protected Rectangle bounds;
    protected ImageEffect imageEffect;

    public Sprite (BufferedImage image) {
        super(0, 0, image.getWidth(), image.getHeight());
        this.image = image;
        this.bounds = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        this.imageEffect = ImageEffect.NONE;
    }

    public Sprite (BufferedImage image, float x, float y) {
        super(x, y, image.getWidth(), image.getHeight());
        this.image = image;
        this.bounds = new Rectangle(0, 0, image.getWidth(), image.getHeight(), scale);
        this.imageEffect = ImageEffect.NONE;;
    }

    public Sprite(BufferedImage image, float x, float y, ImageEffect imageEffect) {
        super(x, y, image.getWidth(), image.getHeight());
        this.image = image;
        this.bounds = new Rectangle(0, 0, image.getWidth(), image.getHeight(), scale);
        this.imageEffect = imageEffect;
    }
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void setImage(String imageFileName) {
		image = ImageLoader.load(imageFileName);
	}

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public ImageEffect getImageEffect() { return imageEffect; }

    public void setImageEffect(ImageEffect imageEffect) {
        this.imageEffect = imageEffect;
    }

    public float getBoundsX1() {
        return x + (bounds.getX1() * scale);
    }

    public float getBoundsX2() {
        return getBoundsX1() + bounds.getWidth();
    }

    public float getBoundsY1() {
        return y + (bounds.getY1() * scale);
    }

    public float getBoundsY2() {
        return getBoundsY1() + bounds.getHeight();
    }

    public Rectangle getBounds() {
        return new Rectangle(getBoundsX1(), getBoundsY1(), bounds.getWidth(), bounds.getHeight());
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = new Rectangle(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight(), scale);
    }

    public void setBounds(float x, float y, int width, int height) {
        this.bounds = new Rectangle(x, y, width, height, scale);
    }

    public Rectangle getIntersectRectangle() {
        return getBounds();
    }

    @Override
	public void update() {
		super.update();
	}
	
	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		graphicsHandler.drawImage(image, Math.round(getX()), Math.round(getY()), getWidth(), getHeight(), imageEffect);
	}

	public void drawBounds(GraphicsHandler graphicsHandler, Color color) {
        Rectangle scaledBounds = getBounds();
        scaledBounds.setColor(color);
        scaledBounds.draw(graphicsHandler);
    }

    @Override
    public String toString() {
        return String.format("Sprite: x=%s y=%s width=%s height=%s bounds=(%s, %s, %s, %s)", getX(), getY(), getWidth(), getHeight(), getBoundsX1(), getBoundsY1(), getBounds().getWidth(), getBounds().getHeight());
    }
}
