package com.Dessertion.src.Entities;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.Dessertion.src.Tiles.World;


public class Player extends Entity {
	
	private int dx,dy, mx,my, prevmx, prevmy;
	private static String fileString = "/player.png";
	private boolean mousePressed = false;
	public Player() {
		super(fileString);
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
		//if(keyCode == KeyEvent.VK_S)this.setVy(this.getVy());
		
	}
	
	public void mousePressed(MouseEvent e) {
	    this.mousePressed=true;
	    this.setPrevMouseX(mx);
	    this.setPrevMouseY(my);
	    this.mx=e.getX();
	    this.my=e.getY();
	}
	
	public void mouseReleased(MouseEvent e) {
	    this.mousePressed=false;
	    //System.out.println("WFWFW");
	}

	public boolean isMousePressed() {
	    return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
	    this.mousePressed = mousePressed;
	}

	
	public int getMouseX() {
	    return mx;
	}
	
	public void setMouseX(int mouseX) {
	    this.mx = mouseX;
	}
	
	public int getMouseY() {
	    return this.my;
	}
	
	public void setMouseY(int mouseY) {
	    this.my = mouseY;
	}

	public int getPrevMouseX() {
	    return prevmx;
	}

	public void setPrevMouseX(int prevmx) {
	    this.prevmx = prevmx;
	}

	public int getPrevMouseY() {
	    return prevmy;
	}

	public void setPrevMouseY(int prevmy) {
	    this.prevmy = prevmy;
	}

}
