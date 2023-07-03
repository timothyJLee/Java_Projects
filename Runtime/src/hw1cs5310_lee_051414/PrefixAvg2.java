
package hw1cs5310_lee_051414;

public class PrefixAvg2 {
	/*
Algorithm prefixAverages2(X):
Input: An n-element array X of numbers.
Output: An n-element array A of numbers such that A[i] is
the averagé of elements X [O],. .. ,X [i].
-----------------------------------------------
Let A be an array of n numbers.
s<-0
for i<-0 to n-1 do
	s<-s+X[i]
	A[i]<-s/(i+1)
return array A
					Algorithm 1.15: Algorithm prefixAverages2.
	 */
	
	private double[] A; // avg of elements of X[0] to X[i]
	private int s; // calculated average for any given A[i]
	
	public PrefixAvg2(int[] X, int n)
	{	
		
		A = new double[X.length];
		s = 0;
		for(int i=0; i<X.length; i++)
		{
			s += X[i];
			A[i] = s/(i+1);
		}
	}
	
	public double[] getA() {
		   return this.A;
		}
}
