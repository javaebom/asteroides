package com.professordelphi.engine;

public class Vetor {
	private double x=100, y=100;
    private double direcao=0, raio=0;
	
	
	public void somar(double x, double y){
		this.x+=x;
		this.y+=y;
		calcRaio();
	}
	
	public void subtrair(double x, double y){
		this.x-=x;
		this.y-=y;
		calcRaio();
	}
	
	public void setDirecao(){
		this.direcao = direcao;
		calcXY();
	}
	
	public void setXY(double x, double y){
		this.x = x;
		this.y = y;
		calcRaio();
		calcDirecao();
	}
	
	public void setRaio(double raio){
		this.raio = raio;
		calcXY();
	}
	
	public void setX(double x){
		this.x = x;
		setXY(x,y);
	}
	
	public void setY(double y){
		this.y = y;
		setXY(x,y);
	}
	
	public double getRaio(){
		return raio;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}	
	
	public double getDirecao(){
		return direcao;
	}
	
	public double getModulo(){
		return raio;
	}
	
	/** Método principal para teste da classe
	 *
	 *
	 */
	public static void main(String arg[]){
		Vetor v = new Vetor();
		System.out.println((Math.atan2(45,45)*(180/Math.PI)));
	}
	
	
	private void calcRaio(){
		raio  = Math.sqrt(Math.pow(x,2)+ Math.pow(y,2));
	}
	
	private void calcDirecao(){
		direcao = Math.atan2(45,45)*(180/Math.PI);
	}
	
	private void calcXY(){
		x = Math.cos((180/Math.PI)*direcao)*raio;
		y = Math.sin((180/Math.PI)*direcao)*raio;
	}
	
	public void paint(java.awt.Graphics g){
		y+=1;
		g.fillOval((int)x,(int)y,10,10);
	}

}
