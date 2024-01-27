package paket2;

import java.util.List;

public class Cereals extends Urun{
	public Cereals(int kategoriIndex, String adi, String detay) {
        super(kategoriIndex, adi, detay);
    }

	 protected static void TahilMinStokEkle(List<List<Urun>> kategoriListeleri, int eklenenStokMiktari) {
	        int kategoriIndex = 5; // Cereals kategorisi
	        Urun enAzStokluUrun = null;

	        // Cereals kategorisine ait ürünler arasında en az stoğa sahip ürünü bul
	        for (Urun urun : kategoriListeleri.get(kategoriIndex - 1)) {
	            if (enAzStokluUrun == null || urun.getStokMiktari() < enAzStokluUrun.getStokMiktari()) {
	                enAzStokluUrun = urun;
	            }
	        }

	        // En az stoğa sahip ürüne stok eklenir
	        if (enAzStokluUrun != null) {
	            enAzStokluUrun.setStokMiktari(enAzStokluUrun.getStokMiktari() + eklenenStokMiktari);
	            System.out.println("Stok Eklendi: " + enAzStokluUrun.getAdi());
	            System.out.println(enAzStokluUrun.getAdi() + "" + enAzStokluUrun.getStokMiktari());
	        } else {
	            System.out.println("Hata: Cereals kategorisinde stok bulunamadı.");
	        }
	    }
}
