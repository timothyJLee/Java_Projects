


/** Timothy Lee
 * Program4: PartB: Tic Tac Toe
 * 2/1/13
 */

 /*
 Part B (50 points) – TicTacToe. Write a simple programming solution that will represent a single TicTacToe game.
 Store the game board as a single two-dimensional array of base type char that has three rows and three columns.
 Allow the user to enter the location of their "X" or "O" on the board and tell when there is a winner.
 Re-render the board game each time a play is made.
 Do not allow anyone to place their move into a place that is already taken. 
 */

import java.util.Scanner;


public class TicTacToeClass {
	

	public static int playerInputCoordinate1 = -99; // left index of mult array
	public static int playerInputCoordinate2 = -99;	// right index of mult array
	public static boolean playerChooserBoolean = true;   // boolean for choosing which player
	public static char playerWinnerChar; // for deciding player winner
	public static char[][] playerAndScore2DArray = new char[3][3];     // multi-dim array to hold gameboard and values
	/*
	 * 00:null 01:null 02:null
	 * 10:X    11:X    12:X          // player X wins this game
	 * 20:O    21:O    22:null
	 */		
	public static void main(String[] args) // main method starts the program
	{		
		boolean gameOverBoolean = false; // deciding when game is over
		
		while(!gameOverBoolean) // while game not over
		{
			Scanner userInputScanner = new Scanner(System.in); // instantiating the scanner
			PrintCurrentGameState(playerAndScore2DArray);			// printing the current game board
			System.out.print("Please enter Coordinate 1 for move, " + PrintPlayer(playerChooserBoolean)); // telling current player to enter coordinate
			
			if (userInputScanner.hasNextInt()) // if user entered int
			{
				playerInputCoordinate1 = userInputScanner.nextInt(); // assign to coordinate one var
				if (CoordinateTester1()) // if valid input
				{
					System.out.print("Please enter Coordinate 2 for move, " + PrintPlayer(playerChooserBoolean)); // enter coordinate two player
					
					if (userInputScanner.hasNextInt()) // if user inputted int
					{
						playerInputCoordinate2 = userInputScanner.nextInt(); // assign to coordinate2 var
						if (CoordinateTester2()) // if valid input
						{
							if (playerAndScore2DArray[playerInputCoordinate1][playerInputCoordinate2] == Character.UNASSIGNED) // if not already
							{                                                                                        // chosen in past move
								PlayerTurn();  // player makes the turn
							}// end if
							else
							{
								System.out.println("Already Assigned in previous move!!!!"); // telling user how they messed up
							} // end else
						}// end it
						else
						{
							System.out.println("Please enter an integer 0-2 for Coordinate2."); // telling user how they messed up
						} // end else
					}// end if
				}		// end if
			}// end if
			else
			{
				System.out.println("Please enter an integer 0-2 for Coordinate1.");// telling user how they messed up
			}// end else
			gameOverBoolean = EndGame(); // deciding whether game continues or not
		}// end while
		
		PrintCurrentGameState(playerAndScore2DArray);	// printing end of game state
		
		if (playerWinnerChar == 'X') // Printing who won
		{
			System.out.println("PLAYERER 1 WINS!!!!!!!"); // player one wins
		}// end if
		else
		{
			if(playerWinnerChar == 'O')
			{
				System.out.println("PLAYERER 2 WINS!!!!!!!"); // player 2 wins
			}// end if
			else
			{
				if(playerWinnerChar == 'D') // deciding the draw
				{
					System.out.println("ITS A DRAW!"); // no one won
				} // end if
				else
				{
					System.out.println(playerWinnerChar); // printing for error
					System.out.println("DAMN SOMETHING HAPPEND!"); // damn something happend
				}// end else
			}// end else
		}// end else
	}// end main
	
