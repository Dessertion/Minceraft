package com.Dessertion.src.Tiles;

import java.awt.Color;

import com.Dessertion.src.GameCore.Sprite;

public class Tile extends Sprite {
	
	protected boolean transparent = false;
	protected int destroyTime;
	
	public Tile(String fileString) {
		super(fileString);
	}
	
	public boolean isTransparent() {
		return transparent;
	}
	
	
}



