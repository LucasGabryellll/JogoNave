package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.BackgraundGame;
import model.Enemy;
import model.Missile;
import model.Nave;

/*
 * Classe que coloca pinta:
 * o Fundo e a Nave
 */

public class WindowStage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BackgraundGame backgraundGame;
	Nave nave;

	private boolean startInitial;
	private boolean startGame;
	private boolean gameWins;

	private List<Enemy> enemies;

	private int[][] coordinates = { { 2480, 29 }, { 2700, 59 }, { 1480, 89 }, { 880, 109 }, { 680, 139 }, { 980, 239 },
			{ 890, 259 }, { 960, 50 }, { 890, 150 }, { 2080, 209 }, { 660, 45 }, { 610, 70 }, { 1030, 159 },
			{ 690, 80 }, { 630, 60 }, { 1040, 59 }, { 1090, 30 }, { 920, 200 }, { 900, 259 }, { 760, 50 }, { 740, 90 },
			{ 910, 220 }, { 960, 20 }, { 840, 180 }, { 920, 128 }, { 590, 170 }, { 800, 30 }, { 1020, 300 },
			{ 956, 328 }, { 556, 320 } };

	public WindowStage() {
		
		focusasableObjects();

		backgraundGame = new BackgraundGame();
		nave = new Nave();

		startInitial = true;
		startGame = false;
		gameWins = false;

		startEnemies();

	}

	public void focusasableObjects() {
		setDoubleBuffered(true);
		setFocusable(true);
	}

	public void startEnemies() {
		enemies = new ArrayList<Enemy>();

		for (int i = 0; i < coordinates.length; i++) {
			enemies.add(new Enemy(coordinates[i][0], coordinates[i][1]));
		}
	}

	public void paint(Graphics g) {
		// pintar na tela os objetos

		Graphics2D graphics = (Graphics2D) g;
		
		if(startInitial) {
			ImageIcon inicial = new ImageIcon("resource\\inicial.png");
			graphics.drawImage(inicial.getImage(), 0, 0, null);
			
		} else {
			graphics.drawImage(backgraundGame.getBackgraund(), 0, 0, null);

			
			if (startGame) {
				
				graphics.drawImage(nave.getImageSprite(), nave.getPositionX(), nave.getPositionY(), this);

				List<Missile> missiles = nave.getMissiles();

				for (int i = 0; i < missiles.size(); i++) {
					Missile m = (Missile) missiles.get(i);
					graphics.drawImage(m.getImageSprite(), m.getPositionX(), m.getPositionY(), this);

				}

				for (int i = 0; i < enemies.size(); i++) {

					Enemy en = enemies.get(i);
					graphics.drawImage(en.getImageSprite(), en.getPositionX(), en.getPositionY(), this);

				}

				graphics.setColor(Color.WHITE);
				graphics.drawString("ENEMIES: " + enemies.size(), 5, 15);

			} else {
				ImageIcon endGame = new ImageIcon("resource\\game_over.jpg");

				graphics.drawImage(endGame.getImage(), 0, 0, null);
			}

			if (gameWins) {
				ImageIcon gameWins = new ImageIcon("resource\\fundoWins.png");

				graphics.drawImage(gameWins.getImage(), 0, 0, null);
			}
		}
	
		g.dispose();
	}

	public BackgraundGame getBackgraundGame() {
		return backgraundGame;
	}

	public Nave getNave() {
		return nave;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public boolean isStartGame() {
		return startGame;
	}

	public void setStartGame(boolean startGame) {
		this.startGame = startGame;
	}

	public void setGameWins(boolean gameWins) {
		this.gameWins = gameWins;
	}

	public boolean isStartInitial() {
		return startInitial;
	}

	public void setStartInitial(boolean startInitial) {
		this.startInitial = startInitial;
	}
}
