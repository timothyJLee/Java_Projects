

/**
 * Timothy Lee
 * Program1: PartA: MilesToKilometers
 * 1/13/13
 */



import java.lang.Math;  // import math class for raising to a power...

public class MilesToKilometers 
{
	/** Class to convert predetermined amount of miles to kilometers... */
	
	public static void main(String[] args) // main method to run at the beginning of the program...
	{
		double beginningNumberDouble = 10;  // declaring field to hold base number
	    double powerIncrementDouble = 3;    //  field to hold power
		
		System.out.println("Convert powers of ten in miles to kilometers...");
		
		do  // do while to control recursive call to DisplayResult
		{
			DisplayResult(beginningNumberDouble, powerIncrementDouble);
			powerIncrementDouble--;	//decrementing the value to deal with power of ten and recursive call.
		} while (powerIncrementDouble != -1); // lets it run with 0 to handle the value of 1.
	}//End of Main
	
	public static void DisplayResult(double baseDouble, double powerDouble)
	{// method to display the results  to the console
		double tempHoldDouble = 0; // to hold ten to a power
		tempHoldDouble = Math.pow(baseDouble, powerDouble);
		System.out.println(baseDouble + " to the " + powerDouble + " power is " +
		                 tempHoldDouble + ".");  // displaying the result of the power calculation
		ConvertMilesToKilometers(tempHoldDouble);  // calling the method to convert miles to kilometers
	}//End of Display Result
	
	public static void ConvertMilesToKilometers(double milesDouble)
	{ // methods to convert miles to kilometers
		double kilometersDouble; // field to hold the result in kilometers
		
		kilometersDouble = milesDouble * 1.609344;  // the calculation to convert to kilometers
		
		System.out.println(milesDouble + "miles equals " + kilometersDouble + "kilometers."); /* displaying the result to
		 the console... */
	}//End of ConvertMilesToKilometers	
}//End of MilesToKilometersClass
