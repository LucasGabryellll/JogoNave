package model;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

//Montar a Imagem de fundo do Jogo
public class BackgraundGame {

	private Image backgraund;

	public BackgraundGame() {
		
		try {
			backgraund = new ImageIcon("resource\\fundo.png").getImage();
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Image not found!");
			System.out.println("Mensagem" + e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}

	}

	public Image getBackgraund() {
		return backgraund;
	}
	
}
