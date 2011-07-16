package com.professordelphi.telas;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.asteroide.Asteroide;
import com.professordelphi.asteroide.Missil;
import com.professordelphi.asteroide.Nave;
import com.professordelphi.engine.Cenario;

public class Fase01 extends Cenario {
	Image imgFundo, imgNave, imgAsteroides;
	public Nave nave;
	public Asteroide asteroide1, asteroide2;
	public Missil missil;

	public Fase01(JApplet applet) {
		super(null);
		try{
			
		    addPrintable(new Nave(applet, this));//diciona a nave na lista de objetos da fase
		    addPrintable(new Asteroide(applet, this));
		    addPrintable(new Asteroide(applet, this));
		    addPrintable(new Asteroide(applet, this));
		    addPrintable(new Asteroide(applet, this));
		    
		    imgFundo = applet.getImage(new URL(applet.getDocumentBase(),"img/fundo ok.jpg"));
		    File file = new File("img/cenario1.png");
		    if (file.isFile()) {
				System.out.println("arquivo cenario1 encontrado");
			}else
				System.out.println("arquivo não encntrado\n"+
						file.exists());
		    setImgFundo(imgFundo);
		    
		    setBounds(0, 0, 500, 500);
		    
		    this.repaint();
		    
		}catch(Exception e){
			System.out.println("erro ao iniciar o fase1");
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
