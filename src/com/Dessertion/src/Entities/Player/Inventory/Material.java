package com.Dessertion.src.Entities.Player.Inventory;

import com.Dessertion.src.Tiles.*;

public enum Material {
	AIR,GRASS,LOG,WOOD,LEAVES;
	
	public static Material getMaterial(Tile tile) {
		if(tile instanceof TileGrass)return GRASS;
		if(tile instanceof TileLog)return LOG;
		return AIR;
	}
}



