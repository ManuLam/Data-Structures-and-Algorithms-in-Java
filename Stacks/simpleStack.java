public class simpleStack {
	private int maxSize;
	private String[] array;
	private int top;

	public simpleStack(int n) {
		maxSize = n;
		array = new String[maxSize];
		top = 0;
	}


	public void push(String str){
		if(top < maxSize) {
			array[top] = str;
			top++;
		}
		else {
			System.out.println("Stack Overflow");
		}
	}

	public String pop(){
		if(!this.empty()) {
			String temp = this.peek();
			array[top-1] = null;
			top--;
			return temp;
			}
		else {
			return null;
			}
	}

	public boolean empty(){
		if(top==0) {
			return true;
		}
		else {
			return false;
		}

	}
	public String peek(){
		if(top>0) {
		return array[top-1];
			}
		else {
			return null;
			}
	}
}