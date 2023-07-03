
package hw4cs5310_lee052814;

import java.util.*;

public class explicit_tree_based_heap {
  private int n;
  private List<Node> heap;
  private int size = 0;
  
  private class Node {public int element;    public int position;  }    

  private int parent(int i) {return i/2;}
	  
  public explicit_tree_based_heap( int[] array , int num) 
  {
	size = 0;
    n = num;
    
    heap = new ArrayList<Node>();

    for (int i=0;i<n;i++)
    	{
    	insert(array[i]);
    	}
  }

  public void insert( int element ) {
    size++;
    Node node = new Node();
    node.element = element;
    node.position = size-1;
    heap.add(node);
    decrease( node );
  }
  
  private boolean decrease( Node deNode ) {
    int index = deNode.position;
    boolean modified = false;

    while ( index>0 &&  heap.get(parent(index)).element > heap.get(index).element  ) 
    {
      exchange( index, parent(index) );
      index = parent(index);
      modified = true;
    }

    return modified;
  }

  private final void exchange( int index, int index2 ) {
    Node temp = heap.get(index);
    temp.position = index2;

    Node temp2 = heap.get(index2);
    temp2.position = index;

    heap.set(index, temp2 );
    heap.set( index2, temp);
  }




 
}

   
  
