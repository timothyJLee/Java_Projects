
package hw1cs5310_lee_051414;

import java.io.*;

public class PrefixAvg1_14 
{
	/*
Algorithm prefixAveragesl(X):
Input: An n-element array X of numbers.
Output: An n-element array A of numbers such that A [i] is
the average of elements X {O],. . . , X [i].
---------------------------------------------
Let A be an array of n numbers.
for i<-0 to n-1 do
	a<-0
	for j <-0 to n-1 do
		a<-a+X[j]
	A[i]<-a/(i+1)
return array A
			Algorithm 1.14: Algorithm prefixAveragesi.
	 */
	
	private double[] A; // avg of elements of X[0] to X[i]
	private int a; // calculated average for any given A[i]
	
	public PrefixAvg1_14(int[] X, int n) throws FileNotFoundException 
	{		
		A = new double[X.length];
		for(int i=0; i<X.length; i++)
		{
			a = 0;
			for(int j=0; j<X.length; j++)
			{
				a += X[j];
			}
			A[i] = a/(i+1);
		}
	}
	
	public double[] getA() {
		   return this.A;
		}
}
