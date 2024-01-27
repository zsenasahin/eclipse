package paket2_2222;

import java.util.ArrayList;
import java.util.List;

public class Urun_2222 {
	private String adi;
	private int kategoriIndex;
	private String birimAgirligi;
	private double birimFiyati;
	private int stokMiktari;
	private String detay;

	public Urun_2222() {
	}

	public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		this.adi = adi;
		this.kategoriIndex = kategoriIndex;
		this.birimAgirligi = birimAgirligi;
		this.birimFiyati = birimFiyati;
		this.stokMiktari = stokMiktari;
	}

	public Urun_2222(int kategoriIndex, String adi, String detay) {
		this.kategoriIndex = kategoriIndex;
		this.adi = adi;
		this.detay = detay;
	}

	public String getAdi() {
		return adi;
	}

	public String getBirimAgirligi() {
		return birimAgirligi;
	}

	public double getBirimFiyati() {
		return birimFiyati;
	}

	public int getKategoriIndex() {
		return kategoriIndex;
	}

	public int getStokMiktari() {
		return stokMiktari;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}

	public void setBirimAgirligi(String birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}

	public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}

	public void setStokMiktari(int stokMiktari) {
		this.stokMiktari = stokMiktari;
	}

	protected static void urunleriFiyataGoreSil(List<List<Urun_2222>> kategoriListeleri, double minFiyat, double maxFiyat) {
		List<Urun_2222> silinecekUrunler = new ArrayList<>();

		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				if (urun.birimFiyati >= minFiyat && urun.birimFiyati <= maxFiyat) {
					silinecekUrunler.add(urun);
				}
			}
		}

		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			kategoriListesi.removeAll(silinecekUrunler);
		}
		// Silinen ürünler için
		/*
		 * for (Urun urun : silinecekUrunler) { System.out.println(urun.adi +
		 * " ürünü fiyat aralığından silindi."); }
		 */
		List<Urun_2222> kalaniUrunler = new ArrayList<>();

		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			kalaniUrunler.addAll(kategoriListesi);
		}

		System.out.println("Ürünlerin Son Hali:");
		for (Urun_2222 urun : kalaniUrunler) {
			System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.stokMiktari);
		}
	}
	
	protected static void UrunKategorikStokGuncelle(List<List<Urun_2222>> kategoriListeleri,String kategoriAdi, int X) {
		if (kategoriAdi.equalsIgnoreCase("Beverages")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 1) {
						double artisOrani = (double) X / 100.0;
			            int yeniStokMiktari = (int) (urun.getStokMiktari() * (1 + artisOrani));
			            urun.setStokMiktari(yeniStokMiktari);
					}
				}
			}
			System.out.println("Güncellenmiş Liste:");
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 1) {
						System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.stokMiktari);
					}
				}
			}
		}
		
		if (kategoriAdi.equalsIgnoreCase("Condiments")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 2) {
						double artisOrani = (double) X / 100.0;
			            int yeniStokMiktari = (int) (urun.getStokMiktari() * (1 + artisOrani));
			            urun.setStokMiktari(yeniStokMiktari);
					}
				}
			}
			System.out.println("Güncellenmiş Liste:");
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 2) {
						System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.stokMiktari);
					}
				}
			}
		}
		
		if (kategoriAdi.equalsIgnoreCase("Confections")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 3) {
						double artisOrani = (double) X / 100.0;
			            int yeniStokMiktari = (int) (urun.getStokMiktari() * (1 + artisOrani));
			            urun.setStokMiktari(yeniStokMiktari);
					}
				}
			}
			System.out.println("Güncellenmiş Liste:");
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 3) {
						System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.stokMiktari);
					}
				}
			}
		}
		
		if (kategoriAdi.equalsIgnoreCase("Dairy Products")) {
			//System.out.println("girdiii");
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 4) {
						double artisOrani = (double) X / 100.0;
			            int yeniStokMiktari = (int) (urun.getStokMiktari() * (1 + artisOrani));
			            urun.setStokMiktari(yeniStokMiktari);
					}
				}
			}
			System.out.println("Güncellenmiş Liste:");
			//System.out.println("girdiii2");
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 4) {
						System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.stokMiktari);
					}
				}
			}
		}
		
		if (kategoriAdi.equalsIgnoreCase("Cereals")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 5) {
						double artisOrani = (double) X / 100.0;
			            int yeniStokMiktari = (int) (urun.getStokMiktari() * (1 + artisOrani));
			            urun.setStokMiktari(yeniStokMiktari);
					}
				}
			}
			System.out.println("Güncellenmiş Liste:");
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 5) {
						System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.stokMiktari);
					}
				}
			}
		}
    }

}
