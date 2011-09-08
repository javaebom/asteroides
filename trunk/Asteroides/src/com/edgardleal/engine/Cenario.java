package com.edgardleal.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Cenario extends JPanel implements Runnable, Updateable{
	Image imgFundo;
	private Thread controle;
	private byte tecla=0;
	private boolean isPause = false;
	private Vetor gravidade;
	private long timer=0;
	private ArrayList<Printable> lista;//Lista de sprites que serão pintados na tela
	protected CenarioListener cenarioListener;
	private ArrayList<Updateable> updateables = new ArrayList<Updateable>();
	
	/**Lista dos objetos que estarão sucetiveis de tratamento de colisão.
	 * 
	 */
	private ColisionCenter colisionCenter = new ColisionCenter();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cenario(CenarioListener c){//Construtor que recebe a imagem
		super(true);//Diz ao JPanel que ele irá trabalhar com double Buffer
		this.setIgnoreRepaint(true);//ignora solicitações de repaint do systema operacinal
		lista = new ArrayList<Printable>();//Inicialização da lista
		cenarioListener = c;
		controle = new Thread(this);
		gravidade = new Vetor(0, .05);
		
		controle.start();
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		if(isPause){
			g.setColor(Color.blue);
			g.fillRect(0, 0, 800, 600);	    	
			return;
		}
		if(imgFundo!=null){//Verifica se a imagem foi passada. Para evitar erros
			g.drawImage(imgFundo,0,0,null);//Ele desenha a imagem na tela. g.drawImage(imagem, x-tela, y-tela, largura-tela, altura-tela, x-imagem, y-imagem, largura-imagem, altura-imagem, notificação)
		}
		for(int i=0;i<lista.size();i++)//Varredura da lista
			lista.get(i).paint(g);
		
	}
	
	
	public void setImgFundo(Image img){
		this.imgFundo = img;
	}
	public void addPrintable(Printable p){
		lista.add(p);
		if(p instanceof Colidivel) 
			colisionCenter.add((Colidivel)p);
		if(p instanceof Tickeable)
			updateables.add((Updateable)p);
	}
	@Override
	public void run() {
		while(controle!= null){
			try {
				Thread.sleep(50);
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
	
	/**Distribui um ataque para todos os objetos Sprites da fase se estejam situados na área 
	 * delimitada pelas cordenadas informadas no parâmetro.
	 * 
	 * @param m Objeto do tipo Moveble o qual disparaou o evento e não será afetado.
	 * @param intencidade informa o nível do ataque.
	 * @param x inicio a área a ser afetada pelo ataque.
	 * @param y inicio superior da área a ser afetada pelo ataque.
	 * @param x2 ponto lateral direito ada área a ser afetada pelo ataque.
	 * @param y2 ponto vertical inferior da área a ser afetada pelo ataque.
	 */
	public void ataque(Movable m,int intencidade ,int x,int y,int x2,int y2){
		for (Printable p:lista) 
			if (p instanceof Sprite && p != m) 
				if(x>=((Sprite)p).getX1() && x2<=((Sprite)p).getX2())
					((Sprite)p).ataque(intencidade);
	}
	
	public ArrayList<Printable> getPrintables(){
		if(lista==null) lista  = new ArrayList<Printable>();
		return lista;
	}
	
	/**Adiciona um item do tipo Colidivel para ser verificado e notificado quando estiver 
	 * em estado de colisão.
	 * 
	 * @param c Objeto do tipo Colidivel
	 */
	public void addColidivel(Colidivel c){
		colisionCenter.add(c);
	}
	
	public long getTimer(){
		return timer;
	}
	
	public void reset(){
		timer = 0;
	}
	
	public void update(ArrayList<Colidivel> lista) {
		for (Updateable u:updateables){ 
			u.update(colisionCenter.getLista());
			if(u instanceof Sprite){
					((Sprite)u).notifyTecla(tecla);
					((Sprite)u).mover(gravidade);
				}
		}
		colisionCenter.verifica();
		timer = ++timer%Long.MAX_VALUE;
	}
}
