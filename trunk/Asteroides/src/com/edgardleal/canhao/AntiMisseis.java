package com.edgardleal.canhao;

import com.edgardleal.engine.view.TelaPadrao;

public class AntiMisseis extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4182748336163526433L;

	public AntiMisseis() {
		this.setFase(new Fase01(this));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new AntiMisseis().setVisible(true);

	}

}
