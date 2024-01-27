package paket1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	static Scanner scanner = new Scanner(System.in);
	static List<Urun> Beverages = new ArrayList<>();
    static List<Urun> Condiments = new ArrayList<>();
    static List<Urun> Confections = new ArrayList<>();
    static List<Urun> DairyProducts = new ArrayList<>();
    static List<Urun> Cereals = new ArrayList<>();
    
    static List<List<Urun>> kategoriListeleri = List.of(Beverages, Condiments, Confections, DairyProducts, Cereals);
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
                Urun urun = new Urun(adi,kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
                //System.out.println(line);
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
    
    public static void DosyaOkumaListeleriOlustur(String urunDosyaAdi) {
        ListeleriOlustur(urunDosyaAdi);
    }

    public static void listeyiYazdir(List<List<Urun>> kategoriListeleri) {
    	for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}
    	}
    }
    
	public static void main(String[] args) {	    
		ListeleriOlustur("urunler.txt");
	    int secim;
		while (true) {
			System.out.println("\nMenü:");
			System.out.println("1: Listeleri oluştur.");
			System.out.println("2: Urun stok guncelle ( URUN SINIFI ICIN )");
			System.out.println("3. Urun stok guncelle ( CONFECTIONS SINIFI ICIN ) ");
			System.out.println("4. Urun adı degistir ( URUN SINIFI İCİN )");
			System.out.println("5. Urun adı degistir ( CONDİMENTS SINIFI ICIN )");
			System.out.println("6. Urun zam yap ( URUN SINIFI ICIN )");
			System.out.println("7. Urun zam yap ( CEREALS SINIFI ICIN )");
			System.out.println("8. Urun zam yap ( CONDİMENTS SINIFI ICIN STOK KONTROLLU )");
			System.out.println("9. Urun zam yap ( CONDİMENTS SINIFI ICIN BİRİM FİYATLI)");
			System.out.println("10. Urun adı degistir ( URUN SINIFI ICIN (sesli/sessiz))");
			System.out.println("11. Urun stok guncelle ( URUN SNIFI ICIN )");
			System.out.println("0. Çıkış");
			System.out.print("Seçiminizi yapınız: ");
			secim = scanner.nextInt();
			Urun urun = new Urun();
			switch (secim) {
			case 1:
				listeyiYazdir(kategoriListeleri);
				break;
			case 2:		
				urun.urunStokGuncelle(kategoriListeleri);
				break;
			case 3:
				Confections confections = new Confections(urun.getAdi(), urun.getKategoriIndex(), urun.getBirimAgirligi(), urun.getBirimFiyati(), urun.getStokMiktari());
				confections.urunStokGuncelle(kategoriListeleri);
				break;
			case 4:
				urun.urunAdiDegistir(kategoriListeleri);
				break;
			case 5:
				Condiments condiments = new Condiments(urun.getAdi(), urun.getKategoriIndex(), urun.getBirimAgirligi(), urun.getBirimFiyati(), urun.getStokMiktari());
				condiments.urunAdiDegistir(kategoriListeleri);
				break;
			case 6:
				urun.uruneZamYap(kategoriListeleri);
				break;
			case 7:
				Cereals cereals = new Cereals(urun.getAdi(), urun.getKategoriIndex(), urun.getBirimAgirligi(), urun.getBirimFiyati(), urun.getStokMiktari());
				cereals.uruneZamYap(kategoriListeleri);
				break;
			case 8:
				System.out.println("Urun adı giriniz: ");
				String urunAdi = scanner.nextLine();
				urunAdi = scanner.nextLine();
				System.out.println("Stok kontrol giriniz: ");
				int stokKontrol = scanner.nextInt();
				System.out.println("Zam miktari giriniz: ");
				int zamMiktari = scanner.nextInt();
				
				Condiments condiments2 = new Condiments(urun.getAdi(), urun.getKategoriIndex(), urun.getBirimAgirligi(), urun.getBirimFiyati(), urun.getStokMiktari());
				condiments2.uruneZamYap(kategoriListeleri, urunAdi, zamMiktari, stokKontrol);
				break;
			case 9:
				System.out.println("Urun adı giriniz: ");
				String urunAdi2 = scanner.nextLine();
				urunAdi2 = scanner.nextLine();
				System.out.println("Zam miktari giriniz: ");
				int zamMiktari2 = scanner.nextInt();
				Condiments condiments3 = new Condiments(urun.getAdi(), urun.getKategoriIndex(), urun.getBirimAgirligi(), urun.getBirimFiyati(), urun.getStokMiktari());
				condiments3.uruneZamYap(kategoriListeleri, urunAdi2, zamMiktari2);
				break;
				
			case 10:
				System.out.println("Sesli Mi ? (true/false)");
				boolean sesliMi = scanner.nextBoolean();
				urun.urunAdiDegistir(kategoriListeleri, sesliMi);
				break;
			case 11:
				System.out.println("Urun adı giriniz: ");
				String urunAdi3 = scanner.nextLine();
				urunAdi3 = scanner.nextLine();
				System.out.println("adet giriniz: ");
				int adet = scanner.nextInt();
				urun.urunStokGuncelle(kategoriListeleri, urunAdi3, adet);
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
