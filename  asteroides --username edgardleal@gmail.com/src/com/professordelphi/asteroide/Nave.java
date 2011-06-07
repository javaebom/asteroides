package com.professordelphi.asteroide;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.Sprite;

public class Nave extends Sprite{

	private Missil missil;
	private Cenario cenario;

	public Nave(JApplet a,Cenario c)throws MalformedURLException {
		super(a.getImage( new URL(a.getDocumentBase(),"img/nave2.png")));
		//System.out.println(new URL(a.getDocumentBase(),"img/nave2.png"));
		addQuadro(10, 0, 42, 40);
		addQuadro(10, 50, 41, 90);
		addQuadro(9, 100, 41, 140);
		setX1(250);
		setY1(370);
		setWidth(24);
		setHeight(32);
		missil = new Missil(a);
		this.cenario = c;
		c.addPrintable(missil);

		//---------------------------------------------

	}
	@Override
	public void paint(Graphics g) {
		switch(tecla){
		case 37:esquerda();
		break;
		case 39:direita();
		break;
		case 32:missil.setLocation(this.getX1(), this.getY1());
		
		missil.show();
		break;
		}
		super.paint(g);
	}
}
