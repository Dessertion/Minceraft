package com.Dessertion.src.GameCore;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SunCycle {
	
	
	public BufferedImage sun=null,moon=null;
	private static boolean isDay = true;
	private static double x,y;
	private Color nightC = new Color(71,42,191,155);
	public SunCycle() {
		try {
			sun = ImageIO.read(getClass().getResource("/com/Dessertion/resources/sun.png"));
			moon = ImageIO.read(getClass().getResource("/com/Dessertion/resources/moon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g, ImageObserver obs) {
		Graphics2D g2d = (Graphics2D) g;
		if(isDay)g2d.drawImage(sun,(int)x,(int)y,sun.getWidth(),sun.getHeight(),obs);
		else {
		
			g2d.setColor(nightC);
			g2d.fillRect(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
			g2d.drawImage(moon,(int)x,(int)y,sun.getWidth(),sun.getHeight(),obs); 
		}
	}
	
	public void move(int t) {
		this.x=t;
		this.y=GameFrame.HEIGHT+(2.5/3600)*(x+500)*(x-1300);
	}
	
	public boolean getIsDay() {
		return this.isDay;
	}
	
	public void setIsDay(boolean flag) {
		this.isDay=flag;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
}



