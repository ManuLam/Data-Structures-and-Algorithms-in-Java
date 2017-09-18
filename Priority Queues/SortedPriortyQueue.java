//This is a Sorted Priority Queue, it has a self resizing algorithm where it saves time and space
//A Test program is placed under the class

import java.util.NoSuchElementException;
import java.util.Iterator;

public class SortedPriortyQueue<Key extends Comparable<Key>> {	// Extending a key to be comparable
	private Key[] pq;											//declaring a Key queue
	private int n;												//declaring a size counter

    public SortedPriortyQueue() {
    	pq = (Key[])new Comparable[2];							//declares a starting size of 2
    	n = 0;													//0 element in the queue
    }

    public boolean isEmpty() { return n==0; }					//return boolean if queue is empty
    public int size() { return n; }								//return the total amount of elements

    public void resize(int size) {								//resizing the queue to x2 the size if full, 1/2 the size if its 1/4 full
    	assert size >= n;										//prove test
    	Key[] temp = (Key[]) new Comparable[size];				//temp queue
    	for(int i=0; i<n; i++)									//filling elements
    		temp[i] = pq[i];
    	pq = temp;												//updating the queue
    }

    public void insert(Key k) {									//inserting elements inside the queue
		int i=n-1;												//arranging the queue into a sorted data structure
		while(i>=0 && max(k,pq[i])) {
			pq[i+1] = pq[i];
			i--;
		}

    	pq[i+1] = k;											//allowing i position to be the "inserted value"'s location
		n++;													//raising total amount of elements
		if(n==pq.length) resize(2*pq.length);					//if queue is full, then array is resized to x2 the original
    }

    public Key returnMax() {
    	if(isEmpty()) throw new NoSuchElementException();		//throwing an error
    	if(n>0 && n==pq.length/4) resize(pq.length/2);			//if queue is 1/4 full, then queue is resized to 1/2 the original

    	return pq[--n];											//returning the larger element
    }

    public boolean max(Key k, Key y) {							//comparing left to right to prove true or false
    	return k.compareTo(y) <0;

    }

    public Key peek() {
    	if(isEmpty()) { throw new NoSuchElementException(); }		//throwing an error
    	return pq[n-1];
    }

    public void displayAll() {
    	StringBuilder s = new StringBuilder();				//building a string to represent the entire Queue
    	for(Key k : pq)
    		s.append(k + " ");

    	System.out.println(s);
    }

}

//Running Program tested
public class test {
public static void main(String[]args) {
	SortedPriortyQueue<String> pq = new SortedPriortyQueue<String>();

	pq.insert("this");						//testing methods
	pq.insert("is");
	pq.insert("our");
	pq.insert("best");
	pq.insert("ever");
	pq.insert("attempt");

	pq.displayAll();

	System.out.println(pq.returnMax());
	}
}