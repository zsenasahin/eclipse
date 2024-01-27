package paket2;

import java.util.List;
import java.util.Scanner;

import paket1.DosyaOkuma;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DosyaOkuma.DosyaOkumaListeleriOlustur("urunler.txt");
		List<List<Urun>> kategoriListeleri = DosyaOkuma.kategoriListeleri;

		Urun urun = new Urun();

		int secim;
		while (true) {
			System.out.println("\nMenü:");
			System.out.println("1: Stok miktarı guncelle");
			System.out.println("2: Urun adi değiştir");
			System.out.println("3. Icecek urunu ekle");
			System.out.println("4. CesniBirimFiyatGuncelle");
			System.out.println("5. SekerlemeDetayEkle");
			System.out.println("6. SutUrunleriniSil");
			System.out.println("7. TahilUrunEkle");
			System.out.println("0. Çıkış");
			System.out.print("Seçiminizi yapınız: ");
			secim = scanner.nextInt();

			switch (secim) {
			case 1:
				System.out.print("Urun Adi: ");
				String urunAdi = scanner.next();
				System.out.print("Satis Mi? (true/false): ");
				boolean satisMi = scanner.nextBoolean();
				System.out.print("Adet: ");
				int adet = scanner.nextInt();
				urun.urunStokGuncelle(kategoriListeleri, urunAdi, satisMi, adet);
				break;

			case 2:
				System.out.println("Değiştirmek istediğiniz ürünün ismini girin: ");
				String eskiIsım = scanner.next();
				System.out.println("yeni isim girin: ");
				String yeniIsım = scanner.next();
				urun.urunAdiDegistir(kategoriListeleri,eskiIsım,yeniIsım);
				break;
			case 3:
				
				//Beverages beverages = new Beverages(urunAdi, birimAgirligi, birimFiyati, stokMiktari);

		        System.out.print("Ürün Adı: ");
		        String eklenecekUrunAdi = scanner.next();

		        System.out.print("Birim Ağırlığı: ");
		        String birimAgirligi = scanner.next();

		        System.out.print("Birim Fiyatı: ");
		        double birimFiyati = scanner.nextDouble();

		        System.out.print("Stok Miktarı: ");
		        int stokMiktari = scanner.nextInt();

		        Beverages.IcecekUrunuEkle(kategoriListeleri, eklenecekUrunAdi, birimAgirligi, birimFiyati, stokMiktari);
				break;
			case 4:
				System.out.println("Ürün adı giriniz: ");
				String isim = scanner.nextLine();
				isim = scanner.nextLine();
				System.out.println("Güncel fiyatı giriniz: ");
				double yeniFiyat = scanner.nextDouble();
				Condiments.CesniBirimFiyatGuncelle(kategoriListeleri,isim,yeniFiyat);
				break;
			case 5:
				Confections.urunGrubuOku();
				break;
			case 6:
				DairyProducts.SutUrunuSil(kategoriListeleri);
				break;
			case 7:
				System.out.println("miktar giriniz: ");
				int miktar = scanner.nextInt();
				Cereals.TahilMinStokEkle(kategoriListeleri, miktar);
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
