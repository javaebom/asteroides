package com.professordelphi.engine;

public class Vetor {
	private double x=1, y=1;
    private double direcao=0, raio=0;
	private double raioLimite=0;
	
    public Vetor(double x,double y){
    	setXY(x, y);
    }
    public Vetor(){
    	setXY(0, 0);
    }
    
    public double produtoInterno(Vetor v){
    	return (v.getX()*x)+(v.getY()*y);
    }
    
    /**retorna o produto externo entre este e outro vetor.
     * 
     * @param v
     * @return
     */
    public Vetor produtoExterno(Vetor v){
    	/* 1  1  1 1  1
    	 * x1 y1 1 x1 y1
    	 * x2 y2 1 x2 y2
    	 * 
    	 * result = 1*y1*1 + 1*1*x2 + 1*x1*y2 - 
    	 *          1*x1*1 - 1*1*y2 - 1*y1*x2 
    	 */
 
    	return new Vetor(y-x,v.getX()-v.getY());
    }
    
    public String toString(){
    	return "X:" + getX() + " , Y:" + getY() + " Raio:" + getRaio() + " �ngulo : " + getDirecao()*(180/Math.PI);
    }
    
    
	public void somar(double x, double y){
		if(raioLimite!=0 && calcModulo(x, y)+getModulo()>raioLimite ) return;
		this.x+=x;
		this.y+=y;
		calcRaio();
		calcDirecao();
	}
	
	private double calcModulo(double x, double y) {
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
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
	/**Este m�todo faz a subtra��o do raio informado e resolve o problema de 
	 * tamanho do raio subtraido ser maior que o raio do vetor em que ser� removido.
	 * 
	 * @param v
	 */
	public void subtrair(Vetor v){
		double raio_anterior = v.getRaio();
		if(raio_anterior>raio) v.setRaio(raio);
		subtrair(v.getX(),v.getY());
		v.setRaio(raio_anterior);//devolve o valor original para o objeto par�metro
	}
	
	/**Informar o valor em radianos : um círculo = 2*Pi
	 * 
	 * @param direcao
	 */
	public void setDirecao(double direcao){
		direcao = direcao==Double.NaN?0:direcao;
		this.direcao = direcao;
		calcXY();
	}
	
	/**Informar o valor em graus : 0 -> 360 </br>
	 * OBS: o ângulo 0(zero) fica ao lado direito (3 horas)
	 * 
	 * @param angulo
	 */
	public void setDirecaoGraus(double angulo){
		angulo = angulo==Double.NaN?0:angulo;
		setDirecao(((angulo%360)/180)*Math.PI);
	}
	
	
	public void setXY(double x, double y){
		this.x = x;
		this.y = y;
		calcDirecao();
		calcRaio();
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
		raio = raio==Double.NaN?0:raio;
		return raio;
	}
	
	public double getX(){
		return x;
	}
	/**Retorna o valor da posição X para o raio informado de acordo ângulo atual.
	 * 
	 * @param r
	 * @return
	 */
	public int getXParaORaio(double r){
		return round(Math.cos(getDirecao())*r);
	}
	
	/**Função para arredondamento(Encapsulamento do cast (int)2.5 ).
	 * 
	 * @param v
	 * @return
	 */
	private int round(double v){
		return (int)v;
	}
	
	public double getY(){
		return y;
	}	
	/**Retorna a direção do vetor em Radianos.
	 * 
	 * @return
	 */
	public double getDirecao(){
		direcao = direcao==Double.NaN?0:direcao;
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
	/**Inverte a direção do vetor.
	 * 
	 * @param v
	 */
	public void inverter(Vetor v){
		direcao = (v.getDirecao()+Math.PI);
		direcao = direcao>Math.PI*2?direcao-Math.PI*2:direcao;
		setDirecao(direcao);//para atualização dos calculos necessários
	}
	
	public double getModulo(){
		return raio;
	}
	
	/** Método principal para teste da classe
	 *
	 *
	 */
	public static void main(String arg[]){



		Vetor a = new Vetor(0d,-10d), b = new Vetor(10,0);
		double x = (a.getX()*b.getX() + a.getY() * b.getY()) /
		           a.getRaio() * b.getRaio();
		
		System.out.println("X : " + x);
		System.out.println((a.getDirecao()*(360/(Math.PI*2))));


	}
	
	
	private void calcRaio(){
		raio  = Math.sqrt(Math.pow(x,2d)+ Math.pow(y,2d));
	}
	
	private void calcDirecao(){
		//vetor para orientação (1,0)
		direcao = Math.acos((x*1+y*0)/(calcModulo(x, y)*1));
  direcao = y>0?direcao+Math.PI:direcao;
	}
	
	private void calcXY(){
		x = Math.cos(direcao)*raio;
		y = Math.sin(direcao)*raio;
	}
	
	public void paint(java.awt.Graphics g){
		g.drawLine(100, 100,100 +(int)x, 100+(int)y);
	}

	public void setRaioLimite(double l){
		raioLimite = l;
	}
}
