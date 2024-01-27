package veriYapilari;


public class Node {
	int ogrenciNo;
	String isim;
	String soyisim;
	int yas;
	Node leftChild;
	Node rightChild;
	int height;

	public Node(int ogrenciNo, String isim, String soyisim, int yas) {
		this.ogrenciNo = ogrenciNo;
		this.isim = isim;
		this.soyisim = soyisim;
		this.yas = yas;
		this.height = 1;
	}

	@Override
	public String toString() {
		return "(" + ogrenciNo + ": " + isim + " " + soyisim + ", " + yas + ")";
	}
}
