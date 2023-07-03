



/**
 * Timothy Lee
 * Program3: PartA: NameInputAndSort
 * 1/17/13
 */



import java.util.ArrayList;  // importing files for arraylist
import java.util.Arrays;  // importing for array stuff
import java.util.List;   //  importing for lists
import java.util.Scanner;  // importing for userinputscanner


public class NameInputAndSortClass 
{

	public static List<String> userInputArrayList = new ArrayList<String>();    // instantiating a string list
	public static String[] userInputStringArray;                                    // creating an array to hold the arraylist
	public static Scanner userInputScanner = new Scanner(System.in);         // instantiating a scanner for user input
	public static String tempString;                                       // temp string to hold user input
	
	
	public static void main(String[] args) 
	{				
		FillArrayListUserInput();               // fill the array from user input
		SortArrayOfNames();		               // method to sort the array in ascending order
		System.out.println();                 // extra line for extra readability
		System.out.println("Here are the names you entered, sorted in ascending order.");  // Telling the user what happend
		for(int i =0; i < userInputArrayList.size(); i++) // for statement to display elements of sorted array
		{
			System.out.println(userInputStringArray[i].toString()); // print statement for individual element
		}// end for
	}// end main
	
	public static void FillArrayListUserInput()  // Method to prompt for user input for arraylist
	{
		System.out.println("Please enter a Name...  Enter a blank line to Exit."); // telling user how to exit program
		tempString = userInputScanner.nextLine();  // filling tempString with userinput
    	if (!tempString.isEmpty()) // if tempstring isn't a blank line
    	{    		
    		userInputArrayList.add(tempString);  // adding elements to the list
    		FillArrayListUserInput();            //recursive call		
    	}// end if
    	else
    	{
    		System.out.println("Thank you.  Here are the names you entered.");  // displaying the unsorted names
    		userInputStringArray = userInputArrayList.toArray(new String[userInputArrayList.size()]); // converting the list to an array
    	
    		for(int i =0; i < userInputStringArray.length; i++) // for to print new array
    		{
    			System.out.println(userInputStringArray[i].toString());  // printing element of array
    		}// end for
    	}// end else
	}// end fillarraylistuserinput
	
	public static void SortArrayOfNames() // method to sort array in ascending order
	{
		Arrays.sort(userInputStringArray); // Sorting the array with the Arrays.sort
	}// end sortarrayofnames
}// end nameinputandsortclass
