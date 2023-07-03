
package hw1cs5310_lee_051414;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		StopwatchCPU timer = new StopwatchCPU();
		double startTime;
		
		PrintWriter PrefixFile1 = new PrintWriter("AvgDataRuntime1.txt");
		PrintWriter PrefixFile2 = new PrintWriter("AvgDataRuntime2.txt");

		int[] N = {1, 100, 1000, 5893, 100000, 500000, 1000000};
		Random rand = new Random(); 
		
		int[] X;
		
		for(int n=0; n<N.length; n++)
		{
			X = new int[N[n]];
			for(int i=0; i<X.length; i++)
			{
				X[i] = rand.nextInt((1000 - -1000) + 1) + -1000;
			}			
			
			startTime = System.nanoTime();
			PrefixAvg1_14 prefixAvg1 = new PrefixAvg1_14(X, n);
			PrefixFile1.write(Double.toString((System.nanoTime() - startTime)) + ",");	
			
			System.out.println(n);
			
			startTime = System.nanoTime();
			PrefixAvg2 prefixAvg2 = new PrefixAvg2(X, n);
			PrefixFile2.write(Double.toString((System.nanoTime() - startTime))+ ",");
			System.out.println(n + " : " + N[n]);
		}
		PrefixFile1.close();
		PrefixFile2.close();
		System.out.println("exit");
	}
}
