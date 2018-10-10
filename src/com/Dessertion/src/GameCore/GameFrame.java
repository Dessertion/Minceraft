package com.Dessertion.src.GameCore;

import javax.swing.JFrame;

public class GameFrame extends JFrame{	
	
	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	
	public GameFrame() {
		initUI();
		
	}
	private void initUI() {
		add(new GamePanel());
		setSize(WIDTH,HEIGHT);
		setResizable(false);
		setTitle("Minceraft");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
