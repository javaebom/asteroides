package com.edgardleal.canhao;

import java.awt.Toolkit;

import com.edgardleal.engine.Sprite;

public class Canhao extends Sprite {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4182748336163526433L;

	public Canhao() {
		super(Toolkit.getDefaultToolkit().getImage("img\\Cannon.png"));
		getTimeline().add(6, 20, 50, 55);
		this.setBounds(200, 300, 44, 49);	
	}


}
