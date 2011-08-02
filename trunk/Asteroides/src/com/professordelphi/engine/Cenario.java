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
	private Vetor gravidade;
	private long timer=0;
	private ArrayList<Printable> lista;//Lista de sprites que ser�o pintados na tela
	
	/**Lista dos objetos que estar�o sucetiveis de tratamento de colis�o.
	 * 
	 */
	private ColisionCenter colisionCenter;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cenario(Image imgFundo){//Construtor que recebe a imagem
		super(true);//Diz ao JPanel que ele ir� trabalhar com double Buffer
		lista = new ArrayList<Printable>();//Inicializa��o da lista
		this.imgFundo = imgFundo;//Atribui��o da imagem recebida em argumento
		controle = new Thread(this);
		gravidade = new Vetor(0, .05);
		controle.start();
	}
	@Override
	public void paint(Graphics g){
		Sprite sprite = null;
		if(isPause){
			g.fillRect(0, 0, 800, 600);	    	
			return;
		}
		if(imgFundo!=null){//Verifica se a imagem foi passada. Para evitar erros
			g.drawImage(imgFundo,0,0,600,450,800,600,1600,1200,null);//Ele desenha a imagem na tela. g.drawImage(imagem, x-tela, y-tela, largura-tela, altura-tela, x-imagem, y-imagem, largura-imagem, altura-imagem, notifica��o)
		}
		for(int i=0;i<lista.size();i++){//Varredura da lista
			if(timer%4==0)
				if(lista.get(i) instanceof Sprite){
					sprite = ((Sprite)lista.get(i));
					sprite.notifyTecla(tecla);
					sprite.mover(gravidade);
				}
			lista.get(i).paint(g);
		}
		getColisionCenter().verifica();
		timer = ++timer%Long.MAX_VALUE;
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
				System.out.println("Erro no gameLoop : " + e.getMessage());
			}
		}
	}
	public void pause(){
		isPause = !isPause;
	}
	public void notifyTecla(byte tecla){
		this.tecla = tecla;
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
	
	/**Distribui um ataque para todos os objetos Sprites da fase se estejam situados na �rea 
	 * delimitada pelas cordenadas informadas no par�metro.
	 * 
	 * @param m Objeto do tipo Moveble o qual disparaou o evento e n�o ser� afetado.
	 * @param intencidade informa o n�vel do ataque.
	 * @param x inicio a �rea a ser afetada pelo ataque.
	 * @param y inicio superior da �rea a ser afetada pelo ataque.
	 * @param x2 ponto lateral direito ada �rea a ser afetada pelo ataque.
	 * @param y2 ponto vertical inferior da �rea a ser afetada pelo ataque.
	 */
	public void ataque(Movable m,int intencidade ,int x,int y,int x2,int y2){
		for (Printable p:lista) 
			if (p instanceof Sprite && p != m) 
				if(x>=((Sprite)p).getX1() && x2<=((Sprite)p).getX2())
					((Sprite)p).ataque(intencidade);
	}
	
	/**M�todo get para verifical��o da disponibilidade do objeto.
	 * 
	 * @return Lista dos objetos sucetiveis de tratamento de colis�o.
	 */
	public ColisionCenter getColisionCenter() {
		if (colisionCenter==null) 
			colisionCenter = new ColisionCenter();
		return colisionCenter;
	}
	
	/**Adiciona um item do tipo Colidivel para ser verificado e notificado quando estiver 
	 * em estado de colis�o.
	 * 
	 * @param c Objeto do tipo Colidivel
	 */
	public void addColidivel(Colidivel c){
		getColisionCenter().add(c);
	}
}
