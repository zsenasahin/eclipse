package tumSiniflar_2222;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TUMSINIFLAR_2222 {

	// package paket1;
	// import paket2.Urun_2222;

	public static class DosyadanOku_2222 {
		static List<Urun_2222> Beverages = new ArrayList<>();
		static List<Urun_2222> Condiments = new ArrayList<>();
		static List<Urun_2222> Confections = new ArrayList<>();
		static List<Urun_2222> DairyProducts = new ArrayList<>();
		static List<Urun_2222> Cereals = new ArrayList<>();

		public static List<List<Urun_2222>> kategoriListeleri = List.of(Beverages, Condiments, Confections,
				DairyProducts, Cereals);

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

		private static void ListeleriOlustur(String dosyaAdi) {
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
					Urun_2222 urun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
					System.out.println(line);
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

			System.out.println("Detay listesi:");
			try (BufferedReader br = new BufferedReader(new FileReader("urunGrubu.txt"))) {
				String line;

				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public static void DosyaOkumaListeleriOlustur(String urunDosyaAdi) {
			ListeleriOlustur(urunDosyaAdi);
		}
	}

//*****************************************************************************************************************	

	// package paket2;

	public static class Urun_2222 {
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

		protected static void urunleriFiyataGoreSil(List<List<Urun_2222>> kategoriListeleri, double minFiyat,
				double maxFiyat) {
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
				System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
						+ urun.birimFiyati + " " + urun.stokMiktari);
			}
		}

		protected static void UrunKategorikStokGuncelle(List<List<Urun_2222>> kategoriListeleri, String kategoriAdi,
				int X) {
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
							System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
									+ urun.birimFiyati + " " + urun.stokMiktari);
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
							System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
									+ urun.birimFiyati + " " + urun.stokMiktari);
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
							System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
									+ urun.birimFiyati + " " + urun.stokMiktari);
						}
					}
				}
			}

			if (kategoriAdi.equalsIgnoreCase("Dairy Products")) {
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
				for (List<Urun_2222> kategoriListesi : kategoriListeleri) {
					for (Urun_2222 urun : kategoriListesi) {
						if (urun.kategoriIndex == 4) {
							System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
									+ urun.birimFiyati + " " + urun.stokMiktari);
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
							System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " "
									+ urun.birimFiyati + " " + urun.stokMiktari);
						}
					}
				}
			}
		}

	}

	public static class Main_2222 {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			DosyadanOku_2222.DosyaOkumaListeleriOlustur("urunler.txt");
			List<List<Urun_2222>> kategoriListeleri = DosyadanOku_2222.kategoriListeleri;
			Urun_2222 urun = new Urun_2222();

			int secim;
			while (true) {
				System.out.println("\nMenü:");
				System.out.println("1: Urunleri fiyata gore sil");
				System.out.println("2: Urun Kategorik Stok Guncelle");
				System.out.println("3. Icecek birim agirlik guncelle");
				System.out.println("4. Cesni stok guncelle");
				System.out.println("5. Sekerleme urun ekle");
				System.out.println("6. sut urunleri detay ekle");
				System.out.println("7. Hububat sil");
				System.out.println("0. Çıkış");
				System.out.print("Seçiminizi yapınız: ");
				secim = scanner.nextInt();

				switch (secim) {
				case 1:
					System.out.println("Minimum fiyatı giriniz: ");
					double minFiyat = scanner.nextDouble();
					System.out.println("maximum fiyatı giriniz: ");
					double maxFiyat = scanner.nextDouble();
					Urun_2222.urunleriFiyataGoreSil(kategoriListeleri, minFiyat, maxFiyat);

					break;
				case 2:
					System.out.println("Kategori adı giriniz: ");
					String kategoriAdi = scanner.nextLine();
					kategoriAdi = scanner.nextLine();
					System.out.println("X giriniz: ");
					int x = scanner.nextInt();
					Urun_2222.UrunKategorikStokGuncelle(kategoriListeleri, kategoriAdi, x);
					break;
				case 3:
					System.out.println("yeni ağırlık giriniz: ");
					String yeniAgirlik = scanner.next();
					Beverages_2222.icecekBirimAgirlikGuncelle(yeniAgirlik);
					break;
				case 4:
					System.out.println("indexi giriniz: ");
					int index = scanner.nextInt();
					System.out.println("Satis mi (true/false)");
					boolean satisMi = scanner.nextBoolean();
					System.out.println("Miktar giriniz: ");
					int miktar = scanner.nextInt();
					Condiments_2222.CesniStokGuncelle(index, satisMi, miktar);
					break;
				case 5:
					System.out.println("yeni urun adini giriniz: ");
					String yeniUrunAdi = scanner.next();
					System.out.println("yeni urun birim agirligini giriniz: ");
					String yeniUrunBirimAgirligi = scanner.next();
					System.out.println("yeni urun birim fiyatini giriniz: ");
					double yeniUrunBirimFiyati = scanner.nextDouble();
					System.out.println("yeni urun stok miktarini giriniz :");
					int stokMiktari = scanner.nextInt();
					Confections_2222.SekerlemeUrunEkle(yeniUrunAdi, yeniUrunBirimAgirligi, yeniUrunBirimFiyati,
							stokMiktari);
					break;
				case 6:
					System.out.println("detay giriniz: ");
					String yeniDetay = scanner.next();

					DairyProducts_2222.urunGrubuDetayEkle(yeniDetay);
					break;
				case 7:
					Cereals_2222.hububatSil();
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

	public static class Beverages_2222 extends Urun_2222 {

		protected static void icecekBirimAgirlikGuncelle(String yeniAgirlik) {
			List<Urun_2222> beveragesListesi = DosyadanOku_2222.getBeverages();

			if (!beveragesListesi.isEmpty()) {
				Urun_2222 sonUrun = beveragesListesi.get(beveragesListesi.size() - 1);

				sonUrun.setBirimAgirligi(yeniAgirlik);

			} else {
				System.out.println("Beverages listesi boş.");
			}
			for (Urun_2222 urun : beveragesListesi) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
	}

	public static class Condiments_2222 extends Urun_2222 {
		protected static void CesniStokGuncelle(int index, boolean SatisMi, int miktar) {
			List<Urun_2222> CondimentsListesi = DosyadanOku_2222.getCondiments();
			if (!CondimentsListesi.isEmpty()) {

				Urun_2222 indexliUrun = CondimentsListesi.get(index);
				int stok = indexliUrun.getStokMiktari();
				if (SatisMi) {
					if (stok > miktar) {
						int yeniStok = (stok - miktar);
						indexliUrun.setStokMiktari(yeniStok);
						System.out.println(indexliUrun.getAdi() + " " + indexliUrun.getKategoriIndex() + " "
								+ indexliUrun.getBirimAgirligi() + " " + indexliUrun.getBirimFiyati() + " " + yeniStok);

					} else {
						System.out.println("Hata. Girilen miktar stoktan küçük olamaz.");
					}
				} else {
					int yeniStok = (stok + miktar);
					indexliUrun.setStokMiktari(yeniStok);
					System.out.println(indexliUrun.getAdi() + " " + indexliUrun.getKategoriIndex() + " "
							+ indexliUrun.getBirimAgirligi() + " " + indexliUrun.getBirimFiyati() + " " + yeniStok);

				}

			} else {
				System.out.println("Beverages listesi boş.");
			}
		}
	}

	public static class Confections_2222 extends Urun_2222{
		protected static void SekerlemeUrunEkle(String Adi, String BirimAgirligi, double BirimFiyatı,int StokMiktari) {
			List<Urun_2222> ConfectionsListesi = DosyadanOku_2222.getConfections();
			Urun_2222 yeniUrun = new Urun_2222(Adi, 3, BirimAgirligi,BirimFiyatı,StokMiktari);
			ConfectionsListesi.add(yeniUrun);
			for(Urun_2222 urun : ConfectionsListesi) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi()
	            + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
	}
	
	public static class DairyProducts_2222 extends Urun_2222{
	    private static List<String> details = new ArrayList<>();
	    protected static void urunGrubuDetayEkle(String newDetail) {
	        try (BufferedReader br = new BufferedReader(new FileReader("urunGrubu.txt"))) {
	            String line;

	            while ((line = br.readLine()) != null) {
	                String[] sutun = line.split("\t");
	                if (sutun[0].equals("4")) {
	                    sutun[2] += ", " + newDetail;
	                    line = String.join("\t", sutun);
	                }

	                System.out.println(line);
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public static class Cereals_2222 extends Urun_2222 {
		
		protected static void hububatSil() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Silinecek ürünün adını giriniz: ");
			String urunAdi = scanner.nextLine();
			List<Urun_2222> CerealsListesi = DosyadanOku_2222.getCereals();
			for (Urun_2222 urun : CerealsListesi) {
				if (urun.getAdi().equals(urunAdi)) {
					CerealsListesi.remove(urun);
					System.out.println(urunAdi + " ürünü başarıyla silindi.");
					break;
				}
			}
			System.out.println("Güncellenmiş liste: ");
			for (Urun_2222 urun : CerealsListesi) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}
	}
	
}
