package paket1;

import java.util.List;

public class Condiments extends Urun {
	private String kategoriAdi;
	private String detay;

	public Condiments(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	}

	public void setKategoriAdi(String kategoriAdi) {
		this.kategoriAdi = kategoriAdi;
	}

	public void setDetay(String detay) {
		this.detay = detay;
	}

	public void uruneZamYap(List<List<Urun>> kategoriListeleri,  String urunAdi, int zamOrani, int stokKontrol) {
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if(urun.getKategoriIndex() != 2) {
						System.out.println("Hata, urun condiments sinifina ait degil.");
					}else {
						if (stokKontrol < 10) {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 100.0);
							urun.setBirimFiyati(yeniFiyat);
						} else {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 200.0);
							urun.setBirimFiyati(yeniFiyat);
						}
						System.out.println("Ürüne zam yapıldı. Yeni birim fiyat: " + urun.getBirimFiyati());
					}
				}
			}
		}
	}

	public void uruneZamYap(List<List<Urun>> kategoriListeleri, String urunAdi, int zamOrani)
	{
		for (List<Urun> kategoriListesi : kategoriListeleri)
		{
			for (Urun urun : kategoriListesi)
			{
				if (urun.getAdi().equalsIgnoreCase(urunAdi))
				{
					if(urun.getKategoriIndex() != 2)
					{
						System.out.println("Hata, urun condiments sinifina ait degil.");
					}
					else
					{
						if (urun.getBirimFiyati() < 10.0) {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 100.0);
							urun.setBirimFiyati(yeniFiyat);							
						} else if (10.0 < urun.getBirimFiyati() && urun.getBirimFiyati() < 50) {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 200.0);
							urun.setBirimFiyati(yeniFiyat);
						} else {
							double yeniFiyat = urun.getBirimFiyati() * (1 + zamOrani / 400.0);
							urun.setBirimFiyati(yeniFiyat);
						}
						System.out.println("Ürüne zam yapıldı. Yeni birim fiyatiii: " + urun.getBirimFiyati());
					}		
				}
			}
		}
	}

	@Override
	public void urunAdiDegistir(List<List<Urun>> kategoriListeleri) {
		System.out.println("Değiştirmek istediginiz urunun adini giriniz: ");
		String eskiAdi = scanner.nextLine();
		System.out.println("yeni isim gir: ");
		String yeniAdi = scanner.nextLine();
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(eskiAdi)) {
					if(urun.getKategoriIndex() != 2) {
						System.out.println("Girdiginiz urun condiments sınıfına ait degil.");
					}else {
						String yeniAdiSessizHarflerle = yeniAdi.toLowerCase().replaceAll("[aeıioöuü]", "");
						urun.setAdi(yeniAdiSessizHarflerle);
						System.out.println("Ürün adı değiştirildi. Yeni ad: " + urun.getAdi());
					}
				}
			}
		}
	}
}
