


/**
 * Timothy Lee
 * Program2: PartB: NumbersAndLoops
 * 1/17/13
 */


import java.util.Scanner;  // importing the scanner for user input


public class NumbersAndLoopsClass   // naming the class
{

	public static double[] numberArrayDouble = new double[0];     // To hold the numbers entered
	public static double[] largestSmallestArrayDouble = new double[2];  // To hold the largest and the smallest of the numbers entered
	
	
	public static void main(String[] args) // Called when program is opened
	{
		FillArrayUserInput(); // get user input to fill an array
		FindLargestAndSmallestArray(numberArrayDouble); // passing the array to find the largest and smallest elements and assign to other array
		System.out.println("The smallest number you entered is " +largestSmallestArrayDouble[0] + ","  + // printing out the largest
				           " the largest is " + largestSmallestArrayDouble[1] + "."); // and smallest elements of the array
	} // end main
	
	public static void FillArrayUserInput()  // get user input to fill array
	{
		double tempDouble; // temp variable to hold and validate user input
		System.out.println("Please enter a number.(Enter -99 to finish)."); // Telling how to end program
		Scanner userInputScanner = new Scanner(System.in);  // instantiating a new scanner
            if (userInputScanner.hasNextDouble()) // if next user input is an Double
    		{
            	tempDouble = userInputScanner.nextDouble(); // assigning user input to temp variable
            	if (tempDouble != -99) // checking if end program
            	{
            		numberArrayDouble = IncreaseArray(numberArrayDouble, 1); // increasing array by one
            		numberArrayDouble[numberArrayDouble.length - 1] = tempDouble;  // assign to double array
            		tempDouble = 0; // tempdouble back to zero
            		FillArrayUserInput();    // recursive call    		
            	} // end if
            	else
            	{
            		for(int i =0; i < numberArrayDouble.length; i++) // printing contents of array for
            		{
            		System.out.println(numberArrayDouble[i]);
            		} // end for
            	} // end else
    		}// end if
            else
            {
            	System.out.println("Please enter a proper numerical value for input!"); // validating user input
            	FillArrayUserInput(); // recursive call
            } // end else
		}// end fillarrayuserinput
	
    public static double[] IncreaseArray(double[] arrayIncreaseArray, int increaseByInteger)  // Method to increase array bounds by one
    {  
        int i = arrayIncreaseArray.length;                       //hold old length value
        int n = ++i;                                            //n = i+1
        double[] newArray = new double[n];                       // new array with new size
        for(int cnt=0; cnt < arrayIncreaseArray.length; cnt++)   // for statement assigning elements of old array to new one
        {  
            newArray[cnt] = arrayIncreaseArray[cnt];  
        } // end for 
        return newArray;  // return new array for assigning to old one when method is called
        } // end increasearray 
    
    public static void FindLargestAndSmallestArray(double[] numberArray)  // finding the largest and smallest element
    {
    	largestSmallestArrayDouble[1] = numberArray[0];  // so the zero element is included an no exception is thrown
    	largestSmallestArrayDouble[0] = numberArray[0];  // so the zero element is included an no exception is thrown
    	for (int i = 1; i < numberArray.length; i++) // single for statement for both searches
    	{
    		if (numberArray[i] > largestSmallestArrayDouble[1]) // if new element larger than saved element
    		{
    			largestSmallestArrayDouble[1] = numberArray[i]; // assign new element to saved elements spot
    		} // end if
    		else
    		{    
    		if (numberArray[i] < largestSmallestArrayDouble[0]) // if new element larger than saved element
    		{
    			largestSmallestArrayDouble[0] = numberArray[i]; // assign new element to saved elements spot
    		} // end if
    		} // end else
    	} // end for
    	
    }// end findlargestandsmallestarray
}// numbersandloopsclass