	public static boolean EndGame()  // method for deciding if the end of game conditions have been met
	{	
		if ((playerAndScore2DArray[0][0] == Character.UNASSIGNED) || (playerAndScore2DArray[1][0] == Character.UNASSIGNED) || (playerAndScore2DArray[2][0] == Character.UNASSIGNED) ||
			playerAndScore2DArray[0][1] == Character.UNASSIGNED || playerAndScore2DArray[1][1] == Character.UNASSIGNED ||playerAndScore2DArray[2][1] == Character.UNASSIGNED ||
			playerAndScore2DArray[0][2] == Character.UNASSIGNED || playerAndScore2DArray[1][2] == Character.UNASSIGNED || playerAndScore2DArray[2][2] == Character.UNASSIGNED)
		{// if any character is unassigned
			if (playerAndScore2DArray[0][0] == playerAndScore2DArray[0][1] && playerAndScore2DArray[0][0] == playerAndScore2DArray[0][2] && !(playerAndScore2DArray[0][0] == Character.UNASSIGNED))
			{ // top horizontal
				playerWinnerChar = playerAndScore2DArray[0][0]; // Assigning player winner char for printing winner later
				return true;  // returning true so while statement ends
			}//end if
			else
			{
				if (playerAndScore2DArray[1][0] == playerAndScore2DArray[1][1] && playerAndScore2DArray[1][0] == playerAndScore2DArray[1][2] && !(playerAndScore2DArray[1][0] == Character.UNASSIGNED))
				{ // middle horizontal
					playerWinnerChar = playerAndScore2DArray[1][0]; // Assigning player winner char for printing winner later
					return true; // returning true so while statement ends
				}//end if
				else
				{
					if (playerAndScore2DArray[2][0] == playerAndScore2DArray[2][1] && playerAndScore2DArray[2][0] == playerAndScore2DArray[2][2] && !(playerAndScore2DArray[2][0] == Character.UNASSIGNED))
					{ // lower horizontal
						playerWinnerChar = playerAndScore2DArray[2][0]; // Assigning player winner char for printing winner later
						return true; // returning true so while statement ends
					}//end if
					else
					{
						if (playerAndScore2DArray[0][0] == playerAndScore2DArray[1][1] && playerAndScore2DArray[0][0] == playerAndScore2DArray[2][2] && !(playerAndScore2DArray[0][0] == Character.UNASSIGNED))
						{ // left diagonal
							playerWinnerChar = playerAndScore2DArray[0][0]; // Assigning player winner char for printing winner later
							return true; // returning true so while statement ends
						}//end if
						else
						{
							if (playerAndScore2DArray[0][2] == playerAndScore2DArray[1][1] && playerAndScore2DArray[0][2] == playerAndScore2DArray[2][0] && !(playerAndScore2DArray[2][0] == Character.UNASSIGNED))
							{ // right diagonal
								playerWinnerChar = playerAndScore2DArray[0][2]; // Assigning player winner char for printing winner later
								return true; // returning true so while statement ends
							}//end if
							else
							{
								if (playerAndScore2DArray[0][0] == playerAndScore2DArray[1][0] && playerAndScore2DArray[0][0] == playerAndScore2DArray[2][0] && !(playerAndScore2DArray[2][0] == Character.UNASSIGNED))
								{// left vertical
									playerWinnerChar = playerAndScore2DArray[0][0]; // Assigning player winner char for printing winner later
									return true; // returning true so while statement ends
								}//end if
								else
								{
									if (playerAndScore2DArray[0][1] == playerAndScore2DArray[1][1] && playerAndScore2DArray[0][1] == playerAndScore2DArray[2][1] && !(playerAndScore2DArray[2][1] == Character.UNASSIGNED))
									{ // middle vertical
										playerWinnerChar = playerAndScore2DArray[0][1]; // Assigning player winner char for printing winner later
										return true; // returning true so while statement ends
									}// end if
									else
									{
										if (playerAndScore2DArray[0][2] == playerAndScore2DArray[1][2] && playerAndScore2DArray[0][2] == playerAndScore2DArray[2][2] && !(playerAndScore2DArray[2][2] == Character.UNASSIGNED))
										{// right vertical
											playerWinnerChar = playerAndScore2DArray[0][2]; // Assigning player winner char for printing winner later
											return true; // returning true so while statement ends
										}//end if
										else
										{
											return false; // returning false so while statement continues
										}//end else
									}//end else
								}//end else
							}//end else
						}//end else
					}//end else
				}//end else
			}//end else
		}//end if
		else
		{
			if(!(playerAndScore2DArray[0][0] == Character.UNASSIGNED) && !(playerAndScore2DArray[1][0] == Character.UNASSIGNED) && !(playerAndScore2DArray[2][0] == Character.UNASSIGNED) &&
					   !(playerAndScore2DArray[0][1] == Character.UNASSIGNED) && !(playerAndScore2DArray[1][1] == Character.UNASSIGNED) && !(playerAndScore2DArray[2][1] == Character.UNASSIGNED) &&
					   !(playerAndScore2DArray[0][2] == Character.UNASSIGNED) && !(playerAndScore2DArray[1][2] == Character.UNASSIGNED) && !(playerAndScore2DArray[2][2] == Character.UNASSIGNED))
					{//if none are left unassigned but no one has won
						playerWinnerChar = 'D'; // Assigning player winner char for printing winner later
						return true; // returning true so while statement ends
					}//end if
					else
					{
						return false; // returning false so while statement continues
					}// end else
		}//end else
		
	}//end endgame
	
