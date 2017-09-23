import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {
	private int n; //size
	private Node first; //

	  public LinkedList() {
	  	first = null;
	  	n = 0;
	  	assert check();

    }

    public boolean isEmpty() {
    	return n==0;
    }

    public int size() {
    	return n;
    }

    public void insert(Item item) {
    	Node oldfirst = first;
    	first = new Node();
    	first.item = item;
    	first.next = oldfirst;
    	n++;
    	assert check();
    }

    public void remove() {
    	if(isEmpty()) throw new NoSuchElementException("List underflow");
		first = first.next;
		n--;
		assert check();
    }

    public Item peek() {
    	if(isEmpty()) throw new NoSuchElementException("List underflow");
    	return first.item;
    }

	public void displayAll() {
		StringBuilder s = new StringBuilder();
		for (Item item : this)
            s.append(item + " ");
        System.out.println(s);
	}



//insert / delelte / search / isempty / display

	private class Node {
		private Item item;
		private Node next;
	}

//Iterator Class
//Returns an iterator to this stack that iterates through the items in LIFO order.

    public Iterator<Item> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  } // doesn't support remove

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }


    // check internal invariants
    private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }



}
