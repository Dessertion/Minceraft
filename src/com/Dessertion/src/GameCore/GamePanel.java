package com.Dessertion.src.GameCore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.Dessertion.src.Entities.Player.Player;
import com.Dessertion.src.Tiles.World;

public class GamePanel extends JPanel implements ActionListener
{
	
	private Timer timer;
	private final int DELAY = 16;
	private Player player;
	private World world;
	private MyKeyListener kl;
	private MyMouseListener ml;
	private SunCycle cycle;
	private int time = -100;
	public static boolean RERENDER = false;
	
	public GamePanel() {
	   init();
	}
	
	private void init() {
	   setBackground(Color.cyan);
	   world = new World("/world.bmp"); 
	   cycle = new SunCycle();
	    
	   setFocusable(true);
	   setDoubleBuffered(true);
	   
	   player = new Player(world);
	   kl = new MyKeyListener(player);
	   ml = new MyMouseListener(player);
	   
	   addKeyListener(kl);
	   addMouseMotionListener(ml);
	   addMouseListener(ml);
	   
	   timer = new Timer(DELAY,this);
	   timer.start();
	   
	   
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	   advance();
	}
	
	private void advance() {
       time++;
       if(time>=GameFrame.WIDTH) {
    	   time=-100;
    	   cycle.setIsDay(cycle.getIsDay()^true);
    	   RERENDER=true;
       }
	   player.move();
	   cycle.move(time);
	   if(RERENDER) {
		   repaint();
		   RERENDER = false;
	   }
	   repaint(player.getX()-25,player.getY()-25,player.getW()+50,player.getH()+50);
	   repaint((int)cycle.getX()-20,(int)cycle.getY()-20,140,140);
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
		
		cycle.render(g, this);
		world.render(g, this);
		player.render(g,this);
		
	}
	
	
}
 