package odev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DosyadanOkuma_2222 {
	static Scanner scanner = new Scanner(System.in);
	static List<Urun_2222> BeveragesList = new ArrayList<>();
	static List<Urun_2222> CondimentsList = new ArrayList<>();
	static List<Urun_2222> ConfectionsList = new ArrayList<>();
	static List<Urun_2222> DairyProductsList = new ArrayList<>();
	static List<Urun_2222> CerealsList = new ArrayList<>();

	static List<List<Urun_2222>> kategoriListeleri = List.of(BeveragesList, CondimentsList, ConfectionsList,
			DairyProductsList, CerealsList);

	public static void ListeleriOlustur(String dosyaAdi) {
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
				System.out.println(line);
				switch (kategoriIndex) {
				case 1:
					BeveragesList.add(new Beverages_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
					break;
				case 2:
					CondimentsList.add(new Condiments_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
					break;
				case 3:
					ConfectionsList.add(new Confections_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
					break;
				case 4:
					DairyProductsList
							.add(new DairyProducts_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari,""));
					break;
				case 5:
					CerealsList.add(new Cereals_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari, ""));
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

}
