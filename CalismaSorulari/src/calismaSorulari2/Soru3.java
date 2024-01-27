package calismaSorulari2;
public class Soru3 {

    public static void main(String[] args) {
        int n = 3; // n değerini 3'ten başlatıyoruz, çünkü n > 2 olmalıdır.

        while (true) {
            long solTaraf = faktoriyel(n - 1);
            double sagTaraf = Math.pow(2, n) * Math.pow(n, Math.log10(n));

            if (solTaraf > sagTaraf) {
                System.out.println("Eşitsizliği sağlayan en küçük n değeri: " + n);
                break;
            }

            n++;
        }
    }

    public static long faktoriyel(int n) {
        if (n == 0) {
            return 1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
