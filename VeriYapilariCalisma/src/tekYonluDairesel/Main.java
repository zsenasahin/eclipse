package tekYonluDairesel;

public class Main {
	public static void main(String[] args) {
		TekYonluDairesel tyd = new TekYonluDairesel();
		tyd.basaEkle(10);
		tyd.basaEkle(50);
		tyd.yazdir();
		tyd.sonaEkle(40);
		tyd.sonaEkle(90);
		tyd.yazdir();
		tyd.arayaEkle(0, 3);
		tyd.arayaEkle(3, 150);
		tyd.arayaEkle(6, 200);
		tyd.yazdir();
		tyd.bastanSil();
		tyd.sondanSil();
		tyd.aradanSil(3);
		tyd.yazdir();
	}
}
