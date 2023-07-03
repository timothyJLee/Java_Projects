


/**
 * Timothy Lee
 * Program3: PartB: DiceGame(RandomNumber)
 * 1/17/13
 */


import java.util.Random; // For using the random number generator
import java.util.Scanner; // for gathering user input



public class DiceGameClass //naming the class
{
	public static Scanner userInputScanner = new Scanner(System.in); // instantiating the scanner
	public static Random numberRandom = new Random();                // instantiating the random number
	public static int playerChooserInt;                              // incrementer for choosing which player
	public static int roundChooserInt;                               // incrementer for choosing the round
	public static String diceArtString;    
	public static String tempString; // to hold the user input// for holding the Dice art for display
	public static int[][] playerAndScore2DArray = new int[3][6];     // multi-dim array to hold player and scores and sum of scores
	/*  [Player][Score] : Player 0,1,2
	 *  [Player][5] = Sum of all 5 scores for that player... */
	
	public static void main(String[] args) // main runs at start
	{
		System.out.println("*******Dice Rolling Game*******");        // Telling user what program is
		System.out.println("Three Players!  Enter 'r' to roll the Die.  Player 1 Rolls First."); // Telling user how to play
		
		StartGame();		// Starting the game
		
		System.out.println("       Player1:     Player2:     Player3:"); // header for displaying results of game
		for (int k=0; k < playerAndScore2DArray[playerChooserInt].length ; k++) // for statement to run through 2d array
		{
			if (k < 5) // if k is less than 5 display result of line
			{
				System.out.print("Round:" + (k+1) + "   " + playerAndScore2DArray[0][k]);			          
				System.out.print("           " + playerAndScore2DArray[1][k]);			    	
				System.out.println("          " + playerAndScore2DArray[2][k]);	
			} // end if
			else
			{  // else display totals
				System.out.print("Total: " + "   " + playerAndScore2DArray[0][k]);			          
				System.out.print("          " + playerAndScore2DArray[1][k]);			    	
				System.out.println("         " + playerAndScore2DArray[2][k]);	
			} // end else
		}	// end for
		
		if (playerAndScore2DArray[0][5] == playerAndScore2DArray[1][5] && playerAndScore2DArray[1][5] == playerAndScore2DArray[2][5])
		{ // if the sums of all the scores for each player are equal, all the players win
			System.out.println("Three-way tie!  All three players win!"); // Telling user
		}// end if
		else
		{
			if (playerAndScore2DArray[0][5] == playerAndScore2DArray[1][5])
			{// if player 1 and 2 totals are equal
				System.out.println("Two-way tie!  Player 1 and Player 2 Wins!"); // tell user
			} // end if
			else
			{
				if(playerAndScore2DArray[1][5] == playerAndScore2DArray[2][5])
				{ // if player 2 and 3 totals are equal
					System.out.println("Two-way tie!  Player 2 and Player 3 Wins!"); // tell user
				} // end if
				else
				{
					if (playerAndScore2DArray[0][5] == playerAndScore2DArray[2][5])
					{// if player 1 and 3 totals are equal
						System.out.println("Two-way tie!  Player 1 and Player 3 Wins!"); // tell user
					}// end if
					else
					{
						if (playerAndScore2DArray[0][5] > playerAndScore2DArray[1][5] && playerAndScore2DArray[0][5] > playerAndScore2DArray[2][5])
						{ // if player 1s total is greater than player 2 and 3s total
							System.out.println("Player1 Wins!"); // tell user
						}// end if
						else
						{
							if (playerAndScore2DArray[1][5] > playerAndScore2DArray[2][5])
							{// if player 2s total is greater than player3s
								System.out.println("Player2 Wins!"); //tell user
							}// end if
							else
							{//player three wins by default
								System.out.println("Player3 Wins!");// tell user
							}// end else
						}// end else
					}//end else
				}// end else
			}// end else			
		}// end else		
	}// end main
	
