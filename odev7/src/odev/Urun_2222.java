package odev;

abstract class Urun_2222 implements IUrun_2222{
	public String Adi;
	public int kategoriIndex;
	public String birimAgirligi;
	public double birimFiyati;
	public int stokMiktari;
	public String detay;
	
	public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
		this.Adi = adi;
		this.kategoriIndex = kategoriIndex;
		this.birimAgirligi = birimAgirligi;
		this.birimFiyati = birimFiyati;
		this.stokMiktari = stokMiktari;
		this.detay = detay;
	}
	
	public Urun_2222() {

	}
	
	public String getAdi() {
		return Adi;
	}
	public String getBirimAgirligi() {
		return birimAgirligi;
	}
	public double getBirimFiyati() {
		return birimFiyati;
	}
	public int getKategoriIndex() {
		return kategoriIndex;
	}
	public int getStokMiktari() {
		return stokMiktari;
	}
	public String getDetay() {
		return detay;
	}
	
	public void setAdi(String adi) {
		Adi = adi;
	}
	public void setBirimAgirligi(String birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}
	public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}
	public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}
	public void setStokMiktari(int stokMiktari) {
		this.stokMiktari = stokMiktari;
	}
	public void setDetay(String detay) {
		this.detay = detay;
	}
	abstract void urunFiyatGuncelle(int kayit, int oran, boolean indirimMi);
	
	abstract void urunKategorikZamYap(int kayit, int x);
}
