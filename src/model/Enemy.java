package model;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {

	private static final int WIDTH_SCREEN = 500;
	private static final int SPEED = 1;

	private static int counter = 0;

	public Enemy(int positionX, int postitionY) {

		this.positionX = positionX;
		this.positionY = postitionY;

		if (counter++ % 3 == 0) {
			imageSprite = new ImageIcon("resource\\inimigo_2.gif").getImage();

		} else {
			imageSprite = new ImageIcon("resource\\inimigo_1.gif").getImage();

		}

		this.width = imageSprite.getWidth(null);
		this.heigth = imageSprite.getHeight(null);

		setVisible(true);

	}

	public void moveEnemy() {

		if (this.positionX < 0) {
			this.positionX = WIDTH_SCREEN;

		} else {
			this.positionX -= SPEED;
		}
	}

}
