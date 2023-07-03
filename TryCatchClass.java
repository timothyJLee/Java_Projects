

import java.util.Scanner;


public class TryCatchClass {
	
	public static void main(String[] args) 
	{
		int waitTime;
		String exitString = "enter";
		Scanner userInputScanner = new Scanner(System.in);
		
		while(exitString.compareTo("Exit") != 0)
		{
			try
			{
				System.out.println("Please Enter a Wait Time.  Type \"Exit\" to exit...");
				if(userInputScanner.hasNextInt())
				{
					waitTime = userInputScanner.nextInt();
					if(waitTime < 0 || waitTime > 30)
					{
						throw new IllegalArgumentException();
					}
					else
					{
						System.out.println(waitTime);
					}
				}
				else
				{						
					exitString = userInputScanner.nextLine();
				}
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e);
				System.out.println("Please Enter an Acceptable Wait Time!!!");
			}
		}
	}
}
