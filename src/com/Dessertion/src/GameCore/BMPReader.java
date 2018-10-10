package com.Dessertion.src.GameCore;

import java.awt.image.BufferedImage;

public class BMPReader {
	
	//private int width, height;
//	private BufferedImage image;
	
	public BMPReader() {
	}
	
	public int[] toRGBData(BufferedImage image) {
		int width = image.getWidth(), height = image.getHeight();
		int[] ret = new int[width*height];
		for(int i = 0 ; i < height; i++) {
			for(int j = 0; j < width; j++) {
				ret[j+i*width] = image.getRGB(j, i);
			}
		}
		return ret;
	}
}



