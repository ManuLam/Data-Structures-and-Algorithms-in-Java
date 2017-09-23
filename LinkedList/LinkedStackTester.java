public class LinkedStackTester {

    public static void main(String[]args) {
    	LinkedStack<String> list = new LinkedStack<String>();

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
