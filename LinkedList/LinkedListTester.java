public class LinkedListTester {

    public static void main(String[]args) {
    	LinkedList<String> list = new LinkedList<String>();

    	list.insert("this");
    	list.insert("is");
    	list.insert("the");
    	list.insert("best");
    	list.insert("test");

    	list.displayAll();

    	list.remove();
    	list.remove();

    	list.displayAll();

    	System.out.println(list.peek());
    }


}