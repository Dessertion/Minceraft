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
	private static double vy = 0, vx = 0;
	private static boolean onGround = false, touchingTop = false, touchingLeft = false, touchingRight = false;
	private static boolean jumping = false;
	
	public Entity(String fileString) {
		super(fileString);
	}
	
	public void move() {
		checkCollision();
		int arrPos = World.getTile(getX(), getY());
		
		//handle jumping
		if(onGround&&!jumping) {
			Entity.vy=0;
		}
		else {
		if(onGround&&jumping) {
			Entity.vy=-2;
		}
		else {
			Entity.vy+=grav;
			setY((int)(getY()+vy));
		}
		}
	}
	
	public double getVy() {
		return vy;
	}
	
	public void setVy(double v) {
		Entity.vy = v;
	}
	
	public void setIsJumping(boolean flag) {
		Entity.jumping = flag;
	}
	
	public boolean isJumping() {
		return jumping;
	}
	
	private void checkCollision() {
		int calcY = getY() + getH(), calcX = getX() + getW();
		int xcy = World.getTile(getX(), calcY), cxcy = World.getTile(calcX, calcY), xy = World.getTile(getX(), getY()),cxy = World.getTile(calcX, getY());
		if(calcY>=GameFrame.HEIGHT) {
			Entity.onGround=true;
			Entity.vy=0;
		}
		else {
			int l = World.getTile(getX(), calcY+5), r = World.getTile(calcX, calcY+5);
			if(!World.tiles[l].isTransparent()||!World.tiles[r].isTransparent()) {
				Entity.onGround = true;
				Entity.vy=0;
			}
			else Entity.onGround = false;
		}
		
		if(calcX>=GameFrame.WIDTH) {
			Entity.touchingRight=true;
		}
		else {
			int top = World.getTile(calcX+1, getY()), bot = World.getTile(calcX+1, calcY-1);
			if(!World.tiles[top].isTransparent()||!World.tiles[bot].isTransparent()) {
				Entity.touchingRight=true;
			}
			else Entity.touchingRight=false;
		}
		
		if(getX()<=0) {
			Entity.touchingLeft=true;
		}
		else {
			int top = World.getTile(getX()-1, getY()), bot = World.getTile(getX()-1, calcY-1);
			if(!World.tiles[top].isTransparent()||!World.tiles[bot].isTransparent())Entity.touchingLeft=true;
			else Entity.touchingLeft = false;
		}
		
		
	}
	
	public boolean isOnGround() {
		return onGround;
	}

	public boolean isTouchingTop() {
		return touchingTop;
	}

	public void setTouchingTop(boolean touchingTop) {
		Entity.touchingTop = touchingTop;
	}

	public boolean isTouchingLeft() {
		return touchingLeft;
	}

	public void setTouchingLeft(boolean touchingLeft) {
		Entity.touchingLeft = touchingLeft;
	}

	public boolean isTouchingRight() {
		return touchingRight;
	}

	public void setTouchingRight(boolean touchingRight) {
		Entity.touchingRight = touchingRight;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		Entity.vx = vx;
	}
	
	
	
	
	
}



