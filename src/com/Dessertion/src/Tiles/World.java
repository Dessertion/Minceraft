package com.Dessertion.src.Tiles;

import java.awt.Color; 
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;

import com.Dessertion.src.GameCore.BMPReader;
import com.Dessertion.src.GameCore.Sprite;
import com.Dessertion.src.Tiles.*;

public class World {
	
	public static final int WIDTH_T = 16, HEIGHT_T = 12, MAX_T = WIDTH_T*HEIGHT_T, LEN = 50;
	public static Tile[] tiles;
	public static final int greenColorInt = Color.GREEN.getRGB();
	public static boolean RERENDER = false;
	private static int[] fileData;
	private File worldBMP;
	private BMPReader reader;
	BufferedImage worldImg; 
	
	public World(String worldFileString) {
		this.tiles = new Tile[WIDTH_T*HEIGHT_T];
		loadFromFile(worldFileString);
		reader = new BMPReader();
		fileData = reader.toRGBData(worldImg);
		init();
	}
	
	private void loadFromFile(String fileString) {
		try {
			worldImg = ImageIO.read(getClass().getResource(Sprite.urlString+fileString));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void render(Graphics g, ImageObserver obs) {
		for(int i = 0 ; i < MAX_T; i ++) {
			tiles[i].render(g, obs);
		}
	}
	
	public void render(Graphics g, ImageObserver obs, int tile) {
		tiles[tile].render(g, obs);
	}
	
	private void init() {
		for(int i = 0; i < MAX_T; i++) {
			int tileColor = fileData[i];
			int y = (i/WIDTH_T)*LEN;
			int x = (i-(i/WIDTH_T)*WIDTH_T)*LEN;
			Color curColor = new Color(tileColor);
			tiles[i] = handleColor(tileColor);
			tiles[i].setX(x);
			tiles[i].setY(y);
			tiles[i].setH(LEN);
			tiles[i].setW(LEN);
		}
	}
	
	private Tile handleColor(int c) { 
		if(c==greenColorInt)return new TileGrass();
		return new TileAir();
	}
	
	public static int getTile(int x, int y) {
		return (y/LEN)*WIDTH_T+(x/LEN);
	}
	
	public void destroyTile(int tileNum) {
		Tile temp = new TileAir();
		temp.setX(tiles[tileNum].getX()); temp.setY(tiles[tileNum].getY());
		tiles[tileNum] = temp;
	}
	
	public <T extends Tile> void placeTile(int tileNum, Class<T> tileType){
		try {
			Tile tile = tileType.getConstructor(null).newInstance();
			tile.setX(tiles[tileNum].getX()); tile.setY(tiles[tileNum].getY());
			tiles[tileNum] = tile;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
}



