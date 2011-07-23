package com.professordelphi.engine;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Sprite extends Movable implements Printable{
	private Image img;
	private boolean visible = false;
	protected byte tecla;
	private ArrayList<Rectangle> quadros;//lista de quadros mapeados
	private int quadroAtual=0;
	protected boolean teclas[] = new boolean[90];
	private long time=0;
	public Sprite(Image img){
		this.img=img;
		quadros = new ArrayList<Rectangle>();
	}
	@Override
	public void paint(Graphics g) {
		//Rectangle r = quadros.get(quadroAtual);
		if(quadros.size()==0)return;
		Rectangle r = quadros.get(quadroAtual);
		g.drawImage(img,getLeft(),getTop(),(int)getX2(),(int)getY2(),
				r.x,r.y,r.width,r.height,null);
		time++;
	}
	public void addQuadro(int x1, int y1, int x2, int y2){
		quadros.add(new Rectangle(x1,y1,x2,y2));
	}
	public void notifyTecla(byte tecla){
		this.tecla = tecla;
	}
	
	public void keyDown(byte tecla){
		this.tecla = tecla;
		teclas[tecla] = true;
	}
	
	public void keyUp(byte tecla){
		this.tecla = tecla;
		teclas[tecla] = false;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
		
	}
	public void nextQuadro(){
		//T�cnica para reiniciar o arraylist
		if(time%5==0)
			quadroAtual = ++ quadroAtual % (quadros.size());
	}
	public void nextFrame(){
		nextQuadro();
	}
	
	public long getTime(){
		return time;
	}
	public int getQuadroAtual() {
		return quadroAtual;
	}
	public void setQuadroAtual(int quadroAtual) {
		this.quadroAtual = quadroAtual;
	}
	
	public int getQuadrosCount(){
		return quadros.size();
	}
	
}
