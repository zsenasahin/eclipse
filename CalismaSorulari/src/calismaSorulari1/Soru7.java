package calismaSorulari1;

import java.util.Scanner;

public class Soru7 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Sayıyı giriniz: ");
		int sayi = scanner.nextInt();
		harshadKontrol(sayi);

	}
	
	public static void harshadKontrol(int sayi) {
	 int toplam = 0;
        int geciciSayi = sayi; // Orjinal sayının kopyasını alıyoruz
        while (geciciSayi > 0) {
            toplam += geciciSayi % 10;
            geciciSayi = geciciSayi / 10;
        }
        int sonuc = sayi % toplam;
        if (sonuc == 0) {
            System.out.println("Harshad sayıdır.");
        } else {
            System.out.println("Harshad sayı değildir.");
        }
	}

}
