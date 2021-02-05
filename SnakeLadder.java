// the player gets to exact winning position 100.
import java.util.*;
class DiceRoll {
	// constants
	final int STARTING_POINT = 0;
	final int END_POINT = 100;
	static String plr1;
	static int plr1_pos;
	static int rand_output;
	static int choice;
	int total_roll=0;  // total die roll count here
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
	
	void reachedPosition() 
	{
		
		while (plr1_pos >= STARTING_POINT && plr1_pos < END_POINT) 
		{
			rolling_dice();
			Random rand = new Random();
			choice = rand.nextInt(3) + 1;
			System.out.println("choice: "+choice);
			
			switch (choice) 
			{
			case noplay:
				System.out.println("No Play");
				plr1_pos += 0;
				System.out.println("Player Position(update): "+plr1_pos);
				break;
				
			case snake:
				System.out.println("Snake");
				plr1_pos -= rand_output;
				if (plr1_pos < STARTING_POINT)
					plr1_pos = 0;
				System.out.println("Player Position(update): "+plr1_pos);
				break;
				
			case ladder:
				System.out.println("Ladder");
				plr1_pos += rand_output;
				System.out.println("Player Position(update): "+plr1_pos);
				if (plr1_pos == END_POINT)
					break;
				else if (plr1_pos > END_POINT)
					plr1_pos -= rand_output;
				break;
			}
		}
		if (plr1_pos >= 100)
		{
			System.out.println("we reach final position; Thank You!!");
			System.out.println("Total Dice Roll: "+total_roll); // here print total die roll
		}
		
		else if(plr1_pos == 100)
			System.out.println("YOU WIN!!, You reach the exact location");
		else
			System.out.println("Someting wrong");
	}

}
public class SnakeLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***************************************");
		System.out.println("<--:Welcome to my Snake Ladder game:-->");
		System.out.println("***************************************");
		// calling object
		DiceRoll dc = new DiceRoll();
		dc.insert();
		dc.rolling_dice();
		dc.reachedPosition();;
	}

}

