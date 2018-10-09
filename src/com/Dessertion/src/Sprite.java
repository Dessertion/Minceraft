package com.Dessertion.src;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Sprite {
	
	private int x, y, w, h;
	private BufferedImage image;
	private URL url;
	private String urlString = "src/com/Dessertion/resources";
	
	public Sprite(String name) throws MalformedURLException {
		url = new URL(urlString + name);
		try {
			loadImage(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadImage(URL url) throws IOException {
		image = ImageIO.read(url);
		w = image.getWidth();
		h = image.getHeight();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public URL getURL() {
		return url;
	}
	
	
}
