package com.professordelphi.canhao;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.CenarioListener;

public class Fase01 extends Cenario {

	public Fase01(CenarioListener c) {
		super(c);
		this.addPrintable(new Projetil());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
