package paket1;

import java.util.List;

public class Cereals extends Urun {
	private String kategoriAdi;
	private String detay;

	public Cereals(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
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

	@Override
	public void uruneZamYap(List<List<Urun>> kategoriListeleri) {
		System.out.println("Urun adı giriniz: ");
		String urunAdi = scanner.nextLine();
		System.out.println("Zam oranı giriniz: ");
		int zamOrani = scanner.nextInt();
		scanner.nextLine();
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if (urun.getKategoriIndex() != 5) {
						System.out.println("Hata. Urun cereals sınıfına ait değil");
					} else {
						if (urun.getStokMiktari() < 10 && urun.getBirimFiyati() < 50) {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 100.0);
							urun.setBirimFiyati(yeniFiyat);
						} else if (urun.getStokMiktari() > 10 && urun.getBirimFiyati() > 50) {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 400.0);
							urun.setBirimFiyati(yeniFiyat);
						} else if (urun.getStokMiktari() < 10 && urun.getBirimFiyati() > 50) {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 200.0);
							urun.setBirimFiyati(yeniFiyat);
						} else {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 300.0);
							urun.setBirimFiyati(yeniFiyat);
						}
						System.out.println("Ürüne zam yapıldı. Yeni birim fiyat: " + urun.getBirimFiyati());
					}
				}
			}
		}
	}
}
