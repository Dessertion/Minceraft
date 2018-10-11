package com.Dessertion.src.Entities.Player.Inventory;

import com.Dessertion.src.Entities.Entity;
import com.Dessertion.src.Tiles.World;

public class Item extends Entity {
	
	protected String fileString;
	protected World world;
	public Item(String fileString, World world) {
		super(fileString, world);
		this.fileString=fileString;
		this.world = world;
	}
	
}



