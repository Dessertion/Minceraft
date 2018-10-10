package com.Dessertion.src.Entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.net.URL;

import com.Dessertion.src.GameCore.GameFrame;
import com.Dessertion.src.GameCore.Sprite;
import com.Dessertion.src.Tiles.World;

public class Entity extends Sprite
{	
	
	private static final double grav = 0.05;
	private static double vy = 0;
	private static boolean onGround = false;
	private static boolean jumping = false;
	
	public Entity(String fileString) {
		super(fileString);
	}
	
	public void move() {
		checkOnGround();
		int arrPos = World.getTile(getX(), getY());
		if(onGround&&!jumping) {
			vy=0;
		}
		else {
		vy+=grav;
		setY((int)(getY()+vy));
		}
	}
	
	public double getVy() {
		return vy;
	}
	
	public void setVy(double v) {
		vy = v;
	}
	
	public void setIsJumping(boolean flag) {
		jumping = flag;
	}
	
	public boolean isJumping() {
		return jumping;
	}
	
	private void checkOnGround() {
		int calcY = getY() + getH(), calcX = getX() + getW();
		if(calcY>=GameFrame.HEIGHT) {
			onGround=true;
			return;
		}
		int t1 = World.getTile(getX(), calcY), t2 = World.getTile(calcX, calcY);
		if(!World.tiles[t1].isTransparent()||!World.tiles[t2].isTransparent())onGround = true;
		else onGround = false;
	}
	
	public boolean isOnGround() {
		return onGround;
	}
	
	
	
	
	
}



