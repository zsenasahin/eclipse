package odev;
/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUMSINIFLAR_2222 {

	//Urun sınıfı
	abstract class Urun_2222 implements IUrun_2222{
		public String Adi;
		public int kategoriIndex;
		public String birimAgirligi;
		public double birimFiyati;
		public int stokMiktari;
		public String detay;
		
		public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			this.Adi = adi;
			this.kategoriIndex = kategoriIndex;
			this.birimAgirligi = birimAgirligi;
			this.birimFiyati = birimFiyati;
			this.stokMiktari = stokMiktari;
			this.detay = detay;
		}
		
		public Urun_2222() {
	
		}
		
		public String getAdi() {
			return Adi;
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
		public String getDetay() {
			return detay;
		}
		
		public void setAdi(String adi) {
			Adi = adi;
		}
		public void setBirimAgirligi(String birimAgirligi) {
			this.birimAgirligi = birimAgirligi;
		}
		public void setBirimFiyati(double birimFiyati) {
			this.birimFiyati = birimFiyati;
		}
		public void setKategoriIndex(int kategoriIndex) {
			this.kategoriIndex = kategoriIndex;
		}
		public void setStokMiktari(int stokMiktari) {
			this.stokMiktari = stokMiktari;
		}
		public void setDetay(String detay) {
			this.detay = detay;
		}
		abstract void urunFiyatGuncelle(int kayit, int oran, boolean indirimMi);
		
		abstract void urunKategorikZamYap(int kayit, int x);
	}

	//IUrun sınıfı
	public interface IUrun_2222 {
		void urunStokGuncelle(int adet, boolean GirisMi, int kayit);
		void urunIsimGuncelle(int kayit,String yeniIsım, String yeniDetay);
		void urunSil(int kayit);
		void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay);
	}
	
	//DosyadanOkuma
	public static class DosyadanOkuma_2222 {
		static Scanner scanner = new Scanner(System.in);
		static List<Urun_2222> BeveragesList = new ArrayList<>();
		static List<Urun_2222> CondimentsList = new ArrayList<>();
		static List<Urun_2222> ConfectionsList = new ArrayList<>();
		static List<Urun_2222> DairyProductsList = new ArrayList<>();
		static List<Urun_2222> CerealsList = new ArrayList<>();

		static List<List<Urun_2222>> kategoriListeleri = List.of(BeveragesList, CondimentsList, ConfectionsList,
				DairyProductsList, CerealsList);

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
					switch (kategoriIndex) {
					case 1:
						BeveragesList.add(new Beverages_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
						break;
					case 2:
						CondimentsList.add(new Condiments_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
						break;
					case 3:
						ConfectionsList.add(new Confections_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
						break;
					case 4:
						DairyProductsList
								.add(new DairyProducts_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari,""));
						break;
					case 5:
						CerealsList.add(new Cereals_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
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


	//Beverages
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
	
	//Condiments
	public class Condiments_2222 extends Urun_2222{
		private int katsayi = 2;
	    private String kategoriAdi;
	    private String detay = null;
	    int sayac=0;
		public Condiments_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, int katsayi, String kategoriAdi, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
			this.katsayi = katsayi;
	        this.kategoriAdi = kategoriAdi;
	        this.detay = detay;
		}

		public Condiments_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari,detay);
		}

		public Condiments_2222() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void urunStokGuncelle(int adet, boolean GirisMi, int kayit) {
			
			for(Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				sayac++;
				if(sayac==kayit) {
					if(GirisMi) {
						int yeniStok = urun.getStokMiktari()+adet+katsayi;
						urun.setStokMiktari(yeniStok);
						System.out.println("Eklenen urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
					}else {
						int yeniStok = urun.getStokMiktari()-(adet+katsayi);
						if(yeniStok < 0) {
							System.out.println("Stok yeterli degil.");
						}else {
							urun.setStokMiktari(yeniStok);
							System.out.println("Cikarilan urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
						}
					}
				}
			}
			
			System.out.println("Guncel Liste");
			for(Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.getStokMiktari());
			}
		}

		@Override
		public void urunIsimGuncelle(int kayit, String yeniIsım, String yeniDetay) {
			for (Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				sayac++;
				if (sayac == kayit) {
					System.out.println("Degistirilen urun: " + urun.getAdi());
					urun.setAdi(yeniIsım);
					urun.setDetay(yeniDetay);
				}
			}
			
			System.out.println("\nGuncel Liste");
			for (Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " "
						+ urun.birimFiyati + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}
		}

		@Override
		public void urunSil(int kayit) {
			List<Urun_2222> silinecekler = new ArrayList<>();
			for(Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				sayac++;
				if(sayac==kayit) {
					silinecekler.add(urun);
				}
			}
			DosyadanOkuma_2222.CondimentsList.removeAll(silinecekler);
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}		
		}

		@Override
		public void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			Condiments_2222 yeniUrun = new Condiments_2222();
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimAgirligi(birimAgirligi);
			yeniUrun.setBirimFiyati(birimFiyati+katsayi);
			yeniUrun.setStokMiktari(stokMiktari);
			yeniUrun.setDetay(detay);
			DosyadanOkuma_2222.CondimentsList.add(yeniUrun);
			for(Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				System.out.println(urun.getAdi() + " " + "1" + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}		
		}

		@Override
		void urunFiyatGuncelle(int kayit, int oran, boolean indirimMi) {
			for (Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
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
		                double zamMiktari = urun.getBirimFiyati() * ((oran + katsayi)/ 100.0);
		                urun.setBirimFiyati(urun.getBirimFiyati() + zamMiktari);
		                System.out.println("Zam yapilan urun: " + urun.getAdi());
		            }
				}
			}
			
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}		
		}

		@Override
		void urunKategorikZamYap(int kayit, int x) {
			for(Urun_2222 urun: DosyadanOkuma_2222.CondimentsList) {
				
					double zam = (urun.getBirimFiyati() * (x+katsayi)  / 100.0);
					urun.setBirimFiyati(urun.getBirimFiyati() + zam);
					System.out.println("Zam yapilan urun: " + urun.getAdi());
				
			}
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.CondimentsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}

	}
	
	
	//Confections
	public class Confections_2222 extends Urun_2222{
		
		private int katsayi = 3;
	    private String kategoriAdi;
	    private String detay = null;
		int sayac=0;

		
		public Confections_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, int katsayi, String kategoriAdi, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari,detay);
			this.katsayi = katsayi;
	        this.kategoriAdi = kategoriAdi;
	        this.detay = detay;
		}

		public Confections_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
		}

		public Confections_2222() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void urunStokGuncelle(int adet, boolean GirisMi, int kayit) {
			for(Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				sayac++;
				if(sayac==kayit) {
					if(GirisMi) {
						int yeniStok = urun.getStokMiktari()+adet+katsayi;
						urun.setStokMiktari(yeniStok);
						System.out.println("Eklenen urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
					}else {
						int yeniStok = urun.getStokMiktari()-(adet+katsayi);
						if(yeniStok < 0) {
							System.out.println("Stok yeterli degil.");
						}else {
						urun.setStokMiktari(yeniStok);
						System.out.println("Cikarilan urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
						}
					}
				}
			}
			
			System.out.println("Guncel Liste");
			for(Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.getStokMiktari());
			}	
		}

		@Override
		public void urunIsimGuncelle(int kayit, String yeniIsım, String yeniDetay) {
			for (Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				sayac++;
				if (sayac == kayit) {
					System.out.println("Degistirilen urun: " + urun.getAdi());
					urun.setAdi(yeniIsım);
					urun.setDetay(yeniDetay);
				}
			}
			
			System.out.println("\nGuncel Liste");
			for (Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " "
						+ urun.birimFiyati + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}
		}

		@Override
		public void urunSil(int kayit) {
			List<Urun_2222> silinecekler = new ArrayList<>();
			for(Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				sayac++;
				if(sayac==kayit) {
					silinecekler.add(urun);
				}
			}
			DosyadanOkuma_2222.ConfectionsList.removeAll(silinecekler);
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}

		@Override
		public void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			Confections_2222 yeniUrun = new Confections_2222();
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimAgirligi(birimAgirligi);
			yeniUrun.setBirimFiyati(birimFiyati+katsayi);
			yeniUrun.setStokMiktari(stokMiktari);
			yeniUrun.setDetay(detay);
			DosyadanOkuma_2222.ConfectionsList.add(yeniUrun);
			for(Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				System.out.println(urun.getAdi() + " " + "1" + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}		
		}

		@Override
		void urunFiyatGuncelle(int kayit, int oran, boolean indirimMi) {
			for (Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
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
			for (Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}			
		}

		@Override
		void urunKategorikZamYap(int kayit, int x) {
			for(Urun_2222 urun: DosyadanOkuma_2222.ConfectionsList) {
				
				double zam = (urun.getBirimFiyati() * (x+katsayi)  / 100.0);
				urun.setBirimFiyati(urun.getBirimFiyati() + zam);
				System.out.println("Zam yapilan urun: " + urun.getAdi());
				
			}
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.ConfectionsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}			
		}

	}
	
	
	//DairyProducts
	public class DairyProducts_2222 extends Urun_2222{
		
		private int katsayi = 4;
	    private String kategoriAdi;
	    private String detay = null;
		int sayac=0;

		public DairyProducts_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, int katsayi, String kategoriAdi, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
			this.katsayi = katsayi;
	        this.kategoriAdi = kategoriAdi;
	        this.detay = detay;
		}

		public DairyProducts_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
		}

		public DairyProducts_2222() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void urunStokGuncelle(int adet, boolean GirisMi, int kayit) {
			for(Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				sayac++;
				if(sayac==kayit) {
					if(GirisMi) {
						int yeniStok = urun.getStokMiktari()+adet+katsayi;
						urun.setStokMiktari(yeniStok);
						System.out.println("Eklenen urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
					}else {
						int yeniStok = urun.getStokMiktari()-(adet+katsayi);
						if(yeniStok < 0) {
							System.out.println("Stok yeterli degil.");
						}else {
						urun.setStokMiktari(yeniStok);
						System.out.println("Cikarilan urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
						}
					}
				}
			}
			
			System.out.println("Guncel Liste");
			for(Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.getStokMiktari());
			}	
		}

		@Override
		public void urunIsimGuncelle(int kayit, String yeniIsım, String yeniDetay) {
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				sayac++;
				if (sayac == kayit) {
					System.out.println("Degistirilen urun: " + urun.getAdi());
					urun.setAdi(yeniIsım);
					urun.setDetay(yeniDetay);
				}
			}
			
			System.out.println("\nGuncel Liste");
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " "
						+ urun.birimFiyati + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}
			
		}

		@Override
		public void urunSil(int kayit) {
			List<Urun_2222> silinecekler = new ArrayList<>();
			for(Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				sayac++;
				if(sayac==kayit) {
					silinecekler.add(urun);
				}
			}
			DosyadanOkuma_2222.DairyProductsList.removeAll(silinecekler);
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}		
		}

		@Override
		public void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			DairyProducts_2222 yeniUrun = new DairyProducts_2222();
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimAgirligi(birimAgirligi);
			yeniUrun.setBirimFiyati(birimFiyati+katsayi);
			yeniUrun.setStokMiktari(stokMiktari);
			yeniUrun.setDetay(detay);
			DosyadanOkuma_2222.DairyProductsList.add(yeniUrun);
			for(Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				System.out.println(urun.getAdi() + " " + "1" + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}		
		}

		@Override
		void urunFiyatGuncelle(int kayit, int oran, boolean indirimMi) {
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
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
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}			
		}

		@Override
		void urunKategorikZamYap(int kayit, int x) {
			for(Urun_2222 urun: DosyadanOkuma_2222.DairyProductsList) {
			
				double zam = (urun.getBirimFiyati() * (x+katsayi)  / 100.0);
				urun.setBirimFiyati(urun.getBirimFiyati() + zam);
				System.out.println("Zam yapilan urun: " + urun.getAdi());
			
			}
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.DairyProductsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}			
		}

	}
	
	
	//Cereals sınıfı
	public class Cereals_2222 extends Urun_2222{
		
		private int katsayi = 5;
	    private String kategoriAdi;
	    private String detay;
		int sayac=0;

		public Cereals_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, int katsayi, String kategoriAdi, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari,detay);
			this.katsayi = katsayi;
	        this.kategoriAdi = kategoriAdi;
	        this.detay = detay;
		}

		public Cereals_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, detay);
		}

		public Cereals_2222() {
			
		}

		@Override
		public void urunStokGuncelle(int adet, boolean GirisMi, int kayit) {
			for(Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				sayac++;
				if(sayac==kayit) {
					if(GirisMi) {
						int yeniStok = urun.getStokMiktari()+adet+katsayi;
						urun.setStokMiktari(yeniStok);
						System.out.println("Eklenen urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
					}else {
						int yeniStok = urun.getStokMiktari()-(adet+katsayi);
						if(yeniStok < 0) {
							System.out.println("Stok yeterli degil.");
						}else {
						urun.setStokMiktari(yeniStok);
						System.out.println("Cikarilan urun: " + urun.getAdi() + " guncel stok miktari: " + urun.getStokMiktari());
						}
					}
				}
			}
			
			System.out.println("Guncel Liste");
			for(Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " " + urun.birimFiyati + " " + urun.getStokMiktari());
			}		
		}

		@Override
		public void urunIsimGuncelle(int kayit, String yeniIsım, String yeniDetay) {
			for (Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				sayac++;
				if (sayac == kayit) {
					System.out.println("Degistirilen urun: " + urun.getAdi());
					urun.setAdi(yeniIsım);
					urun.setDetay(yeniDetay);
				}
			}
			
			System.out.println("\nGuncel Liste");
			for (Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.birimAgirligi + " "
						+ urun.birimFiyati + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}
		}

		@Override
		public void urunSil(int kayit) {
			List<Urun_2222> silinecekler = new ArrayList<>();
			for(Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				sayac++;
				if(sayac==kayit) {
					silinecekler.add(urun);
				}
			}
			DosyadanOkuma_2222.CerealsList.removeAll(silinecekler);
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
		}

		@Override
		public void yeniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari, String detay) {
			Cereals_2222 yeniUrun = new Cereals_2222();
			yeniUrun.setAdi(adi);
			yeniUrun.setBirimAgirligi(birimAgirligi);
			yeniUrun.setBirimFiyati(birimFiyati+katsayi);
			yeniUrun.setStokMiktari(stokMiktari);
			yeniUrun.setDetay(detay);
			DosyadanOkuma_2222.CerealsList.add(yeniUrun);
			for(Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				System.out.println(urun.getAdi() + " " + "1" + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari() + " " + urun.getDetay());
			}
		}

		@Override
		void urunFiyatGuncelle(int kayit, int oran, boolean indirimMi) {
			Cereals_2222 yeniUrun = new Cereals_2222();
			for (Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				sayac++;
				if(sayac==kayit) {
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
			for (Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}			
		}

		@Override
		void urunKategorikZamYap(int kayit, int x) {
			for(Urun_2222 urun: DosyadanOkuma_2222.CerealsList) {
				double zam = (urun.getBirimFiyati() * (x+katsayi) / 100.0);
				urun.setBirimFiyati(urun.getBirimFiyati() + zam);
				System.out.println("Zam yapilan urun: " + urun.getAdi());	
			}
			System.out.println("Güncellenmis Urun Listesi");
			for (Urun_2222 urun : DosyadanOkuma_2222.CerealsList) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}		
		}

	}
	
	
	//MENU
	public class Menu_2222 {
		static Scanner scanner = new Scanner(System.in);
		public static void main(String[] args) {
			DosyadanOkuma_2222.ListeleriOlustur("Urunler.txt");
			int secim;
			int secim2;
			while(true) {
				System.out.println("\nMenü:");
				System.out.println("1: Beverages ");
				System.out.println("2: Condiments");
				System.out.println("3. Confections");
				System.out.println("4. Dairy Products");
				System.out.println("5. Cereals");
				System.out.println("0. Cikis");
				System.out.print("Seçiminizi yapınız: ");
				secim = scanner.nextInt();
				Beverages_2222 beverages = new Beverages_2222();
				Condiments_2222 condiments = new Condiments_2222();
				Confections_2222 confections = new Confections_2222();
				DairyProducts_2222 dairyProducts = new DairyProducts_2222();
				Cereals_2222 cereals = new Cereals_2222();
				System.out.println("Kacinci siradaki urune islem uygulamak istersiniz ?");
				int kayit = scanner.nextInt();
				switch(secim) {
				case 1:
					while(true) {
						System.out.println("Islemler");
						System.out.println("1: Urun Stok Guncelle (BEVERAGES)");
						System.out.println("2: Urun Isim Guncelle (BEVERAGES)");
						System.out.println("3: Urun Sil (BEVERAGES)");
						System.out.println("4: Yeni Urun Ekle (BEVERAGES)");
						System.out.println("5: Urun Fiyat Guncelle (BEVERAGES)");
						System.out.println("6. Urun Kategorik Zam Yap (BEVERAGES)");
						System.out.println("0. Cikis.");
						System.out.println("Seçiminizi yapınız: ");
						secim2 = scanner.nextInt();
						switch(secim2) {
						case 1:
							System.out.println("Giris Mi (true/false)");
							boolean girisMi = scanner.nextBoolean();
							System.out.println("Adet giriniz: ");
							int adet = scanner.nextInt();
							beverages.urunStokGuncelle(adet, girisMi, kayit);
							break;
						case 2:
							System.out.println("Yeni isim giriniz: ");
							String yeniIsim = scanner.nextLine();
							yeniIsim = scanner.nextLine();
							System.out.println("Detay giriniz: ");
							String detay = scanner.nextLine();
							beverages.urunIsimGuncelle(kayit, yeniIsim, detay);
							break;
						case 3:
							beverages.urunSil(kayit);
							break;
						case 4:
							System.out.println("Yeni urun adi giriniz: ");
							String yeniAdi = scanner.nextLine();
							yeniAdi = scanner.nextLine();
							System.out.println("Birim agirligi giriniz: ");
							String birimAgirligi = scanner.nextLine();
							System.out.println("Birim fiyati giriniz: ");
							double birimFiyati = scanner.nextDouble();
							System.out.println("Stok miktari giriniz: ");
							int stokMiktari = scanner.nextInt();
							System.out.println("Detay giriniz :");
							detay = scanner.nextLine();
							beverages.yeniUrunEkle(yeniAdi, birimAgirligi, birimFiyati, stokMiktari, detay);
							break;
						case 5:
							System.out.println("Oran giriniz: ");
							int oran = scanner.nextInt();
							System.out.println("İndirim Mi (true/false)");
							boolean indirimMi = scanner.nextBoolean();
							beverages.urunFiyatGuncelle(kayit, oran, indirimMi);
							break;
						case 6:
							System.out.println("Zam Orani giriniz: ");
							int zamOrani = scanner.nextInt();
							beverages.urunKategorikZamYap(kayit, zamOrani);
							break;
						case 0:
							System.out.println("Programdan cikiliyor...");
							break;
						}
						break;
					}
					break;
				case 2:
					while(true) {
						System.out.println("Islemler");
						System.out.println("1: Urun Stok Guncelle");
						System.out.println("2: Urun Isim Guncelle");
						System.out.println("3: Urun Sil");
						System.out.println("4: Yeni Urun Ekle");
						System.out.println("5: Urun Fiyat Guncelle");
						System.out.println("6. Urun Kategorik Zam Yap");
						System.out.println("Seçiminizi yapınız: ");
						secim2 = scanner.nextInt();
						switch(secim2) {
						case 1:
							System.out.println("Giris Mi (true/false)");
							boolean girisMi = scanner.nextBoolean();
							System.out.println("Adet giriniz: ");
							int adet = scanner.nextInt();
							condiments.urunStokGuncelle(adet, girisMi, kayit);
							break;
						case 2:
							System.out.println("Yeni isim giriniz: ");
							String yeniIsim = scanner.nextLine();
							yeniIsim = scanner.nextLine();
							System.out.println("Eklenecek detay giriniz: ");
							String detay = scanner.nextLine();
							condiments.urunIsimGuncelle(kayit, yeniIsim, detay);
							break;
						case 3:
							
							condiments.urunSil(kayit);
							break;
						case 4:
							System.out.println("Yeni urun adi giriniz: ");
							String yeniAdi = scanner.nextLine();
							yeniAdi = scanner.nextLine();
							System.out.println("Birim agirligi giriniz: ");
							String birimAgirligi = scanner.nextLine();
							System.out.println("Birim fiyati giriniz: ");
							double birimFiyati = scanner.nextDouble();
							System.out.println("Stok miktari giriniz: ");
							int stokMiktari = scanner.nextInt();
							System.out.println("Detay giriniz :");
							detay = scanner.nextLine();
							detay = scanner.nextLine();
							condiments.yeniUrunEkle(yeniAdi, birimAgirligi, birimFiyati, stokMiktari, detay);
							break;
						case 5:
							System.out.println("Oran giriniz: ");
							int oran = scanner.nextInt();
							System.out.println("İndirim Mi (true/false)");
							boolean indirimMi = scanner.nextBoolean();
							condiments.urunFiyatGuncelle(kayit, oran, indirimMi);
							break;
						case 6:
							System.out.println("Zam Orani giriniz: ");
							int zamOrani = scanner.nextInt();
							condiments.urunKategorikZamYap(kayit, zamOrani);
							break;
						case 0:
							System.out.println("Programdan cikiliyor...");
							break;
						}
						break;
					}
					break;
				case 3:
					while(true) {
						System.out.println("Islemler");
						System.out.println("1: Urun Stok Guncelle");
						System.out.println("2: Urun Isim Guncelle");
						System.out.println("3: Urun Sil");
						System.out.println("4: Yeni Urun Ekle");
						System.out.println("5: Urun Fiyat Guncelle");
						System.out.println("6. Urun Kategorik Zam Yap");
						System.out.println("Seçiminizi yapınız: ");
						secim2 = scanner.nextInt();
						switch(secim2) {
						case 1:
							System.out.println("Giris Mi (true/false)");
							boolean girisMi = scanner.nextBoolean();
							System.out.println("Adet giriniz: ");
							int adet = scanner.nextInt();
							confections.urunStokGuncelle(adet, girisMi, kayit);
							break;
						case 2:
							System.out.println("Yeni isim giriniz: ");
							String yeniIsim = scanner.nextLine();
							yeniIsim = scanner.nextLine();
							System.out.println("Detay giriniz: ");
							String detay = scanner.nextLine();
							confections.urunIsimGuncelle(kayit, yeniIsim, detay);
							break;
						case 3:
							confections.urunSil(kayit);
							break;
						case 4:
							System.out.println("Yeni urun adi giriniz: ");
							String yeniAdi = scanner.nextLine();
							yeniAdi = scanner.nextLine();
							System.out.println("Birim agirligi giriniz: ");
							String birimAgirligi = scanner.nextLine();
							System.out.println("Birim fiyati giriniz: ");
							double birimFiyati = scanner.nextDouble();
							System.out.println("Stok miktari giriniz: ");
							int stokMiktari = scanner.nextInt();
							System.out.println("Detay giriniz :");
							detay = scanner.nextLine();
							detay = scanner.nextLine();
							confections.yeniUrunEkle(yeniAdi, birimAgirligi, birimFiyati, stokMiktari, detay);
							break;
						case 5:
							System.out.println("Oran giriniz: ");
							int oran = scanner.nextInt();
							System.out.println("İndirim Mi (true/false)");
							boolean indirimMi = scanner.nextBoolean();
							confections.urunFiyatGuncelle(kayit, oran, indirimMi);
							break;
						case 6:
							System.out.println("Zam Orani giriniz: ");
							int zamOrani = scanner.nextInt();
							confections.urunKategorikZamYap(kayit, zamOrani);
							break;
						case 0:
							System.out.println("Programdan cikiliyor...");
							break;
						}
						break;
					}
					break;
				case 4:
					while(true) {
						System.out.println("Islemler");
						System.out.println("1: Urun Stok Guncelle");
						System.out.println("2: Urun Isim Guncelle");
						System.out.println("3: Urun Sil");
						System.out.println("4: Yeni Urun Ekle");
						System.out.println("5: Urun Fiyat Guncelle");
						System.out.println("6. Urun Kategorik Zam Yap");
						System.out.println("Seçiminizi yapınız: ");
						secim2 = scanner.nextInt();
						switch(secim2) {
						case 1:
							System.out.println("Giris Mi (true/false)");
							boolean girisMi = scanner.nextBoolean();
							System.out.println("Adet giriniz: ");
							int adet = scanner.nextInt();
							dairyProducts.urunStokGuncelle(adet, girisMi, kayit);
							break;
						case 2:
							System.out.println("Yeni isim giriniz: ");
							String yeniIsim = scanner.nextLine();
							yeniIsim = scanner.nextLine();
							System.out.println("Detay giriniz: ");
							String detay = scanner.nextLine();
							dairyProducts.urunIsimGuncelle(kayit, yeniIsim, detay);
							break;
						case 3:
							dairyProducts.urunSil(kayit);
							break;
						case 4:
							System.out.println("Yeni urun adi giriniz: ");
							String yeniAdi = scanner.nextLine();
							yeniAdi = scanner.nextLine();
							System.out.println("Birim agirligi giriniz: ");
							String birimAgirligi = scanner.nextLine();
							System.out.println("Birim fiyati giriniz: ");
							double birimFiyati = scanner.nextDouble();
							System.out.println("Stok miktari giriniz: ");
							int stokMiktari = scanner.nextInt();
							System.out.println("Detay giriniz :");
							detay = scanner.nextLine();
							detay = scanner.nextLine();
							dairyProducts.yeniUrunEkle(yeniAdi, birimAgirligi, birimFiyati, stokMiktari, detay);
							break;
						case 5:
							System.out.println("Oran giriniz: ");
							int oran = scanner.nextInt();
							System.out.println("İndirim Mi (true/false)");
							boolean indirimMi = scanner.nextBoolean();
							dairyProducts.urunFiyatGuncelle(kayit, oran, indirimMi);
							break;
						case 6:
							System.out.println("Zam Orani giriniz: ");
							int zamOrani = scanner.nextInt();
							dairyProducts.urunKategorikZamYap(kayit, zamOrani);
							break;
						case 0:
							System.out.println("Programdan cikiliyor...");
							break;
						}
						break;
					}
					break;
				case 5:
					while(true) {
						System.out.println("Islemler");
						System.out.println("1: Urun Stok Guncelle");
						System.out.println("2: Urun Isim Guncelle");
						System.out.println("3: Urun Sil");
						System.out.println("4: Yeni Urun Ekle");
						System.out.println("5: Urun Fiyat Guncelle");
						System.out.println("6. Urun Kategorik Zam Yap");
						System.out.println("7. Cikis.");
						System.out.println("Seçiminizi yapınız: ");
						secim2 = scanner.nextInt();
						switch(secim2) {
						case 1:
							System.out.println("Giris Mi (true/false)");
							boolean girisMi = scanner.nextBoolean();
							System.out.println("Adet giriniz: ");
							int adet = scanner.nextInt();
							cereals.urunStokGuncelle(adet, girisMi, kayit);
							break;
						case 2:
							System.out.println("Yeni isim giriniz: ");
							String yeniIsim = scanner.nextLine();
							yeniIsim = scanner.nextLine();
							System.out.println("Detay giriniz: ");
							String detay = scanner.nextLine();
							cereals.urunIsimGuncelle(kayit, yeniIsim, detay);
							break;
						case 3:
							cereals.urunSil(kayit);
							break;
						case 4:
							System.out.println("Yeni urun adi giriniz: ");
							String yeniAdi = scanner.nextLine();
							yeniAdi = scanner.nextLine();
							System.out.println("Birim agirligi giriniz: ");
							String birimAgirligi = scanner.nextLine();
							System.out.println("Birim fiyati giriniz: ");
							double birimFiyati = scanner.nextDouble();
							System.out.println("Stok miktari giriniz: ");
							int stokMiktari = scanner.nextInt();
							System.out.println("Detay giriniz :");
							detay = scanner.nextLine();
							detay = scanner.nextLine();
							cereals.yeniUrunEkle(yeniAdi, birimAgirligi, birimFiyati, stokMiktari, detay);
							break;
						case 5:
							System.out.println("Oran giriniz: ");
							int oran = scanner.nextInt();
							System.out.println("İndirim Mi (true/false)");
							boolean indirimMi = scanner.nextBoolean();
							cereals.urunFiyatGuncelle(kayit, oran, indirimMi);
							break;
						case 6:
							System.out.println("Zam Orani giriniz: ");
							int zamOrani = scanner.nextInt();
							cereals.urunKategorikZamYap(kayit, zamOrani);
							break;
						case 0:
							System.out.println("Programdan cikiliyor...");
							break;
						}
						break;
					}
					break;
				case 0:
					System.out.println("Programdan cikiliyor...");
					break;
				}
			}
			
		}
	}

	
	
}
*/
