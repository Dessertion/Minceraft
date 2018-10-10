package com.Dessertion.src.GameCore;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

import com.Dessertion.src.Entities.Player;

public class MyMouseListener implements MouseInputListener{
    
    MouseInputListener ml;
    Player player;
    public MyMouseListener(Player player) {
	this.player = player;
	
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	player.mousePressed(e);
	//player.setMousePressed(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	player.mouseReleased(e);
	//player.setMousePressed(false);
	//System.out.println("afwfw");
	
    }

    @Override
    public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	player.mousePressed(e);
	//if(e.isConsumed())player.mouseReleased(e);
	//System.out.println("afwfwf");
	
    }

    @Override
    public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
	
    }
    
}



