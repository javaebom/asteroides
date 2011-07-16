package com.professordelphi.telas;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JApplet;

public class AppletGeral extends JApplet implements KeyListener{
	
	Fase01 inicio,cenario;
	Container tela;
	int x = 0;
	Graphics g;
	Image imgFundo;
	URL urlFundo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**Comentários para o Javadoc para o método Init
	 * 
	 */
	@Override 
	public void init(){
		setSize(500, 500);
		tela = this.getContentPane();
		this.setLayout(null);/*Desativa o gerenciador de Layout*/
		try{
			
			inicio = new Fase01(this);// Criação do cenário que recebe o endereço na aplet no construtor
			tela.add(inicio);// Adicionando o cenário 'inicio' no container
			this.addKeyListener(this);
			this.requestFocus();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void stop(){
	}

	public void keyPressed(KeyEvent key) {
		inicio.keyDown((byte)key.getKeyCode());
		inicio.notifyTecla((byte)key.getKeyCode());
		if (key.getKeyChar()==27) {
			inicio.pause();
		}
	}

	public void keyReleased(KeyEvent key) {
		inicio.keyUp((byte)key.getKeyCode());
	}

	public void keyTyped(KeyEvent key) {
		
	}
}
