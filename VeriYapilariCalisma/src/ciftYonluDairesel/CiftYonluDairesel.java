package ciftYonluDairesel;

public class CiftYonluDairesel {
	Node head = null;
	Node tail = null;
	Node temp = null;
	Node temp2 = null;
	int data;
	int index;

	void basaEkle(int data) {

		Node eleman = new Node(data);
		if (head == null) {
			head = eleman;
			tail = eleman;

			head.next = tail;
			tail.prev = head;
			head.prev = tail;
			tail.next = head;
		} else {
			eleman.next = head;
			head.prev = eleman;
			head = eleman;
			tail.next = head;
			head.prev = tail;
		}
	}

	void sonaEkle(int data) {
		Node eleman = new Node(data);
		if (head == null) {
			head = eleman;
			tail = eleman;

			head.next = tail;
			tail.prev = head;
			head.prev = tail;
			tail.next = head;
		} else {
			tail.next = eleman;
			eleman.prev = tail;
			tail = eleman;
			tail.next = head;
			head.prev = tail;
		}
	}

	void arayaEkle(int index, int data) {

		Node eleman = new Node(data);
		if (head == null) // 
		{
			head = eleman;
			tail = eleman;

			head.next = tail;
			tail.prev = head;
			head.prev = tail;
			tail.next = head;

		} else if (index == 0) {
			basaEkle(data);
		} else {
			temp = head;
			temp2 = temp;
			int n = 0;
			while (temp != tail) {
				n++;
				temp = temp.next;
			}
			temp = head;
			int i = 0;
			while (i < index) {
				temp2 = temp;
				temp = temp.next;
				i++;
			}
			if (n < index) {
				tail.next = eleman;
				eleman.prev = tail;
				tail = eleman;
				tail.next = head;
				head.prev = tail;
			} else {
				temp2.next = eleman;
				eleman.prev = temp2;
				eleman.next = temp;
				temp.prev = eleman;
			}
		}
	}
	//****************************************************************
	
	 void bastanSil(){
	        if(head == null){
	            System.out.println("Liste boş");
	        }else if(head == tail){
	            head = null;
	            tail = null;
	        }else{
	            head = head.next;
	            head.prev = tail;
	            tail.next = head;
	        }
	    }

	    void sondanSil(){
	        if(head == null){
	            System.out.println("Liste boş");
	        }else if(head == tail){
	            head = null;
	            tail = null;
	        }else{
	            temp = head;
	            while(temp.next != tail){
	                temp = temp.next;
	            }
	            tail = temp;
	            tail.next = head;
	            head.prev = tail;
	        }
	    }

	    void aradanSil(int index){
	        if(head == null){
	            System.out.println("Liste boş");
	        }else{
	           
	            if(index == 0 && head == tail){
	                head = null;
	                tail = null;
	            }
	            else if(index == 0 && head!= tail){
	                head = head.next;
	                head.prev = tail;
	                tail.next = head;
	            }else{
	                int n = 0;
	                temp = head;
	                while(temp.next != tail){
	                    n++;
	                    temp = temp.next;
	                }
	                if(index == 0){
	                    tail = temp;
	                    tail.next = head;
	                    head.prev = tail;
	                }
	                else{ // asıl aradan silme
	                    temp = head;
	                    temp2 = head;
	                    int i = 0;
	                    while (i<index){
	                        i++;
	                        temp2 = temp;
	                        temp = temp.next;
	                    }
	                    temp2.next = temp.next;
	                    temp.next.prev = temp2;
	                }
	            }
	        }
	    }
	
	
	
	void yazdir(){
        if(head == null)
        {
            System.out.println("liste boş");
        }
        else
        {
            temp = head;
            System.out.print("\nBaş -->");
            while(temp!= tail)
            {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.print(temp.data + "--> son");
        }
    }
}
