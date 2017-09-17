//Implementing a queue that resizes double when full and halving when quarter full
//Saves space and time comparing to a LinkedList Queue, Every Operation is constant "amortized time" compared to LinkedList's worst case "constant time"

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueResizing {
	private String[] strArray;
	private int total;
	private int first;
	private int last;

    public QueueResizing() {
    	strArray = new String[2];
    	total = 0;
    	first = 0;
    	last = 0;
    }

    public boolean isEmpty() {
    	return total == 0;
    }

    public int size() {
    	return total;
    }

    public void resize(int size) {
    	assert size >= total;
    	String[] temp = new String[size];
    	for(int i=0; i<total; i++) {
    		temp[i] = strArray[(first+i) % strArray.length];
    	}
    	strArray = temp;
    	first = 0;
    	last = total;	//set the last element to the midpoint when resized
    }

    public void enqueue(String s) {
    	if(total==strArray.length) resize(2*strArray.length); // doubling the size of array if its full
    	strArray[last++] = s; // adding the item to the wrapped place [0]
    	if(last==strArray.length) last = 0; // Wrap around (Only happens once when last reaches 2)
    	total++;
    }
    //["LAST",NULL,NULL,"Front","2","3", , , , , , ,] Front always increases, never falling back... leaving nulls

    public String dequeue() {
    	if(this.isEmpty()) throw new NoSuchElementException("Queue Underflow"); //if its empty
    	String item = strArray[first];
    	strArray[first] = null;
    	total--;
    	first++;
    	if(first == strArray.length) first=0; //When the array is literally full with 1 element
    	if(total>0 && total == strArray.length/4) resize(strArray.length/2); // halving the size of array if its 1/4 full
    	return item;
    }

    public String peek() {
    	if(this.isEmpty()) throw new NoSuchElementException("Queue Underflow");
    	return strArray[first];
    }
}

// Testing in running program
public class Queue {

    public static void main(String[]args) {
    	QueueResizing queue = new QueueResizing();

		queue.enqueue("this");
		queue.enqueue("is");
		queue.enqueue("the");
		queue.enqueue("best");
		queue.enqueue("code");

		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println(queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty());

    }
}