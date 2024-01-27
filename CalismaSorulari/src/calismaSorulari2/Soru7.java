package calismaSorulari2;

import java.util.Random;

public class Soru7 {
	public static void main(String[] args) {
        int count = 0;
        Random random = new Random();

        while (count < 10) {
            int x = random.nextInt(91) + 10; // 10 ila 100 arasında rastgele bir x değeri
            int y = random.nextInt(91) + 10; // 10 ila 100 arasında rastgele bir y değeri

            double sol = Math.PI * Math.sqrt(x * y);
            double sag = x * Math.log10(y);

            if (sol > sag) {
                System.out.println("x : " + x + ", y : " + y);
                count++;}}}
}


