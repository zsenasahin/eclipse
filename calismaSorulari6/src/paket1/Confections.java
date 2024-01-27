package paket1;

import java.util.List;

public class Confections extends Urun {
	private String kategoriAdi;
	private String detay;

	public Confections(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	}

	@Override
	public void urunStokGuncelle(List<List<Urun>> kategoriListeleri) {
		System.out.println("Urun adi giriniz: ");
		String urunAdi = scanner.nextLine();
		System.out.println("Satış mı ?");
		boolean satisMi = scanner.nextBoolean();
		System.out.println("Adet giriniz: ");
		int adet= scanner.nextInt();
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if(urun.getKategoriIndex() != 3) {
						System.out.println("Confections sınıfından olması lazım.");
					}else {
					if(satisMi) {
						if (urun.getStokMiktari() > 10) {
							urun.setStokMiktari(urun.getStokMiktari() - adet);
							System.out.println(adet + " adet " + urun.getAdi() + " satıldı.");
						} else {
							System.out.println("Ürün stokta yetersiz. Satış iptal edildi.");
						}
					}else {
						urun.setStokMiktari(urun.getStokMiktari() + adet);
						System.out.println(adet + " adet " + urun.getAdi() + " alındı.");
						}
					}
				}
			}
		}
	}

}
