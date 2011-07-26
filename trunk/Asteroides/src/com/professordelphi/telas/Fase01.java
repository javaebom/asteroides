package com.professordelphi.telas;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.asteroide.Asteroide;
import com.professordelphi.asteroide.Missil;
import com.professordelphi.asteroide.Mosquito;
import com.professordelphi.asteroide.Nave;
import com.professordelphi.engine.Cenario;

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
		    addPrintable(new Mosquito(applet, this));
		    
		    
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
    /**Registra um ataque , a intencidade diz quando de life a nave irá perder.
     * 
     * @param intencidade
     */
	public void perda(int intencidade){
    	nave.ataque(intencidade);
    	perdas++;
    }
	
	public void acerto(){
		acertos ++;
	}
	
	@Override 
	public void paint(java.awt.Graphics g){
		super.paint(g);
		g.setColor(Color.black);
		g.drawString("Pontos : " + acertos, 10, 10);
		g.drawString("Perdas : " + perdas, 10, 30);
	}
}
