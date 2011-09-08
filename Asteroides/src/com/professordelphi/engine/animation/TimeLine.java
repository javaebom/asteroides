package com.professordelphi.engine.animation;

import java.util.ArrayList;

public class TimeLine {
	private ArrayList<Frame> frames = new ArrayList<Frame>();
	private int frameAtual = 0;

	/**Atualiza o frame para o proximo passo do timelinne.
	 * 
	 */
	public void nextFrame(){
		Frame f  = frames.get(frameAtual);
		if (f.time==f.delay) {
			f.time = 0;
			if (f.nextFrame==-1)
				frameAtual = ++frameAtual%frames.size();
				else
					frameAtual = f.nextFrame;
		}
		else{
			f.time++;
		}
	}

	public void add(Frame f){
		frames.add(f);
	}
	public void add(int x,int y,int w, int h){
		add(new Frame(x,y,w,h));
	}
	public void add(int x,int y,int w, int h, int nextFrame){
		add(new Frame(x,y,w,h,nextFrame));
	}

	public Frame getFrame(){
		return frames.get(frameAtual);
	}
	
	public int getSize(){
		return frames.size();
	}
}
