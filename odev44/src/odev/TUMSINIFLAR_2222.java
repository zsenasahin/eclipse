package odev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TUMSINIFLAR_2222 {

public static class Urun_2222 {
	
	private String adi;
    private int kategoriIndex;
    private String birimAgirligi;
    private double birimFiyati;
    private int stokMiktari;
    public String yeniDetay;
    
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
    
    public int getKategoriIndex() {
		return kategoriIndex;
	}
    
    public String getBirimAgirligi() {
		return birimAgirligi;
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
    public void setAdi(String adi) {
        this.adi = adi;
    }
    public void setBirimAgirligi(String birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}
    public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}
    public String getYeniDetay() {
		return yeniDetay;
	}

	public void setYeniDetay(String yeniDetay) {
		this.yeniDetay = yeniDetay;
	}
	static DecimalFormat df = new DecimalFormat("#.##");
    
    public void StokMiktarinaGoreUrunFiyatlariGuncelle(int stokAdedi, List<List<Urun_2222>> kategoriListeleri) {
        for (List<Urun_2222> kategori : kategoriListeleri) {
            for (Urun_2222 urun : kategori) {
                if (urun.getStokMiktari() < stokAdedi) {
                    double guncelFiyat = urun.getBirimFiyati() * (1 + ((stokAdedi - urun.getStokMiktari()) / 100.0));
                    urun.setBirimFiyati(guncelFiyat);
                    System.out.println(urun.getAdi() + " - Kategori: " + urun.getKategoriIndex() +
                            " - Güncellenmiş Fiyat: " + df.format(guncelFiyat));
                }
            }
        }
    }
    
    public void UrunZamYap(int X, List<List<Urun_2222>> kategoriListeleri) {
        Urun_2222 enDusukFiyatliUrun = null;
        double enDusukFiyat = Double.MAX_VALUE;

        for (List<Urun_2222> kategori : kategoriListeleri) {
            for (Urun_2222 urun : kategori) {
                if (urun.getBirimFiyati() < enDusukFiyat) {
                    enDusukFiyat = urun.getBirimFiyati();
                    enDusukFiyatliUrun = urun;
                }
            }
        }

        if (enDusukFiyatliUrun != null) {
            double yeniFiyat = enDusukFiyatliUrun.getBirimFiyati() * (1 + X / 100.0);
            enDusukFiyatliUrun.setBirimFiyati(yeniFiyat);

            System.out.println(enDusukFiyatliUrun.getAdi() + " - Kategori: " + enDusukFiyatliUrun.getKategoriIndex() +
                    " - Güncellenmiş Fiyat: " + df.format(yeniFiyat));
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }
	
}


public static class Menu_2222{
	
	public static void listeOlustur(String dosyaAdi, Kategori_2222 kategori) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dosyaAdi));
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                if (satir.isEmpty() || satir.toLowerCase().startsWith("adi")) {
                    continue;
                }

                String[] urunBilgileri = satir.split("\t");

                String adi = urunBilgileri[0];
                int kategoriIndex = Integer.parseInt(urunBilgileri[1]);
                String birimAgirligi = urunBilgileri[2];
                double birimFiyati = Double.parseDouble(urunBilgileri[3]);
                int stokMiktari = Integer.parseInt(urunBilgileri[4]);

                System.out.println(adi + "\t\t" + kategoriIndex + "\t" + birimAgirligi + "\t" + birimFiyati + "\t" + stokMiktari);

                Urun_2222 urun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                kategori.urunEkle(kategoriIndex, urun);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		Kategori_2222 kategori = new Kategori_2222();
        Scanner scanner = new Scanner(System.in);
        List<List<Urun_2222>> kategoriListeleri = kategori.getKategoriListeleri();
        Urun_2222 urun = new Urun_2222();
        listeOlustur("Urunler.txt", kategori);
        int secim;
        while (true) {
            System.out.println("\nMenü:");
            System.out.println("1: StokMiktarinaGoreUrunFiyatlariGuncelle");
            System.out.println("2: UrunZamYap");
            System.out.println("3. IcecekStoklariniGuncelle");
            System.out.println("4. CesniBirimAgirlikGuncelle");
            System.out.println("5. SekerlemeDetayEkle");
            System.out.println("6. SutUrunleriniSil");
            System.out.println("7. TahilUrunEkle");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminizi yapınız: ");
            secim = scanner.nextInt();

            switch (secim) {
	           case 1:
	        	   System.out.println("Stok adedi giriniz: ");
                   int stokAdedi = scanner.nextInt();
                   urun.StokMiktarinaGoreUrunFiyatlariGuncelle(stokAdedi, kategoriListeleri);
                   break;
               case 2:
            	   System.out.println("Zam miktarını girin: ");
                   int zamMiktari = scanner.nextInt();
                   urun.UrunZamYap(zamMiktari, kategoriListeleri);
                   break;
               case 3:
            	   System.out.println("İçecek Stoklarını Güncellemek İçin Miktar Giriniz: ");
                   int miktar = scanner.nextInt();
                   Beverages_2222 beverages = new Beverages_2222("", 0, "", 0, urun.getStokMiktari());
                   beverages.kategori = kategori; 
                   beverages.ıcecekStoklariGuncelle(miktar);
                   break;
               case 4:
            	   System.out.println("N:");
            	   int N=scanner.nextInt();
            	   System.out.println("Yeni Agirlik:");
            	   String yeniAgirlik = scanner.next();
            	   Condiments_2222 condiments = new Condiments_2222("",0,urun.getBirimAgirligi(),0,0);
            	   condiments.kategori=kategori;
                   condiments.CesniBirimAgirlikGuncelle(N,yeniAgirlik);
                    break;
                case 5:
                	System.out.println("Detay eklemek istediğiniz ürün:");
                	String adi=scanner.next();
                	System.out.println("Eklenecek detay:");
                	String yeniDetay=scanner.next();
                	Confections_2222 confections = new Confections_2222(urun.getAdi(),0,"",0,0," ");
                	confections.kategori=kategori;
                    confections.SekerlemeDetayEkle(adi,yeniDetay);
                    break;
                case 6:
                	System.out.println("Min fiyat:");
                	double minFiyat =scanner.nextInt();
                	System.out.println("Max fiyat:");
                	double maxFiyat=scanner.nextInt();
                	DairyProducts_2222 dairyProducts = new DairyProducts_2222("",0,"",urun.getBirimFiyati(),0);
                	dairyProducts.kategori=kategori;
                    dairyProducts.sutUrunleriniSil(minFiyat,maxFiyat);
                    break;
                case 7:
                	System.out.println("Eklenecek ürünün ismi:");
					String eklenecekadi = scanner.next();
					System.out.println("Birim Ağırlığı:");
					String birimAgirligi = scanner.next();
					System.out.println("Birim Fiyatı:");
					double birimFiyati = scanner.nextDouble();
					System.out.println("Stok Miktarı:");
					int stokMiktari = scanner.nextInt();
					Cereals_2222 cereals = new Cereals_2222(urun.getAdi(), 0, urun.getBirimAgirligi(), urun.getBirimFiyati(), urun.getStokMiktari());
					cereals.kategori=kategori;									
                    cereals.TahilUrunEkle(eklenecekadi,birimAgirligi,birimFiyati,stokMiktari);
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




public static class Kategori_2222 {	
	List<Urun_2222> Beverages = new ArrayList<>();
    List<Urun_2222> Condiments = new ArrayList<>();
    List<Urun_2222> Confections = new ArrayList<>();
    List<Urun_2222> DairyProducts = new ArrayList<>();
    List<Urun_2222> Cereals = new ArrayList<>();
    
    List<List<Urun_2222>> kategoriListeleri = List.of(Beverages, Condiments, Confections, DairyProducts, Cereals);
    
    public void urunEkle(int kategoriIndex, Urun_2222 urun) {
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
    
    public List<List<Urun_2222>> getKategoriListeleri() {
        return kategoriListeleri;
    }

    public List<Urun_2222> getBeverages() {
        return Beverages;
    }

    public List<Urun_2222> getCondiments() {
        return Condiments;
    }

    public List<Urun_2222> getConfections() {
        return Confections;
    }

    public List<Urun_2222> getDairyProducts() {
        return DairyProducts;
    }

    public List<Urun_2222> getCereals() {
        return Cereals;
    }
    
	public void setBeverages(List<Urun_2222> beverages) {
		Beverages = beverages;
	}
	public void setCondiments(List<Urun_2222> condiments) {
		Condiments = condiments;
	}
	public void setConfections(List<Urun_2222> confections) {
		Confections = confections;
	}
	public void setDairyProducts(List<Urun_2222> dairyProducts) {
		DairyProducts = dairyProducts;
	}
	public void setCereals(List<Urun_2222> cereals) {
		Cereals = cereals;
	}
	public void setKategoriListeleri(List<List<Urun_2222>> kategoriListeleri) {
		this.kategoriListeleri = kategoriListeleri;
	}
}


public static class Beverages_2222 extends Urun_2222 {
	public Kategori_2222 kategori;

	public Beverages_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);

	}

	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		kategori.urunEkle(kategoriIndex, yeniUrun);
	}

	public void ıcecekStoklariGuncelle(int miktar) {
		System.out.println("İçecek Stokları Güncelleniyor...");
		for (Urun_2222 urun : kategori.getBeverages()) {
			if((urun.getStokMiktari()+ miktar) < 0) {
				System.out.println("Stok miktarı sıfırdan küçük olamaz.");
			}
			else {
				System.out.println("Ürün Adı: " + urun.getAdi() + "\tKategori: " + urun.getKategoriIndex()
					+ "\tStok Miktarı: " + urun.getStokMiktari() + "\tGüncellenmiş Stok Miktarı: "
					+ (urun.getStokMiktari() + miktar));
			urun.setStokMiktari(urun.getStokMiktari() + miktar);
			}		
		}
	}
}


public static class Condiments_2222 extends Urun_2222 {

	public Kategori_2222 kategori;

	public Condiments_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);

	}

	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		kategori.urunEkle(kategoriIndex, yeniUrun);
	}

	public void CesniBirimAgirlikGuncelle(int N, String yeniAgirlik) {
		List<Urun_2222> condimentsList = kategori.getCondiments();

		if (N >= 1 && N <= condimentsList.size()) {
			Urun_2222 urun = condimentsList.get(N - 1);
			if (urun.getBirimAgirligi() != null) {
				urun.setBirimAgirligi(yeniAgirlik);
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " "
						+ urun.getBirimFiyati() + " " + urun.getStokMiktari());
			} else {
				System.out.println("Çeşni bulunamadı veya ağırlık bilgisi yok.");
			}
		} else {
			System.out.println("Geçersiz çeşni indexi.");
		}
	}
}


