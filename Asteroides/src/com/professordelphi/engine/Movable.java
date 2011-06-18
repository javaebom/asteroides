package com.professordelphi.engine;

public class Movable implements Colidivel{
	private double x1,x2,y1,y2 ;
	private double passo = 1;
	private Vetor atrito, aceleracao, vDireita, vEsquerda;
	
	public Movable(){
		atrito = new Vetor(.8d,.8d);
		aceleracao = new Vetor();
		vDireita = new Vetor(getPasso(), 0);
		vEsquerda= new Vetor(getPasso()*(-1), 0);
	}
	
	@Override
	public void colidiu(Movable m) {

	}
	
	public void mover(){
		setLocation(x1+aceleracao.getX(), y1+aceleracao.getY());
		atrito.inverter(aceleracao);
		aceleracao.subtrair(atrito);
	}
	
	public void subir(){
		setLocation(x1, (y1-getPasso()));
	}
	
	public void descer(){
		setLocation(x1,(y1+getPasso()));
	}
	
	public void direita(){
		aceleracao.somar(vDireita);
		setLocation((x1+getPasso()), getY1());
	}
	
	public void esquerda(){
		aceleracao.somar(vEsquerda);
		setLocation((x1-getPasso()), getY1());
	}
	
	public strictfp void setLocation(double x,double y){

		setX2(getWidth()+x);
		setX1(x);
		
		setY2(y+getHeight());
		setY1(y);
	}
	
	public void setPosition(int x, int y){
		setLocation(x, y);
	}

	public int getX1() {
		return (int)x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return (int)x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return (int)y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getPasso() {
		return passo;
	}

	public void setPasso(double passo) {
		this.passo = passo;
	}
	
	public int getWidth(){
		return (int)(x2-x1);
	}
	
	public int getHeight(){
		return (int)(y2-y1);
	}
	
	public void setWidth(double w){
		setX2(getX1()+w);
	}
	
	public void setHeight(double h){
		setY2(getY1()+h);
	}
	
	public int getLeft(){
		return (int)getX1();
	}
	
	public int getTop(){
		return (int)getY1();
	}
	
	public static void main(String[] args) {
		System.out.println(Math.acos(1)*2);
		System.out.println(Math.asin(1)*2);
	}
}
