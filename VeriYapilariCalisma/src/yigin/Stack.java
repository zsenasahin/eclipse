package yigin;

public class Stack {
	Node top;
	
	public Stack() {
		this.top = null;
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		System.out.println("Pushed: " + data);
	}

	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack boş.");
			return;
		}
		
		Node temp = top;
		top = top.next;
		System.out.println("Popped: " + temp.data);
	}
	
	public void delete(int data) {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		Node current = top;
		Node prev = null;
		
		while(current != null && current.data != data) {
			prev = current;
			current = current.next;
		}
		
		if(current == null) {
			System.out.println("Düğüm bulunamadi");
		}else {
			if(prev == null) {
				top = current.next;
			}else {
				prev.next = current.next;
			}
			System.out.println("Silindi. " + data);
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Stack boş.");
			return -1;
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void printStack() {
		if(isEmpty()) {
			System.out.println("Stack boş.");
			return;
		}
		Node current = top;
		System.out.print("Stack:  ");
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
}
