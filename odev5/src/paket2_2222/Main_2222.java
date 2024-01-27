package paket2_2222;

import java.util.List;
import java.util.Scanner;

import paket1_2222.DosyadanOku_2222;

public class Main_2222 {
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
				Confections_2222.SekerlemeUrunEkle(yeniUrunAdi, yeniUrunBirimAgirligi, yeniUrunBirimFiyati, stokMiktari);
				break;
			case 6:
				System.out.println("detay giriniz: ");
				String yeniDetay = scanner.nextLine();
				yeniDetay = scanner.nextLine();
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
