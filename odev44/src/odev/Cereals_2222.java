package odev;

public class Cereals_2222 extends Urun_2222{
    public Kategori_2222 kategori;

    public Cereals_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        
    }
    
	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        kategori.urunEkle(kategoriIndex, yeniUrun);
    }
 
	public void TahilUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Cereals_2222 yeniUrun = new Cereals_2222(adi, 5, birimAgirligi, birimFiyati, stokMiktari);
        kategori.Cereals.add(yeniUrun);

        System.out.println("Yeni Tahıl Ürünü Eklendi: " + adi);
        System.out.println("Güncellenmiş Tahıl Ürünleri Listesi:");
        for (Urun_2222 tahilUrunu : kategori.getCereals()) {
            System.out.println(tahilUrunu.getAdi() + " " + tahilUrunu.getKategoriIndex()+" " + tahilUrunu.getBirimAgirligi() + " " + 
        tahilUrunu.getBirimFiyati() + " " + tahilUrunu.getStokMiktari());
        }
    }
}
