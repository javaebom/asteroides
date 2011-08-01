package com.professordelphi.asteroide;

import java.awt.Color;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.Sprite;
import com.professordelphi.engine.Vetor;

public class Nave extends Sprite{
	private boolean atirando = false;
	private Missil missil;
	private Cenario c=null;
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
		this.c = c;
		vDireita.setXY(.2, 0);
		atrito.setRaio(0.002);
		vEsquerda.setXY(-0.2d, 0);
		aceleracao.setRaioLimite(8);
		aceleracao.setXY(.0, .0);
		//---------------------------------------------

	}
	@Override
	public void paint(Graphics g) {
		if(teclas[37]){
			esquerda();
		}
		if(teclas[39]){
			direita();
		}
		if(teclas[32]) {
			atirando = true;
		}
		if (teclas[66]&&missil.isRead()){
			missil.setLocation(this.getX1()+(getWidth()/2)-6, this.getY1());
			missil.show();			
		}

		if(atirando) {
			g.setColor(Color.cyan);
			g.drawLine(getX1() + getWidth()/2 -1, getY1(), getX1() + getWidth()/2-1, 0);
			g.setColor(Color.white);
			g.drawLine(getX1() + getWidth()/2 , getY1(), getX1() + getWidth()/2, 0);
			g.setColor(Color.cyan);
			g.drawLine(getX1() + getWidth()/2 +1, getY1(), getX1() + getWidth()/2+1, 0);
			atirando = false;
			c.ataque(this,1, getX1() + getWidth()/2 , getY1(), getX1() + getWidth()/2, 0);
		}

		super.paint(g);
		nextFrame();//muda para o proximo quadro
	}//paint

	@Override
	public void direita(){
		if (getX2()>=500) return;
		super.direita();
		/*
		if(aceleracao.getDirecao()>1){
			vDireita.setRaio(aceleracao.getRaio());
			aceleracao.somar(vDireita);
		}
		*/
	}

	@Override
	public void esquerda(){
		if(getX1()<=0) return;
		super.esquerda();
	}
	/**Anula a gravidade.
	 * 
	 */
	@Override 
	public void mover(Vetor gravidade){
		mover();
	}
	@Override
	public void mover(){
		if (getX2()>=500) aceleracao.setXY(-0.5, 0);
		else
			if (getX1()<=0) aceleracao.setXY(0.5, 0);
//		if(aceleracao.getX()>0) atrito.setXY(-.04, 0);
//		else if(aceleracao.getX()<0) atrito.setXY(.04, 0);
//		else
//			atrito.setXY(0, 0);
		super.mover();
	}
	
}//class