package odev8;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DosyaIslemleri_2222 {

	static class DosyadanOku {
		static List<Urun_2222> BeveragesList = new ArrayList<>();
		static List<Urun_2222> CondimentsList = new ArrayList<>();
		static List<Urun_2222> ConfectionsList = new ArrayList<>();
		static List<Urun_2222> DairyProductsList = new ArrayList<>();
		static List<Urun_2222> CerealsList = new ArrayList<>();

		static List<List<Urun_2222>> kategoriListeleri = List.of(BeveragesList, CondimentsList, ConfectionsList,
				DairyProductsList, CerealsList);

		public static ArrayList<Urun_2222> ListeleriOlustur(String dosyaAdi) {

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
						BeveragesList.add(new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari));
						break;
					case 2:
						CondimentsList.add(new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari));
						break;
					case 3:
						ConfectionsList.add(new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari));
						break;
					case 4:
						DairyProductsList.add(new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari));
						break;
					case 5:
						CerealsList.add(new Urun_2222(adi, kategoriIndex, birimAgirligi, birimFiyati, stokMiktari));
						break;
					default:
						System.out.println("Geçersiz kategori indexi.");
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;

		}
	}
	
	
	static class DosyayaYazma_2213 {
		public static void dosyayaYaz(List<List<Urun_2222>> urunList) {
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sonHalii.txt"))) {
				out.writeObject(urunList);
				System.out.println("Dosyaya yazıldı...");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
