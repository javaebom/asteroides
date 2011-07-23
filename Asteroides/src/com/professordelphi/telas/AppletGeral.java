package com.professordelphi.telas;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JApplet;

import com.professordelphi.engine.MediaCenter;

public class AppletGeral extends JApplet implements KeyListener{
	
	Fase01 inicio,cenario;
	Container tela;
	int x = 0;
	Graphics g;
	Image imgFundo;
	URL urlFundo;
	MediaCenter mediaCenter;
	
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
		mediaCenter = new MediaCenter(this);
		
		tela = this.getContentPane();
		this.setLayout(null);/*Desativa o gerenciador de Layout*/
		try{
			mediaCenter.add("img/mosquito.png");
			mediaCenter.add("img/enemy1.png");
//			mediaCenter.add("img/enemy2.png");
//			mediaCenter.add("img/fundo ok.jpg");
//			mediaCenter.add("img/misseis.png");
//			mediaCenter.add("img/mosquito.png");
			mediaCenter.add("http://3.bp.blogspot.com/-S3O4zwxgrMw/TYaET-9DkoI/AAAAAAAADnk/9uwpLzA_YIU/s1600/mapa_salvador_turistico.jpg");
//			mediaCenter.add("http://1.bp.blogspot.com/-YgHUtwI2taQ/TfI1BcKzbUI/AAAAAAAADgo/DZnBw9HWFzQ/s1600/luana%2Bpiovani%2B2.jpg");
//			mediaCenter.start();
			
			inicio = new Fase01(this);// Criação do cenário que recebe o endereço na aplet no construtor
			tela.add(inicio);// Adicionando o cenário 'inicio' no container
			this.addKeyListener(this);
			this.requestFocus();
			
		}catch(Exception e){
			e.printStackTrace();
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
