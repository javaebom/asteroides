package com.edgardleal.asteroide;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.JApplet;

import com.edgardleal.engine.Cenario;
import com.edgardleal.engine.Colidivel;
import com.edgardleal.engine.Sprite;
import com.edgardleal.telas.Fase01;

public class Asteroide extends Sprite{
	private static int count=0;
	private boolean explodindo = false;
	private int id=-1;
	private Cenario c=null;
	public Asteroide(JApplet applet,Cenario c) throws Exception{
		super(applet.getImage(new URL(applet.getDocumentBase(),"img/enemy1.png")));
		this.id  = ++count;
		this.addQuadro(0, 1, 32, 31);       // 0
		this.addQuadro(32, 1, 32+32, 31);   // 1
		this.addQuadro(67, 3, 26+67, 26+3); // 2
		this.addQuadro(99, 3, 26+99, 26+3); // 3 

		/* Explos�o */
		getTimeline().add(133, 6, 21+133, 22+6,5); //4 vai mudar para o 5
		getTimeline().add(165, 6, 22+165, 6+22,6); //5 vai mudar para o 6
		getTimeline().add(97, 6, 22+197, 22+6 ,1); //6 vai mudar para o 1
		
		this.setHeight(32);
		this.setWidth(32);
		this.reset();
		setPasso(0.5);
		atrito.setRaio(1);
		c.addPrintable(this);
		aceleracao.setRaioLimite(1.0);
	    this.c = c;
	}

	public void reset(){
		this.setLocation((int)(Math.random()*(500-this.getWidth())), 
				(int)(Math.random()*60));
		explodindo = false;
		aceleracao.setXY(0, 0);//zera a movimenta��o
		setLife(100);
		setSolid(true);
	}

	public boolean isExplodindo() {
		return explodindo;
	}

	private void setExplodindo(boolean explodindo) {
		this.explodindo = explodindo;
	}

	public void explodir(){
		if(explodindo) return ;
		setSolid(false);
		setExplodindo(true);
	}
	
	@Override 
	public boolean ataque(int intencidade){
		super.ataque(intencidade);
		if(getLife()<=0 && !explodindo){
			System.out.println("Ponto marcado em asteroide");
			((Fase01)c).acerto();
			explodir();
		}
		return false;
	}
	
	/**Retorna o n�mero da instancia deste objeto , 
	 * toda vez que � criado um novo Asteroide , � criado um 
	 * identificador �nico para instacia criada.
	 * 
	 * @return Valor inteiro que identifica de forma �nca este objeto
	 */
	public int getId(){
		return this.id;
	}
	
	
	public void colidiu(Colidivel c){
		explodir();
	}
	
	public void update(ArrayList<Colidivel> lista){

	}
	
	@Override
	public void paint(java.awt.Graphics g){
		super.paint(g);
	}
}
