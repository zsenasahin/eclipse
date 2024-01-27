package ciftYonluDogrusal;

public class Main {
	public static void main(String[] args) {
		CiftYonluDogrusal bl = new CiftYonluDogrusal();
		bl.basaEkle(10);
	    bl.sonaEkle(20);
	    bl.sonaEkle(40);
	    bl.basaEkle(30);
	    bl.arayaEkle(3,50);
	    bl.arayaEkle(0,5);
	    bl.arayaEkle(5,15);
	    bl.arayaEkle(7, 100);
	    bl.yazdir();
	    bl.bastanSil();
	    //bl.sondanSil();
	    //bl.aradanSil(4);
	    bl.yazdir();
	    //bl.sondanYazdir();
	    bl.sondanSil();
	    bl.aradanSil(4);
	}
	
}
