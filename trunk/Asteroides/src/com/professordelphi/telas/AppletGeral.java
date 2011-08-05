package com.professordelphi.telas;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.Cenario;
import com.professordelphi.engine.CenarioListener;
import com.professordelphi.engine.MediaCenter;

public class AppletGeral extends JApplet implements KeyListener, CenarioListener{

	Fase01 inicio;
	Menu1 menu;
	Container tela;
	int x = 0;
	Graphics g;
	Image imgFundo;
	URL urlFundo;
	MediaCenter mediaCenter;

	private static final long serialVersionUID = 1L;

	/**Coment�rios para o Javadoc para o m�todo Init
	 * 
	 */
	@Override 
	public void init(){
		setSize(500, 500);
		mediaCenter = new MediaCenter(this);

		tela = this.getContentPane();
		this.setLayout(null);/*Desativa o gerenciador de Layout*/
		this.addKeyListener(this);
		this.requestFocus();
		try {
			iniciar();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void stop(){
		
	}

	private void iniciar() throws Exception{
		//mediaCenter.add("img/mosquito.png");
		mediaCenter.add("img/enemy1.png");
		mediaCenter.start();
		menu = new Menu1(this);
		//inicio = new Fase01(this);// Cria��o do cen�rio que recebe o endere�o na aplet no construtor
		//tela.add(inicio);// Adicionando o cen�rio 'inicio' no container
		tela.add(menu);
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

	@Override
	public int fim(Cenario sender) {
		System.out.println("Fim de execu��o do menu");
		tela.remove(menu);
		menu = null;
		inicio = new Fase01(this);// Cria��o do cen�rio que recebe o endere�o na aplet no construtor
		tela.add(inicio);// Adicionando o cen�rio 'inicio' no container
		return 0;
	}

}
