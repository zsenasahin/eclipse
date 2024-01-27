package kuyruk;

public class Kuyruk {

	Node front, rear;
	
	public Kuyruk() {
		this.front = this.rear = null;
	}
	
	void enQueue(int data) {
		Node newNode = new Node(data);
		
		if(this.rear == null) {
			this.front = this.rear = newNode;
			System.out.println("ilk eleman eklendi: " + newNode.data);
			return;
		}
		
		this.rear.next = newNode;
		this.rear = newNode;
		System.out.println("Eleman eklendi: " + newNode.data);
	}
	
	void deQueue() { 
		if(this.front == null) {
			return;
		}
		
		Node temp = this.front;
		this.front = this.front.next;
		
		if(this.front == null) {
			this.rear = null;
		}
		
		System.out.println("Dequeue : " +temp.data); //ilk giren ilk çıkar.
	}
	
	void search(int key) {
		Node current = this.front;
		
		while(current != null) {
			if(current.data == key) {
				System.out.println("Aranan deger " +key + " kuyrukta bulundu.");
				return;
			}
			current = current.next;
		}
		
		System.out.println("Aranan deger " + key + " kuyrukta bulunamadı");
		return;
	}
	
	int toplam() {
		int toplam = 0;
		
		Node current = this.front;
		while(current != null) {
			toplam += current.data;
			current = current.next;
		}
		System.out.println("Toplam: " + toplam);
		return toplam;
	}
	
	
}
