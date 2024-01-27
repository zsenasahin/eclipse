package calismaSorulari2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Soru12 {
   // public static int index;

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            System.out.print("Lütfen bir isim girin: ");
            String name = scanner.nextLine();
            nameList.add(name);
        }

        Collections.sort(nameList);

        System.out.println("Sıralanmış liste: " + nameList);

        System.out.print("Eklemek istediğiniz yeni ismi girin: ");
        String newname = scanner.nextLine();

        int indexToInsert = Collections.binarySearch(nameList, newname);
        if (indexToInsert < 0) {
            // Eğer index negatifse, isim listede bulunmuyor demektir.
            // -index - 1, eklenmesi gereken pozisyonu temsil eder.
            indexToInsert = -indexToInsert - 1;
        }

        nameList.add(indexToInsert, newname);

        System.out.println("Yeni liste: " + nameList);
    }
}
