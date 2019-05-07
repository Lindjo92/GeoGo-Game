
package client;

import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class StartMenu extends JPanel implements ActionListener {
	private JButton bnSingle = new JButton("Singleplayer");
	private JButton bnMulti = new JButton("Multiplayer");
	private JButton bnRules = new JButton("Game rules");
	private Image image;
	private JFrame frame;
	private ControllerGUI controller;

	public StartMenu() {
		this.setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 400)); // The games outer panel
		this.getLayout();

		// Add buttons to this panel
		bnSingle.setBounds(240, 80, 130, 30);// GridbagLayout, dynamiska layouter
		add(bnSingle);
		bnMulti.setBounds(240, 160, 130, 30);
		add(bnMulti);
		bnRules.setBounds(240, 240, 130, 30);
		add(bnRules);

		// Add actionelisteners
		bnSingle.addActionListener(this);
		bnMulti.addActionListener(this);
		bnRules.addActionListener(this);
		try {
			image = ImageIO.read(new File("images/worldmap2.jpg"));
			JLabel label = new JLabel(new ImageIcon(image));
			this.add(label);

		} catch (IOException ex) {
			System.out.print("Image exception" + ex);
		}
	}

	void showUI() {
		frame = new JFrame("GeoGo-mapLocator");
//			setUserMenu();
//	      setUserList();
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object input = e.getSource();
		if (input.equals(bnSingle)) {
			singlePlayer();
			dispose();
		} else if (input.equals(bnMulti)) {
//				multiPlayer();
			dispose();
		} else if (input.equals(bnRules)) {
			gameRules();
			dispose();
		}
	}

	public void dispose() {
		frame.dispose();
	}

	public void singlePlayer() {
		String name = JOptionPane.showInputDialog("Create a user"); // inte ha null h�r?
		controller.addLocalUser(name);
		controller.getLocalUsers();
//		controller.setUserMenu();?
		GameMenu game = new GameMenu();
		game.showUI();
	}

	public void gameRules() {
		System.out.println("Add what happens when pressed button Game Rules");
		JOptionPane.showMessageDialog(null, "The task of a player of GeoGo is to estimate the locations of different cities on a worldmap. "
				+ "\n"
				+ "A score is then given the player as a result of the difference in distance between the estimated spot and the actual location."
				+ "\n" + "Players can choose what part of the world him or her wishes to play in." + "\n" + "\n" + "Upgrade your geographical knowledge now!");
	}

}