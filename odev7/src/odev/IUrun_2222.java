package odev;

public interface IUrun_2222 {
	void urunStokGuncelle(int adet, boolean GirisMi, int kayit);
	void urunIsimGuncelle(int kayit,String yeniIsım, String yeniDetay);
	void urunSil(int kayit);
	void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay);
}
