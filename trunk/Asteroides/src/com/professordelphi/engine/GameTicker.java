package com.professordelphi.engine;

import java.util.ArrayList;

public class GameTicker extends Thread {
	private int delay = 10;
	private ArrayList<Tickeable> items = new ArrayList<Tickeable>();
	
	public GameTicker() {
		super();
	}
	public void add(Tickeable t){
		items.add(t);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override 
	public void run(){
		while (this!=null) {
			try {
				for (Tickeable t : items)
					t.update(null);
				Thread.sleep(delay);
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
