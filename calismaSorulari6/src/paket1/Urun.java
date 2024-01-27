package paket1;

import java.util.List;
import java.util.Scanner;

public class Urun {
	Scanner scanner = new Scanner(System.in);
	private String adi;
	private int kategoriIndex;
	private String birimAgirligi;
	private double birimFiyati;
	private int stokMiktari;

	public Urun(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		this.adi = adi;
		this.kategoriIndex = kategoriIndex;
		this.birimAgirligi = birimAgirligi;
		this.birimFiyati = birimFiyati;
		this.stokMiktari = stokMiktari;
	}

	public Urun() {

	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public int getKategoriIndex() {
		return kategoriIndex;
	}

	public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}

	public String getBirimAgirligi() {
		return birimAgirligi;
	}

	public void setBirimAgirligi(String birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}

	public double getBirimFiyati() {
		return birimFiyati;
	}

	public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}

	public int getStokMiktari() {
		return stokMiktari;
	}

	public void setStokMiktari(int stokMiktari) {
		this.stokMiktari = stokMiktari;
	}

	public void urunStokGuncelle(List<List<Urun>> kategoriListeleri) {
		System.out.println("Urun adi :");
		String urunAdi = scanner.nextLine();
		System.out.println("Satış mı ?");
		boolean satisMi = scanner.nextBoolean();
		System.out.println("Adet gir: ");
		int adet = scanner.nextInt();
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if (satisMi) {
						if (urun.stokMiktari > adet) {
							urun.stokMiktari -= adet;
							System.out.println(adet + " adet " + urun.getAdi() + " satıldı.");
							System.out.println(urun.getAdi() + " " + urun.getBirimAgirligi() + " "
									+ urun.getBirimFiyati() + " " + (urun.getStokMiktari() - adet));
						} else {
							System.out.println("Girilen miktar stok degerinden buyuk olamaz.");
						}

					} else {
						urun.stokMiktari += adet;
						System.out.println(adet + " adet " + urun.getAdi() + " stoğa eklendi.");
						System.out.println(urun.getAdi() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati()
								+ " " + (urun.getStokMiktari() + adet));

					}
				}
			}
		}
	}

	public void urunAdiDegistir(List<List<Urun>> kategoriListeleri) {
		System.out.println("Urun adi giriniz: ");
		String eskiAdi = scanner.nextLine();
		System.out.println("Yeni urun adını giriniz: ");
		String yeniAdi = scanner.nextLine();

		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(eskiAdi)) {
					urun.setAdi(yeniAdi);
					System.out.println(yeniAdi + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " "
							+ urun.getStokMiktari());
				}
			}
		}
	}

	public void uruneZamYap(List<List<Urun>> kategoriListeleri) {
		System.out.println("Urun adi giriniz: ");
		String urunAdi = scanner.nextLine();
		System.out.println("Zam oranı gir: ");
		int zamOrani = scanner.nextInt();
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					urun.birimFiyati *= (1 + zamOrani / 100.0);
					System.out.println("Ürüne zam yapıldı. Yeni birim fiyat: " + urun.birimFiyati);
				}
			}
		}
	}

	public void urunAdiDegistir(List<List<Urun>> kategoriListeleri, boolean sesliMi) {
		System.out.println("Urun adi giriniz: ");
		String eskiAdi = scanner.nextLine();
		System.out.println("Yeni urun adını giriniz: ");
		String yeniAdi = scanner.nextLine();

		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(eskiAdi)) {
					if (sesliMi) {
						String yeniAdiSessizHarflerle = yeniAdi.toLowerCase().replaceAll("[bcçdfgğhjklmnprstvyz]", "");
						urun.setAdi(yeniAdiSessizHarflerle);
						System.out.println("Ürün adı değiştirildi. Yeni ad: " + urun.getAdi());
					} else {
						String yeniAdiSessizHarflerle = yeniAdi.toLowerCase().replaceAll("[aeıioöuü]", "");
						urun.setAdi(yeniAdiSessizHarflerle);
						System.out.println("Ürün adı değiştirildi. Yeni ad: " + urun.getAdi());
					}
				}
			}
		}
	}

	public void urunStokGuncelle(List<List<Urun>> kategoriListeleri, String urunAdi, int adet) {
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if (urun.stokMiktari > adet) {
						int yeniStok = urun.stokMiktari -= adet;
						setStokMiktari(yeniStok);
						System.out.println(adet + " adet " + urun.getAdi() + " satıldı.");
						System.out.println(urun.getAdi() + " " + urun.getBirimAgirligi() + " "
								+ urun.getBirimFiyati() + " " + (urun.getStokMiktari()));
					} else {
						System.out.println("Girilen miktar stok degerinden buyuk olamaz.");
					}
				}
			}
		}
	}

}
