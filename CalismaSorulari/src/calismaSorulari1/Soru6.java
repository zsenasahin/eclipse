package calismaSorulari1;
import java.util.Scanner;


public class Soru6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int sayi = scanner.nextInt();
        scanner.close();
        
        asalCarpanlariBul(sayi);
       
    }

    public static void asalCarpanlariBul(int sayi) {
        System.out.print(sayi + " sayısının asal çarpanları: ");
        int carpan = 2;
        int carpanSayisi = 0;

        while (sayi > 1) {
            if (sayi % carpan == 0) {
                if (carpanSayisi == 0) {
                    System.out.print(carpan);
                } else {
                    System.out.print(", " + carpan);
                }
                carpanSayisi++;
                sayi /= carpan;
                while (sayi % carpan == 0) {
                    sayi /= carpan;
                }
            }
            carpan++;
        }

        System.out.println("\nToplam asal çarpan sayısı: " + carpanSayisi);
    }
    
    
   
}
