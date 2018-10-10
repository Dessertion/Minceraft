package com.Dessertion.src.GameCore;

import com.Dessertion.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sprite {
	
	
	private int x;
	private int y;
	private int w;
	private int h;
	private BufferedImage image = null;
	public static  String urlString = "/com/Dessertion/resources";
	
	public Sprite(String fileString) {
		try {
			loadImage(fileString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadImage(String fileString) throws IOException {
		image = ImageIO.read(getClass().getResource(urlString+fileString));
		w = image.getWidth();
		h = image.getHeight();
	}
	
	
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void render(Graphics g, ImageObserver obs) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getImage(), getX(), getY(), obs);
	}

	
}
