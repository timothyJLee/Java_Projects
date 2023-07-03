

/**
 * Timothy Lee
 * Program1: PartB: Roman Numerals
 * 1/13/13
 */

import java.util.Scanner;  // importing the scanner to receive user input

public class RomanNumerals // Giving the class a name that fits
{
	public static String outputString;  // declaring static ouputString so multiple methods can access
	
	public static void main(String[] args) //main method for the program...
	{				
		System.out.println("Please enter a value 1-10 to convert to Roman Numerals."); // prompting user for input
		
		RomanNumeralSwitch(); // calling method for validating user input and converting to Roman Numeral
		
		System.out.println("Your number in Roman Numerals is: " + outputString); // Displaying the Roman Numeral Result
	}//End of Main
	
	public static void RomanNumeralSwitch() // Holding control structures to decide roman numerals
	{
		Scanner userInputScanner = new Scanner(System.in); // declaring scanner for user input
		int userInputInteger;  // declaring integer for holding correct user input
		
		if (userInputScanner.hasNextInt()) // if next user input is an integer
		{
			userInputInteger = userInputScanner.nextInt();  // assign to integer variable
			if (userInputInteger <=10 && userInputInteger > 0) // if variable is within bounds
			{
			switch (userInputInteger) {  // switch statement assigning outputString the proper Roman Numeral
            case 1:  outputString = "I";
                     break;
            case 2:  outputString = "II";
                     break;
            case 3:  outputString = "III";
                     break;
            case 4:  outputString = "IV";
                     break;
            case 5:  outputString = "V";
                     break;
            case 6:  outputString = "VI";
                     break;
            case 7:  outputString = "VII";
                     break;
            case 8:  outputString = "VIII";
                     break;
            case 9:  outputString = "IX";
                     break;
            case 10: outputString = "X";
                     break;
                     default: ; // Empty default because I thought of everything...
                    	 break;
			}//End of switch
		}// end of if
			else
			{
				System.out.println("Please enter a Value 1-10!"); // Integer Value was not between 1 and 10.
				RomanNumeralSwitch();  // Recursive Call
			}// End Else
		}//End of If
		else
		{
			System.out.println("Please enter a proper Integer Value 1-10!"); // Input was not an Integer..
			RomanNumeralSwitch(); // Recursive Call
		} // End of Else
	}//RomanNumeralSwitch
}//RomanNumeralClass
