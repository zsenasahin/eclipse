package tumSiniflar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ogrenci {
    public static void main(String[] args) {
        ArrayList<String> ogrenciListesi = new ArrayList<>();
        double toplamOrtalama = 0;
        //double ortalama = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("Ogrenci.txt"));
            String satir;

            while ((satir = br.readLine()) != null) {
                ogrenciListesi.add(satir);
                String[] sutun = satir.split(" ");
                if (sutun.length >= 4) {
                	String numara = sutun[0];
                	String adi = sutun[1];
                    int vizeNotu = Integer.parseInt(sutun[2]);
                    int finalNotu = Integer.parseInt(sutun[3]);

                    double ortalama = ortalamaHesapla(vizeNotu, finalNotu);
                    String harfNotu = harfNotuHesapla(ogrenciListesi, ortalama);

                    System.out.println(satir + "\tOrtalama: " + ortalama + " Harf Notu: " + harfNotu);
                    toplamOrtalama += ortalama;
                }
            }

            double sinifOrtalama = toplamOrtalama / ogrenciListesi.size();
            System.out.println("Sinif Ortalamasi: " + sinifOrtalama);

            sinifOrtalamaKarsilastir(ogrenciListesi, sinifOrtalama);
            gecenleriGoster(ogrenciListesi, sinifOrtalama);
            tekCiftGoster(ogrenciListesi, satir);
            //puanEkle(ogrenciListesi);
            ortalamayaGoreSirala(ogrenciListesi);
            //yeniOgrenciEkle(ogrenciListesi);
            //ortalamayaGoreSirala(ogrenciListesi);
            degistirEnBasariliTekCift(ogrenciListesi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double ortalamaHesapla(int vizeNotu, int finalNotu) {
        return (0.4 * vizeNotu) + (0.6 * finalNotu);
    }
    
    public static boolean gectiMi(double ogrenciOrtalama) {
    	if(ogrenciOrtalama>=50) {
    		return true;
    	}else {
    		return false;
    	}
    }

    
    public static void sinifOrtalamaKarsilastir(ArrayList<String> ogrenciList, double sinifOrtalama) {
        System.out.println("\nSinif Ortalamasindan buyuk olan ogrenciler: ");
        for (String ogrenci : ogrenciList) {
            String[] sutun = ogrenci.split(" ");
            if (sutun.length >= 4) {
                int vizeNotu = Integer.parseInt(sutun[2]);
                int finalNotu = Integer.parseInt(sutun[3]);

                double ogrenciOrtalama = ortalamaHesapla(vizeNotu, finalNotu);

                if (ogrenciOrtalama > sinifOrtalama) {
                    System.out.println(ogrenci + "\tOrtalama: " + ogrenciOrtalama);
                }
            }
        }

        System.out.println("\nSinif Ortalamasindan kucuk olan ogrenciler: ");
        for (String ogrenci : ogrenciList) {
            String[] sutun = ogrenci.split(" ");
            if (sutun.length >= 4) {
                int vizeNotu = Integer.parseInt(sutun[2]);
                int finalNotu = Integer.parseInt(sutun[3]);

                double ogrenciOrtalama = ortalamaHesapla(vizeNotu, finalNotu);

                if (ogrenciOrtalama < sinifOrtalama) {
                    System.out.println(ogrenci + "\tOrtalama: " + ogrenciOrtalama);
                }
            }
        }
    }
    
    public static void gecenleriGoster(ArrayList<String> ogrenciList,double sinifOrtalama) {
    	System.out.println("\nDersten geçenler: ");
    	for(String ogrenci : ogrenciList) {
    		String[] sutun = ogrenci.split(" ");
    		if(sutun.length >= 4) {
    			int vizeNotu = Integer.parseInt(sutun[2]);
                int finalNotu = Integer.parseInt(sutun[3]);

                double ogrenciOrtalama = ortalamaHesapla(vizeNotu, finalNotu);
                if(gectiMi(ogrenciOrtalama)) {
                	System.out.println(ogrenci + "\tOrtalama: " + ogrenciOrtalama);
                }
    		}
    	}
    	System.out.println("\nDersten kalanlar: ");
    	for(String ogrenci : ogrenciList) {
    		String[] sutun = ogrenci.split(" ");
    		if(sutun.length >= 4) {
    			int vizeNotu = Integer.parseInt(sutun[2]);
                int finalNotu = Integer.parseInt(sutun[3]);

                double ogrenciOrtalama = ortalamaHesapla(vizeNotu, finalNotu);
                if(!gectiMi(ogrenciOrtalama)) {
                	System.out.println(ogrenci + "\tOrtalama: " + ogrenciOrtalama);
                }
    		}
    	} 	
    }
    
    public static String harfNotuHesapla(ArrayList<String> ogrenciList,double ortalama) {
    	if(ortalama<=40) {
    		return "FF";
    	}else if(40<ortalama && ortalama<=49) {
    		return "DD";
    	}else if(50<=ortalama && ortalama<=69) {
    		return "CC";
    	}else if(70<= ortalama && ortalama <= 79) {
    		return "BB";
    	}else if(80<=ortalama && ortalama<=100) {
    		return "AA";
    	}
		return "";
    }
    
    public static void tekCiftGoster(ArrayList<String> ogrenciList, String numara) {
    	System.out.println("\nÇift öğrenciler: ");
    	for(String ogrenci : ogrenciList) {
    		String[] sutun = ogrenci.split(" ");
    		if(sutun.length >= 4) {
    			numara = sutun[0];
    		}
    		int sonuc = Integer.valueOf(numara);
    		if(sonuc%2 == 0) {
    			System.out.println(ogrenci);
    		}
    	}
    	System.out.println("\nTek öğrenciler: ");
    	for(String ogrenci : ogrenciList) {
    		String[] sutun = ogrenci.split(" ");
    		if(sutun.length >= 4) {
    			numara = sutun[0];
    		}
    		int sonuc = Integer.valueOf(numara);
    		if(sonuc%2 != 0) {
    			System.out.println(ogrenci);
    		}
    	}
    }

    public static void puanEkle(ArrayList<String> ogrenciList) {
    	Scanner scanner = new Scanner(System.in);
        double enDusukOrtalama = Double.MAX_VALUE;
        int enDusukIndex = -1;

        for (int i = 0; i < ogrenciList.size(); i++) {
            String ogrenci = ogrenciList.get(i);
            String[] sutun = ogrenci.split(" ");
            if (sutun.length >= 4) {
                int vizeNotu = Integer.parseInt(sutun[2]);
                int finalNotu = Integer.parseInt(sutun[3]);

                double ogrenciOrtalama = ortalamaHesapla(vizeNotu, finalNotu);

                if (ogrenciOrtalama < enDusukOrtalama) {
                    enDusukOrtalama = ogrenciOrtalama;
                    enDusukIndex = i;
                }
            }
        }

        if (enDusukIndex != -1) {
        	System.out.println("Ek puan yüzdesini giriniz: ");
            double ekPuanYuzdesi = scanner.nextInt();; 
            String ogrenci = ogrenciList.get(enDusukIndex);
            String[] sutun = ogrenci.split(" ");
            int vizeNotu = Integer.parseInt(sutun[2]);
            int finalNotu = Integer.parseInt(sutun[3]);

            double eklenmisOrtalama = ortalamaHesapla(vizeNotu, finalNotu) * (1 + ekPuanYuzdesi / 100);

            System.out.println("\nEn düşük ortalamaya sahip öğrencinin puanı " + ekPuanYuzdesi +
                    "% artırıldı. Yeni Ortalama: " + eklenmisOrtalama);
        }
    }
    
    public static void ortalamayaGoreSirala(ArrayList<String> ogrenciList) {
        int n = ogrenciList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String ogrenci1 = ogrenciList.get(j);
                String ogrenci2 = ogrenciList.get(j + 1);

                // Her bir öğrenci bilgisini parçala
                String[] sutun1 = ogrenci1.split(" ");
                String[] sutun2 = ogrenci2.split(" ");

                if (sutun1.length >= 4 && sutun2.length >= 4) {
                    // Ortalamaları al
                    double ortalama1 = ortalamaHesapla(Integer.parseInt(sutun1[2]), Integer.parseInt(sutun1[3]));
                    double ortalama2 = ortalamaHesapla(Integer.parseInt(sutun2[2]), Integer.parseInt(sutun2[3]));

                    // Swap işlemi
                    if (ortalama1 > ortalama2) {
                        String temp = ogrenciList.get(j);
                        ogrenciList.set(j, ogrenciList.get(j + 1));
                        ogrenciList.set(j + 1, temp);
                    }
                }
            }
        }

        System.out.println("\nÖğrencilerin Ortalamaya Göre Sıralanmış Listesi:");
        for (String ogrenci : ogrenciList) {
        	String[] sutun = ogrenci.split(" ");
        	double ortalama = ortalamaHesapla(Integer.parseInt(sutun[2]), Integer.parseInt(sutun[3]));
        	System.out.println(ogrenci + " " + ortalama);
        }
    }
    
    public static void yeniOgrenciEkle(ArrayList<String> ogrenciList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nYeni öğrencinin bilgilerini girin:");

        System.out.print("Numara: ");
        String numara = scanner.next();

        System.out.print("Adı: ");
        String adi = scanner.next();

        System.out.print("Vize Notu: ");
        int vizeNotu = scanner.nextInt();

        System.out.print("Final Notu: ");
        int finalNotu = scanner.nextInt();

        double ortalama = ortalamaHesapla(vizeNotu, finalNotu);

        String yeniOgrenci = numara + " " + adi + " " + vizeNotu + " " + finalNotu;
        ogrenciList.add(yeniOgrenci);

        System.out.println("Yeni öğrenci eklendi: " + yeniOgrenci);
    }
    
    public static void degistirEnBasariliTekCift(ArrayList<String> ogrenciList) {
        // En başarılı tek ve çift öğrencilerin indislerini bul
        int enBasariliTekIndex = -1;
        int enBasariliCiftIndex = -1;
        double enBasariliTekOrtalama = 0;
        double enBasariliCiftOrtalama = 0;

        for (int i = 0; i < ogrenciList.size(); i++) {
            String ogrenci = ogrenciList.get(i);
            String[] sutun = ogrenci.split(" ");
            if (sutun.length >= 4) {
                double ogrenciOrtalama = ortalamaHesapla(Integer.parseInt(sutun[2]), Integer.parseInt(sutun[3]));

                // En başarılı tek öğrenciyi bul
                if (gectiMi(ogrenciOrtalama) && Integer.parseInt(sutun[0]) % 2 != 0) {
                    if (ogrenciOrtalama > enBasariliTekOrtalama) {
                        enBasariliTekOrtalama = ogrenciOrtalama;
                        enBasariliTekIndex = i;
                    }
                }

                // En başarılı çift öğrenciyi bul
                if (gectiMi(ogrenciOrtalama) && Integer.parseInt(sutun[0]) % 2 == 0) {
                    if (ogrenciOrtalama > enBasariliCiftOrtalama) {
                        enBasariliCiftOrtalama = ogrenciOrtalama;
                        enBasariliCiftIndex = i;
                    }
                }
            }
        }

        // En başarılı tek ve çift öğrencilerin indislerini kontrol et
        if (enBasariliTekIndex != -1 && enBasariliCiftIndex != -1) {
            // Swap işlemi gerçekleştir
            String temp = ogrenciList.get(enBasariliTekIndex);
            ogrenciList.set(enBasariliTekIndex, ogrenciList.get(enBasariliCiftIndex));
            ogrenciList.set(enBasariliCiftIndex, temp);

            System.out.println("\nEn başarılı tek ve çift öğrencilerin yerleri değiştirildi.");
            System.out.println("Yeni durum:");
            
            // Yeni durumu yazdır
            for (String ogrenci : ogrenciList) {
                System.out.println(ogrenci);
            }
        } else {
            System.out.println("\nEn başarılı tek ve çift öğrenciler bulunamadı.");
        }
    }
}
