package paket1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import paket2.*;

public class DosyaOkuma {
	static List<Urun> Beverages = new ArrayList<>();
    static List<Urun> Condiments = new ArrayList<>();
    static List<Urun> Confections = new ArrayList<>();
    static List<Urun> DairyProducts = new ArrayList<>();
    static List<Urun> Cereals = new ArrayList<>();
    
    public static List<List<Urun>> kategoriListeleri = List.of(Beverages, Condiments, Confections, DairyProducts, Cereals);
    
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
                System.out.println(line);
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
       
        /*try (BufferedReader br = new BufferedReader(new FileReader("urunGrubu.txt"))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    
    
    
    public static void DosyaOkumaListeleriOlustur(String urunDosyaAdi) {
        ListeleriOlustur(urunDosyaAdi);
    }
  
	
}
