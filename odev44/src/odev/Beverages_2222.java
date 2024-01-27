package odev;

public class Beverages_2222 extends Urun_2222 {
	public Kategori_2222 kategori;

	public Beverages_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);

	}

	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		kategori.urunEkle(kategoriIndex, yeniUrun);
	}

	public void ıcecekStoklariGuncelle(int miktar) {
		System.out.println("İçecek Stokları Güncelleniyor...");
		for (Urun_2222 urun : kategori.getBeverages()) {
			if((urun.getStokMiktari()+ miktar) < 0) {
				System.out.println("Stok miktarı sıfırdan küçük olamaz.");
			}
			else {
				System.out.println("Ürün Adı: " + urun.getAdi() + "\tKategori: " + urun.getKategoriIndex()
					+ "\tStok Miktarı: " + urun.getStokMiktari() + "\tGüncellenmiş Stok Miktarı: "
					+ (urun.getStokMiktari() + miktar));
			urun.setStokMiktari(urun.getStokMiktari() + miktar);
			}		
		}
	}
}