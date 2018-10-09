package com.Dessertion.src;

import javax.swing.JFrame;

public class GameFrame extends JFrame{	
	public GameFrame() {
		initUI();
		
	}
	private void initUI() {
		add(new GamePanel());
		setSize(800,600);
		setResizable(false);
		setTitle("Minceraft");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
