

import java.util.Scanner;

public class Calculator 
{	
	public static void main(String arg[]) 
	{
		
		
		
		
		Scanner scannerInput = new Scanner(System.in);
		double firstDouble, secondDouble, answerDouble;
		System.out.println("Enter first Number: ");
		firstDouble = scannerInput.nextDouble();
		System.out.println("Enter second Number: ");
		secondDouble = scannerInput.nextDouble();
		answerDouble = firstDouble + secondDouble;
		System.out.println(answerDouble);
	}
}
