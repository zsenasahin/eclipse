package paket1;

public class DairyProducts extends Urun {
    protected String kategoriAdi;
    protected String detay;

    public DairyProducts(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari,
            String kategoriAdi, String detay) {
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        this.kategoriAdi = kategoriAdi;
        this.detay = detay;
    }

    public void setKategoriAdi(String kategoriAdi) {
        this.kategoriAdi = kategoriAdi;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }
}