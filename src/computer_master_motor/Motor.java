package computer_master_motor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import computer_master_display.Display;
import computer_master_graphics.Load_Image;
import computer_master_tile.Tile;

public class Motor implements KeyListener{
	private int x;
	private int y;
	private int ofset;
	private double speed;
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	private int condition;
	private int gear;
	
	public Motor(){
		x=Display.width/2;;
		y=Tile.tileHeight*120;
		ofset=0;
		speed =0.3f;
		condition = 3;
		gear=0;
		
	}
	public void init(){
		Display.frame.addKeyListener(this);
		
		
	}
	
	public void tick(){
		if(condition>0){
		  ofset  = y - (Display.height-100);                           // this variable will stop the car from going out of the frame 
		if(right){
			if(x<=343){
			x+=1;
			}
		}
		if(left){
			if(x>130){
			x-=1;
			}
		}
		if(up){
			if(y>700){
			speed+=0.03f;
			if(speed>=7){
				speed=7;
			}
		 }
		}
		if(y>700)
		y-=speed;
		if(down){
			speed -=0.030f;
			if(speed<=0){
				speed=0;
			}
		}
		}
		
		
	}
	public double getSpeed(){
		return speed;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getOfset(){
		return ofset;
	}
	public void setSpeed(double speed){
		this.speed=speed;
	}
	public void setHealth(int health){
		this.condition=health;
	}
	public void drawBoard(Graphics g){
		int speed1 = (int) speed;
		switch(speed1){
		case 0: gear=0;
		        break;
		case 2: gear =1;
		        break;
		case 4: gear =2;
		        break;
		case 6: gear =3;
		        break;
		}
		
		g.setColor(Color.white);
		g.fillRect(10, 10, 150, 80);
		
		g.setColor(Color.BLACK);
		String Sgear = Integer.toString(gear);
		g.setFont((new Font("arial",Font.BOLD,10)));
		g.drawString("Gear: "+Sgear, 20,40);
		g.drawString("Damage: "+condition, 20, 60);
		g.drawString("Developed By TURJO 86", 20, 85);
		
	}
	public void gameOver(Graphics g){
		g.setColor(Color.BLUE);
		g.setFont(new Font("arial",Font.PLAIN,40));
		g.drawString("Game Over", Display.width/3, Display.height/2);
	}
	public void render(Graphics g){
		if(condition>0){
		g.setColor(Color.black);
		g.drawImage(Load_Image.playerMotor,x,y-ofset,40,70,null);
		}
		else{
			gameOver(g);
		}
		drawBoard(g);
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int source = e.getKeyCode();
		if(source==KeyEvent.VK_RIGHT){
			right=true;
		}
		if(source==KeyEvent.VK_LEFT){
			left=true;
		}
		if(source==KeyEvent.VK_UP){
			up=true;
		}
		if(source==KeyEvent.VK_DOWN){
			down=true;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int source = e.getKeyCode();
		if(source==KeyEvent.VK_RIGHT){
			right=false;
		}
		if(source==KeyEvent.VK_LEFT){
			left=false;
		}
		if(source==KeyEvent.VK_UP){
			up=false;
		}
		if(source==KeyEvent.VK_DOWN){
			down=false;
		}
		
	}

}
