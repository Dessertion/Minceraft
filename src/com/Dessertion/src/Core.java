package com.Dessertion.src;

import java.awt.EventQueue;

public class Core
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(() -> {
			GameFrame frame = new GameFrame();
			frame.setVisible(true);
		});
	}

}
