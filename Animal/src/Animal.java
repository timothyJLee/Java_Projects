


/** Timothy Lee
 * Program5: PartA: Animal
 * 2/13/13
 */


/*
   Part A (50 points) – Objects. Write a simple Java programming solution that will define an Animal class.
   Next, define three different types of objects: a dog, a cat, and a tRex. For each of the objects have an instance 
   variable for the name. All of these objects extend the Animal class.
   In each of the animals build a makeSound() method. The dog can safe "bark, bark", the cat "meow, meow" and the tRex 
   says "ROOOOOAAAAAAR!"
   Next, construct a "Tester" class. In it, build an array of 10 randomly generated Animals - (You can use: 0 - dog, 1 - 
   cat, 2 - tRex)
   Give each animal a name and using a loop, print out their name and the sound they make!
 */


abstract class Animal 
{
	
	private String name;
	
	public Animal()
	{
		this(null);
	}
	
	public Animal(String nameInput)
	{
		SetName(nameInput);
	}
	
	public void SetName(String inputtedName) // public property
	{
	   this.name = inputtedName;
	} // end property
    public String GetName() // public property
	{
	   return this.name;
	} // end property
	
	
	protected abstract String MakeSound();
}
