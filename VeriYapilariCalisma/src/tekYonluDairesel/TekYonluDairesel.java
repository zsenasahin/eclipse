package tekYonluDairesel;

public class TekYonluDairesel {
	Node head = null;
	Node tail = null;

	void basaEkle(int data) {
		Node eleman = new Node(data);

		if (head == null) {
			head = eleman;
			tail = eleman;
			tail.next = head;
		} else {
			eleman.next = head;
			head = eleman;
			tail.next = head;
		}
	}

	void sonaEkle(int data) {
		Node eleman = new Node(data);
		if (head == null) {
			head = eleman;
			tail = eleman;
			System.out.println("Liste olusturuldu.");
		} else {
			tail.next = eleman;
			tail = eleman;
			tail.next = head;
			System.out.println("\nSona eleman eklendi.");
		}
	}

	void arayaEkle(int index, int data) {
		Node eleman = new Node(data);

		if (head == null) {
			head = eleman;
			tail = eleman;
			tail.next = head;
		} else if (index == 0) {
			basaEkle(data);
		} else {
			int n = 0;
			Node temp = head;
			Node temp2 = head;
			while (temp != tail) {
				temp = temp.next;
				n++;
			}
			n++;
			if (index >= n) {
				sonaEkle(data);
			} else {
				temp = head;
				temp2 = temp;
				int i = 0;
				while (i < index) {
					i++;
					temp2 = temp;
					temp = temp.next;
				}
				temp2.next = eleman;
				eleman.next = temp;
			}
		}
	}

	// *********************************************************

	void bastanSil() {
		if (head == null) {
			System.out.println("Liste boş.");
		} else if (head == tail) {
			head = null;
			tail = null;
		} else {
			head = head.next;
			tail.next = head;
		}
	}

	void sondanSil() {
		if (head == null) {
			System.out.println("Liste boş.");
		} else if (head == tail) {
			head = null;
			tail = null;
		} else {
			Node temp = head;
			while (temp.next != tail) {
				temp = temp.next;
			}
			tail = temp;
			tail.next = head;
		}
	}

	void aradanSil(int index) {
		if (head == null) {
			System.out.println("Liste boş.");
		} else if (head == tail) {
			head = null;
			tail = null;
		} else {
			int n = 0;

			Node temp = head;
			Node temp2 = head;

			while (temp != tail) {
				temp = temp.next;
				n++;
			}
			n++;
			temp = head;
			int i = 0;
			while (i < index) {
				temp2 = temp;
				temp = temp.next;
				i++;
			}
			temp2.next = temp.next;
		}
	}

	void yazdir() {
		if (head == null) {
			System.out.println("liste boş");
		} else {
			Node temp = head;
			System.out.print("\nbaş-->");
			while (temp != tail) {
				System.out.print(temp.data + "--> ");
				temp = temp.next;
			}
			System.out.print(temp.data + "-->son");
		}
	}
}
