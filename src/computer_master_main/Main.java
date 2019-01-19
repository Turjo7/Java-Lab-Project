package computer_master_main;

import computer_master_game.Game_Set_Up;
import computer_master_sound.Sound;

public class Main {

	public static void main(String[] args){
		//new Display("Dhaka Racer",500,600);
		Game_Set_Up game = new Game_Set_Up("Dhaka Racer",500,600);
		game.start();
		Sound.music();
	}
}
