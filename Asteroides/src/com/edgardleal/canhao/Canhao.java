package com.edgardleal.canhao;

import java.awt.Toolkit;

import com.edgardleal.engine.Cenario;
import com.edgardleal.engine.Sprite;
import com.edgardleal.engine.Vetor;

public class Canhao extends Sprite {
	Bala balas[] = new Bala[10];
	/**
	 * 
	 */
	private static final long serialVersionUID = -4182748336163526433L;
	private Cenario cenario;
	public Canhao(Cenario c) {
		super(Toolkit.getDefaultToolkit().getImage("C:\\Documents and Settings\\Edgard.HOME-DD4C0A08CC\\Meus documentos\\Dropbox\\Projetos\\Java\\Asteroides\\bin\\img\\Cannon2.png"));
		this.cenario = c;
		for (int i = 0; i < 21; i++) {
			getTimeline().add(i*50,0,i*50+50,55,i==4?0:-1,10);
		}
		for (int i = 0; i < balas.length; i++) 
			cenario.addPrintable(getBala());
		
		this.atrito.setRaio(4);
		this.setBounds(400, 400, 50, 55);	
	}
	
	@Override 
	public void mover(Vetor gravidade){
		
	}

	@Override 
	public void onFrameChange(int frame){
		if(frame==4){
			Bala temp = getBala();
			temp.setVisible(true);
			cenario.addPrintable(temp);
		}
	}
	
	public Bala getBala(){
		for (int i = 0; i < balas.length; i++){
			if(balas[i]==null){
				balas[i] = new Bala();
				return balas[i];
			}
			else
				if(!balas[i].isVisible()) return balas[i];
		}
		return null;
	}
}
