package com.edgardleal.asteroide;

import java.awt.Color;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JApplet;

import com.edgardleal.engine.Cenario;
import com.edgardleal.engine.Colidivel;
import com.edgardleal.engine.Sprite;
import com.edgardleal.engine.Vetor;
import com.edgardleal.telas.Fase01;

public class Nave extends Sprite{
	private boolean atirando = false;
	private Missil missil;
	private ArrayList<Missil> misseis;
	private Cenario c=null;
	private JApplet applet;
	/**Indica um limite para lancamento de m�sseis.
	 * 
	 */
	private long timerDeLancamento=0;
	//private Cenario cenario; pode ser utilizado posteriormente para tratamento de explos�es

	public Nave(JApplet a,Cenario c)throws MalformedURLException {
		super(a.getImage( new URL(a.getDocumentBase(),"img/nave2.png")));
		//System.out.println(new URL(a.getDocumentBase(),"img/nave2.png"));
		addQuadro(10, 0, 42, 40);
		addQuadro(10, 50, 41, 90);
		addQuadro(9, 100, 41, 140);
		setLocation(250, 400);
		setWidth(24);
		setHeight(32);
		missil = new Missil(a);
		//this.cenario = c;
		setPasso(1.5);
		c.addPrintable(missil);
		this.c = c;
		this.applet = a;
		vDireita.setXY(.4, 0);
		atrito.setRaio(0.09);
		vEsquerda.setXY(-0.4d, 0);
		aceleracao.setRaioLimite(8);
		aceleracao.setXY(.0, .0);
		//---------------------------------------------
	}

	@Override
	public void direita(){
		if (getX2()>=500) return;
		super.direita();
	}
	
	public void lancar(){
		if(timerDeLancamento!=0) return;
		for(Missil m:getMisseis())
			if(m.isRead()){
				m.setLocation(this.getX1()+(getWidth()/2)-6, this.getY1());
				m.show();
				timerDeLancamento = 3;
				break;
			}
	}

	@Override
	public void esquerda(){
		if(getX1()<=0) return;
		super.esquerda();
	}
	/**Anula a gravidade.
	 * 
	 */
	@Override 
	public void mover(Vetor gravidade){
		mover();
	}
	@Override
	public void mover(){
		if (getX2()>=500) aceleracao.setXY(-0.5, 0);
		else
			if (getX1()<=0) aceleracao.setXY(0.5, 0);
//		if(aceleracao.getX()>0) atrito.setXY(-.04, 0);
//		else if(aceleracao.getX()<0) atrito.setXY(.04, 0);
//		else
//			atrito.setXY(0, 0);
		super.mover();
	}
	
	public void keyDown(byte tecla){
		super.keyDown(tecla);
	}
	
	public ArrayList<Missil> getMisseis(){
		if (misseis==null) {
			misseis = new ArrayList<Missil>();
			try{
			for (int i = 0; i < 20; i++){ 
				misseis.add(new Missil(applet));
				c.addPrintable(misseis.get(i));
			}
			}catch(Exception ex){}
		}
		return misseis;
	}
	@Override
	public synchronized void update(ArrayList<Colidivel> lista){

		if(teclas[37]){
			esquerda();
		}
		if(teclas[39]){
			direita();
		}
		if(teclas[32]) {
			atirando = true;
		}
		if (teclas[66]&&missil.isRead()){
			lancar();
		}
		if (teclas[10])
			((Fase01)c).ataque(this, 100, 0, 0, 500, 500);
		
		nextFrame();//muda para o proximo quadro
	}
	
	@Override
	public void paint(Graphics g) {
		timerDeLancamento = timerDeLancamento>0?--timerDeLancamento:0;
	

		if(atirando) {
			g.setColor(Color.cyan);
			g.drawLine(getX1() + getWidth()/2 -1, getY1(), getX1() + getWidth()/2-1, 0);
			g.setColor(Color.white);
			g.drawLine(getX1() + getWidth()/2 , getY1(), getX1() + getWidth()/2, 0);
			g.setColor(Color.cyan);
			g.drawLine(getX1() + getWidth()/2 +1, getY1(), getX1() + getWidth()/2+1, 0);
			atirando = false;
			c.ataque(this,5, getX1() + getWidth()/2 , getY1(), getX1() + getWidth()/2, 0);
		}
		g.setColor(Color.red);
		g.fillRect(30, 10, (int)(aceleracao.getRaio()*50), 5);

		super.paint(g);
	}//paint
}//class