package tekYonluDogrusal;

public class TekYonluListe {
	
	Node head = null;
	Node tail = null;
	
	public void basaEkle(int x) {
		Node eleman = new Node();
		eleman.data = x;
		
		if(head == null) {
			eleman.next = null;
			head = eleman;
			tail = eleman;
			System.out.println("Başa eleman eklendi. Eleman: " + eleman.data);
		}else {
			eleman.next = head;
			head = eleman;
			System.out.println("Başa eleman eklendi. Eleman: " + eleman.data);
		}
	}
	
	public void sonaEkle(int x) {
		Node eleman = new Node();
		eleman.data = x;
		if(head == null) {
			eleman.next = null;
			head = eleman;
			tail = eleman;
		}else {
			eleman.next = null;
			tail.next = eleman;
			tail = eleman;
			System.out.println("Sona eleman eklendi. Eleman: " + eleman.data);
		}
	}
	
	public void arayaEkle(int index ,int x) {
		Node eleman = new Node();
		eleman.data = x;
		if(head == null && index == 0) {
			System.out.println("Liste yapısı oluşturuldu.");
			basaEkle(x);		
		}else if(head != null && index == 0) {
			basaEkle(x);
		}else {
			int n = 0;
			Node temp = head;
			Node temp2 = head;
			while(temp.next != null) {
				n++;
				temp2 = temp;
				temp = temp.next;
			}
			if(n== index) {
				sonaEkle(x);
			}else {
				temp = head;
				temp2 = head;
				int i = 0;
				while(i != index) {
					temp2 = temp;
					temp = temp.next;
					i++;
				}
				temp2.next = eleman;
				eleman.next = temp;
				System.out.println(index+ ". sıraya eleman eklendi. Eleman: " + eleman.data);
			}
		}
	}
	
	
	//**************************************************************
	
	public void bastanSil() {
		if(head == null) {
			System.out.println("Liste boş. Silinecek eleman yok.");
		}else if(head.next == null) {
			head = null;
			tail = null;
			System.out.println("Listede kalan son eleman silindi.");
		}else {
			System.out.println("Baştaki eleman silindi. Silinen eleman: " + head.data);
			head = head.next;
		}
	}
	
	public void sondanSil() {
		if(head == null) {
			System.out.println("Liste boş.");
		}else if(head.next == null) {
			head = null;
			tail = null;
			System.out.println("Listede kalan son eleman silindi.");
		}else {
			Node temp = head;
			Node temp2 = head;
			while(temp.next != null) {
				temp2 = temp;
				temp = temp.next;
			}
			temp2.next = null;
			tail = temp2;
			System.out.println("Sondan eleman silindi.");
		}
	}
	
	public void aradanSil(int index) {
		if(head == null) {
			System.out.println("Liste boş. silinme yapılamaz.");
		}else if((head.next == null && index == 0) || (head.next != null && index == 0)) {
			bastanSil();
		}else {
			int i = 0;
			Node temp = head;
			Node temp2 = head;
			while(temp.next == null) {
				i++;
				temp2 = temp;
				temp = temp.next;		
			}
			if(i == index) {
				sondanSil();
			}else {
				temp = head;
				temp2 = head;
				int j = 0;
				while(j != index) {
					temp2 = temp;
					temp = temp.next;
					j++;
				}
				temp2.next = temp.next;
				System.out.println(index+ ". indexteki eleman silindi.");
			}
		}
	}
	
	//****************************************************************
	
	public void yazdir() {
		if(head == null) {
			System.out.println("Liste yapısı boş.");
		}else {
			Node temp = head;
			System.out.print("Baş->");
			while(temp != null) {
				System.out.print(temp.data + "->");
				temp = temp.next;
			}
			System.out.println(" Son.");
		}
	}

}
