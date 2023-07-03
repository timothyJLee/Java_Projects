



/**
 * Timothy Lee
 * Program4: PartA: Random Card Deal
 * 2/1/13
 */


/*
 * Part A (50 points) – Cards. Write a simple Java programming solution that will deal out cards and display them to the
 *user. Deal out 1000 random cards.  Be sure to include the suit and the card's value. (i.e. AD for Ace of Diamonds, 
 *JS for Jack of Spades, 9C for a nine of clubs.)  Store the values in an array and display them to the user 
 *in a readable format of 10 cards to a line and a blank line between every 100 cards.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CardDealClass {  // overall Java class

	public static void main(String[] args)  // main class for start of program...
	{
		File cardDataFile = new File("CardData.txt");  // file to be read for array input
		Random numberRandom = new Random();   // random number for assigning 1000 cards
		
		try // trying to catch some errors
		{
		Scanner scanner = new Scanner(cardDataFile); // instantiating the scanner
		
		CardObject[] cardObjectArray = new CardObject[Integer.parseInt(scanner.nextLine())]; // instantiating an array
		  // the size of the input file which is written on the first line of the input file
		
		while (scanner.hasNextLine()) // while there is another line in the input file
		{
			for (int i = 1; i < cardObjectArray.length; i++)  // for loop instantiating a new card and 
			{  // inputting the array initialization data from the input file
	             cardObjectArray[i] = new CardObject(scanner.nextLine()); // passing input file data as parameter to 
			}// end for				// Card object constructor
        }// end while
		
		for (int i = 0; i < 1000; i++)  // for loop for assigning 1000 random cards
		{   // picking random element of cardobject array and call the inrement total number cards dealt method
			cardObjectArray[(numberRandom.nextInt(52) + 1)].IncrementTotalNumberDealt();			            
		} // end for
		
		int cardCounterInt = 0;  // card counter to not interfere with the loops
		for (int j = 1; j < cardObjectArray.length; j++)  // deciding which card to print
		{
			
			for (int i = 1; i <= cardObjectArray[j].GetTotalNumberDealt(); i++)
			{ // for loop for printing the correct number of cards using the public get to get total number dealt
				cardCounterInt++;  // increasing card counter
					if (cardCounterInt % 10 == 0)  // if cardcounter is divisible by ten
					{
						System.out.printf("%s.\n",cardObjectArray[j].toString()); // print with new line						
						if (cardCounterInt % 100 == 0) //  if cardcounter divisible by 100
						{
							System.out.println(); // print a new line
						} // end if	
					} // end if
					else
					{
						System.out.printf("%s, ",cardObjectArray[j].toString()); // else print normally
					} // end else
			} //end for		
		}// end for
		}// try
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}// end catch
	}//end main
}//end carddealclass