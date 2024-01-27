package odev;

import java.util.ArrayList;
import java.util.List;

public class Beverages_2222 extends Urun_2222 {

	private String kategoriAdi;
	private String detay = null;
	private int katsayi = 1;
	int sayac = 0;

	public Beverages_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari,
			int katsayi, String kategoriAdi, String detay) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
		this.katsayi = katsayi;
		this.kategoriAdi = kategoriAdi;
		this.detay = detay;
	}

	public Beverages_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari,
			String detay) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
	}

	public Beverages_2222() {

	}

	@Override
	public void urunStokGuncelle(int adet, boolean GirisMi, int kayit) {
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			sayac++;
			if (sayac == kayit) {
				if (GirisMi) {
					int yeniStok = urun.getStokMiktari() + adet + katsayi;
					urun.setStokMiktari(yeniStok);
					System.out.println(
							"Eklenen urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
				} else {
					int yeniStok = urun.getStokMiktari() - (adet + katsayi);
					if (yeniStok < 0) {
						System.out.println("Stok yeterli degil.");
					}else {
						urun.setStokMiktari(yeniStok);
						System.out.println(
								"Cikarilan urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
					}			

				}
			}
		}

		System.out.println("Guncel Liste");
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " "
					+ urun.birimFiyati + " " + urun.getStokMiktari());
		}
	}

	@Override
	public void urunIsimGuncelle(int kayit, String yeniIsım, String yeniDetay) {
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			sayac++;
			if (sayac == kayit) {
				System.out.println("Degistirilen urun: " + urun.getAdi());
				urun.setAdi(yeniIsım);
				urun.setDetay(yeniDetay);
			}
		}
		
		System.out.println("\nGuncel Liste");
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " "
					+ urun.birimFiyati + " " + urun.getStokMiktari() + " " + urun.getDetay());
		}
	}

	@Override
	public void urunSil(int kayit) {
		List<Urun_2222> silinecekler = new ArrayList<>();
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			sayac++;
			if(sayac==kayit) {
				silinecekler.add(urun);
			}
		}
		DosyadanOkuma_2222.BeveragesList.removeAll(silinecekler);
		System.out.println("Güncellenmis Urun Listesi");
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}

	@Override
	public void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
		Beverages_2222 yeniUrun = new Beverages_2222();
		yeniUrun.setAdi(adi);
		yeniUrun.setBirimAgirligi(birimAgirligi);
		yeniUrun.setBirimFiyati(birimFiyati + katsayi);
		yeniUrun.setStokMiktari(stokMiktari);
		yeniUrun.setDetay(detay);
		DosyadanOkuma_2222.BeveragesList.add(yeniUrun);
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			System.out.println(urun.getAdi() + " " + "1" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati()
					+ " " + urun.getStokMiktari() + " " + urun.getDetay());
		}
	}

	@Override
	void urunFiyatGuncelle(int kayit,int oran, boolean indirimMi) {
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			sayac++;
			if(kayit==sayac) {
				if (indirimMi) {
					double indirimMiktari = urun.getBirimFiyati() * ((oran + katsayi)/ 100.0 );
	                double yeniFiyat = urun.getBirimFiyati() - indirimMiktari;
	                if(yeniFiyat<0) {
		                System.out.println("Fiyat negatif olamaz.");
	                }else {
	                	urun.setBirimFiyati(yeniFiyat);
	                }
	                System.out.println("İndirim yapılan urun: " + urun.getAdi());
	            } else {
	                double zamMiktari = urun.getBirimFiyati() * ((oran + katsayi)/ 100.0 );
	                urun.setBirimFiyati(urun.getBirimFiyati() + zamMiktari);
	                System.out.println("Zam yapilan urun: " + urun.getAdi());
	            }
			}	
		}

		System.out.println("Güncellenmis Urun Listesi");
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}

	}

	@Override
	void urunKategorikZamYap(int kayit, int x) {
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			
				double zam = (urun.getBirimFiyati() * (x+katsayi)  / 100.0);
				urun.setBirimFiyati(urun.getBirimFiyati() + zam);
				System.out.println("Zam yapilan urun: " + urun.getAdi());
			
			
		}
		System.out.println("Güncellenmis Urun Listesi");
		for (Urun_2222 urun : DosyadanOkuma_2222.BeveragesList) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
					+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}

}
