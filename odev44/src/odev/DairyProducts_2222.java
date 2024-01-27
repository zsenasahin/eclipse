package odev;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DairyProducts_2222 extends Urun_2222{
    public Kategori_2222 kategori;

    public DairyProducts_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        
    }
    
	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        kategori.urunEkle(kategoriIndex, yeniUrun);
    }
	
	static DecimalFormat df = new DecimalFormat("#.##"); //birim fiyat için
	
	public void sutUrunleriniSil(double minFiyat, double maxFiyat) {
        List<Urun_2222> silinecekler = new ArrayList<>();

        for (Urun_2222 sutUrunu : kategori.getDairyProducts()) {
            double birimFiyat = sutUrunu.getBirimFiyati();

            if (birimFiyat >= minFiyat && birimFiyat <= maxFiyat) {
                silinecekler.add(sutUrunu);
                System.out.println(sutUrunu.getAdi() + " ürünü silindi.");
            }
        }

        for (Urun_2222 silinecek : silinecekler) {
            kategori.getDairyProducts().remove(silinecek);
        }

        System.out.println("Güncellenmiş Süt Ürünleri Listesi:");
        for (Urun_2222 sutUrunu : kategori.getDairyProducts()) {
            System.out.println(sutUrunu.getAdi() + " - Fiyat: " + df.format(sutUrunu.getBirimFiyati()));
        }
    }
}
