// the player gets to exact winning position 100.
import java.util.*;
class DiceRoll {
	// constants
	final int STARTING_POINT = 0;
	final int END_POINT = 100;
	static String plr1;
	static String plr2;
	static int plr1_pos;
	static int plr2_pos;
	static int rand_output_plr1;
	static int rand_output_plr2;
	static int choice;
	int total_roll_plr1 = 0;
	int total_roll_plr2 = 0;
	final int noplay = 1;
	final int snake = 2;
	final int ladder = 3;
			
	
	void insert() {
		// gatting user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Player name: ");
		String plr1 = sc.nextLine();
		System.out.println("Enter the Player name: ");
		String plr2 = sc.nextLine();
		System.out.println("Player name: "+plr1);
		plr1_pos = STARTING_POINT;
		System.out.println("Player name: "+plr2);
		plr2_pos = STARTING_POINT;
		System.out.println("Start Player position: "+plr1_pos);
		System.out.println("Start Player position: "+plr2_pos);
	}
	
	void rolling_dice() {
		Random rand = new Random();
		rand_output_plr1 = rand.nextInt(6) + 1;
		System.out.println("Dice Roll Output: "+rand_output_plr1);
		total_roll_plr1 += 1;
		rand_output_plr2 = rand.nextInt(6) + 1;
		System.out.println("Dice Roll Output: "+rand_output_plr2);
		total_roll_plr2 += 1;
	}
	
	void reachedPosition() 
	{
		
		while (plr1_pos >= STARTING_POINT && plr1_pos < END_POINT && plr1_pos >= STARTING_POINT && plr1_pos < END_POINT) 
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
				plr2_pos += 0;
				System.out.println("Player1 Position(update): "+plr1_pos);
				System.out.println("Player2 Position(update): "+plr2_pos);
				break;
				
			case snake:
				System.out.println("Snake");
				plr1_pos -= rand_output_plr1;
				if (plr1_pos < STARTING_POINT)
					plr1_pos = 0;
				plr2_pos -= rand_output_plr2;
				if (plr2_pos < STARTING_POINT)
					plr2_pos = 0;
				System.out.println("Player1 Position(update): "+plr1_pos);
				System.out.println("Player2 Position(update): "+plr1_pos);
				break;
				
			case ladder:
				System.out.println("Ladder");
				plr1_pos += rand_output_plr1;
				plr2_pos += rand_output_plr2;
				System.out.println("Player1 Position(update): "+plr1_pos);
				if (plr1_pos == END_POINT)
					break;
				else if (plr1_pos > END_POINT)
					plr1_pos -= rand_output_plr1;
				else
					System.out.println();
				
				System.out.println("Player2 Position(update): "+plr2_pos);
				if (plr2_pos == END_POINT)
					break;
				else if (plr2_pos > END_POINT)
					plr2_pos -= rand_output_plr2;
				else
					System.out.println();
				break;
			}
		}
		if (plr1_pos >= 100 && plr2_pos >= 100)
		{
			System.out.println("we reach final position; Thank You!!");
			System.out.println("Total Dice Roll: "+total_roll_plr1);
			System.out.println("Total Dice Roll: "+total_roll_plr2);
		}
		
		else if(plr1_pos == 100)
			System.out.println("YOU WIN!!, Player1 reach the exact location");
		else if(plr2_pos == 100)
			System.out.println("YOU WIN!!, Player2 reach the exact location");
		else
			System.out.println("Something wrong");
		
		if(plr1_pos == plr2_pos)
			System.out.println("Player1 and Player2 has same position and draw the match");
		else if(plr1_pos > plr2_pos)
			System.out.println("Player1 won the match");
		else
			System.out.println("Player2 won the match");
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

