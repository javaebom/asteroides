package com.edgardleal.engine;

import java.util.ArrayList;


public class GameTicker extends Thread {
	private int delay = 10;
	private ArrayList<Tickeable> items = new ArrayList<Tickeable>();
	
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
			try {
				for (Tickeable t : items)
					t.update(null);
				timer  = System.currentTimeMillis();
				Thread.sleep(delay);
				if(System.currentTimeMillis()-timer>delay*1.7) System.err.println("\nAtrazo na Thread GameTicker"+
						"\n" + (System.currentTimeMillis()-timer) + " X " + delay);
			} catch (Exception e) {
				// TODO: handle exception
			}//catch
		}//while
	}//run

	public synchronized int getDelay() {
		return delay;
	}

	public synchronized void setDelay(int delay) {
		this.delay = delay;
	}
	
	
}//class
