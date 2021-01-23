// Snake and Ladder game played with single player at start position 0
import java.util.*;
class DiceRoll {
	// constants
	final int STARTING_POINT = 0;
	final int END_POINT = 100;
	static int plr1_pos;
	
	void insert() {
		// gatting user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Player name: ");
		String plr1 = sc.nextLine();
		System.out.println("Player name: "+plr1);
		plr1_pos = STARTING_POINT;
		System.out.println("Start Player position: "+plr1_pos);
	}
}


public class SnakeLadder {

	public static void main(String[] args) {
		// welcome message here
		System.out.println("***************************************");
		System.out.println("<--:Welcome to my Snake Ladder game:-->");
		System.out.println("***************************************");
		
		DiceRoll dc = new DiceRoll();
		dc.insert();
	}

}
