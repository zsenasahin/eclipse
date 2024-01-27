package ciftYonluDairesel;

public class Main {

	public static void main(String[] args) {
		CiftYonluDairesel cyd = new CiftYonluDairesel();
		cyd.basaEkle(5);
		cyd.basaEkle(10);
		cyd.yazdir();
		cyd.sonaEkle(15);
		cyd.sonaEkle(40);
		cyd.yazdir();
		cyd.arayaEkle(3, 20);
		cyd.arayaEkle(8, 25);
		cyd.yazdir();
		cyd.bastanSil();
		cyd.sondanSil();
		cyd.aradanSil(3);
		cyd.yazdir();
		
		
	}
}
