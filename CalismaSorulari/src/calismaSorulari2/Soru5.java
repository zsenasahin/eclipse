package calismaSorulari2;
import java.util.Scanner;

public class Soru5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir metin girin: ");
        String metin = scanner.nextLine();

        int[] harfSayilari = new int[26]; // İngiliz alfabesi için

        for (int i = 0; i < metin.length(); i++) {
            char harf = Character.toLowerCase(metin.charAt(i)); // Büyük/küçük harf farkı yapma

            if (harf >= 'a' && harf <= 'z') {
                int index = harf - 'a';
                harfSayilari[index]++;
            }
        }

        // Her harfin tekrar sayısını yazdır
        for (int i = 0; i < 26; i++) {
            if (harfSayilari[i] > 0) {
                char harf = (char) (i + 'a');
                System.out.println(harf + ": " + harfSayilari[i]);
            }
        }

        scanner.close();
    }
}
