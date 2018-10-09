package com.Dessertion.src.GameCore;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.Dessertion.Tiles.World;
import com.Dessertion.src.Entities.Player;

public class GamePanel extends JPanel implements ActionListener
{
	
	private Timer timer;
	private final int DELAY = 16;
	private Player player;
	private World world;
	
	public GamePanel() {
	   init();
	}
	
	private void init() {
	  
	   world = new World(); 
	    
	   setFocusable(true);
	   setDoubleBuffered(true);
	   
	   try {
		player = new Player();
	   } catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
	   addKeyListener(new MyKeyListener(player));
	   
	   timer = new Timer(DELAY,this);
	   timer.start();
	   
	   
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   advance();
	}
	
	private void advance() {
	   player.move();
	   repaint();
	 
	}
	
	private void render(Graphics g) {
		//player.render(g, this);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		render(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
}
 