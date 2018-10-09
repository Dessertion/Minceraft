package com.Dessertion.src;

import com.Dessertion.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;


public class Player extends Sprite {

	private int dx, dy;
	
	public Player() throws MalformedURLException {
		super(Player.class.getClassLoader().getResource("com/Dessertion/resources/player.png"));
		this.setX(0);
		this.setY(0);
	}
	
	public void render(Graphics g, ImageObserver obs) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getImage(), getX(), getY(), obs);

	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_A)dx=-2;
		if(keyCode==KeyEvent.VK_D)dx=2;
	}
	
	public void move() {
		this.setX(this.getX()+dx);
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_A)dx=0;
		if(keyCode == KeyEvent.VK_D)dx=0;
	}

}
