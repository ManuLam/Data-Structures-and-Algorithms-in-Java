//Implementing a stack that resizes double when full and halving when quarter full
//Saves space and time comparing to a LinkedList Stack, Every Operation is constant "amortized time" compared to LinkedList's worst case "constant time"


import java.util.Iterator;
import java.util.NoSuchElementException;

//public class StackResizing<Item> implements Iterable<Item> {
public class StackResizing {
	private String[] strArray;
	private int top;


    public StackResizing() {
    	strArray = new String[2];
    	top = 0;
    }

    public boolean isEmpty() {
    	return top == 0;
    }

    public int size() {
    	return top;
    }

    public void resize(int size) {
    	assert size >= top;
    	String[] temp = new String[size];
    	for(int i=0; i<top; i++) {
    		temp[i] = strArray[i];
    	}
    	strArray = temp;
    }

    public void push(String s) {
    	if(top == strArray.length) resize(strArray.length*2);
		strArray[top++] = s;
    }

    public String pop() {
		if(this.isEmpty()) throw new NoSuchElementException("Stack underflow");
		String item = strArray[top-1];
		strArray[top-1] = null;
		top--;

		if(top > 0 && top == strArray.length/4) resize(strArray.length/4);
		return item;
    }

    public String peek() {
    	if(this.isEmpty()) throw new NoSuchElementException("Stack underflow");
    	return strArray[top-1];
    }


}

// Testing in running program
public class Stack {

    public static void main(String[]args) {
    	StackResizing stack = new StackResizing();

		stack.push("this");
		stack.push("is");
		stack.push("the");
		stack.push("best");
		stack.push("code");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());

    }
}