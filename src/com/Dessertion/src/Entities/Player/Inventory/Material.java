package com.Dessertion.src.Entities.Player.Inventory;

import com.Dessertion.src.Tiles.Tile;
import com.Dessertion.src.Tiles.TileAir;
import com.Dessertion.src.Tiles.TileGrass;
import com.Dessertion.src.Tiles.TileLeaves;
import com.Dessertion.src.Tiles.TileLog;

public enum Material {
	AIR,GRASS,LOG,WOOD,LEAVES;
	
	public static Material getMaterial(Tile tile) {
		if(tile instanceof TileGrass)return GRASS;
		if(tile instanceof TileLog)return LOG;
		if(tile instanceof TileLeaves)return LEAVES;
		return AIR;
	}
	
	public static Tile getTile(Material material) {
		if(material == GRASS)return new TileGrass();
		if(material == LOG)return new TileLog();
		if(material == LEAVES)return new TileLeaves();
		return new TileAir();
	}
}



