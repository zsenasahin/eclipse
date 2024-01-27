package paket_2222;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUMSINIFLAR_2222 {
	public static class Urun_2222 {
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
			if (kategoriAdi.equalsIgnoreCase("DairyProducts")) {
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
	
	
	public static class DosyadanOkuma_2222 {
		static Scanner scanner = new Scanner(System.in);
		static List<Urun_2222> Beverages = new ArrayList<>();
	    static List<Urun_2222> Condiments = new ArrayList<>();
	    static List<Urun_2222> Confections = new ArrayList<>();
	    static List<Urun_2222> DairyProducts = new ArrayList<>();
	    static List<Urun_2222> Cereals = new ArrayList<>();
	    
	    public static List<Urun_2222> getBeverages() {
			return Beverages;
		}
	    public static List<Urun_2222> getCondiments() {
			return Condiments;
		}
	    public static List<Urun_2222> getConfections() {
			return Confections;
		}
	    public static List<Urun_2222> getDairyProducts() {
			return DairyProducts;
		}
	    public static List<Urun_2222> getCereals() {
			return Cereals;
		}
	    
	    static List<List<Urun_2222>> kategoriListeleri = List.of(Beverages, Condiments, Confections, DairyProducts, Cereals);
		public static void ListeleriOlustur(String dosyaAdi) {
	        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
	            String line;
	            br.readLine();
	            while ((line = br.readLine()) != null) {
	            	String[] urunBilgileri = line.split("\t");
	                String adi = urunBilgileri[0];
	                int kategoriIndex = Integer.parseInt(urunBilgileri[1]);
	                String birimAgirligi = urunBilgileri[2];
	                double birimFiyati = Double.parseDouble(urunBilgileri[3]);
	                int stokMiktari = Integer.parseInt(urunBilgileri[4]);
	                System.out.println(line);
	                Urun_2222 urun = new Urun_2222(adi,kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	                switch (kategoriIndex) {
	                case 1:
	                    Beverages.add(urun);
	                    break;
	                case 2:
	                    Condiments.add(urun);
	                    break;
	                case 3:
	                    Confections.add(urun);
	                    break;
	                case 4:
	                    DairyProducts.add(urun);
	                    break;
	                case 5:
	                    Cereals.add(urun);
	                    break;
	                default:
	                    System.out.println("Geçersiz kategori indexi.");
	                    break;
	            }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}
	
	public static class Beverages_2222 extends Urun_2222{

		@Override
		public void urunFiyatGuncelle(List<List<Urun_2222>> kategoriListeleri, int oran) {
			/* ürünün stokMiktarı < 20 ise oran/2 ile işlem yap. 20<stokMiktarı<50 ise oran ile
			stokMiktarı >50 ise oran^2 ile işlem yaparak override ediniz*/
			for(Urun_2222 urun: DosyadanOkuma_2222.Beverages) {
				if(urun.getStokMiktari() < 20) {
					double yeniFiyat = urun.getBirimFiyati() * (1 + oran / 200.0);
					urun.setBirimFiyati(yeniFiyat);
				}else if(urun.getStokMiktari()> 20 && urun.getStokMiktari()<50) {
					double yeniFiyat = urun.getBirimFiyati() * (1 + oran / 100.0);
					urun.setBirimFiyati(yeniFiyat);
				}else if(urun.getStokMiktari() >50) {
					double yeniFiyat = urun.getBirimFiyati() * (1 + (oran*oran) / 100.0);
					urun.setBirimFiyati(yeniFiyat);
				}
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex()+ " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
		
	}
	
	
	public static class Condiments_2222 extends Urun_2222{
		public void cesniBirimAgirlikGuncelle(String yeniAgirlik) {
			int enCokStok = 0;
			Urun_2222 enCokStokluUrun = null;
			for(Urun_2222 urun: DosyadanOkuma_2222.Condiments) {
				if(urun.getStokMiktari()> enCokStok) {
					enCokStok = urun.getStokMiktari();
					enCokStokluUrun = urun;
					urun.setBirimAgirligi(yeniAgirlik);
				}
			}
			System.out.println(enCokStokluUrun.getAdi() + " " + enCokStokluUrun.getKategoriIndex()+  " " + enCokStokluUrun.getBirimAgirligi() + " " +enCokStokluUrun.getBirimFiyati() + " " + enCokStokluUrun.getStokMiktari());
		}
		
		
		public static void cesniBirimAgirlikGuncelle(String yeniAgirlik, int stokMiktari) {
			Urun_2222 enYakinUrun = DosyadanOkuma_2222.Condiments.get(0);
	        int enKucukUzaklik = Math.abs(stokMiktari - enYakinUrun.getStokMiktari());

	        for (Urun_2222 urun : DosyadanOkuma_2222.Condiments) {
	            int uzaklik = Math.abs(stokMiktari - urun.getStokMiktari());
	            if (uzaklik < enKucukUzaklik) {
	                enKucukUzaklik = uzaklik;
	                enYakinUrun = urun;
	            }
	        }

	        enYakinUrun.setBirimAgirligi(yeniAgirlik);

	        System.out.println("En yakın ürün: " + enYakinUrun.getAdi());
	        System.out.println("Yeni Urun Listesi: ");
	        for(Urun_2222 urun : DosyadanOkuma_2222.Condiments) {
	        	System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
	        }
	    }
		
	}
	
	
	public static class Confections_2222 extends Urun_2222{
		
		@Override
		public void urunStokGuncelle(List<List<Urun_2222>> kategoriListeleri, int stokMiktari, boolean girisMi) {
			//stokMiktari > 10 ise çıkış, stokMiktari<20 ise giriş işlemini yap.
			for(Urun_2222 urun: DosyadanOkuma_2222.Confections) {
				if(girisMi) {
					if(stokMiktari > 10) {
						int yeniStok = urun.getStokMiktari() + stokMiktari;
						urun.setStokMiktari(yeniStok);
					}
				}else {
					if(stokMiktari< 20) {
						int yeniStok = urun.getStokMiktari() - stokMiktari;
						urun.setStokMiktari(yeniStok);
					}
				}
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
	}

	
	public static class DairyProducts_2222 extends Urun_2222 {

		public void sutUrunuSil() {
			int enAzStok = Integer.MAX_VALUE;
			Urun_2222 enAzStokluUrun = null;

			List<Urun_2222> silinecekler = new ArrayList<>();

			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
				if (urun.getStokMiktari() < enAzStok) {
					enAzStok = urun.getStokMiktari();
					enAzStokluUrun = urun;
				}
			}

			if (enAzStokluUrun != null) {
				System.out.println(enAzStokluUrun.getAdi() + " adlı süt ürünü silindi.");
				silinecekler.add(enAzStokluUrun);
			} else {
				System.out.println("Süt ürünü bulunamadı.");
			}

			DosyadanOkuma_2222.DairyProducts.removeAll(silinecekler);

			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}

		public void sutUrunuSil(int minStok, int maxStok, double fiyat) {
			// Girilen iki sayı aralığında fiyat > urunFiyati ise urunu sil.
			List<Urun_2222> silinecekler = new ArrayList<>();
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
				if (urun.getStokMiktari() > minStok && urun.getStokMiktari() < maxStok) {
					if (fiyat > urun.getBirimFiyati()) {
						silinecekler.add(urun);
					}
				}
			}
			System.out.println("Silinenler");
			for (Urun_2222 urun : silinecekler) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}

			DosyadanOkuma_2222.DairyProducts.removeAll(silinecekler);
			System.out.println("\nGüncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}

		public void sutUrunuSil(double fiyat) {
			// fiyat<urunFiyati urunleri sil
			List<Urun_2222> silinecekler = new ArrayList<>();
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
				if (fiyat < urun.getBirimFiyati()) {
					silinecekler.add(urun);
				}

			}
			System.out.println("Silinenler");
			for (Urun_2222 urun : silinecekler) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}

			DosyadanOkuma_2222.DairyProducts.removeAll(silinecekler);
			System.out.println("\nGüncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProducts) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
	}
	
	public static class Cereals_2222 extends Urun_2222 {

		public void tahilUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
			Cereals_2222 yeniUrun = new Cereals_2222();
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimAgirligi(birimAgirligi);
			yeniUrun.setBirimFiyati(birimFiyati);
			yeniUrun.setStokMiktari(stokMiktari);
			DosyadanOkuma_2222.Cereals.add(yeniUrun);
			for(Urun_2222 urun : DosyadanOkuma_2222.Cereals) {
				System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
		
		public void tahilUrunEkle(String adi, double birimFiyati, int stokMiktari) {
			Cereals_2222 yeniUrun = new Cereals_2222();
			yeniUrun.setBirimAgirligi("10");
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimFiyati(birimFiyati);
			yeniUrun.setStokMiktari(stokMiktari);
			DosyadanOkuma_2222.Cereals.add(yeniUrun);
			for(Urun_2222 urun : DosyadanOkuma_2222.Cereals) {
				System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}

		}

		public void tahilUrunEkle(String adi, String birimAgirligi, double birimFiyati, String detay) {
			Cereals_2222 yeniUrun = new Cereals_2222();
			yeniUrun.setBirimAgirligi(birimAgirligi);
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimFiyati(birimFiyati);
			yeniUrun.setStokMiktari(20);
			yeniUrun.setDetay(detay);
			DosyadanOkuma_2222.Cereals.add(yeniUrun);
			
			for(Urun_2222 urun : DosyadanOkuma_2222.Cereals) {
				if(urun.getDetay() == null) {
					System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
				}else {
					System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari() + " " + urun.getDetay() );

				}
			}
		}
	}

	public static class Main_2222 {
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			DosyadanOkuma_2222.ListeleriOlustur("Urunler.txt");
			List<List<Urun_2222>> kategoriListeleri = DosyadanOkuma_2222.kategoriListeleri;
			
			int secim;
			while (true) {
				System.out.println("\nMenü:");
				System.out.println("1: Urun Fiyat Güncelle 1");
				System.out.println("2: Urun Fiyat Güncelle 2");
				System.out.println("3. Urun Stok Güncelle");
				System.out.println("4. Urun Kategorik Zam Yap 1");
				System.out.println("5. Urun Kategorik Zam Yap 2");
				System.out.println("6. Beverages -> UrunFiyatGuncelle");
				System.out.println("7. Condiments -> CesniBirimAgirlikGuncelle 1");
				System.out.println("8. Condiments -> CesniBirimAgirlikGuncelle 2");
				System.out.println("9. Confections -> UrunStokGuncelle");
				System.out.println("10. DairyProducts -> SutUrunuSil 1");
				System.out.println("11. DairyProducts -> SutUrunuSil 2");
				System.out.println("12. DairyProducts -> SutUrunuSil 3");
				System.out.println("13. Cereals -> TahilUrunEkle 1");
				System.out.println("14. Cereals -> TahilUrunEkle 2");
				System.out.println("15. Cereals -> TahilUrunEkle 3");
				System.out.println("0. Çıkış");
				System.out.print("Seçiminizi yapınız: ");
				secim = scanner.nextInt();
				Urun_2222 urun = new Urun_2222();
				switch (secim) {
				case 1:
					System.out.println("Oran giriniz: ");
					int oran = scanner.nextInt();
					urun.urunFiyatGuncelle(kategoriListeleri,oran);
					break;
				case 2:
					System.out.println("Stok giriniz: ");
					int stokMiktari = scanner.nextInt();
					System.out.println("Oran giriniz: ");
					int oran2 = scanner.nextInt();
					urun.urunFiyatGuncelle(kategoriListeleri, oran2, stokMiktari);
					break;
				case 3:
					System.out.println("Stok giriniz: ");
					int stok = scanner.nextInt();
					System.out.println("Giris Mi (true/false)");
					boolean girisMi = scanner.nextBoolean();
					urun.urunStokGuncelle(kategoriListeleri, stok, girisMi);
					break;
				case 4:
					System.out.println("Kategori adı giriniz: ");
					String kategoriAdi = scanner.nextLine();
					kategoriAdi = scanner.nextLine();
					urun.urunKategorikZamYap(kategoriListeleri, kategoriAdi);
					
					break;
				case 5:
					urun.urunKategorikZamYap(kategoriListeleri);
					break;
				case 6:
					System.out.println("Oran gir: ");
					int oran3 = scanner.nextInt();
					Beverages_2222 beverages = new Beverages_2222();
					beverages.urunFiyatGuncelle(kategoriListeleri, oran3);
					break;
				case 7:
					Condiments_2222 condiments = new Condiments_2222();
					System.out.println("Yeni ağırlık giriniz: ");
					String yeniAgirlik = scanner.next();
					condiments.cesniBirimAgirlikGuncelle(yeniAgirlik);
					break;
				case 8:
					condiments = new Condiments_2222();
					System.out.println("Yeni agirlik giriniz: ");
					yeniAgirlik = scanner.next();
					System.out.println("Stok miktari giriniz: ");
					stokMiktari = scanner.nextInt();
					condiments.cesniBirimAgirlikGuncelle(yeniAgirlik, stokMiktari);
					break;
				case 9:
					Confections_2222 confections = new Confections_2222();
					System.out.println("StokMiktari giriniz: ");
					int stokMiktari2 = scanner.nextInt();
					System.out.println("GirisMi (true/false)");
					girisMi = scanner.nextBoolean();
					confections.urunStokGuncelle(kategoriListeleri, stokMiktari2, girisMi);
					break;
				case 10:
					DairyProducts_2222 dairyProducts = new DairyProducts_2222();
					dairyProducts.sutUrunuSil();
					break;
				case 11:
					dairyProducts = new DairyProducts_2222();
					System.out.println("Min stok gir: ");
					int minStok = scanner.nextInt();
					System.out.println("Max stok gir: ");
					int maxStok = scanner.nextInt();
					System.out.println("Fiyat gir: ");
					int fiyat = scanner.nextInt();
					dairyProducts.sutUrunuSil(minStok, maxStok, fiyat);
					break;
				case 12: 
					dairyProducts = new DairyProducts_2222();
					System.out.println("Fiyat giriniz: ");
					fiyat = scanner.nextInt();
					dairyProducts.sutUrunuSil(fiyat);
					break;
				case 13:
					System.out.println("Adini giriniz: ");
					String yeniIsim = scanner.nextLine();
					yeniIsim = scanner.nextLine();
					System.out.println("Birim agirligi giriniz: ");
					String yeniBirimAgirligi = scanner.next();
					System.out.println("Birim fiyatini giriniz: ");
					double yeniBirimFiyati = scanner.nextDouble();
					System.out.println("Stok miktari giriniz :");
					int yeniStokMiktarii = scanner.nextInt();
					Cereals_2222 cereals = new Cereals_2222();
					cereals.tahilUrunEkle(yeniIsim, yeniBirimAgirligi, yeniBirimFiyati, yeniStokMiktarii);
					break;
				case 14:
					System.out.println("Adini giriniz: ");
					String adi = scanner.nextLine();
					adi = scanner.nextLine();
					System.out.println("Birim fiyatini giriniz: ");
					double birimFiyati = scanner.nextDouble();
					System.out.println("Stok miktari giriniz :");
					int stokMiktarii = scanner.nextInt();
					cereals = new Cereals_2222();
					cereals.tahilUrunEkle(adi, birimFiyati, stokMiktarii);
					break;
				case 15:
					System.out.println("Adini giriniz: ");
					String yeniAdi = scanner.nextLine();
					yeniAdi = scanner.nextLine();
					System.out.println("Birim agirligi giriniz: ");
					String birimAgirligi = scanner.next();	
					System.out.println("Birim Fiyati giriniz: ");
					yeniBirimFiyati = scanner.nextDouble();
					System.out.println("Detay giriniz: ");
					String detay = scanner.next();
					Cereals_2222 cereals2 = new Cereals_2222();
					cereals2.tahilUrunEkle(yeniAdi, birimAgirligi, yeniBirimFiyati , detay);
					break;
				case 0:
					System.out.println("Programdan çıkılıyor..");
					System.exit(0);
					break;
				default:
					System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
				}
			}
		}
		
	}
	
}
