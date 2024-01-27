package odev;

import java.util.Scanner;

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
