package com.edgardleal.engine;

import java.util.Vector;

import com.edgardleal.engine.math.Fila;


public class GameTicker extends Thread {
	private int delay = 15;
	private double ultimoAtrazo = 0.,
	ajusteDoAtrazo = 0.0;
	private Fila fila  = new Fila();
	private long time = 0L;
	private Vector<Tickeable> items = new Vector<Tickeable>();

	public GameTicker() {
		super();
		this.setPriority(10);

	}
	public void add(Tickeable t){
		items.add(t);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	@Override 
	public void run(){
		long timer = 0l;
		while (this!=null) {
			time = time+1==Long.MAX_VALUE?0:++time;
			timer  = System.currentTimeMillis();
			try {
				synchronized(this){
					for (Tickeable t : items)
						t.update(null);
				}
				Thread.sleep((int)(delay));
			} catch (Exception e) {
				e.printStackTrace();
			}//catch
			ultimoAtrazo = System.currentTimeMillis()-timer-delay;
			if(ultimoAtrazo>delay*1.7) System.err.println("\nAtrazo na Thread GameTicker"+
					"\n" + (System.currentTimeMillis()-timer) + " X " + delay);
			else
				if(ultimoAtrazo<0) {
					//System.err.println("Erro fatal (ConcurrentModificationException)");
					//System.exit(2);
				}
			fila.put(ultimoAtrazo);
			ajusteDoAtrazo = fila.getMedia();
			if(time%100==0) System.out.println("Atrazo : " +ultimoAtrazo);
		}//while
	}//run

	public synchronized int getDelay() {
		return delay;
	}

	public synchronized void setDelay(int delay) {
		this.delay = delay;
	}


}//class
