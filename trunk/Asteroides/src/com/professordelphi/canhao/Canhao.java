package com.professordelphi.canhao;

import com.professordelphi.engine.view.TelaPadrao;

public class Canhao extends TelaPadrao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4182748336163526433L;

	public Canhao() {
		this.setFase(new Fase01(this));
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Canhao().setVisible(true);

	}

}
