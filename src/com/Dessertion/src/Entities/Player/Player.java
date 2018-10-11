package com.Dessertion.src.Entities.Player;

import java.awt.event.KeyEvent;

import com.Dessertion.src.Entities.Entity;
import com.Dessertion.src.Entities.Player.Inventory.Inventory;
import com.Dessertion.src.Tiles.World;


public class Player extends Entity {
	

	private static String fileString = "/player.png";
	protected Inventory inventory;
	public Player(World world) {
		super(fileString,world);
		this.setX(0);
		this.setY(0);
		this.inventory = new Inventory(this);
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
	

	public Inventory getInventory() {
		return this.inventory;
	}
	

}
