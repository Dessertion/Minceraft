package com.Dessertion.src.Tiles;

import java.awt.Color;

import com.Dessertion.src.GameCore.Sprite;

public class Tile extends Sprite {
	
	protected boolean transparent = false;
	
	public Tile(String fileString) {
		super(fileString);
	}
	
	public boolean isTransparent() {
		return transparent;
	}
	
	
}



