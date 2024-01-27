package paket2_2222;

import java.util.List;

import paket1_2222.DosyadanOku_2222;

public class Confections_2222 extends Urun_2222{
	protected static void SekerlemeUrunEkle(String Adi, String BirimAgirligi, double BirimFiyatı,int StokMiktari) {
		List<Urun_2222> ConfectionsListesi = DosyadanOku_2222.getConfections();
		Urun_2222 yeniUrun = new Urun_2222(Adi, 3, BirimAgirligi,BirimFiyatı,StokMiktari);
		ConfectionsListesi.add(yeniUrun);
		for(Urun_2222 urun : ConfectionsListesi) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi()
            + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}
}
