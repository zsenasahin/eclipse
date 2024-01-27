package calismaSorulari2;
import java.util.ArrayList;
import java.util.Scanner;

public class Soru9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            System.out.print("Lütfen " + i + ". ismi girin: ");
            String name = scanner.nextLine();
            nameList.add(name);
        }

        System.out.println("A'dan başlayıp C ile biten isimler:");

        for (String name : nameList) {
            if (name.toLowerCase().startsWith("a") && name.toLowerCase().endsWith("c")) {
                System.out.println(name);
            }
        }
    }
}
