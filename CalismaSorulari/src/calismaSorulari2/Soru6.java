package calismaSorulari2;
import java.util.Scanner;

public class Soru6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();

        if (isPalindrom(metin)) {
            System.out.println("Girilen metin bir palindromdur.");
        } else {
            System.out.println("Girilen metin bir palindrom değildir.");
        }

        scanner.close();
    }

    public static boolean isPalindrom(String metin) {
        //metin = metin.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Harf ve rakamlar dışındaki karakterleri kaldır ve küçük harfe dönüştür.

        int baslangic = 0;
        int son = metin.length() - 1;

        while (baslangic < son) {
            if (metin.charAt(baslangic) != metin.charAt(son)) {
                return false;
            }
            baslangic++;
            son--;
        }

        return true;
    }
}
