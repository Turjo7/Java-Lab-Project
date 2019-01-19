package computer_master_display;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	private String title;
	public static int width;
	public static int height;
	public static JFrame frame;
	public static Canvas canvas;
	public Display(String title,int width,int height){
		this.title=title;
		this.width=width;
		this.height=height;
		createDisplay();
		
	}
	public void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setVisible(true); // visable the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //  the cross button
		frame.setLocationRelativeTo(null); // sets the frame at the center
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height)); 
		canvas.setFocusable(false);
		frame.add(canvas); // put the canvas in the frame
		frame.pack();   // saves the canvas from extends 
		
		
	}

}
