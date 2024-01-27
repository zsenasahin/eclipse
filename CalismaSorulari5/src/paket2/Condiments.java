package paket2;

import java.util.List;
import java.util.Scanner;

public class Condiments extends Urun {
	static Scanner scanner = new Scanner(System.in);
	public Condiments(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		super(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
	}

	
	protected static void CesniBirimFiyatGuncelle(List<List<Urun>> kategoriListeleri,String urunAdi, double yeniFiyat) {
		//System.out.println("Urun adı giriniz: ");
		//String urunAdi = scanner.nextLine();
		for (List<Urun> kategoriListesi : kategoriListeleri) {
			for (Urun urun : kategoriListesi) {
				if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
					if(urun.getKategoriIndex() != 2) {
						System.out.println("Girdiğiniz ürün çeşni grubunda değil.");
						break;
					}else {
						double eskiFiyat = urun.getBirimFiyati();
						urun.setBirimFiyati(yeniFiyat);
						System.out.println(
								urunAdi + " isimli ürünün fiyati " + urun.getBirimFiyati() + " olarak güncellendi.");
						return;
					}		
				}
			}
		}
		System.out.println(urunAdi + " isimli ürün bulunamadı.");
	}
}
