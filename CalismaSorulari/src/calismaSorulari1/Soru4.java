package calismaSorulari1;
import java.util.Scanner;

public class Soru4 {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı girin: ");
        int n = scanner.nextInt();
        
   
        int sayac = 0;

        for (int i = n - 1; i >= 2 && sayac < 3; i--) {
            if (asalMi(i)) {
                //System.out.print(i + " ");
                sayac++;
            }
            if(sayac == 3) {
            	System.out.println(i);
            }
        }      
    }
    public static boolean asalMi(int sayi) {
        if (sayi <= 1) {
            return false;
        }
        if (sayi <= 3) {
            return true;
        }
        if (sayi % 2 == 0 || sayi % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= sayi) {
            if (sayi % i == 0 || sayi % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }
    
    
    
}
