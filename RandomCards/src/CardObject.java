


/**
 * Timothy Lee
 * Program4: PartA: Random Card Deal
 * 2/1/13
 */

/*
 * Part A (50 points) – Cards. Write a simple Java programming solution that will deal out cards and display them to the
 *user. Deal out 1000 random cards.  Be sure to include the suit and the card's value. (i.e. AD for Ace of Diamonds, 
 *JS for Jack of Spades, 9C for a nine of clubs.)  Store the values in an array and display them to the user 
 *in a readable format of 10 cards to a line and a blank line between every 100 cards.
 */

public class CardObject //object card to be made into an array
{
	private String _suiteAndValueString; // private backing field
	private int _totalNumberDealtInt;  // private backing field	
	
	public CardObject() // default constructor
	{
		this(null);
	} // end default constructor
	
	public CardObject(String cardValuePassedString) // parameterized constructor passing in input file data
	{
		SetSuiteAndValue(cardValuePassedString); // using the set
	} // end parameterized constructor	
	
	public void SetSuiteAndValue(String _suiteAndValueString) // public property
		{
		   this._suiteAndValueString = _suiteAndValueString;
		} // end property
	public String GetSuiteAndValue() // public property
		{
		   return this._suiteAndValueString;
		} // end property
	
	public void SetTotalNumberDealt(int _totalNumberDealtInt) // public property
		{
		   this._totalNumberDealtInt = _totalNumberDealtInt;
		} // end property
	public int GetTotalNumberDealt() // public property
		{
		   return this._totalNumberDealtInt;
		} // end property	
	
	public int IncrementTotalNumberDealt() // method to increment the total in the 1000 card assigner
	{
		return ++this._totalNumberDealtInt;
	} // end incrementtotalnumberdealt
	
	public String toString()  // toString method to format output
	{
		return String.format("%s", GetSuiteAndValue()); // string format
	} // end tostring
} // end cardobject
