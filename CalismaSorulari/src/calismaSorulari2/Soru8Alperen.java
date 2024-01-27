package calismaSorulari2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Soru8Alperen {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> sayiListesi = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            System.out.print("Double sayı girin: ");
            double sayi = scanner.nextDouble();
            sayiListesi.add(sayi);
        }

        Collections.sort(sayiListesi); // Sayıları sıralar
        

        System.out.print("Yeni sayıyı girin: ");
        double yeniSayi = scanner.nextDouble();

        siraliEkle(sayiListesi, yeniSayi);

        System.out.print("Sıralı liste: ");
        for (double sayi : sayiListesi)
        {
            System.out.print(sayi + " ");
        }
        scanner.close();
    }

    public static void siraliEkle(ArrayList<Double> liste, double yeniSayi)
    {
        for (int i = 0; i < liste.size(); i++)
        {
            if (yeniSayi < liste.get(i))
            {
                liste.add(i, yeniSayi);
                return;
            }
        }
        liste.add(yeniSayi);}
}

