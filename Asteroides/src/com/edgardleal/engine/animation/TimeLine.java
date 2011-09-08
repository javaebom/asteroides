package com.edgardleal.engine.animation;

import java.util.ArrayList;

public class TimeLine {
	private ArrayList<Frame> frames = new ArrayList<Frame>();
	private int currentFrame = 0;

	/**Atualiza o frame para o proximo passo do timelinne.
	 * 
	 */
	public void nextFrame(){
		Frame f  = frames.get(currentFrame);
		if (f.time==f.delay) {
			f.time = 0;
			if (f.nextFrame==-1)
				currentFrame = ++currentFrame%frames.size();
				else
					currentFrame = f.nextFrame;
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
		return frames.get(currentFrame);
	}
	
	public int getSize(){
		return frames.size();
	}
	public int getCurrentFrame(){
		return currentFrame;
	}
}
