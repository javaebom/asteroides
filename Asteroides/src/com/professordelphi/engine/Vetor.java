package com.professordelphi.engine;

public class Vetor {
	private double x=1, y=1;
    private double direcao=0, raio=0;
	
	
    public Vetor(double x,double y){
    	setXY(x, y);
    }
    public Vetor(){
    	setXY(0, 0);
    }
    
    public double produtoInterno(Vetor v){
    	return (v.getX()*x)+(v.getY()*y);
    }
    /**Falta finalizar
     * 
     * @param v
     * @return
     */
    public Vetor produtoExterno(Vetor v){
    	Vetor result=new Vetor();
    	
    	return result;
    }
    
    
	public void somar(double x, double y){
		this.x+=x;
		this.y+=y;
		calcRaio();
		calcDirecao();
	}
	
	public void somar(Vetor v){
		somar(v.getX(),v.getY());
	}
	
	public void subtrair(double x, double y){
		this.x-=x;
		this.y-=y;
		calcRaio();
		calcDirecao();
	}
	public void subtrair(Vetor v){
		subtrair(v.getX(),v.getY());
	}
	
	/**Informar o valor em radianos : um círculo = 2*Pi
	 * 
	 * @param direcao
	 */
	public void setDirecao(double direcao){
		this.direcao = direcao;
		calcXY();
	}
	/**Informar o valor em graus : 0 -> 360 </br>
	 * OBS: o ângulo 0(zero) fica ao lado direito (3 horas)
	 * 
	 * @param angulo
	 */
	public void setDirecaoGraus(double angulo){
		setDirecao(((angulo%360)/180)*Math.PI);
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
		setXY(x,this.y);
	}
	
	public void setY(double y){
		setXY(this.x,y);
	}
	
	public double getRaio(){
		return raio;
	}
	
	public double getX(){
		return x;
	}
	
	public int getXParaORaio(double r){
		return round(Math.cos(direcao)*r);
	}
	
	
	private int round(double v){
		return (int)v;
	}
	
	public double getY(){
		return y;
	}	
	
	public double getDirecao(){
		return direcao;
	}
	
	public void multiplicar(double v){
		x = v*x;
		y = v*y;
		calcRaio();//a direção continua a mesma
	}
	
	public void inverter(){
		inverter(this);
	}
	public void inverter(Vetor v){
		setDirecao((v.getDirecao()+Math.PI)%(2*Math.PI));
	}
	
	public double getModulo(){
		return raio;
	}
	
	/** Método principal para teste da classe
	 *
	 *
	 */
	public static void main(String arg[]){
		new Vetor();
		System.out.println(Math.cos(0));

	}
	
	
	private void calcRaio(){
		raio  = Math.sqrt(Math.pow(x,2d)+ Math.pow(y,2d));
	}
	
	private void calcDirecao(){
		direcao = Math.atan2(45,45)*(180/Math.PI);
	}
	
	private void calcXY(){
		x = Math.cos(direcao)*raio;
		y = Math.sin(direcao)*raio;
	}
	
	public void paint(java.awt.Graphics g){
		g.drawLine(100, 100,100 +(int)x, 100+(int)y);
	}

}
