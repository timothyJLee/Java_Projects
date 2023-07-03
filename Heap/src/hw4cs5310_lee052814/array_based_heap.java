package hw4cs5310_lee052814;

import java.util.*;

public class array_based_heap
{
	
	private int[] Heap;
	private int n;
	private static int total;
	
	public array_based_heap(int[] heap, int num)
	{
		n = num;
		Heap = new int[n];	
		total = 0;
		for(int i=0; i<n; i++)
		{
			add(heap[i]);
		}
	}
    
    private void swimUp()
    {
        int p = n-1;  // Position to swim up
        while (p != 0)
        {
           int parent = (p-1) / 2;           
           if (Heap[p] >= Heap[parent])
           {
               // We are done
               break;
           }
           else
           {
              // Do a swap
              Integer temp = Heap[parent];
              Heap[parent] = Heap[p];
              Heap[p] = temp;
              
              // Move up
              p = parent;
           }            
        }
    }
    
    boolean add(int x)
    {
       // Add x at the end of the array list
       Heap[total] = x;
       
       total++;
       // swim up
       swimUp();
       return true;
    }
}
