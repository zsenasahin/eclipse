package calismaSorulari1;

import java.util.Scanner;

public class Soru8 {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
		System.out.println("Sayıyı giriniz: ");
		int n = scanner.nextInt();
        long fermat = 1;
        
        for (int i = 0; i < n; i++) {
            fermat *= 2;
        }
        
        fermat = usHesapla(2, fermat) + 1;
        
        System.out.println(n + ". Fermat Sayısı: " + fermat);
    }
    
    public static long usHesapla(int taban, long fermat) {
        long sonuc = 1;
        for (int i = 0; i < fermat; i++) {
            sonuc *= taban;
        }
        return sonuc;
    }
}
