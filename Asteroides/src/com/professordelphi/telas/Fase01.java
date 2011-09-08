package com.professordelphi.telas;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.asteroide.Asteroide;
import com.professordelphi.asteroide.Missil;
import com.professordelphi.asteroide.Nave;
import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.Colidivel;
import com.professordelphi.engine.Movable;
import com.professordelphi.engine.Printable;
import com.professordelphi.engine.Sprite;

public class Fase01 extends Cenario {
	Image imgFundo, imgNave, imgAsteroides;
	public Nave nave;
	public Asteroide asteroide1, asteroide2;
	public Missil missil;
	private int perdas = 0 , acertos = 0;

	public Fase01(JApplet applet) {
		super(null);
		try{
			nave  = new Nave(applet, this);
		    addPrintable(nave);//diciona a nave na lista de objetos da fase
		    addPrintable(new Asteroide(applet, this));
		    addPrintable(new Asteroide(applet, this));
		    addPrintable(new Asteroide(applet, this));
		    addPrintable(new Asteroide(applet, this));
		    for (int i = 0; i < 30; i++) {
		    	addPrintable(new Asteroide(applet, this));
			}
		    
//		    addPrintable(new Mosquito(applet, this));
		    
		    imgFundo = applet.getImage(new URL(applet.getDocumentBase(),"img/fundo ok.jpg"));
		    setImgFundo(imgFundo);
		    setBounds(0, 0, 500, 500);
		    
		    this.repaint();
		    
		}catch(Exception e){
			System.out.println("erro ao iniciar o fase1");
		}
	}
	
	@Override
	public void addPrintable(Printable p){
		if(p instanceof Missil) System.out.println("Missil sendo adicionado ao cen�rio");
		if(p instanceof Colidivel)
			addColidivel((Colidivel)p);
		super.addPrintable(p);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**Registra um ataque , a intencidade diz quando de life a nave ir� perder.
     * 
     * @param intencidade
     */
	public void perda(int intencidade){
    	nave.ataque(intencidade);
    	perdas++;
    }
	
	public void acerto(){
		acertos ++;
		System.out.println("Acertos = " + acertos);
	}
	
	@Override 
	public void paint(java.awt.Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.drawString("Pontos : " + acertos, 10, 10);
		g.drawString("Perdas : " + perdas, 10, 30);
	}
	@Override
	public void ataque(Movable m,int intencidade ,int x,int y,int x2,int y2){
		for (Printable p:getPrintables()) 
			if (p instanceof Asteroide && p != m) 
				if(x>=((Sprite)p).getX1() && x2<=((Sprite)p).getX2()){
					((Asteroide)p).ataque(intencidade);
					
				}
	}
}