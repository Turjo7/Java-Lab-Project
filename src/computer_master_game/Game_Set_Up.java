package computer_master_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import computer_master_display.Display;
import computer_master_manager.Game_Manager;

public class Game_Set_Up implements Runnable {
	private Thread thread;
	private Display display;
	private String title;
	private int width;
	private int height;
	private BufferStrategy buffer;
	private Graphics g;
	
	private Game_Manager manager;
	public Game_Set_Up(String title,int width,int height){
		this.title=title;
		this.width=width;
		this.height=height;
		
	}
	public void init(){
		display = new Display(title,width,height);
		manager = new Game_Manager();
		manager.init();
	}
	public void tick(){
		manager.tick();
	}
	
	public synchronized void start(){
		if(thread==null){
			thread = new Thread(this);
			thread.start();
		}
		
	}// Starts the thread
	
	public synchronized void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// Stops the thread
	public void render(){
		buffer = display.canvas.getBufferStrategy();
		if(buffer==null){
			display.canvas.createBufferStrategy(3);
			return;
		}
		g = buffer.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		// draw method starts
		manager.render(g);
		
		// draw method ends
		buffer.show();
		g.dispose();
	}// Draw everything by this method
	public void run(){
		init();
		int fps = 50; // the change rate of Frame
		double timePerTick = 1000000000/fps;
		double delta = 0 ;  // time
		long current = System.nanoTime();
		while(true){
			delta = delta + (System.nanoTime()-current)/timePerTick;
			current = System.nanoTime();
			if(delta>=1){
				tick();
				render();
				delta--;
			}
			
		}
		
	} // executes everything 

}
