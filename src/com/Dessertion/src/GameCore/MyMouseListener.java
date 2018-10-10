package com.Dessertion.src.GameCore;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

import com.Dessertion.src.Entities.Player;
import com.Dessertion.src.Tiles.World;

public class MyMouseListener implements MouseInputListener{
	private int mx,my, prevmx, prevmy, mTile = 0;
	private boolean mousePressed = false;
    MouseInputListener ml;
    Player player;
    public MyMouseListener(Player player) {
    	this.player = player;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	
    }

    @Override
    public void mouseExited(MouseEvent e) {
    	
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        this.mousePressed=true;
	    this.setPrevMouseX(mx);
	    this.setPrevMouseY(my);
	    this.mx=e.getX();
	    this.my=e.getY();
	    if(this.mx>=0&&this.mx<=GameFrame.WIDTH&&this.my>=0&&this.my<=GameFrame.HEIGHT) {
	    	this.setMouseTile(World.getTile(this.mx, this.my));
	    }
	    if(e.getButton() == e.BUTTON1) {
	    	player.getWorld().destroyTile(mTile);
	    	player.getWorld().RERENDER=true;
	    }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	this.mousePressed=false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	mousePressed(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	
    }
    
    
    
    
    public boolean isMousePressed() {
	    return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
	    this.mousePressed = mousePressed;
	}

	
	public int getMouseX() {
	    return mx;
	}
	
	public void setMouseX(int mouseX) {
	    this.mx = mouseX;
	}
	
	public int getMouseY() {
	    return this.my;
	}
	
	public void setMouseY(int mouseY) {
	    this.my = mouseY;
	}

	public int getPrevMouseX() {
	    return prevmx;
	}

	public void setPrevMouseX(int prevmx) {
	    this.prevmx = prevmx;
	}

	public int getPrevMouseY() {
	    return prevmy;
	}

	public void setPrevMouseY(int prevmy) {
	    this.prevmy = prevmy;
	}

	public int getMouseTile() {
		return mTile;
	}

	public void setMouseTile(int mTile) {
		this.mTile = mTile;
	}
    
}



