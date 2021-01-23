// The Player then checks for a Option. They are No Play, Ladder or Snake.
import java.util.*;
class DiceRoll {
	// constants
	final int STARTING_POINT = 0;
	final int END_POINT = 100;
	static String plr1;
	static int plr1_pos;
	static int rand_output;
	static int choice;
	int total_roll=0;
	final int noplay = 1;
	final int snake = 2;
	final int ladder = 3;
			
	
	void insert() {
		// gatting user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Player name: ");
		String plr1 = sc.nextLine();
		System.out.println("Player name: "+plr1);
		plr1_pos = STARTING_POINT;
		System.out.println("Start Player position: "+plr1_pos);
	}
	
	void rolling_dice() {
		Random rand = new Random();
		rand_output = rand.nextInt(6) + 1;
		System.out.println("Dice Roll Output: "+rand_output);
		total_roll += 1;
	}
	
	void option_check() {
		Random rand = new Random();
		choice = rand.nextInt(3) + 1;
		System.out.println("Choice: "+choice);
		
		switch(choice)
		{
		case noplay:
			System.out.println("noplay");
			if (plr1_pos >= STARTING_POINT && plr1_pos < END_POINT)
				plr1_pos += 0;
			System.out.println("Player Position(update): "+plr1_pos);
			break;
			
		case ladder:
			System.out.println("Ladder");
			if (plr1_pos >= STARTING_POINT && plr1_pos < END_POINT)
				plr1_pos += rand_output;
			System.out.println("Player position(update): "+plr1_pos);
			break;
		
		case snake: 
			System.out.println("Snake");
			if (plr1_pos >= STARTING_POINT && plr1_pos < END_POINT)
				plr1_pos -= rand_output;
			System.out.println("Player Position(update): "+plr1_pos);
			break;
		}
	}
	
}


public class SnakeLadder {

	public static void main(String[] args) {
		// Welcome message here
		System.out.println("***************************************");
		System.out.println("<--:Welcome to my Snake Ladder game:-->");
		System.out.println("***************************************");
		// calling object
		DiceRoll dc = new DiceRoll();
		dc.insert();
		dc.rolling_dice();
		dc.option_check();
	}

}
