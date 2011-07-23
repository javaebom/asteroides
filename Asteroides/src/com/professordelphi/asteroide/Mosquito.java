package com.professordelphi.asteroide;

import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.Sprite;

public class Mosquito extends Sprite {
	private boolean explodindo = false;
	
	public Mosquito(JApplet applet,Cenario c)throws Exception {
		super(applet.getImage(new URL(applet.getDocumentBase(),"img/mosquito.png")));
		
		addQuadro(0  , 0, 32 , 32); // - 0
		addQuadro(32 , 0, 64 , 32); // - 1

		addQuadro(64 , 0, 96 , 32); // - 2
		addQuadro(96 , 0, 128, 32); // - 3
		addQuadro(128, 0, 160, 32); // - 4
		
		this.setHeight(32);
		this.setWidth(32);
		this.reset();
		setPasso(1);
		c.addPrintable(this);		
	}
	
	/**Reinicia o Objeto
	 * 
	 */
	public void reset(){
		this.setLocation((int)((Math.random()*500)-this.getWidth())+getWidth(), 
				(int)(Math.random()*60));
		explodindo = false;
		setQuadroAtual(0);		
	}
	
	@Override
	public void paint(java.awt.Graphics g){
		super.paint(g);
		if(getTop()>=500-100)
			explodindo = true;

		if(getTime()%5==0) 
			if(!explodindo){
				if(getTime()%10==0)
					setQuadroAtual(getQuadroAtual()==0?1:0);
				descer();
			}
			else{
				if (getQuadroAtual()<4)
					if(getTime()%20==0)
						setQuadroAtual(getQuadroAtual()+1);
					else descer();
					else
						reset();
			}
	}	

}
