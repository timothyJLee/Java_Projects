import java.util.Random;




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


public class TesterClass 
{

	public static void main(String[] args) 
	{
		Random numberRandom = new Random(); 
		Animal[] newAnimal = new Animal[10];
		for (int i = 0; i < newAnimal.length; i++)
		{
			switch (numberRandom.nextInt(3))
			{
			case 0: newAnimal[i] = new Cat("Harold");
				break;
			case 1: newAnimal[i] = new Dog("Rex");
				break;
			case 2: newAnimal[i] = new Trex("Spot");
				break;
			}
		}
		
	}
}
