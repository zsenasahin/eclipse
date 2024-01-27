package calismaSorulari2;
public class Soru4 {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 11; n > 0; i++) {
            for (int j = 11; j < i; j++) {
                double solTaraf = Math.PI * Math.sqrt(i) * Math.sqrt(j);
                double sagTaraf = i * Math.log10(j);

                if (solTaraf > sagTaraf) {
                    System.out.println("x = " + i + ", y = " + j);
                    n--;
                }
            }
        }
    }
}
