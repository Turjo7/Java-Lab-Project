package computer_master_world;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import computer_master_display.Display;
import computer_master_motor.Motor;
import computer_master_tile.Tile;

public class World {
	private int[][] tile;
	private int width;
	private int height;
	private Motor motor;
	
	public World(Motor motor){
		loadWorld("res/world.txt");  // loading the file 
		this.motor = motor ;
		
	}
	private int parseInt(String number){
		return Integer.parseInt(number);
	}
	private void loadWorld(String path){
		String file = loadFile(path);
		String[] space = file.split("\\s+");  // symbol for space \\ s+ means later part of the space 
		 width = parseInt(space[0]);  // converting the string into integer
		 height =parseInt(space[1]);
		
		tile = new int[width][height];
		
		for(int x=0;x<width;x++){
			for(int y=0;y<height;y++){
				tile[x][y] = parseInt(space[2+(x+y*width)]);
			}
		}
		
		
	}
	public String loadFile(String path){
		StringBuilder sr = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line =reader.readLine())!=null){
				sr.append(line+"\n");
				
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sr.toString();  // converts sr into string
		
	}
	
	public void render(Graphics g){
		int start = Math.max(0, motor.getOfset()/Tile.tileHeight);
		int end = Math.min(height, (motor.getOfset()+Display.height+20)/Tile.tileHeight); // making the game size smaller 
		for(int i=0;i<width;i++){
			for(int j=start;j<end;j++){
				Tile t = Tile.tiles[tile[i][j]];
				t.render(g, i*Tile.tileWidth, (j*Tile.tileHeight)-motor.getOfset());
			}
		}
		
	}

}
