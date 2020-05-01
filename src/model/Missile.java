package model;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Missile extends Sprite{
		
	private static final int WIDTH_SCREEN = 500;
	private static final int SPEED = 2;
	
	public Missile(int positionX, int positionY) {
		
		this.positionX = positionX;
		this.positionY = positionY;
				
		try {
			imageSprite = new ImageIcon("resource\\missel.png").getImage();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Image not found!");
			System.out.println("Mensagem" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		
		this.width = imageSprite.getWidth(null);
		this.heigth = imageSprite.getHeight(null);
	
		setVisible(true);
	}
	
	public void moveMissile() {
		
		this.positionX += SPEED;
		
		if(this.positionX > WIDTH_SCREEN) {
			setVisible(false);
		}
	}
	
}
