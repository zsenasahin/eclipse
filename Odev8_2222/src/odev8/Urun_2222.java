package odev8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import odev8.DosyaIslemleri_2222.DosyadanOku;


public class Urun_2222 implements Serializable {

	public String Adi;
	public int KategoriIndex;
	public String BirimAgirligi;
	public double BirimFiyati;
	public int StokMiktari;

	public Urun_2222() {

	}

	public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		this.Adi = adi;
		this.KategoriIndex = kategoriIndex;
		this.BirimAgirligi = birimAgirligi;
		this.BirimFiyati = birimFiyati;
		this.StokMiktari = stokMiktari;
	}

	public String getAdi() {
		return Adi;
	}

	public int getKategoriIndex() {
		return KategoriIndex;
	}

	public String getBirimAgirligi() {
		return BirimAgirligi;
	}

	public double getBirimFiyati() {
		return BirimFiyati;
	}

	public int getStokMiktari() {
		return StokMiktari;
	}

	public void setAdi(String adi) {
		Adi = adi;
	}

	public void setKategoriIndex(int kategoriIndex) {
		KategoriIndex = kategoriIndex;
	}

	public void setBirimAgirligi(String birimAgirligi) {
		BirimAgirligi = birimAgirligi;
	}

	public void setBirimFiyati(double birimFiyati) {
		BirimFiyati = birimFiyati;
	}

	public void setStokMiktari(int stokMiktari) {
		StokMiktari = stokMiktari;
	}

	public void urunStokGuncelle(String urunAdi, boolean ekleMi) {
		for (List<Urun_2222> kategoriListesi : DosyadanOku.kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if (ekleMi) {
						int yeniStok = (urun.getStokMiktari() * 3) / 2;
						System.out.println(urun.getAdi() + " adli urune " + urun.getStokMiktari() + "'nin %50si kadar stok eklendi. ");
						urun.setStokMiktari(yeniStok);
						System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi()
								+ " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
					} else {
						int yeniStok = (urun.getStokMiktari()) / 2;
						System.out.println(urun.getAdi() + " adli urunden " + urun.getStokMiktari() + "'nin %50si kadar stok cikarildi. ");
						urun.setStokMiktari(yeniStok);
						System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi()
								+ " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
					}

				}
			}
			
		}
	}

	public void urunKategorikIndirimYap(String kategoriAdi, int x) {
		double toplam = 0.0;
		double ortalamaFiyat = 0.0;
		int sayac = 0;
		int index = -1;
		switch (kategoriAdi) {
		case "Beverages":
			index = 1;
			break;
		case "Condiments":
			index = 2;
			break;
		case "Confections":
			index = 3;
			break;
		case "Dairy Products":
			index = 4;
			break;
		case "Cereals":
			index = 5;
			break;
		default :
			System.out.println("Kategori bulunamamaktadir.");
			break;
		}

		for (List<Urun_2222> kategoriListesi : DosyadanOku.kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				if (urun.getKategoriIndex() == index) {
					sayac++;
					toplam += urun.getBirimFiyati();
				}
			}
		}
		ortalamaFiyat = toplam / sayac;
		System.out.println("Ortalama Fiyat: " + ortalamaFiyat);

		for (List<Urun_2222> kategoriListesi : DosyadanOku.kategoriListeleri) {
			for (Urun_2222 urun : kategoriListesi) {
				if (urun.getKategoriIndex() == index) {
					if (urun.getBirimFiyati() > ortalamaFiyat) {
						double yeniFiyat = urun.getBirimFiyati() - ((urun.getBirimFiyati() * x) / 100.0);
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi()
								+ " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
					}
				}
			}
		}
	}

	static class Beverages_2222 {

		public Beverages_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati,
				int stokMiktari) {

		}

		public static void IcecekUrunuSil(String urunAdi) {
		    List<Urun_2222> silinecekler = new ArrayList<>();

		    for (Urun_2222 urun : DosyadanOku.BeveragesList) {
		        if (urun.getAdi().trim().equalsIgnoreCase(urunAdi.trim())) {
		            System.out.println(urun.getAdi() + " adlı icecek ürünü silindi.");
		            silinecekler.add(urun);
		        }
		    }

		    if (!silinecekler.isEmpty()) {
		        DosyadanOku.BeveragesList.removeAll(silinecekler);
		    } else {
		        System.out.println("icecek");
		    }

		    System.out.println("Güncellenmiş Ürün Listesi");
		    for (Urun_2222 urun : DosyadanOku.BeveragesList) {
		        System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
		                + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		    }
		}

		}
		static class Condiments_2222 {
			private String adi;
			private String birimAgirligi;
			private double birimFiyati;
			private int stokMiktari;


			public Condiments_2222(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
				this.adi = adi;
	            this.birimAgirligi = birimAgirligi;
	            this.birimFiyati = birimFiyati;
	            this.stokMiktari = stokMiktari;
			}
			
			public Condiments_2222() {
				
			}
			
			
			public static void cesniUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {	
				Urun_2222 urun2 = new Urun_2222(adi, stokMiktari, birimAgirligi, birimFiyati, stokMiktari);
				DosyadanOku.CondimentsList.add(urun2);
				for(Urun_2222 urun: DosyadanOku.CondimentsList) {
					System.out.println(urun.getAdi() + " " + "2" + " " + urun.getBirimAgirligi() + " "
			                + urun.getBirimFiyati() + " " + urun.getStokMiktari());
				}
				
			}
			
			
		}

		static class Confections_2222 {
			public Confections_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati,
					int stokMiktari) {

			}
			
			private static List<String> details = new ArrayList<>();
		    protected static void urunGrubuDetayEkle(String newDetail) {
		        try (BufferedReader br = new BufferedReader(new FileReader("urunGrubu.txt"))) {
		            String line;

		            while ((line = br.readLine()) != null) {
		                String[] sutun = line.split("\t");
		                if (sutun[0].equals("3")) {
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

		static class DairyProducts_2222 {
			public DairyProducts_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati,
					int stokMiktari) {

			}
			public static void sutUrunuStokGuncelle(boolean satisMi, int miktar) {
				for(Urun_2222 urun : DosyadanOku.DairyProductsList) {
					if(satisMi) {
						if(urun.getStokMiktari()-miktar < 0) {
							System.out.println("Yeterli stok bulunmamaktadir.");
						}else {
							urun.setStokMiktari(urun.getStokMiktari() - miktar);
						}
					}else {
						urun.setStokMiktari(urun.getStokMiktari() + miktar);
					}
					System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
				}
			}
			
		}

		static class Cereals_2222 {
			public Cereals_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati,
					int stokMiktari) {
			}
			
			public static void TahilBirimFiyatGuncelle(double yeniFiyat) {
		        if (DosyadanOku.CerealsList.isEmpty()) {
		            System.out.println("Liste boş. Güncelleme yapılamaz.");
		            return;
		        }

		        double ortalamaFiyat = 0.0;
		        for (Urun_2222 tahil : DosyadanOku.CerealsList) {
		            ortalamaFiyat += tahil.getBirimFiyati();
		        }
		        ortalamaFiyat /= DosyadanOku.CerealsList.size();
		        System.out.println("ortalama: " + ortalamaFiyat);
		        Urun_2222 enYakinTahil = DosyadanOku.CerealsList.get(0);
		        double minFark = Math.abs(DosyadanOku.CerealsList.get(0).getBirimFiyati() - ortalamaFiyat);
		        for (Urun_2222 tahil : DosyadanOku.CerealsList) {
		            double fark = Math.abs(tahil.getBirimFiyati() - ortalamaFiyat);
		            if (fark < minFark) {
		                minFark = fark;
		                enYakinTahil = tahil;
		            }
		        }

		        enYakinTahil.setBirimFiyati(yeniFiyat);

		        System.out.println("Güncellenmiş Liste:");
		        for (Urun_2222 tahil : DosyadanOku.CerealsList) {
		            System.out.println(tahil.getAdi() + " " + tahil.getBirimAgirligi() + " " + tahil.getBirimFiyati() + " " + tahil.getStokMiktari());
		        }
		    }
			
		}
	
}
