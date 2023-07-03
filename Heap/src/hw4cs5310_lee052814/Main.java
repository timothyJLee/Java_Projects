package hw4cs5310_lee052814;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		StopwatchCPU timer = new StopwatchCPU();
		double startTime;
		
		PrintWriter arrayHeapFile1 = new PrintWriter("arrayHeap.txt");
		PrintWriter explicitHeapFile2 = new PrintWriter("explicitHeap.txt");
		PrintWriter Kselect = new PrintWriter("Kselect.txt");

		int[] N = {10, 50, 100, 1000, 10000, 100000, 1000000};
		Random rand = new Random(); 
		
		int[] X;
		int[] K;
		
		for(int n=0; n<N.length; n++)
		{
			X = new int[N[n]];
			K = new int[N[n]];
			for(int i=0; i<X.length; i++)
			{
				X[i] = rand.nextInt((5*n - -(5*n)) + 1) + -(5*n);
				K[i] = rand.nextInt((int)(((.2*n - -(.2*n)) + 1) + -(.2*n)));
			}			
			
			startTime = System.nanoTime();
			array_based_heap arrayHeap = new array_based_heap(X, n);
			arrayHeapFile1.write(Double.toString((System.nanoTime() - startTime)) + ",");	
			
			System.out.println(n);
		
			startTime = System.nanoTime();
			explicit_tree_based_heap explicitHeap = new explicit_tree_based_heap(X, n);
			explicitHeapFile2.write(Double.toString((System.nanoTime() - startTime))+ ",");
			System.out.println(n + " : " + N[n]);			
			
			explicit_k_select_heap KselectHeap = new explicit_k_select_heap(X, n);
			startTime = System.nanoTime();
			for(int i=0; i<K[n]; i++)
			{
				KselectHeap.Remove();				
			}
			Kselect.write(Double.toString((System.nanoTime() - startTime))+ ",");
		}
		arrayHeapFile1.close();
		explicitHeapFile2.close();
		Kselect.close();
		System.out.println("exit");
	}

}
