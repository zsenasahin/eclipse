package paket2_2222;

import java.util.List;

import paket1_2222.DosyadanOku_2222;

public class Beverages_2222 extends Urun_2222 {
	
	protected static void icecekBirimAgirlikGuncelle(String yeniAgirlik) {
		List<Urun_2222> beveragesListesi = DosyadanOku_2222.getBeverages();

        if (!beveragesListesi.isEmpty()) {
            Urun_2222 sonUrun = beveragesListesi.get(beveragesListesi.size() - 1);

            sonUrun.setBirimAgirligi(yeniAgirlik);
            
            
        } else {
            System.out.println("Beverages listesi boş.");
        }
        for (Urun_2222 urun : beveragesListesi) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}
	
}
