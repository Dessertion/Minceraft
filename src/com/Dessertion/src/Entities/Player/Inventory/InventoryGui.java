package com.Dessertion.src.Entities.Player.Inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Dessertion.src.Entities.Player.Player;
import com.Dessertion.src.GameCore.Sprite;

public class InventoryGui {
	
	protected Player player;
	protected Inventory inventory;
	protected BufferedImage hotbar, selected;
	protected final int hotbarX = 150, hotbarY = 520;
	protected static Sprite[] sprites;
	
	public InventoryGui(Player player) {
		 this.player=player;
		 this.inventory=player.getInventory();
		 sprites = new Sprite[10];
		 try {
			hotbar = ImageIO.read(getClass().getResource("/com/Dessertion/resources/hotbar.png"));
			selected = ImageIO.read(getClass().getResource("/com/Dessertion/resources/selected.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g, ImageObserver obs) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(hotbar,hotbarX,hotbarY,hotbar.getWidth(),hotbar.getHeight(),obs);
		Font font = new Font("Consolas", Font.BOLD,16);
		g2d.setColor(Color.magenta);
		for(int i = 0 ; i < 10 ; i++) {
			if(sprites[i]!=null) {
				g2d.setFont(font);
				sprites[i].render(g, obs);
				if(inventory.getItemSlot(i)!=null)g2d.drawString(Integer.toString(inventory.getItemSlot(i).getStackCount()), sprites[i].getX()+25, sprites[i].getY()+40);
			}
		}
		g2d.drawImage(selected, 150+player.getCurSlot()*49, 520, selected.getWidth(), selected.getHeight(), obs);
	}
	
	public BufferedImage getHotbarImage() {
		return hotbar;
	}
	
	public void update() {
		for(int i = 0 ; i < 10; i ++) {
			if(player.getInventory().getItemSlot(i)!=null){
				Sprite sp = new Sprite(player.getInventory().getItemSlot(i).fileString);
				sp.setX(155+i*48);
				sp.setY(525);
				sprites[i] = sp;
			}
			else sprites[i] = null;
		}
	}
	
	
	public int getHotbarX() {
		return hotbarX;
	}
	public int getHotbarY() {
		return hotbarY;
	}
}



