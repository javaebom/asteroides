package com.professordelphi.telas;

import java.awt.Image;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.asteroide.Missil;
import com.professordelphi.asteroide.Nave;
import com.professordelphi.engine.Cenario;

public class Fase01 extends Cenario {
	Image imgFundo, imgNave, imgAsteroides;
	public Nave nave;
	public Missil missil;

	public Fase01(JApplet applet) {
		super(null);
		try{
			
			nave = new Nave(applet, this);
		    addPrintable(nave);//diciona a nave na lista de objetos da fase
		    
		    
		    imgFundo = applet.getImage(new URL(applet.getDocumentBase(),"img/fundo ok.jpg"));
		    setImgFundo(imgFundo);
		    
		    setBounds(0, 0, 500, 500);
		    
		    this.repaint();
		    
		}catch(Exception e){
			
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
