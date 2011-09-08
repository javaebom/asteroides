package com.professordelphi.canhao;

import java.awt.Color;

import com.professordelphi.engine.Sprite;

public class Projetil extends Sprite {

    	
	 
	public Projetil() {
		super(null);
		setWidth(10);
		setHeight(10);
		setLocation(10, 10);
		
	}
	public void paint(java.awt.Graphics g){
		g.setColor(Color.black);
		g.fillOval(this.getLeft(), this.getTop(), this.getWidth(), this.getHeight());
	}
}
