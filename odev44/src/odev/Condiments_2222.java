package odev;

import java.text.DecimalFormat;
import java.util.List;

public class Condiments_2222 extends Urun_2222 {

	public Kategori_2222 kategori;
	static DecimalFormat df = new DecimalFormat("#.##");

	public Condiments_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);

	}

	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		kategori.urunEkle(kategoriIndex, yeniUrun);
	}

	public void CesniBirimAgirlikGuncelle(int N, String yeniAgirlik) {
		List<Urun_2222> condimentsList = kategori.getCondiments();

		if (N >= 1 && N <= condimentsList.size()) {
			Urun_2222 urun = condimentsList.get(N - 1);
			if (urun.getBirimAgirligi() != null) {
				urun.setBirimAgirligi(yeniAgirlik);
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ df.format(urun.getBirimFiyati()) + " " + urun.getStokMiktari());
			} else {
				System.out.println("Çeşni bulunamadı veya ağırlık bilgisi yok.");
			}
		} else {
			System.out.println("Geçersiz çeşni indexi.");
		}
	}
}
