package calismaSorulari2;

import java.util.ArrayList;
import java.util.Scanner;

public class Soru11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> stringList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            System.out.print("Lütfen " + i + ". string'i girin: ");
            String str = scanner.nextLine();
            stringList.add(str);
        }

        System.out.println("Sonuçlar:");

        for (String str : stringList) {
            if (containsYazWithoutB(str)) {
                System.out.println(str);
            }
        }
    }

    public static boolean containsYazWithoutB(String str) {
        // İçinde "yaz" geçen ve 'b' içermeyen bir string'i kontrol etmek için bu işlevi kullanabilirsiniz.
        return str.contains("yaz") && !str.contains("b");
    }
}
