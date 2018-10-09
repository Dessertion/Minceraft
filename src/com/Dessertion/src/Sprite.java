package com.Dessertion.src;

import com.Dessertion.*;
import java.awt.image.BufferedImage;
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
	private URL url;
	private String urlString = "src/com/Dessertion/resources";
	
	public Sprite(URL url) throws MalformedURLException {
		this.url = url;
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

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
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
	
	
	
}
