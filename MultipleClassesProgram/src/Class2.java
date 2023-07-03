
public class Class2 
{
	private String girlName;
	
	public Class2(String name)
	{
		girlName = name;
	}
	
	public void setName(String name)
	{
		girlName = name;
	}
	
	public String getName()
	{
		return girlName;
	}
	
	public void saying()
	{
		System.out.printf("Your first gf was %s.\n",  getName());
	}
	
	public void SimpleMessage()
	{
		System.out.println("This is another class!");
	}
}
