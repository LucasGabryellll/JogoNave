package model;

import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Nave extends Sprite implements KeyListener{
		
		private List<Missile> missiles;
	
		public Nave() {
		
		try {
			imageSprite = new ImageIcon("resource\\nave.gif").getImage();
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Image not found!");
			System.out.println("Mensagem" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		
		this.heigth = imageSprite.getHeight(null);
		this.width = imageSprite.getWidth(null);
		
		missiles = new ArrayList<Missile>();
		
		this.positionX = 100;
		this.positionY = 100;
		
	}
	
	public void moveNave() {
		
		positionX += updateCoordinatesX; // 1 e 453
		positionY += updateCoordinatesY; // 1 e 330
		
		colisionBorder();
	}
	
	public void colisionBorder() {
		
		if(this.positionX < 1) {
			positionX = 1;
		}
		
		if(this.positionX > 453) {
			positionX = 453;
		}
		
		if(this.positionY < 1) {
			positionY = 1;
		}
		
		if(this.positionY > 360) {
			positionY = 360;
		}
	}
	
	public void useMissile() {
		
		this.missiles.add(new Missile(positionX + this.width , positionY + this.heigth/2));
	}
	
	@Override
	public void keyTyped(KeyEvent key) {
		//Sem necessidade nesse caso
		//Porque não preciso capturar nada que esteja sendo digitado
	}

	@Override
	public void keyPressed(KeyEvent key) {
		
		if(key.getKeyCode() == KeyEvent.VK_SPACE) { useMissile(); }
		
		if(key.getKeyCode() == KeyEvent.VK_UP) { updateCoordinatesY = -1; }
		if(key.getKeyCode() == KeyEvent.VK_DOWN) { updateCoordinatesY = 1; }
		
		if(key.getKeyCode() == KeyEvent.VK_LEFT) { updateCoordinatesX = -1; }
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) { updateCoordinatesX = 1; }
		
	}

	@Override
	public void keyReleased(KeyEvent key) {

		if(key.getKeyCode() == KeyEvent.VK_UP) { updateCoordinatesY = 0; }
		if(key.getKeyCode() == KeyEvent.VK_DOWN) { updateCoordinatesY = 0; }
		
		if(key.getKeyCode() == KeyEvent.VK_LEFT) { updateCoordinatesX = 0; }
		if(key.getKeyCode() == KeyEvent.VK_RIGHT) { updateCoordinatesX = 0; }
	}
	
	public List<Missile> getMissiles() {
		return missiles;
	}
	
}
