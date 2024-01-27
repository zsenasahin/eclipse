
package calismaSorulari1;
import java.util.Scanner;

public class soru9Deneme {
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
        int birler = sayi % 10;
        sayi /= 10;
        int onlar = sayi % 10;
        sayi /= 10;
        int yuzler = sayi % 10;
        sayi /= 10;
        int binler = sayi;

        // Büyükten küçüğe sıralama
        int temp;
        if (binler > yuzler) {
            temp = binler;
            binler = yuzler;
            yuzler = temp;
        }
        if (yuzler > onlar) {
            temp = yuzler;
            yuzler = onlar;
            onlar = temp;
        }
        if (onlar > birler) {
            temp = onlar;
            onlar = birler;
            birler = temp;
        }

        return birler + onlar * 10 + yuzler * 100 + binler * 1000;
    }

    public static int rakamlariKucuktenBuyugeSiralama(int sayi) {
        int birler = sayi % 10;
        sayi /= 10;
        int onlar = sayi % 10;
        sayi /= 10;
        int yuzler = sayi % 10;
        sayi /= 10;
        int binler = sayi;

        // Küçükten büyüğe sıralama
        int temp;
        if (birler > onlar) {
            temp = birler;
            birler = onlar;
            onlar = temp;
        }
        if (onlar > yuzler) {
            temp = onlar;
            onlar = yuzler;
            yuzler = temp;
        }
        if (yuzler > binler) {
            temp = yuzler;
            yuzler = binler;
            binler = temp;
        }

        return binler + yuzler * 10 + onlar * 100 + birler * 1000;
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
