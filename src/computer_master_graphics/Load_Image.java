package computer_master_graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Load_Image {
	public static BufferedImage Motors,playerMotor,enemyMotor, fullImage,road,grass,foothpath;

	public static void init(){
		fullImage =	imageLoader("/grid.png");
		Motors = imageLoader("/motor.png");
		crop();
	}
	
	public static BufferedImage imageLoader(String path){
		
		try{
			return ImageIO.read(Load_Image.class.getResource(path));
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(1);
		}
		return null;
		
	}
	public static void crop(){
		grass = fullImage.getSubimage(0, 0,130, 119);
		road = fullImage.getSubimage(130, 0, 130, 119);
		foothpath = fullImage.getSubimage(130*2, 0, 130, 119);
		
		playerMotor = Motors.getSubimage(0, 0, 240, 460);
		enemyMotor = Motors.getSubimage(245, 0, 240, 460);
		
		
	}
	
	

}
