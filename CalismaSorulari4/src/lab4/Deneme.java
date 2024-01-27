package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deneme {
	static Scanner scanner = new Scanner(System.in);
	static Kategoriler kategoriler = new Kategoriler();

	public static class Urun {
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
//1
		public void urunStokGuncelle(boolean satisMi, int adet) {
			if (satisMi) {
				this.stokMiktari += adet;
				System.out.println(this.getAdi() + " isimli ürünün stok miktarı " + this.getStokMiktari()
						+ " olarak güncellendi.");
			} else {
				this.stokMiktari -= adet;
				System.out.println(this.getAdi() + " isimli ürünün stok miktarı " + this.getStokMiktari()
						+ " olarak güncellendi.");
			}
		}
//2
		public void urunAdiDegistir(String yeniAdi) {
			this.adi = yeniAdi;
			System.out.println("Ürün adı " + this.getAdi() + " olarak güncellendi.\n"
					+ this.getAdi() + " " + this.getKategoriIndex() +" "+ this.getBirimAgirligi()
					+" " + this.getBirimFiyati() + " " + this.getStokMiktari());
		}
	}

	public static class Beverages extends Urun {
		public Beverages(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		}

		public void icecekUrunuEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
			Beverages yeniUrun = new Beverages(adi, 1, birimAgirligi, birimFiyati, stokMiktari);
			kategoriler.urunler.add(yeniUrun);
			System.out.println(adi + " isimli ürün başarıyla eklendi.");
			kategoriler.urunleriListele();
		}
	}

	public static class Condiments extends Urun {
		public Condiments(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
			super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		}

		public void cesniBirimFiyatGuncelle() {
			System.out.print("Güncellemek istediğiniz çeşni:");
			String cesniAdi = scanner.next();
			scanner.nextLine();
			System.out.println("İkinci ismi:");
			String ikinciAdi = scanner.next();
			String isim = (cesniAdi + " " + ikinciAdi);
			System.out.println(isim);
			System.out.print("Yeni Fiyat: ");
			double yeniFiyat = scanner.nextDouble();
			//if (this.getAdi().equalsIgnoreCase(isim)) {
				this.setAdi(isim); // Update the name
				this.setBirimFiyati(yeniFiyat); // Update the price
				System.out.println(this.getAdi() + " isimli ürünün birim fiyatı güncellendi.\n" + this.getAdi() + " "
						+ this.getKategoriIndex() + " " + this.getBirimAgirligi() + " " + this.getBirimFiyati() + " "
						+ this.getStokMiktari());
			//} else {
			//	/System.out.println("Öyle bir ürün yok");
		//	}
		}
	}

	public static class Confections extends Urun {
	    public Confections(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
	        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	    }

	    public void sekerlemeDetaySil() {
	        String dosyaAdi = "UrunGrubu.txt";
	        List<String> guncellenmisSatirlar = new ArrayList<>();

	        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
	            String line;
	            reader.readLine();
	            while ((line = reader.readLine()) != null) {
	                String[] urunGrubuBilgileri = line.split("\t");
	                int kategoriIndex = Integer.parseInt(urunGrubuBilgileri[0]);
	                String adi = urunGrubuBilgileri[1];
	                String detay = urunGrubuBilgileri[2];
	                if (kategoriIndex == 3 /*&& adi.equalsIgnoreCase(this.getAdi())*/) {
	                    String[] detayBilgisi = detay.split(",");
	                    if (detayBilgisi.length > 0) {
	                        String sonDetay = detayBilgisi[detayBilgisi.length - 1].trim();
	                        detay = detay.replace("," + sonDetay, "");
	                    }
	                }
	                guncellenmisSatirlar.add(kategoriIndex + "\t" + adi + "\t" + detay);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        for (String satir : guncellenmisSatirlar) {
	            System.out.println(satir);
	        }

	        System.out.println("Son detay bilgisi silindi.");
	    }
	}


	/*public class DairyProducts extends Urun {
	    public DairyProducts(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
	        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	    }

	    public void sutUrunuSil() {
	        List<Double> birimFiyatlar = new ArrayList<>();

	        for (Urun urun : kategoriler.getUrunler()) {
	            if (urun.getKategoriIndex() == 4) {
	                birimFiyatlar.add(urun.getBirimFiyati());
	            }
	        }

	        // Birim fiyatlarının ortalamasını bul
	        double ortalamaBirimFiyat = 0;
	        if (!birimFiyatlar.isEmpty()) {
	            for (double birimFiyat : birimFiyatlar) {
	                ortalamaBirimFiyat += birimFiyat;
	            }
	            ortalamaBirimFiyat /= birimFiyatlar.size();
	        } else {
	            System.out.println("Hata: Kategori index'i 4 olan ürün bulunamadı.");
	            return;
	        }

	        // Ortalamadan büyük olan ilk ürünü sil
	        for (Urun urun : kategoriler.getUrunler()) {
	            if (urun.getKategoriIndex() == 4 && urun.getBirimFiyati() > ortalamaBirimFiyat) {
	                this.urun.remove(urun);
	                System.out.println("Ortalamanın üzerindeki ürün silindi: " + urun.getAdi());
	                return;  // İlk uygun ürünü bulduktan sonra döngüden çık
	            }
	        }

	        System.out.println("Hata: Ortalamadan büyük ürün bulunamadı.");
	    }
	}*/

	 public static class Cereals extends Urun {
	        public Cereals(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
	            super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	        }

	        public void tahilMinStokEkle(int miktar) {
	            Urun minStokUrun = null;
	            int minStok = Integer.MAX_VALUE;

	            for (Urun urun : kategoriler.getUrunler()) {
	                if (urun.getKategoriIndex() == 5 && urun.getStokMiktari() < minStok) {
	                    minStokUrun = urun;
	                    minStok = urun.getStokMiktari();
	                }
	            }

	            if (minStokUrun != null) {
	                minStokUrun.urunStokGuncelle(true, miktar);
	                System.out.println("En az stoğa sahip tahıl ürününe " + miktar + " adet stok eklendi.");
	            } else {
	                System.out.println("Hata: Tahıl ürünü bulunamadı.");
	            }
	        }
	    }
	public static class Kategoriler {
		private List<Urun> urunler;

		public Kategoriler() {
			this.urunler = new ArrayList<>();
		}

		public List<Urun> getUrunler() {
			return urunler;
		}

		public void urunleriListele() {
			int kategoriIndex = 1;
			for (Urun urun : urunler) {
				if (urun.getKategoriIndex() == kategoriIndex) {
					System.out.println(urun.getAdi() + " " + kategoriIndex + " " + urun.birimAgirligi + " "
							+ urun.birimFiyati + " " + urun.stokMiktari);
				}
			}
		}

		public void listeleriOlustur(String dosyaAdi) {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(dosyaAdi));
				String line;
				reader.readLine();
				while ((line = reader.readLine()) != null) {
					String[] urunBilgileri = line.split("\t");
					String adi = urunBilgileri[0];
					int kategoriIndex = Integer.parseInt(urunBilgileri[1]);
					String birimAgirligi = urunBilgileri[2];
					double birimFiyati = Double.parseDouble(urunBilgileri[3]);
					int stokMiktari = Integer.parseInt(urunBilgileri[4]);
					Urun urun;
					switch (kategoriIndex) {
					case 1:
						urun = new Beverages(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
						break;
					case 2:
						urun = new Condiments(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
						break;
					/*
					 * case 3: urun = new Confections(adi, kategoriIndex, birimAgirligi,
					 * birimFiyati, stokMiktari); break;
					 */
					/*case 4:
						urun = new DairyProducts(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
						break;*/
					case 5:
						urun = new Cereals(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
						break;
					default:
						urun = new Urun(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
					}
					urunler.add(urun);
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Main {
		public static void main(String[] args) {
			Kategoriler kategoriler = new Kategoriler();
			kategoriler.listeleriOlustur("Urunler.txt");
			while (true) {
				System.out.println("1. Icecek Urunu Ekle");
				System.out.println("2. Cesni Birim Fiyat Guncelle");
				System.out.println("3. Sekerleme Detay Sil");
				System.out.println("4. Sut Urunu Sil");
				System.out.println("5. Tahil Min Stok Ekle");
				System.out.println("6. Urun Stok Guncelle");
				System.out.println("7. Urun Adi Degistir");
				System.out.println("0. Cikis");
				System.out.print("Seciminizi yapin: ");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					Beverages icecek = (Beverages) kategoriler.getUrunler().get(0);
					System.out.println("Eklemek istediğiniz ürünün ismi:");
					String adi = scanner.next();
					System.out.println("Birim Ağırlığı:");
					String birimAgirligi = scanner.next();
					System.out.println("Birim Fiyatı:");
					double birimFiyati = scanner.nextDouble();
					System.out.println("Stok Miktarı:");
					int stokMiktari = scanner.nextInt();
					icecek.icecekUrunuEkle(adi, birimAgirligi, birimFiyati, stokMiktari);
					kategoriler.urunleriListele();
					break;
				case 2:
					Condiments cesni = (Condiments) kategoriler.getUrunler().get(2);
					/*System.out.print("Güncellemek istediğiniz çeşni:");
					String cesniAdi = scanner.next();
					//scanner.nextLine();
					System.out.print("Yeni Fiyat: ");
					double yeniFiyat = scanner.nextDouble();*/
					cesni.cesniBirimFiyatGuncelle();//cesniAdi, yeniFiyat
					break;
				case 3:
					Confections sekerleme = (Confections) kategoriler.getUrunler().get(12);
					sekerleme.sekerlemeDetaySil();
				    break;
				case 4:
					//DairyProducts sut = (DairyProducts) kategoriler.getUrunler().get(11);
					//sut.sutUrunuSil();
					break;
				case 5:
					Cereals tahil = (Cereals) kategoriler.getUrunler().get(13);
					System.out.print("Stok Eklenecek Miktar: ");
					int miktar = scanner.nextInt();
					tahil.tahilMinStokEkle(miktar);
					break;
				case 6:
					System.out.print("Urun Adi: ");
					String urunAdi = scanner.next();
					System.out.print("Satis Mi? (true/false): ");
					boolean satisMi = scanner.nextBoolean();
					System.out.print("Adet: ");
					int adet = scanner.nextInt();
					for (Urun urun : kategoriler.getUrunler()) {
						if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
							urun.urunStokGuncelle(satisMi, adet);
							break;
						}
					}
					break;
				case 7:
					System.out.print("Urun Adi: ");
					String eskiAd = scanner.next();
					System.out.print("Yeni Adi: ");
					String yeniAd = scanner.next();
					for (Urun urun : kategoriler.getUrunler()) {
						if (urun.getAdi().equalsIgnoreCase(eskiAd)) {
							urun.urunAdiDegistir(yeniAd);
							break;
						}
					}
					break;
				case 0:
					System.out.println("Programdan cikiliyor...");
					scanner.close();
					System.exit(0);
				default:
					System.out.println("Geçersiz secim. Tekrar deneyin.");
				}
			}
		}
	}
}