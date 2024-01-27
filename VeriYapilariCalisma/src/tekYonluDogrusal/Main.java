package tekYonluDogrusal;

public class Main {
	public static void main(String[] args) {
		TekYonluListe tyl = new TekYonluListe();
		tyl.basaEkle(50);
		tyl.basaEkle(25);
		tyl.yazdir();
		tyl.basaEkle(40);
		tyl.yazdir();
		tyl.sonaEkle(30);
		tyl.sonaEkle(60);
		tyl.yazdir();
		tyl.arayaEkle(0, 15);
		tyl.arayaEkle(6, 80);
		tyl.arayaEkle(3, 43);
		tyl.yazdir();
		/*tyl.bastanSil();
		tyl.bastanSil();
		tyl.yazdir();
		tyl.sondanSil();
		tyl.sondanSil();
		tyl.yazdir();*/
		
		tyl.aradanSil(0);
		tyl.aradanSil(6);
		tyl.aradanSil(3);
		tyl.yazdir();

	}
}
