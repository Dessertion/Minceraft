package com.Dessertion.src.Tiles;

public class TileAir extends Tile {
	
	public static String fileString = "/tileAir.png";
	
	
	
	public TileAir() {
		super(fileString);
		transparent = true;
	}
	
	public TileAir(Tile tile) {
		super(tile.fileString);
		transparent = true;
	}
	
}



