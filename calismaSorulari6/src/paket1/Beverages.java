package paket1;

public class Beverages extends Urun {
	private final String kategoriAdi;
	private final String detay;

	public Beverages(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari,
			String kategoriAdi, String detay) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		this.kategoriAdi = kategoriAdi;
		this.detay = detay;
	}

	public String getKategoriAdi() {
		return kategoriAdi;
	}

	public String getDetay() {
		return detay;
	}
}
