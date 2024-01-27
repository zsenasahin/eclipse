package yigin;

public class Main {
	public static void main(String[] args) {
		Stack yigin = new Stack();
		yigin.push(40);
		yigin.push(59);
		yigin.push(20);
		yigin.push(55);
		yigin.push(19);
		yigin.printStack();
		yigin.pop();
		//yigin.pop();
		yigin.printStack();
		yigin.peek();
		yigin.printStack();
		yigin.delete(20);
		yigin.printStack();
	}
}
