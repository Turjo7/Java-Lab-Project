package computer_master_enemies;

import java.awt.Graphics;

import computer_master_graphics.Load_Image;
import computer_master_motor.Motor;

public class EnemyMotor {
	private int x;
	private int y;
	private Motor motor;
	public EnemyMotor(Motor motor,int x,int y){
		this.motor=motor;
		this.x=x;
		this.y=y;
		
	}
	
	public void tick(){
		y+=1;
		
	}
	
	public void render(Graphics g){
		g.drawImage(Load_Image.enemyMotor, x, y-motor.getOfset(),40,70, null);
		
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}
