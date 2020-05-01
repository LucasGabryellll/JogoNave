package view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/*
 * Receber tudo o que o Controler da fase altera e mostrar na Tela
 * Recebe o WindowStage(Fase) e coloca na Tela
 */

public class WindowsContainer extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private WindowStage windowStage;
	private CardLayout cardLayout;

	public WindowsContainer() {
		
		cardLayout = new CardLayout();
				
		menu();
		
		setTitle("Game Nave");
		setSize(500, 420);
		setLayout(cardLayout);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);

		windowStage = new WindowStage();
		add(windowStage, "g");

		cardLayout.show(getContentPane(), "g");

		setVisible(true);
	}
	
	public void menu() {
		
		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Menu");

		JMenuItem onMenu = new JMenuItem("Sobre");
		onMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Jogo Desenvolvido Com Estrutura: MVC" + "\n" + 
						"Autor: Lucas Gabryel" + "\n" + 
						"Faculdade: UFRPE(uast)", 
						"Informação", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(onMenu);
		menu.add(new JSeparator());
		menu.add(exit);

		menuBar.add(menu);
		
		setJMenuBar(menuBar);
	}

	public void show(String indice) {
		cardLayout.show(getContentPane(), indice);
	}

	public WindowStage getWindowStage() {
		return windowStage;
	}

}
