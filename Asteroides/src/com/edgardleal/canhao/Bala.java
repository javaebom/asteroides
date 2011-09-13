package com.edgardleal.canhao;

import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;

import com.edgardleal.engine.Colidivel;
import com.edgardleal.engine.Sprite;
import com.edgardleal.engine.Vetor;

public class Bala extends Sprite {


	public Bala(){
		super(Toolkit.getDefaultToolkit().getImage("C:\\Documents and Settings\\Edgard.HOME-DD4C0A08CC\\Meus documentos\\Dropbox\\Projetos\\Java\\Asteroides\\bin\\img\\bol.png"));
		if(!new File("C:\\Documents and Settings\\Edgard.HOME-DD4C0A08CC\\Meus documentos\\Dropbox\\Projetos\\Java\\Asteroides\\bin\\img\\bol.png").exists()) {
			System.out.println("O arquivo não existe");
			System.exit(0);
		}
		setBounds(425, 425, 16, 16);
		//		setVisible(true);
		getTimeline().add(0,0,16,16,0,5);
		atrito.setRaio(0.8);
		this.setVisible(false);
		aceleracao.setRaio(1);
		aceleracao.setDirecaoGraus(15);
	}

	@Override 
	public void mover(Vetor gravidade){
		super.mover(gravidade);
		if(this.getY1()> 500 || this.getX1()>500 || this.getX1()<0) this.setVisible(false);
	}

	@Override
	public void update(ArrayList<Colidivel> lista){
		if(!this.isVisible()) return;
		super.update(lista);
	}

}
