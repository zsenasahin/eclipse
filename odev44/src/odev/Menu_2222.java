package odev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu_2222 {
	
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
