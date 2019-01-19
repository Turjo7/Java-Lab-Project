package computer_master_manager;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import computer_master_display.Display;
import computer_master_enemies.EnemyMotor;
import computer_master_graphics.Load_Image;
import computer_master_motor.Motor;
import computer_master_world.World;

public class Game_Manager {
	private World world;
	private Motor motor;
	private long time =  System.nanoTime();
	private long delay;
	private int health;
	private ArrayList<EnemyMotor> eMotor;

	public Game_Manager(){
		motor = new Motor();
        world =new World(motor);
        eMotor = new ArrayList<EnemyMotor> ();
        delay = 2000;
        health=3;
		
//		motor = new Motor();
		
	}
	
	public void init(){
	
//		world =new World();
//		
//		motor = new Motor();
//		
		
		Load_Image.init();
		motor.init();
	}// Initialization
	
	public void tick(){
		Random rand = new Random();
		int randX = rand.nextInt(300);
		int randY = rand.nextInt(Display.height);
		
		while(randX <150){
			randX = rand.nextInt(300);
			
		}
		for(int i=0;i<eMotor.size();i++){
		 int px = motor.getX();
		 int py = motor.getY();
		 
		 
		 int ex = eMotor.get(i).getX();
		 int ey = eMotor.get(i).getY();
		 if(px< ex+40 && px+40> ex && py<ey+40 && py+40>ey){
			 // Collison
			 eMotor.remove(i);
			 i--;
			 health--;
			 
			 motor.setSpeed(0);
			 motor.setHealth(health);
		 }
		}
		long elapsed = (System.nanoTime() -time)/1000000;
		if(elapsed>delay){
			if(motor.getSpeed()>=3){
			eMotor.add(new EnemyMotor(motor,randX,(-randY)+motor.getOfset()));
			}
			time = System.nanoTime();
			
		}
				
		
		motor.tick();
		for(int i=0;i<eMotor.size();i++){
			eMotor.get(i).tick();
		}
		
	}// Update
	public void render(Graphics g){
		world.render(g);
		motor.render(g);
		for(int i =0;i<eMotor.size();i++){
			eMotor.get(i).render(g);
		}
	
		
	}// This method will take the graphics

}
