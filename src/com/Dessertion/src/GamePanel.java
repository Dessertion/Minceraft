package com.Dessertion.src;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener
{
	
	private Timer timer;
	private final int DELAY = 16;
	
	public GamePanel() {
	   init();
	}
	
	private void init() {
	   addKeyListener(new MyKeyListener());
	   setFocusable(true);
	   setDoubleBuffered(true);
	   
	   timer = new Timer(DELAY,this);
	   timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   advance();
	}
	
	private void advance() {
	   repaint();
	 
	}
	
	private void render() {
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		render();
	}
}
 