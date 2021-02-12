import java.util.ArrayList;
import java.util.PriorityQueue;

public class Exercises {

	/**
	 * Exercise 1 
	 * 
	 * a) False, heaps are not binary search trees.
	 * b) False, nodes within a heap can contain the same values.
	 * c) True, the largest value in a min-heap, if unique, is always a leaf.
	 * d) True, you can only have one node per child..
	 * e) True, if a heap has n nodes, a new node can be inserted using at most log(base2) n + 1 comparisons.
	 * f) False, an array is the most economical implementation of a heap.
	 * 
	 */
	
	/**
	 * Exercise 2
	 * 
	 * a) see separate document
	 * b) see separate document
	 * 
	 */
	
	/**
	 * Exercise 3
	 * 
	 * a) Indices of:
	 *    Parent - i / 2
	 *    Left child - (2 * i)
	 *    Right child - (2 * i) + 1
	 *   
	 * b) x[i] is a leaf is i >= total number of nodes (n) / 2
	 * 
	 * c) The number of levels in a heap is log(base 2) of n
	 * 
	 */
	
	/**
	 * Exercise 4
	 * 
	 * My thinking for this exercise was to recursively add elements
	 * in chunks of two to the power of i. Since each level of the heap
	 * has two to the i elements, that is how i was going to navigate the heap in order. 
	 *
	 * The book had a helper method than check if 2*k was less than n then
	 * added the nodes to a string. Less complicated than what I was trying to do. 
	 */

	public void traverseInOrder(int[] x, int n, int stopper, int start) {
		int[] answer = new int[n];
		stopper = 1;
		start = 1;
		for (int i = 1; i <= stopper; i++) {
			answer[i] = x[i];
			start++;
		}
		traverseInOrder(x, n, (int) Math.pow(2, stopper++), start);
		
	}
	
	/**
	 * Exercise 5
	 * 
	 * a) see separate document
	 * b) see separate document
	 * 
	 */
	
	/**
	 * Exercise 6
	 * 
	 * This is less efficient than a heap because in a heap, a node's number can
	 * tell us exactly where in the tree we can find it.
	 */
	public void exercise6() {
		ArrayList<Integer> myQueue = new ArrayList<Integer>();
		
	}
	
}
