package calismaSorulari2;
import java.util.Scanner;

public class Soru2Deneme {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Poligonun kaç köşesi var? ");
        int n = scanner.nextInt();

        double alan = 0.0;

        double[] xn = new double[n];
        double[] yn = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Köşe " + (i + 1) + " x koordinatını girin: ");
            xn[i] = scanner.nextDouble();
            System.out.print("Köşe " + (i + 1) + " y koordinatını girin: ");
            yn[i] = scanner.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n; // Bir sonraki köşenin indeksi
            alan += (xn[j] - xn[i]) * (yn[j] + yn[i]) / 2;
        }

        scanner.close();

        System.out.println("Poligonun Alanı: " + Math.abs(alan));
    }
}
