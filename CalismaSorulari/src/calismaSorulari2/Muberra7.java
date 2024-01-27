package calismaSorulari2;

import java.util.Scanner;

public class Muberra7 {
    public static void main(String[] args) {
        PalindromYap();
    }

    static void PalindromYap() {
        /*String metin = "45fabcxcbaf36";
        System.out.print("Girilen metin  :" + metin);
*/
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Metin giriniz: ");
    	String metin = scanner.next();
        for (int i = 0; i < metin.length() / 2; i++) {
            if (metin.charAt(i) != metin.charAt(metin.length() - 1 - i)) {
                metin = metin.substring(0, i) + metin.substring(i + 1, metin.length() - i);
                metin = metin.substring(0, metin.length() - i - 1) + metin.substring(metin.length() - i);
                i--; // Bir karakteri sildiğimizde, indeksi bir azaltmalıyız.
            }
        }
        System.out.println("\npalindrom yapılan metin:" + metin);}
        
}