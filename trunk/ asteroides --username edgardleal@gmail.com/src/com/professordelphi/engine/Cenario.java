package com.professordelphi.engine;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Cenario extends JPanel implements Runnable{
	Image imgFundo;
	private Thread controle;
	private byte tecla=0;
	private boolean isPause = false;
	private ArrayList<Printable> lista;//Lista de sprites que serão pintados na tela

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cenario(Image imgFundo){//Construtor que recebe a imagem
		super(true);//Diz ao JPanel que ele irá trabalhar com double Buffer
		lista = new ArrayList<Printable>();//Inicialização da lista
		this.imgFundo = imgFundo;//Atribuição da imagem recebida em argumento
		controle = new Thread(this);
		controle.start();
	}
	@Override
	public void paint(Graphics g){//Método que recebe uma imagem a ser pintada na tela
		//super.paint(g);//Reenvio da imagem recebida para o método paint do JPanel
		if(isPause){
			g.fillRect(0, 0, 800, 600);	    	
			return;
		}
		if(imgFundo!=null){//Verifica se a imagem foi passada. Para evitar erros
			g.drawImage(imgFundo,0,0,600,450,800,600,1600,1200,null);//Ele desenha a imagem na tela. g.drawImage(imagem, x-tela, y-tela, largura-tela, altura-tela, x-imagem, y-imagem, largura-imagem, altura-imagem, notificação)
		}
		for(int i=0;i<lista.size();i++){//Varredura da lista
			if(lista.get(i) instanceof Sprite)
				((Sprite)lista.get(i)).notifyTecla(tecla);
			lista.get(i).paint(g);
		}
	}
	public void setImgFundo(Image img){
		this.imgFundo = img;
	}
	public void addPrintable(Printable p){
		lista.add(p);
	}
	@Override
	public void run() {
		while(controle!= null){
			try {
				Thread.sleep(10);
				this.repaint();
			} catch (Exception e) {

			}
		}
	}
	public void pause(){
		isPause = !isPause;
	}
	public void notifyTecla(byte tecla){
		this.tecla = tecla;
		System.out.println("Chamou-2!!!!");
	}
	public void keyDown(byte tecla){
		for(Printable p : lista){
			if(p instanceof Sprite)
				((Sprite)(p)).keyDown(tecla);
		}
	}
	public void keyUp(byte tecla){
		for(Printable p : lista){
			if(p instanceof Sprite)
				((Sprite)(p)).keyUp(tecla);
		}
	}
}
