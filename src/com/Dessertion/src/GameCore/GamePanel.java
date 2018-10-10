package com.Dessertion.src.GameCore;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.Dessertion.src.Entities.Player;
import com.Dessertion.src.Tiles.World;

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
	  
	   world = new World("/world.bmp"); 
	    
	   setFocusable(true);
	   setDoubleBuffered(true);
	   
	   player = new Player();
	   addKeyListener(new MyKeyListener(player));
	   addMouseMotionListener(new MyMouseListener(player));
	   addMouseListener(new MyMouseListener(player));
	   
	   timer = new Timer(DELAY,this);
	   timer.start();
	   
	   
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   advance();
	}
	
	private void advance() {
	   player.move();
	   if(player.isMousePressed()) {
	       System.out.println(player.getMouseX() + " " + player.getMouseY() + " ||| " + player.getPrevMouseX() + " " + player.getPrevMouseY());
	   }
	   repaint(player.getX()-25,player.getY()-25,player.getW()+50,player.getH()+50);
	 
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		render(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void render(Graphics g) {
		//player.render(g, this);
		Graphics2D g2d = (Graphics2D) g;
		
		world.render(g, this);
		player.render(g,this);
	}
}
 