package model;

import java.awt.Image;
import java.awt.Rectangle;

public abstract class Sprite {
	
	protected int width, heigth;
	private boolean isVisible;
	
	protected int positionX, positionY;
	protected int updateCoordinatesX, updateCoordinatesY;
	
	protected Image imageSprite;
	
	
	public int getWidth() {
		return width;
	}

	public int getHeigth() {
		return heigth;
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public Image getImageSprite() {
		return imageSprite;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(positionX, positionY, width, heigth);
	}
	
}
