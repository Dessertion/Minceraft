package com.Dessertion.src.Entities.Player.Inventory;

import com.Dessertion.src.Entities.Player.Player;

public class Inventory {
	
	protected Player player;
	protected ItemStack[] invenArr;
	public Inventory(Player player) {
		this.player=player;
		invenArr = new ItemStack[10];
	}
	public ItemStack getItemSlot(int slot) {
		return invenArr[slot];
	}
	public ItemStack[] getInventory() {
		return invenArr;
	}
	public void setItemSlot(int slot, ItemStack item) {
		invenArr[slot] = item;
	}
	public void incrementItemSlot(int slot) {
		invenArr[slot].increaseStackCount(1);
	}
	public void decrementItemSlot(int slot) {
		invenArr[slot].decreaseStackCount(1);
	}
	public void update() {
		for(int i = 0 ; i < 10 ; i++) {
			if(invenArr[i]!=null&&invenArr[i].getDestroyFlag())invenArr[i]=null;
		}
	}
	public int checkForEmptySlot() {
		for(int i = 0; i < 10 ; i++) {
			if(invenArr[i]==null)return i;
		}
		return -1;
	}
	public int checkForSlotType(Material material) {
		for(int i = 0 ; i < 10 ; i++) {
			if(invenArr[i]!=null&&invenArr[i].getMaterial()==material)return i;
		}
		return -1;
	}
}