	public static char ChoosePlayer(boolean playerChooserBoolean) // Deciding which Player Symbol to print
	{
		if (playerChooserBoolean)
		{
			return 'X'; // for player1
		}//end if
		else
		{
			return 'O'; // for player2
		}//end else
	}// end ChoosePlayer
	
	public static String PrintPlayer(boolean playerChooserBooleanPrint) // printing which player it is
	{
		if (playerChooserBooleanPrint)
		{
			return "Player1"; //return player1 from function
		}//end if
		else
		{
			return "Player2"; //return player1 from function
		}//end else
	}// end printplayer
	
	public static boolean CoordinateTester1()  // user input for Coordinate1
	{	
			if (playerInputCoordinate1 <= 2 && playerInputCoordinate1 > -1) // if variable is within bounds
			{
				return true; // return true for valid input
			} // end if
			else
			{				
				System.out.println("Enter an acceptable Coordinate1!");	// enter an acceptable coordinate1
				return false; // return false for invalid input
			} // end else
	}// end CoordinateInputter1
	public static boolean CoordinateTester2()  // user input for Coordinate 2
	{
			if (playerInputCoordinate2 <= 2 && playerInputCoordinate2 > -1) // if variable is within bounds
			{
				return true;// return true for valid input
			} // end if
			else
			{				
				System.out.println("Enter an acceptable Coordinate2!");	// enter an acceptable coordinate2
				return false; // return false for invalid input
			}//end else
	}// end CoordinateInputter2
	
	public static void PlayerTurn() // player turn method
	{//sets the coordinates as indexes to the gameboardarray and lets the chooseplayer method return the player symbol to assign to the proper place
		playerAndScore2DArray[playerInputCoordinate1][playerInputCoordinate2] = ChoosePlayer(playerChooserBoolean);
		playerChooserBoolean = !playerChooserBoolean; // changing which player it is
	} // end player turn
	
	public static void PrintCurrentGameState(char[][] playerAndScore2DArrayPrint) //Printing the current game state method
	{
		for(int i = 0; i < playerAndScore2DArrayPrint.length; i++) // for loop going through first index
		{
			for(int j = 0; j < playerAndScore2DArrayPrint[i].length; j++) // for loop going through second index
			{
				if (j == 2)//j=2 for new line
				{
					if (playerAndScore2DArrayPrint[i][j] == Character.UNASSIGNED) // if move not already taken
					{
						System.out.println("" + i + j + "     "); // print index values as coordinates to spot
					}//end if
					else
					{
						if(playerAndScore2DArrayPrint[i][j] == 'X') //if has value
						{
							System.out.println(playerAndScore2DArrayPrint[i][j] + " "); //printing
						}//end if
						else
						{
							if(playerAndScore2DArrayPrint[i][j] == 'O')//if has value
							{
								System.out.println(playerAndScore2DArrayPrint[i][j] + " ");//printing
							}//end if
							else
							{
								System.out.println(playerAndScore2DArrayPrint[i][j] + "errPrintLn"); // if by chance some error
							}// end else
						}//end else
					}//end else
				}//end if
				else
				{
					if (playerAndScore2DArrayPrint[i][j] == Character.UNASSIGNED) // if move not already taken // for not new line
					{
						System.out.print("" + i + j  + "     "); // print index values as coordinates to spot
					}//end if
					else
					{
						if(playerAndScore2DArrayPrint[i][j] == 'X')//if has value
						{
							System.out.print(playerAndScore2DArrayPrint[i][j] + " " + "     ");//printing
						}//end if
						else
						{
							if(playerAndScore2DArrayPrint[i][j] == 'O')//if has value
							{
								System.out.print(playerAndScore2DArrayPrint[i][j]+ " " + "     ");//printing
							}//end if
							else
							{
								System.out.print(playerAndScore2DArrayPrint[i][j] + "errPrint");//printing
							}//end else
						}//end else
					}//end else
				}//end else
			}//end for
		}//end for
	}// end PrintCurrentGameState
}// end tictactoeclass
