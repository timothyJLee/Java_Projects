



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



public class Dog extends Animal
{
	public Dog()
	{
		this(null);
	}
	
	public Dog(String nameInput)
	{      super(nameInput);
		SetName(nameInput);
		System.out.println(GetName() + ", the dog says, \"" + MakeSound() + ".\"");
	}
	
	protected String MakeSound()
	{
		return "Bark, bark";
	}
}
