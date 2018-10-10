package com.Dessertion.src.Entities;

import com.Dessertion.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.net.MalformedURLException;
import java.net.URL;


public class Player extends Entity {
	
	private int dx,dy;
	private static String fileString = "/player.png";
	public Player() {
		super(fileString);
		this.setX(0);
		this.setY(0);
	}
	
	
	
	@Override
	public void move() {
		super.move();
		this.setX(this.getX()+dx);
		this.setY((int)(this.getY()+this.getVy()));
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_A)dx=-2;
		if(keyCode==KeyEvent.VK_D)dx=2;
		//if(keyCode==KeyEvent.VK_S)this.setVy(this.getVy()+0.5);
		if(keyCode==KeyEvent.VK_W) {
			if(isOnGround()) {
				this.setIsJumping(true);
				this.setVy(-2);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_A)dx=0;
		if(keyCode == KeyEvent.VK_D)dx=0;
		if(keyCode==KeyEvent.VK_W) {
			this.setIsJumping(false);
		}
		//if(keyCode == KeyEvent.VK_S)this.setVy(this.getVy());
		
	}

}
