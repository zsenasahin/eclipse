package paket_2222;

import java.util.List;
import java.util.Scanner;


public class Main_2222 {
	
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
