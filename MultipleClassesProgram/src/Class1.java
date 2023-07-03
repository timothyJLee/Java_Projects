import java.util.Scanner;


public class Class1 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter your first gf name.");
		Scanner sc = new Scanner(System.in);
		Class2 class2Object = new Class2(sc.next());
		class2Object.saying();
		class2Object.SimpleMessage();
	}
}
