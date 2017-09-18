//This is an Unsorted Priority Queue, it has a self resizing algorithm where it saves time and space
//A Test program is placed under the class

import java.util.NoSuchElementException;
import java.util.Iterator;

public class UnsortedPriortyQueue<Key extends Comparable<Key>> {	// Extending a key to be comparable
	private Key[] pq;		//declaring a Key queue
	private int n;			//declaring a size counter

    public UnsortedPriortyQueue() {
    	pq = (Key[])new Comparable[2];	//declares a starting size of 2
    	n = 0;							// 0 element
    }

    public boolean isEmpty() { return n==0; }	//return if queue is empty
    public int size() { return n; }				//return the total amount of elements

    public void resize(int size) {				//resizing the queue to x2 the size if full, 1/2 the size if its 1/4 full
    	assert size >= n;						//prove test
    	Key[] temp = (Key[]) new Comparable[size];	//temp queue
    	for(int i=0; i<n; i++)						//filling elements
    		temp[i] = pq[i];
    	pq = temp;									//updating the queue
    }

    public void insert(Key k) {						//inserting elements inside the queue
    	if(n==pq.length) resize(2*pq.length);		//if queue is full, then array is resized to x2 the original
    	pq[n++] = k;								//setting the element into next position UNSORTED
    }

    public Key returnMax() {
    	if(isEmpty()) throw new NoSuchElementException();	//throwing an error
    	int max = 0;										//base case max
    	for(int i= 1; i<n; i++)								//looping until a max is found
    		if(max(max,i)) max = i;
    	swap(max,n-1);										//swap max with last position in queue

    	if(n>0 && n==pq.length/4) resize(pq.length/2);		//if queue is 1/4 full, then queue is resized to 1/2 the original

    	return pq[--n];										//returning the max element
    }

    public boolean max(int x, int y) {						//comparing left to right to prove true or false
    	return pq[x].compareTo(pq[y]) <0;

    }

    public void swap(int x, int y) {						//swap max and last position in queue
    	Key swap = pq[x];
    	pq[y] = pq[x];
    	pq[x] = swap;
    }

    public Key peek() {
    	if(isEmpty()) { throw new NoSuchElementException(); }	//throwing an error
    	return pq[n-1];
    }

    public void displayAll() {
    	StringBuilder s = new StringBuilder();					//building a string to represent the entire Queue
    	for(Key k : pq)
    		s.append(k + " ");

    	System.out.println(s);
    }

}

// Running Program tested
public class unsortedPQTest {
public static void main(String[]args) {
	UnsortedPriortyQueue<String> pq = new UnsortedPriortyQueue<String>();

	pq.insert("this");					//testing methods
	pq.insert("is");
	pq.insert("our");
	pq.insert("best");
	pq.insert("ever");
	pq.insert("attempt");

	pq.displayAll();

	System.out.println(pq.returnMax());
	}
}