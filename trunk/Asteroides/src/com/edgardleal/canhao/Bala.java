package com.edgardleal.canhao;

import java.awt.Toolkit;

import com.edgardleal.engine.Sprite;
import com.edgardleal.engine.Vetor;

public class Bala extends Sprite {

	
	public Bala(){
		super(Toolkit.getDefaultToolkit().getImage("C:\\Users\\edgard.leal\\Dropbox\\Projetos\\image\\bol.png"));
		
		setBounds(425, 425, 16, 16);
//		setVisible(true);
		getTimeline().add(0,0,16,16,0,5);
		atrito.setRaio(0.8);
		aceleracao.setRaio(1);
		aceleracao.setDirecaoGraus(15);
	}
	
	@Override 
	public void mover(Vetor gravidade){
		super.mover(gravidade);
	}
}