	public static void StartGame() // method to begin the dice game
	{		
		if (roundChooserInt == 5) // if all the rounds are over
		{
			for(int i = 0; i < 3; i++) // for statement accumulating the gathered scores
			{
				playerAndScore2DArray[i][5] = playerAndScore2DArray[i][0] + playerAndScore2DArray[i][1] + playerAndScore2DArray[i][2] +
                        playerAndScore2DArray[i][3] + playerAndScore2DArray[i][4];	
			}// end for				
		}//end if
		else
		{
		System.out.print("Enter r to Roll the Die, "); // Tell user how to roll die
		switch (playerChooserInt)  // switch statement telling which players turn it is
		{  // Outputting Formatted Score
        case 0:  System.out.println("Player1.");
                 break;
        case 1:  System.out.println("Player2.");
        		 break;
        case 2: System.out.println("Player3.");
        		 break;
        default:
        		 break;
		}
		
		
		tempString = userInputScanner.next(); // assigning next user input to tempstring
		System.out.println(tempString); // Printing tempString to see if assignment was correct
		
		
		RollDice(); // Calling the Roll Dice Method
		if (tempString != "r")//  if user input is correct
		{
			if (roundChooserInt != 5) // if number of rounds is correct
			{
				if (playerChooserInt == 2) // if time to increment to new round
				{
					NextRound(); // call newround
				}			// end if
				NextPlayer();// call newplayer
				System.out.println(playerChooserInt);// show new player
				System.out.println(roundChooserInt); // show current round
				StartGame();				// recursive startgame call
			}// end if
		}// end if
		else
		{
			StartGame();// recursive startgame call
		}// end else
		}// end if
	}// end startgame
	
	public static void RollDice()// does all the rolling of dice stuff
	{				
				playerAndScore2DArray[playerChooserInt][roundChooserInt] = RandomNumberAssigner(); // assigns random number to score
				DiceStringChooser(playerAndScore2DArray[playerChooserInt][roundChooserInt]); // chooses die art
				System.out.println(diceArtString + playerAndScore2DArray[playerChooserInt][roundChooserInt]); // displays die roll
								
				System.out.println();// extra line
				
				for (int k=0; k < playerAndScore2DArray[playerChooserInt].length ; k++) // displays current scores
				{
				System.out.print("   " + playerAndScore2DArray[0][k]);			          
				System.out.print("           " + playerAndScore2DArray[1][k]);			    	
				System.out.println("          " + playerAndScore2DArray[2][k]);			    		
				}	// end for
	}// end roll dice
	
	public static int RandomNumberAssigner()  // for assigning a random number for the dice and score
	{
		int returnInteger = numberRandom.nextInt(6)+1; // a random number that can be 1-6(not zero)
		
		return returnInteger; // return that number
	} // end randomnumberassinger
	
	public static void NextPlayer() // increments the player
	{		
		if (playerChooserInt == 2) // if player3 start over again
		{			
			playerChooserInt = 0; // assign player1 number
		}// end if
		else
		{
			playerChooserInt++; // else increment the playerchooser
		} // end else
	} // end nextplayer
	
	public static void NextRound() // increments the round
	{
		if (roundChooserInt == 5) // if round if five
		{
			// game will end
		}// end if
		else
		{
			roundChooserInt++; // else increment round
		}// end else
	}// end nextround
	
	public static void DiceStringChooser(int dieRollInt) // for choosing die art
	{
		switch (dieRollInt) // random number in the form of player score for round will be passed into the switch in the form of a parameter for the method in which player score gets passed
		{  // Outputting Formatted Score
        case 1:  diceArtString =" ________\n" + // die roll 1
        							"|             |\n" +
                                    "|             |\n" +
                                    "|      @      |\n" + 
                                    "|             |\n" +
                                    "|             |\n" +
                                    "+-------------+\n";
        		 break;
        case 2: diceArtString = " ________\n" + // die roll 2
        							"|             |\n" +
                                    "|  @          |\n" + 
                                    "|             |\n" + 
                                    "|          @  |\n" + 
                                    "|             |\n" +
                                    "+-------------+\n";
        		 break;
        case 3: diceArtString = " ________\n" + // die roll 3
        							"|             |\n" +
                                    "|  @          |\n" + 
                                    "|      @      |\n" + 
                                    "|           @ |\n" + 
                                    "|             |\n" +
                                    "+-------------+\n";
        		 break;
        case 4: diceArtString = " ________\n" + // die roll 4
        							"|           |\n" +
                                    "|  @      @ |\n" +
                                    "|           |\n" +
                                    "|  @      @ |\n" +
                                    "|           |\n" +
                                    "+-------------+\n";
        		 break;
        case 5: diceArtString = " ________\n" + // die roll 5
        							"|           |\n" +
                                    "|  @      @ |\n" +
                                    "|      @    |\n" + 
                                    "|  @      @ |\n" +
                                    "|           |\n" +
                                    "+-------------+\n";
        		 break;
        case 6: diceArtString =  " ________\n" + // die roll 6
        						"|            |\n" +
                                "|  @      @  |\n" + 
                                "|  @      @  |\n" + 
                                "|  @      @  |\n" + 
                                "|            |\n" +
                                "+-------------+\n";
        		 break;
        default:
        		 break;
		}// end switch
	}//end dieartchooser
}// end dicegameclass
