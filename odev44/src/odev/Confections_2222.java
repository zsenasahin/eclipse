package odev;

public class Confections_2222 extends Urun_2222 {
	public Kategori_2222 kategori;
	String yeniDetay;

	public Confections_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari,
			String yeniDetay) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		this.yeniDetay = yeniDetay;
	}

	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		kategori.urunEkle(kategoriIndex, yeniUrun);
	}

	public void SekerlemeDetayEkle(String eklenecekAdi, String yeniDetay) {
		for (Urun_2222 confections : kategori.getConfections()) {
			if (eklenecekAdi.equals(confections.getAdi())) {
				confections.yeniDetay = yeniDetay;
				System.out.println(confections.getAdi() + " " + confections.getStokMiktari() + " "
						+ confections.getBirimAgirligi() + " " + confections.getBirimFiyati() + " "
						+ confections.getStokMiktari() + " " + confections.yeniDetay);
			}
		}
		System.out.println("ürün bulunamadı");
	}
}