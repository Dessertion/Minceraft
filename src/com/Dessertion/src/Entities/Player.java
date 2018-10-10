package com.Dessertion.src.Entities;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.Dessertion.src.Tiles.World;


public class Player extends Entity {
	

	private static String fileString = "/player.png";

	public Player(World world) {
		super(fileString,world);
		this.setX(0);
		this.setY(0);
	}
	
		
	
	@Override
	public void move() {
		super.move();
		if(!(this.getVx()>0&&this.isTouchingRight())&&!((this.getVx()<0)&&this.isTouchingLeft()))this.setX((int)(this.getX()+this.getVx()));
		if(!(this.getVy()<0&&this.isTouchingTop()))this.setY((int)(this.getY()+this.getVy()));
		else this.setVy(0);
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode==KeyEvent.VK_A) {
			if(!this.isTouchingLeft())this.setVx(-2);
		}
		if(keyCode==KeyEvent.VK_D) {
			if(!this.isTouchingRight())this.setVx(2);
		}
		if(keyCode==KeyEvent.VK_W) {
			if(isOnGround()) {
				this.setIsJumping(true);
				this.setVy(-2);
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_A) {
			if(!this.isTouchingLeft()&&this.getVx()<0)this.setVx(this.getVx()+2);
			else this.setVx(0);
		}
		if(keyCode == KeyEvent.VK_D) {
			if(!this.isTouchingRight()&&this.getVx()>0)this.setVx(this.getVx()-2);
			else this.setVx(0);
		}
		if(keyCode==KeyEvent.VK_W) {
			this.setIsJumping(false);
		}
		
	}
	

	

}
