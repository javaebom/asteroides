package com.professordelphi.telas;

import java.awt.Color;
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
	
	/**Coment�rios para o Javadoc para o m�todo Init
	 * 
	 */
	@Override 
	public void init(){
		setSize(500, 500);
		tela = this.getContentPane();
		this.setLayout(null);/*Desativa o gerenciador de Layout*/
		try{
			
			inicio = new Fase01(this);// Cria��o do cen�rio que recebe o endere�o na aplet no construtor
			inicio.setBounds(0,0,800,600);// Setagem das dimens�es. Argumentos do setbounds (x,y,w,h)
			inicio.setBackground(Color.MAGENTA);// Setagem da cor de fundo. Essa cor n�o ser� exibida pois 
			tela.add(inicio);// Adicionando o cen�rio 'inicio' no container
			
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
