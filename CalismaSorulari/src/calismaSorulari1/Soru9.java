package calismaSorulari1;
import java.util.Scanner;
import java.util.Arrays;
public class Soru9 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dört basamaklı bir sayı girin: ");
        int sayi = scanner.nextInt();

        if (sayi < 1000 || sayi >= 10000) {
            System.out.println("Lütfen geçerli bir dört basamaklı sayı girin.");
        } else {
            int buyuktenKucugeSayi = rakamlariBuyuktenKucugeSiralama(sayi);
            int kucuktenBuyugeSayi = rakamlariKucuktenBuyugeSiralama(sayi);

            System.out.println("Rakamları Büyükten Küçüğe Sıralı Sayı: " + buyuktenKucugeSayi);
            System.out.println("Rakamları Küçükten Büyüğe Sıralı Sayı: " + kucuktenBuyugeSayi);

            int adimSayisi = kaprekarSabitiAdimSayisi(sayi, true);
            System.out.println("Kaprekar Sabiti Adım Sayısı: " + adimSayisi);
        }

        scanner.close();
    }

    public static int rakamlariBuyuktenKucugeSiralama(int sayi) {
        int[] rakamlar = new int[4];

        for (int i = 0; i < 4; i++) {
            rakamlar[i] = sayi % 10;
            sayi /= 10;
        }

        Arrays.sort(rakamlar);
        int siraliSayi = 0;

        for (int i = 3; i >= 0; i--) {
            siraliSayi = siraliSayi * 10 + rakamlar[i];
        }

        return siraliSayi;
    }

    public static int rakamlariKucuktenBuyugeSiralama(int sayi) {
        int[] rakamlar = new int[4];

        for (int i = 0; i < 4; i++) {
            rakamlar[i] = sayi % 10;
            sayi /= 10;
        }

        Arrays.sort(rakamlar);
        int siraliSayi = 0;

        for (int i = 0; i < 4; i++) {
            siraliSayi = siraliSayi * 10 + rakamlar[i];
        }

        return siraliSayi;
    }

    public static int kaprekarSabitiAdimSayisi(int sayi, boolean showSteps) {
        int adimSayisi = 0;

        while (sayi != 6174 && sayi != 0) {
            int buyuktenKucuge = rakamlariBuyuktenKucugeSiralama(sayi);
            int kucuktenBuyuge = rakamlariKucuktenBuyugeSiralama(sayi);
            sayi = buyuktenKucuge - kucuktenBuyuge;
            adimSayisi++;

            if (showSteps) {
                System.out.println("Adım " + adimSayisi + ": " + buyuktenKucuge + " - " + kucuktenBuyuge + " = " + sayi);
            }
        }

        return adimSayisi;
    }
}