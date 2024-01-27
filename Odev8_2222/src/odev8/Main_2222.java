package odev8;

import java.util.List;
import java.util.Scanner;

import odev8.DosyaIslemleri_2222.DosyadanOku;

public class Main_2222 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// String dosyaAdi = "urunler.txt";

		List<Urun_2222> urunListesi = DosyaIslemleri_2222.DosyadanOku.ListeleriOlustur("urunler.txt");

		while (true) {
			System.out.println("\n---MENU---");
			System.out.println("1-Urun Stok Guncelle");
			System.out.println("2-Urun Kategorik Indirim Yap");
			System.out.println("3-Icecek Urunu Sil");
			System.out.println("4-Cesni Urun Ekle");
			System.out.println("5-Sekerleme Detay Ekle");
			System.out.println("6-Sut Urunu Stok Guncelle");
			System.out.println("7-Tahil Birim fiyat Guncelle");
			System.out.println("8-Dosyaya Yaz");
			System.out.println("0-Cikis");
			System.out.println("Secim Yapiniz: ");
			int secim = scanner.nextInt();
			Urun_2222 urun = new Urun_2222();
			switch (secim) {
			case 1:

				System.out.println("Urun adi giriniz:");
				String urunAdi = scanner.nextLine();
				urunAdi = scanner.nextLine();
				System.out.println("Ekle Mi ? ");
				boolean ekleMi = scanner.nextBoolean();
				urun.urunStokGuncelle(urunAdi, ekleMi);
				break;
			case 2:
				System.out.println("Kategori adi giriniz: ");
				String kategoriAdi = scanner.nextLine();
				kategoriAdi = scanner.nextLine();
				System.out.println("Indirim orani giriniz: ");
				int x = scanner.nextInt();
				urun.urunKategorikIndirimYap(kategoriAdi, x);
				break;
			case 3:
				System.out.println("Urun adi giriniz: ");
				String urunAdii = scanner.nextLine();
				urunAdii = scanner.nextLine();
				Urun_2222.Beverages_2222.IcecekUrunuSil(urunAdii);
				break;
			case 4:
				System.out.println("Yeni isim giriniz: ");
				String yeniIsim = scanner.nextLine();
				yeniIsim = scanner.nextLine();
				System.out.println("Yeni birim agirlik giriniz: ");
				String birimAgirlik = scanner.nextLine();
				System.out.println("Yeni birim fiyat giriniz: ");
				double birimFiyat = scanner.nextDouble();
				System.out.println("Yeni stok giriniz: ");
				int yeniStok = scanner.nextInt();
				Urun_2222.Condiments_2222.cesniUrunEkle(yeniIsim, birimAgirlik, birimFiyat, yeniStok);
				break;
			case 5:
				System.out.println("Detay giriniz: ");
				String yeniDetay = scanner.nextLine();
				yeniDetay = scanner.nextLine();
				Urun_2222.Confections_2222.urunGrubuDetayEkle(yeniDetay);

				break;
			case 6:
				System.out.println("Miktar giriniz: ");
				int miktar = scanner.nextInt();
				System.out.println("SatisMi ?");
				boolean satisMi = scanner.nextBoolean();
				Urun_2222.DairyProducts_2222.sutUrunuStokGuncelle(satisMi, miktar);

				break;
			case 7:
				System.out.println("Yeni fiyat girin: ");
				double yeniFiyat = scanner.nextDouble();

				Urun_2222.Cereals_2222.TahilBirimFiyatGuncelle(yeniFiyat);
				break;
			case 8:
				DosyaIslemleri_2222.DosyayaYazma_2213.dosyayaYaz(DosyadanOku.kategoriListeleri);
				break;
			case 0:
				System.out.println("Programdan Cikiliyor...");
				break;
			default:
				System.out.println("Geçersiz secim.");
			}
		}
	}

}
