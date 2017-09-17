public class simpleQueue {
	private String[] strArray;
	private int total;
	private int front;

    public simpleQueue(int maxSize) {
    	strArray = new String[maxSize];
    	total = 0; front = 0;
    }

    public boolean isEmpty() {
    	return total == 0;
    }

    public int size() {
    	return total;
    }

    public void enqueue(String s) {
    	if(total<strArray.length) {
    		strArray[front] = s;
    		total++;
    	}
    }

    public String dequeue() {
    	String item = new String();
		if(!this.isEmpty()) {
			item = strArray[front];
			front++;
			total--;
		}
    	return item;
    }

    public String peek() {
    	if(total>0) return strArray[front];
    	return "Queue Underflow";
    }

}