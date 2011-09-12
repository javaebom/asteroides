package com.edgardleal.canhao;

import java.awt.Toolkit;

import com.edgardleal.engine.Cenario;
import com.edgardleal.engine.Sprite;
import com.edgardleal.engine.Vetor;

public class Canhao extends Sprite {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4182748336163526433L;
	private Cenario cenario;
	public Canhao(Cenario c) {
		super(Toolkit.getDefaultToolkit().getImage("C:\\Users\\edgard.leal\\Dropbox\\Projetos\\Java\\Asteroides\\bin\\img\\Cannon2.png"));
		this.cenario = c;
		for (int i = 0; i < 21; i++) {
			getTimeline().add(i*50,0,i*50+50,55,i==4?0:-1,10);
		}
		
		this.atrito.setRaio(4);
		this.setBounds(400, 400, 50, 55);	
	}
	
	@Override 
	public void mover(Vetor gravidade){
		
	}

	@Override 
	public void onFrameChange(int frame){
		if(frame==4) cenario.addPrintable(new Bala());
	}
}
