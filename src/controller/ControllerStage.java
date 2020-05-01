package controller;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Timer;

import model.Enemy;
import model.Missile;
import model.Nave;
import view.WindowStage;

/*
 * Controla o movimento da nave e Atualiza o WindowStage(Panel)
 */

public class ControllerStage implements ActionListener {
	
	private WindowStage windowStage;
	private Nave nave;
	
	Timer timer;
		
	public ControllerStage(WindowStage windowStage) {
		
		this.windowStage = windowStage;
		this.nave = windowStage.getNave();
	
		windowStage = new WindowStage();

		timer = new Timer(5, this);
		timer.start();

		keyListener();
		
	}

	public void keyListener() {
		windowStage.addKeyListener(new TecladoTeste());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(windowStage.getEnemies().size() == 0) {
			windowStage.setGameWins(true);
			windowStage.setStartGame(false);
		}
		
		addMissile();
		addEnemy();
		
		nave.moveNave();
		observeColision();
		
		windowStage.repaint();
	}
	
	public void addMissile() {
		
		List<Missile> missiles = nave.getMissiles();

		for (int i = 0; i < missiles.size(); i++) {
			Missile m = (Missile) missiles.get(i);

			if (m.isVisible()) {
				m.moveMissile();
			} else {
				missiles.remove(i);
			}
		}
	}
	
	public void addEnemy() {
		
		List<Enemy> enemies = windowStage.getEnemies();
		
		for (int i = 0; i < enemies.size(); i++) {
			Enemy en = (Enemy) enemies.get(i);

			if (en.isVisible()) {
				en.moveEnemy();
			} else {
				enemies.remove(i);
			}
		}
	}
	
	public void observeColision() {
		
		Rectangle formNave = nave.getBounds();
		Rectangle formEnemy;
		Rectangle formMissile;
		
		for(int i = 0; i < windowStage.getEnemies().size(); i++) {
			
			Enemy temporaryEnemy = windowStage.getEnemies().get(i);
			formEnemy = temporaryEnemy.getBounds();
			
			if(formNave.intersects(formEnemy)) {
				
				nave.setVisible(false);
				temporaryEnemy.setVisible(false);
				windowStage.setStartGame(false);
			}
		}
		
		List<Missile> missiles = nave.getMissiles();
		
		for(int i = 0; i < missiles.size(); i++) {
			 Missile temporaryMissile = missiles.get(i);
			 formMissile = temporaryMissile.getBounds();
			 
			 for(int j = 0; j < windowStage.getEnemies().size(); j++) {
				 
				 Enemy temporaryEnemy = windowStage.getEnemies().get(j);
				 formEnemy = temporaryEnemy.getBounds();
				 
				 if(formMissile.intersects(formEnemy)) {
					 
					 temporaryEnemy.setVisible(false);
					 temporaryMissile.setVisible(false);
				 }
				 
			 }
		}
		
	}

	public class TecladoTeste extends KeyAdapter {
		// Pegar eventos do Teclado Feitos na Classe Nave

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				windowStage.setStartInitial(false);
				
				windowStage.setStartGame(true);
				windowStage.setGameWins(false);
				new Nave();
				windowStage.startEnemies();
			}
			
			if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				System.exit(0);
			}
			
			nave.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}
	}

}
