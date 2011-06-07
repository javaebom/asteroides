package com.professordelphi.engine;

public class Movable implements Colidivel{
	private double x1,x2,y1,y2 ;
	private double passo = 1;

	@Override
	public void colidiu(Movable m) {

	}
	
	public void subir(){
		setLocation((int)getX1(), (int)(getY1()-getPasso()));
	}
	
	public void descer(){
		setLocation((int)getX1(),(int)(getY1()+getPasso()));
	}
	
	public void direita(){
		setLocation((int)(getX1()+getPasso()), getY1());
	}
	
	public void esquerda(){
		setLocation((int)(getX1()-getPasso()), getY1());
	}
	
	public void setLocation(int x,int y){
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
}