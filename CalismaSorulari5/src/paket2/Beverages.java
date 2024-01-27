package paket2;

import java.util.List;

public class Beverages extends Urun{
	public Beverages(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
        super(adi, 1, birimAgirligi, birimFiyati, stokMiktari);
    }

    protected static void IcecekUrunuEkle(List<List<Urun>> kategoriListeleri, String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Urun yeniIcecek = new Urun(adi, 1, birimAgirligi, birimFiyati, stokMiktari);
        kategoriListeleri.get(0).add(yeniIcecek);

        System.out.println(adi + " isimli içecek ürünü eklendi.");
        System.out.println("Güncel içecek listesi:");
        for (Urun icecek : kategoriListeleri.get(0)) {
            System.out.println(icecek.getAdi() + " " + "1 " + icecek.getBirimAgirligi() + " " + icecek.getBirimFiyati() + " " + icecek.getStokMiktari());
        }
    }

}
