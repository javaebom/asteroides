package com.professordelphi.asteroide;

import java.awt.Color;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.Sprite;
import com.professordelphi.telas.Fase01;

public class Asteroide extends Sprite{

	private boolean explodindo = false;
	private Cenario c=null;
	public Asteroide(JApplet applet,Cenario c) throws Exception{
		super(applet.getImage(new URL(applet.getDocumentBase(),"img/enemy1.png")));
		this.addQuadro(0, 1, 32, 31);       // 0
		this.addQuadro(32, 1, 32+32, 31);   // 1
		this.addQuadro(67, 3, 26+67, 26+3); // 2
		this.addQuadro(99, 3, 26+99, 26+3); // 3 

		/* Explos�o */
		this.addQuadro(133, 6, 21+133, 22+6); // 4
		this.addQuadro(165, 6, 22+165, 6+22); // 5
		this.addQuadro(197, 6, 22+197, 22+6); // 6


		this.setHeight(32);
		this.setWidth(32);
		this.reset();
		setPasso(2);
		c.addPrintable(this);
	    this.c = c;
	}

	@Override
	public void paint(java.awt.Graphics g){
		super.paint(g);
		if(getTop()>=500){
			reset();
			if(c instanceof Fase01) ((Fase01)c).perda(5);
		}
		if(getTime()%5==0) 
			if(!explodindo){
				if(getTime()%20==0)
					setQuadroAtual((getQuadroAtual()+1)%3);
				descer();
			}
			else{
				if (getQuadroAtual()<6)
					if(getTime()%20==0)
						setQuadroAtual(getQuadroAtual()+1);
					else descer();
					else
						reset();
			}
	}

	public void reset(){
		this.setLocation((int)((Math.random()*500)-this.getWidth())+getWidth(), 
				(int)(Math.random()*60));
		explodindo = false;
		setLife(100);
		setQuadroAtual(0);
	}

	public boolean isExplodindo() {
		return explodindo;
	}

	private void setExplodindo(boolean explodindo) {
		this.explodindo = explodindo;
	}

	public void explodir(){
		if(explodindo) return ;		
		setExplodindo(true);
	}
	
	@Override 
	public boolean ataque(int intencidade){
		super.ataque(intencidade);
		if(getLife()<=0 && !explodindo) explodir();
		return false;
	}
}
