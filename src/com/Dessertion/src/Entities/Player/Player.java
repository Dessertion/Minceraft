package com.Dessertion.src.Entities.Player;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import com.Dessertion.src.Entities.Entity;
import com.Dessertion.src.Entities.Player.Inventory.Inventory;
import com.Dessertion.src.Entities.Player.Inventory.InventoryGui;
import com.Dessertion.src.Entities.Player.Inventory.Material;
import com.Dessertion.src.Tiles.World;


public class Player extends Entity {
	

	private static String fileString = "/player.png";
	protected Inventory inventory;
	protected int curSlot = 0;
	protected InventoryGui GUI;
	public Player(World world) {
		super(fileString,world);
		this.setX(0);
		this.setY(0);
		this.inventory = new Inventory(this);
		this.GUI=new InventoryGui(this);
	}
	
	@Override
	public void render(Graphics g, ImageObserver obs) {
		super.render(g, obs);
		GUI.render(g, obs);
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
		if(keyCode>=KeyEvent.VK_0&&keyCode<=KeyEvent.VK_9) {
			if(keyCode==KeyEvent.VK_0)this.curSlot=1;
			else this.curSlot=(keyCode-KeyEvent.VK_1);
		}
		//haha crafting amirite
		if(keyCode==KeyEvent.VK_C&&inventory.getItemSlot(curSlot).getMaterial()==Material.LOG) {
			
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
	
	public int getCurSlot() {
		return this.curSlot;
	}
	
	public void setCurSlot(int slot) {
		if(slot<=9&&slot>=0)this.curSlot=slot;
	}
	public InventoryGui getInventoryGui() {
		return this.GUI;
	}
}
