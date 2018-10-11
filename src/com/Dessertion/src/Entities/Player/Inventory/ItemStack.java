package com.Dessertion.src.Entities.Player.Inventory;

import com.Dessertion.src.GameCore.Sprite;
import com.Dessertion.src.Tiles.Tile;
import com.Dessertion.src.Tiles.TileGrass;
import com.Dessertion.src.Tiles.TileLog;

public class ItemStack extends Sprite {

	protected String fileString;
	private int stackCount = 0;
	private Material material;
	private boolean destroyFlag = false;

	public ItemStack(String fileString) {
		super(fileString);
		this.fileString = fileString;
		this.stackCount = 1;
	}
	public ItemStack(String fileString, int num) {
		this(fileString);
		this.stackCount=num;
	}

	public ItemStack(Material material) {
		this(getFileString(material));
		this.material = material;
	}
	public ItemStack(Material material, int num) {
		this(material);
		this.stackCount=num;
	}

	public ItemStack(Tile tile) {
		this(Material.getMaterial(tile));
	}
	public ItemStack(Tile tile, int num) {
		this(tile);
		this.stackCount=num;
	}

	public Material getMaterial() {
		return this.material;
	}

	public int getStackCount() {
		return this.stackCount;
	}

	public void setStackCount(int stackCount) {
		this.stackCount = stackCount;
	}

	public boolean getDestroyFlag() {
		return destroyFlag;
	}

	public void setDestroyFlag(boolean flag) {
		this.destroyFlag = flag;
	}

	public void decreaseStackCount(int decr) {
		if (decr >= stackCount||stackCount<=0)
			this.setDestroyFlag(true);
		stackCount -= decr;
	}

	public void increaseStackCount(int incr) {
		stackCount += incr;
	}

	public static String getFileString(Material material) {
		String thing = "/";
		switch (material) {
		case GRASS:
			thing = thing + "itemGrass";
			break;
		case LOG:
			thing = thing + "itemLog";
			break;
		case LEAVES:
			thing = thing + "itemLeaves";
			break;
		case WOOD:
			thing = thing + "itemWood";
			break;
		default:
			thing = thing + "noTexture";
			break;
		}
		return thing + ".png";
	}

}
