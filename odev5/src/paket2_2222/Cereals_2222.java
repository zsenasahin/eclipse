package paket2_2222;

import java.util.List;
import java.util.Scanner;

import paket1_2222.DosyadanOku_2222;

public class Cereals_2222 extends Urun_2222 {

	protected static void hububatSil() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Silinecek ürünün adını giriniz: ");
		String urunAdi = scanner.nextLine();
		List<Urun_2222> CerealsListesi = DosyadanOku_2222.getCereals();
		for (Urun_2222 urun : CerealsListesi) {
			if (urun.getAdi().equals(urunAdi)) {
				if (urun.getKategoriIndex() != 5) {
					System.out.println("Girdiginiz urun cereals kategorisinde degil.");
					break;
				} else {
					CerealsListesi.remove(urun);
					System.out.println(urunAdi + " ürünü başarıyla silindi.");
					break;
				}
			}
		}
		System.out.println("Cereals Listesi: ");
		for (Urun_2222 urun : CerealsListesi) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}

}
