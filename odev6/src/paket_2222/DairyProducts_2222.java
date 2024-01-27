package paket_2222;

import java.util.ArrayList;
import java.util.List;

public class DairyProducts_2222 extends Urun_2222 {

	public void sutUrunuSil() {
		int enAzStok = Integer.MAX_VALUE;
		Urun_2222 enAzStokluUrun = null;

		List<Urun_2222> silinecekler = new ArrayList<>();

		for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
			if (urun.getStokMiktari() < enAzStok) {
				enAzStok = urun.getStokMiktari();
				enAzStokluUrun = urun;
			}
		}

		if (enAzStokluUrun != null) {
			System.out.println(enAzStokluUrun.getAdi() + " adlı süt ürünü silindi.");
			silinecekler.add(enAzStokluUrun);
		} else {
			System.out.println("Süt ürünü bulunamadı.");
		}

		DosyadanOkuma_2222.DairyProducts.removeAll(silinecekler);

		System.out.println("Güncellenmis Urun Listesi");
		for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}

	public void sutUrunuSil(int minStok, int maxStok, double fiyat) {
		// Girilen iki sayı aralığında fiyat > urunFiyati ise urunu sil.
		List<Urun_2222> silinecekler = new ArrayList<>();
		for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
			if (urun.getStokMiktari() > minStok && urun.getStokMiktari() < maxStok) {
				if (fiyat > urun.getBirimFiyati()) {
					silinecekler.add(urun);
				}
			}
		}
		System.out.println("Silinenler");
		for (Urun_2222 urun : silinecekler) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}

		DosyadanOkuma_2222.DairyProducts.removeAll(silinecekler);
		System.out.println("\nGüncellenmis Urun Listesi");
		for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}

	public void sutUrunuSil(double fiyat) {
		// fiyat<urunFiyati urunleri sil
		List<Urun_2222> silinecekler = new ArrayList<>();
		for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
			if (fiyat < urun.getBirimFiyati()) {
				silinecekler.add(urun);
			}

		}
		System.out.println("Silinenler");
		for (Urun_2222 urun : silinecekler) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}

		DosyadanOkuma_2222.DairyProducts.removeAll(silinecekler);
		System.out.println("\nGüncellenmis Urun Listesi");
		for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}
}
