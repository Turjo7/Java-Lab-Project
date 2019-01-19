package computer_master_tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static Tile[] tiles = new Tile[24];
	public static Tile Road_Tile = new Road_Tile(0);
	public static Tile Grass_Tile = new Grass_Tile(1);
	public static Tile FoothPath_Tile = new FoothPath_Tile(2);
	public BufferedImage texture;
	public static final int tileWidth=64;
	public static final int tileHeight=64;   // change the keyword final, and watch the magic
	public Tile(BufferedImage texture,int id){
		this.texture=texture;
		tiles[id]=this;
		
	}
	
	public void render(Graphics g,int x,int y){
		g.drawImage(texture, x, y, null);
	}

}
