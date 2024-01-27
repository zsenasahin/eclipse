package calismaSorulari2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Soru12Alp {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> isimListesi = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("İsim girin: ");
            String isim = scanner.nextLine();
            isimListesi.add(isim);
        }
        

        Collections.sort(isimListesi); // İsimleri sıralar

        System.out.print("Yeni ismi girin: ");
        String yeniIsim = scanner.nextLine();
        scanner.close();

        isimListesi.add(yeniIsim); // Yeni ismi ekler

        Collections.sort(isimListesi); // Yeni eklenen ismi tekrar sıralar

        System.out.println("Sıralı İsim Listesi:");
        for (String isim : isimListesi) {
            System.out.println(isim);}}
	
}