public static class Confections_2222 extends Urun_2222 {
	public Kategori_2222 kategori;
	String yeniDetay;

	public Confections_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari,
			String yeniDetay) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		this.yeniDetay = yeniDetay;
	}

	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
		kategori.urunEkle(kategoriIndex, yeniUrun);
	}

	public void SekerlemeDetayEkle(String eklenecekAdi, String yeniDetay) {
		for (Urun_2222 confections : kategori.getConfections()) {
			if (eklenecekAdi.equals(confections.getAdi())) {
				confections.yeniDetay = yeniDetay;
				System.out.println(confections.getAdi() + " " + confections.getStokMiktari() + " "
						+ confections.getBirimAgirligi() + " " + confections.getBirimFiyati() + " "
						+ confections.getStokMiktari() + " " + confections.yeniDetay);
			}
		}
		System.out.println("ürün bulunamadı");
	}
}

public static class DairyProducts_2222 extends Urun_2222{
    public Kategori_2222 kategori;

    public DairyProducts_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        
    }
    
	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        kategori.urunEkle(kategoriIndex, yeniUrun);
    }
 
	public void sutUrunleriniSil(double minFiyat, double maxFiyat) {
        List<Urun_2222> silinecekler = new ArrayList<>();

        for (Urun_2222 sutUrunu : kategori.getDairyProducts()) {
            double birimFiyat = sutUrunu.getBirimFiyati();

            if (birimFiyat >= minFiyat && birimFiyat <= maxFiyat) {
                silinecekler.add(sutUrunu);
                System.out.println(sutUrunu.getAdi() + " ürünü silindi.");
            }
        }

        for (Urun_2222 silinecek : silinecekler) {
            kategori.getDairyProducts().remove(silinecek);
        }

        System.out.println("Güncellenmiş Süt Ürünleri Listesi:");
        for (Urun_2222 sutUrunu : kategori.getDairyProducts()) {
            System.out.println(sutUrunu.getAdi() + " - Fiyat: " + sutUrunu.getBirimFiyati());
        }
    }
}


public static class Cereals_2222 extends Urun_2222{
    public Kategori_2222 kategori;

    public Cereals_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        
    }
    
	public void urunEkle(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Urun_2222 yeniUrun = new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
        kategori.urunEkle(kategoriIndex, yeniUrun);
    }
 
	public void TahilUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
        Cereals_2222 yeniUrun = new Cereals_2222(adi, 5, birimAgirligi, birimFiyati, stokMiktari);
        kategori.Cereals.add(yeniUrun);

        System.out.println("Yeni Tahıl Ürünü Eklendi: " + adi);
        System.out.println("Güncellenmiş Tahıl Ürünleri Listesi:");
        for (Urun_2222 tahilUrunu : kategori.getCereals()) {
            System.out.println(tahilUrunu.getAdi() + " " + tahilUrunu.getKategoriIndex()+" " + tahilUrunu.getBirimAgirligi() + " " + 
        tahilUrunu.getBirimFiyati() + " " + tahilUrunu.getStokMiktari());
        }
    }
}

}
