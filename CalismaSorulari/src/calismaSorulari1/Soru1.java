package calismaSorulari1;

import java.util.Scanner;

public class Soru1 {

	public static int Fib_Hesapla(int sira) {
        if (sira <= 0) {
            return 0;
        }
        else {
            int fib1 = 0;
            int fib2 = 1;
            int sonuc = 1;

            for (int i = 1; i < sira; i++) {
                sonuc = fib1 + fib2;
                fib1 = fib2;
                System.out.println(fib2);
                fib2 = sonuc;
                if(i == sira-1) 
                	System.out.println(fib2);    	
            }
            

            return sonuc;
        }
	}
        
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Fibonacci sıra numarasını girin: ");
            int sira = scanner.nextInt();
            

            if (sira < 0) {
                System.out.println("Geçersiz sıra numarası.");
            } else {
                int sonuc = Fib_Hesapla(sira);
                System.out.println(sira + ". Fibonacci sayısı: " + sonuc);
            }
        }

}
