package paket_2222;

import java.util.List;
import java.util.Scanner;

public class Urun_2222 {
	Scanner scanner = new Scanner(System.in);
	private String adi;
	private int kategoriIndex;
	private String birimAgirligi;
	private double birimFiyati;
	private int stokMiktari;
	private String detay;

	public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		this.adi = adi;
		this.kategoriIndex = kategoriIndex;
		this.birimAgirligi = birimAgirligi;
		this.birimFiyati = birimFiyati;
		this.stokMiktari = stokMiktari;
	}

	public Urun_2222() {

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

	public String getDetay() {
		return detay;
	}

	public void setDetay(String detay) {
		this.detay = detay;
	}

	public void urunFiyatGuncelle(List<List<Urun_2222>> kategoriListeleri, int oran) {
		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				double yeniFiyat = urun.getBirimFiyati() * (1 + oran / 100.0);
				urun.setBirimFiyati(yeniFiyat);
				System.out.println(urun.adi + " "+ urun.birimAgirligi + " " + urun.getBirimFiyati() + " " + urun.stokMiktari);
			}
		}
	}

	public void urunFiyatGuncelle(List<List<Urun_2222>> kategoriListeleri, int oran, int stokMiktari) {
		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				if (stokMiktari > urun.getStokMiktari()) {
					double yeniFiyat = urun.getBirimFiyati() * (1 + oran / 100.0);
					urun.setBirimFiyati(yeniFiyat);
				}
			}
		}
		System.out.println("Guncellenmis Liste: \n");
		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				System.out.println(urun.adi + " "+ urun.birimAgirligi + " " + urun.getBirimFiyati() + " " + urun.stokMiktari);
			}
		}

	}

	public void urunStokGuncelle(List<List<Urun_2222>> kategoriListeleri, int stokMiktari, boolean girisMi) {
		// Giriş çıkışa göre stok miktarlarını güncelle.
		for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				if (girisMi) {
					int yeniStok = urun.stokMiktari + stokMiktari;
					urun.setStokMiktari(yeniStok);
				} else {
					int yeniStok = urun.stokMiktari - stokMiktari;
					if(yeniStok < 0) {
						System.out.println("Stok miktari yeterli degil.");
					}else {
						urun.setStokMiktari(yeniStok);
					}
				}
				System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
						+ urun.birimFiyati + " " + urun.stokMiktari);
			}
		}

	}

	public void urunKategorikZamYap(List<List<Urun_2222>> kategoriListeleri, String kategoriAdi) {
		// urun adının uzunlugunu birimfiyata ekle
		if (kategoriAdi.equalsIgnoreCase("Beverages")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 1) {
						int uzunluk = urun.adi.replace(" ", "").length();
						double yeniFiyat = urun.getBirimFiyati() + uzunluk;
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(urun.adi + " " + urun.birimFiyati);
					}
				}
			}
		}

		if (kategoriAdi.equalsIgnoreCase("Condiments")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 2) {
						int uzunluk = urun.adi.replace(" ", "").length();
						double yeniFiyat = urun.getBirimFiyati() + uzunluk;
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(urun.adi + " " + urun.birimFiyati);
					}
				}
			}
		}
		if (kategoriAdi.equalsIgnoreCase("Confections")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 3) {
						int uzunluk = urun.adi.replace(" ", "").length();
						double yeniFiyat = urun.getBirimFiyati() + uzunluk;
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(urun.adi + " " + urun.birimFiyati);
					}
				}
			}
		}
		if (kategoriAdi.equalsIgnoreCase("Dairy Products")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 4) {
						int uzunluk = urun.adi.replace(" ", "").length();
						double yeniFiyat = urun.getBirimFiyati() + uzunluk;
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(urun.adi + " " + urun.birimFiyati);
					}
				}
			}
		}
		if (kategoriAdi.equalsIgnoreCase("Cereals")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 5) {
						int uzunluk = urun.adi.replace(" ", "").length();
						double yeniFiyat = urun.getBirimFiyati() + uzunluk;
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(urun.adi + " " + urun.birimFiyati);
					}
				}
			}
		}
	}

	public void urunKategorikZamYap(List<List<Urun_2222>> kategoriListeleri) {
		// stokKontrol > 10 ise %L kadar (L: urunun ad uzunluğu), değilse %2L kadar zam
		// yap.
		System.out.println("Kategori adi giriniz: ");
		String kategoriAdi = scanner.nextLine();
		if (kategoriAdi.equalsIgnoreCase("Beverages")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 1) {
						if (urun.getStokMiktari() > 10) {
							double uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + (uzunluk / 100.0));
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.getAdi() + " " + urun.getBirimFiyati());
						} else {
							double uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + (2 * uzunluk) / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.getAdi() + " " + urun.getBirimFiyati());
						}

					}
				}
			}
		}

		if (kategoriAdi.equalsIgnoreCase("Condiments")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 2) {
						if (urun.getStokMiktari() > 10) {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + uzunluk / 100.0);
							urun.setBirimFiyati(yeniFiyat);

							System.out.println(urun.adi + " " + urun.birimFiyati);
						} else {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + (2 * uzunluk) / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						}
					}
				}
			}
		}
		if (kategoriAdi.equalsIgnoreCase("Confections")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 3) {
						if (urun.getStokMiktari() > 10) {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + uzunluk / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						} else {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + (2 * uzunluk) / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						}
					}
				}
			}
		}
		if (kategoriAdi.equalsIgnoreCase("Dairy Products")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 4) {
						if (urun.getStokMiktari() > 10) {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + uzunluk / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						} else {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + (2 * uzunluk) / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						}
					}
				}
			}
		}
		if (kategoriAdi.equalsIgnoreCase("Cereals")) {
			for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
				for (Urun_2222 urun : kategoriListesi) {
					if (urun.kategoriIndex == 5) {
						if (urun.getStokMiktari() > 10) {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + uzunluk / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						} else {
							int uzunluk = urun.adi.replace(" ", "").length();
							double yeniFiyat = urun.getBirimFiyati() * (1 + (2 * uzunluk) / 100.0);
							urun.setBirimFiyati(yeniFiyat);
							System.out.println(urun.adi + " " + urun.birimFiyati);
						}
					}
				}
			}
		}
	}
		
	
}
