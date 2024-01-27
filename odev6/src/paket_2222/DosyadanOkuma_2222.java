package paket_2222;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DosyadanOkuma_2222 {
	static Scanner scanner = new Scanner(System.in);
	static List<Urun_2222> Beverages = new ArrayList<>();
    static List<Urun_2222> Condiments = new ArrayList<>();
    static List<Urun_2222> Confections = new ArrayList<>();
    static List<Urun_2222> DairyProducts = new ArrayList<>();
    static List<Urun_2222> Cereals = new ArrayList<>();
    
    public static List<Urun_2222> getBeverages() {
		return Beverages;
	}
    public static List<Urun_2222> getCondiments() {
		return Condiments;
	}
    public static List<Urun_2222> getConfections() {
		return Confections;
	}
    public static List<Urun_2222> getDairyProducts() {
		return DairyProducts;
	}
    public static List<Urun_2222> getCereals() {
		return Cereals;
	}
    
    static List<List<Urun_2222>> kategoriListeleri = List.of(Beverages, Condiments, Confections, DairyProducts, Cereals);
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
                Urun_2222 urun = new Urun_2222(adi,kategoriIndex, birimAgirligi, birimFiyati, stokMiktari);
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
    
}
