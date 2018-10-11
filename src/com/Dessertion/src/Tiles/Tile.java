package com.Dessertion.src.Tiles;

import com.Dessertion.src.GameCore.Sprite;

public class Tile extends Sprite {
	
	protected boolean transparent = false;
	protected int destroyTime;
	protected String fileString;
	
	public Tile(String fileString) {
		super(fileString);
		this.fileString=fileString;
	}
	
	public boolean isTransparent() {
		return transparent;
	}
	
	
}



