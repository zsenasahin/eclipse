package kuyruk;

public class Main {
	public static void main(String[] args) {
		Kuyruk kuyruk = new Kuyruk();
		kuyruk.enQueue(40);
		kuyruk.enQueue(60);
		kuyruk.enQueue(20);
		kuyruk.enQueue(100);
		kuyruk.enQueue(80);

		kuyruk.deQueue();
		
		kuyruk.search(20);
		kuyruk.search(40);
		kuyruk.toplam();
	}
}
