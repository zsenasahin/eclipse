package paket2;

import java.util.List;

public class DairyProducts extends Urun{
	public DairyProducts(int kategoriIndex, String adi, String detay) {
        super(kategoriIndex, adi, detay);
    }

    protected static void SutUrunuSil(List<List<Urun>> kategoriListeleri) {
        int kategoriIndex = 4;
        double ortalamaBirimFiyat = 0;

        for (Urun urun : kategoriListeleri.get(kategoriIndex - 1)) {
            ortalamaBirimFiyat += urun.getBirimFiyati();
        }

        if (!kategoriListeleri.get(kategoriIndex - 1).isEmpty()) {
            ortalamaBirimFiyat /= kategoriListeleri.get(kategoriIndex - 1).size();
        }

        for (Urun urun : kategoriListeleri.get(kategoriIndex - 1)) {
            if (urun.getBirimFiyati() > ortalamaBirimFiyat) {
                kategoriListeleri.get(kategoriIndex - 1).remove(urun);
                System.out.println("Ürün Silindi: " + urun.getAdi());
                break;
            }
        }
    }
}
