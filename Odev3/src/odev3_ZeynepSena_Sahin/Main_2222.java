package odev3_ZeynepSena_Sahin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2222 {

	public static void main(String[] args) {		
		List<Urun_2222> urunList = new ArrayList<>();
		UrunListesi_2222 urun = new UrunListesi_2222();
		Scanner scanner = new Scanner(System.in);
	       int secim = 0;
	        
	       do {
	            System.out.println("------- MENÜ -------");
	            System.out.println("1: ListeOlustur");
	            System.out.println("2: YeniKategoriListeOlustur");
	            System.out.println("3: BirimFiyatGuncelle");
	            System.out.println("4: StokGüncelleVeUrunEkle");
	            System.out.println("5: UrunSil");
	            System.out.println("6: Çıkış");
	            System.out.println("--------------------");
	            System.out.print("Seçiminizi yapınız: ");
	            secim = scanner.nextInt();
	            
	            switch (secim) {
	                case 1:
	                	urun.listeOlustur();
	                    break;
	                case 2:
	                	if (urun.urunList.isEmpty()) {
	        	            System.out.println("Urun listesi boş.");
	        	        }else {
	        	        	System.out.println("Listelemek istediğiniz miktarı giriniz: ");
		                    int N = scanner.nextInt();   
		                    if(N>5) {
		                    	System.out.println("N sayısı 5ten büyük olamaz.");
		                    }else {
			            		Kategori_2222.kategorikGoster(urun.urunList,N);
		                    }
	        	        }	                		
	                    break;
	                case 3:
	                	if (urun.urunList.isEmpty()) {
	        	            System.out.println("Urun listesi boş.");
	        	        }else {
	        	        	System.out.println("x giriniz: ");
		            	    int x = scanner.nextInt();		            	    
		            	    urun.urunFiyatiGuncelle(x);
		            	    urun.urunGoster();
	        	        }	                	
	                    break;
	                case 4:	
	                	if (urun.urunList.isEmpty()) {
	        	            System.out.println("Urun listesi boş.");
	        	        } else {
	        	        	System.out.println("Yeni ürün adını giriniz: ");
		                	String yeniUrunAdi = scanner.next();
		                	System.out.println("Yeni ürünün birim ağırlığını giriniz: ");
		                	String yeniUrunBirimAgirligi = scanner.next();
		                	System.out.println("Yeni ürünün birim fiyatını giriniz :");
		                	Double yeniUrunBirimFiyati = scanner.nextDouble();
		                	Kategori_2222.StokGuncelleVeYeniUrunEkle(urun.urunList,yeniUrunAdi,yeniUrunBirimAgirligi,yeniUrunBirimFiyati);
	        	        }      		                	
	                    break;
	                case 5:
	                    Kategori_2222.silinecekUrunuBelirle(urun.urunList);
	                    break;
	                case 6:
	                    System.out.println("Çıkış yapıldı.");
	                    break;
	                default:
	                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
	                    break;
	            }
	        } while (secim != 6);
	        
	        scanner.close();
    }
}