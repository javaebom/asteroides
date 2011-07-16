package com.professordelphi.asteroide;

import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.Sprite;

public class Nave extends Sprite{

	private Missil missil;
	//private Cenario cenario; pode ser utilizado posteriormente para tratamento de explosões

	public Nave(JApplet a,Cenario c)throws MalformedURLException {
		super(a.getImage( new URL(a.getDocumentBase(),"img/nave2.png")));
		//System.out.println(new URL(a.getDocumentBase(),"img/nave2.png"));
		addQuadro(10, 0, 42, 40);
		addQuadro(10, 50, 41, 90);
		addQuadro(9, 100, 41, 140);
		setLocation(250, 400);
		setWidth(24);
		setHeight(32);
		missil = new Missil(a);
		//this.cenario = c;
		setPasso(1.5);
		c.addPrintable(missil);

		//---------------------------------------------

	}
	@Override
	public void paint(Graphics g) {
		if(teclas[37]) esquerda();
		if(teclas[39])direita();
		if(teclas[32]) {
			missil.setLocation(this.getX1()+(getWidth()/2)-6, this.getY1());
			missil.show();
		}
		super.paint(g);
		nextFrame();//muda para o proximo quadro
	}//paint
}//class
