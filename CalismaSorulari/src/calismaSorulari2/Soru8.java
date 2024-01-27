package calismaSorulari2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Soru8 {
    //private static int index;

	public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Lütfen bir double sayı girin: ");
            double number = scanner.nextDouble();
            doubleList.add(number);
        }

        Collections.sort(doubleList);

        System.out.println("Sıralanmış liste: " + doubleList);

        System.out.print("Eklemek istediğiniz yeni sayıyı girin: ");
        double newNumber = scanner.nextDouble();

        int indexToInsert = Collections.binarySearch(doubleList, newNumber);
        if (indexToInsert < 0) {
        	indexToInsert = -indexToInsert - 1;
        }

        doubleList.add(indexToInsert, newNumber);

        System.out.println("Yeni liste: " + doubleList);
    }
}
