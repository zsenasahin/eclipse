package calismaSorulari1;

public class Soru10 {
    public static void main(String[] args) {
        int satir = 4; // Üçgenin satır sayısını belirtin.

        int sayi = 1;

        for (int i = 1; i <= satir; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(sayi + " ");
                sayi++;
            }
            System.out.println();
        }
    }
}
