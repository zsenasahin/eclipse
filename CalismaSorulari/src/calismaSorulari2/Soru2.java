package calismaSorulari2;
import java.util.Scanner;

public class Soru2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Poligonun kenar sayısını girin: ");
        int n = scanner.nextInt();
        
        double alan = 0.0;

        for (int i = 0; i < n; i++) {
            System.out.print("Kenar " + (i + 1) + " başlangıç x koordinatını girin: ");
            double xn = scanner.nextDouble();
            System.out.print("Kenar " + (i + 1) + " başlangıç y koordinatını girin: ");
            double yn = scanner.nextDouble();
            System.out.print("Kenar " + (i + 1) + " bitiş x koordinatını girin: ");
            double xn1 = scanner.nextDouble();
            System.out.print("Kenar " + (i + 1) + " bitiş y koordinatını girin: ");
            double yn1 = scanner.nextDouble();
            
            alan += (xn1 - xn) * (yn1 + yn) / 2;
        }

        scanner.close();

        System.out.println("Poligonun Alanı: " + alan);
    }
}
