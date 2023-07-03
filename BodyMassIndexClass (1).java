

/**
 * Timothy Lee
 * Program2: PartA: Body Mass Index (BMI)
 * 1/13/13
 */

import java.text.DecimalFormat;  // importing necessary files for Decimal Format
import java.util.Scanner;        // importing necessary files for gathering user input


public class BodyMassIndexClass //Naming of class
{
	public static double heightInchesDouble;      // to hold the users height in inches
	public static double weightPoundsDouble;      // to hold the users weight in pounds
	public static double BMIDouble;               // to hold the users BMI
	public static String BMIConclusionString;     // to hold the string explaining if user is overweight
	
	public static void main(String[] args)   // main starts the program
	{	
		DecimalFormat decimalFormat = new DecimalFormat("#.#");   // Telling the computer how to format the decimals
		
		System.out.println("Body Mass Index (BMI) Calculator!");	  // Printing what the program does to the user
		System.out.println("Enter your height");                  // Telling user to input height
		HeightInputter();                                        // Calling the input height method
		System.out.println("Enter your weight");                  // prompting user to input weight
		WeightInputter();                                       // calling the weightinput method
		BMICalculator();                                       // Calling BMI calculate method
		System.out.println("Your height is " + decimalFormat.format(heightInchesDouble) + "inches" + ".  Your weight is " + decimalFormat.format(weightPoundsDouble) + "pounds.");
		System.out.println("Your Body Mass Index (BMI) is " + decimalFormat.format(BMIDouble));  // outputting height weight BMI
		BMIConclusion(); // Telling people what their BMI means
	} // main
	
	public static void HeightInputter()	// Method for getting user input for height
	{
		Scanner userInputScanner = new Scanner(System.in);  // Instantiating the scanner
		if (userInputScanner.hasNextDouble()) // if next user input is a Double
		{
			heightInchesDouble = userInputScanner.nextDouble();  // assign to double variable
			
			if (heightInchesDouble <= 108 && heightInchesDouble > 0) // if variable is within bounds
			{
				
			} // end if
			else
			{				
				System.out.println("Enter an acceptable hieght!");	// enter a human height
				HeightInputter(); // recursive call
			} // end else
		}
		else
		{
			System.out.println("Enter your height in Inches as a number!"); // enter numbers
			HeightInputter();			//recursive call
		} // end else
	}// HeightInputter
	
	public static void WeightInputter()  // user input for weight
	{
		Scanner userInputScanner = new Scanner(System.in);  // instantiating scanner
		if (userInputScanner.hasNextDouble()) // if next user input is a double.
		{
			weightPoundsDouble = userInputScanner.nextDouble();
			
			if (weightPoundsDouble <= 900 && weightPoundsDouble > 0) // if variable is within bounds
			{
				
			}// end if
			else
			{
				System.out.println("Enter an acceptable weight!"); // Enter a human weight
				WeightInputter(); // recursive call
			}// end else
		} // end if
		else
		{
			System.out.println("Enter your weight in pounds as a number!");  // enter numbers
			WeightInputter(); // recursive call
		} // end else
	}// end weightinputter
	
	public static void BMICalculator()  // calculating BMI
	{
		//BMI = (weight in pounds * 703) / height in inches2
		BMIDouble = (weightPoundsDouble / Math.pow(heightInchesDouble, 2)) * 703;
	}// end BMICalculator
	
	public static void BMIConclusion() // Telling what BMI means
	{
		/*BMI < 18.5 underweight
		18.5 < BMI < 25optimal weight
		BMI > 25overweight*/
		
		if (BMIDouble < 18.5)
		{
			System.out.println("You are underweight."); // Telling someone to eat
		} // end if
		else
		{
			if (BMIDouble > 25)
			{
				System.out.println("You are overweight."); // Telling someone they are overweight
			} // end if
			else
			{
				System.out.println("You are at the optimal weight."); // Telling someone they are fit
			}// end else
		}// end else
	}// end BMIConclusion	
}// end BodyMassIndexClass


