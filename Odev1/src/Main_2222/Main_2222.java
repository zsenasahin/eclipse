package Main_2222;

import java.util.Scanner;

public class Main_2222 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bir sayı giriniz: ");
        int sayi = scanner.nextInt();
        if(chenAsaliMi(sayi) == 1) {
        	System.out.println (sayi + " Chen asalıdır");
        }else {
        	System.out.println("Chen asalı değildir");
        }
        System.out.println("\nİKİ BASAMAKLI CHEN ASAL SAYILAR");
        tumunuYazdir();
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
	
	public static int asal2CarpaniVarMi(int sayi) {
		for (int sayi1 = 2; sayi1 < sayi; sayi1++) {
            for (int sayi2 = 2; sayi2 < sayi; sayi2++) {
                if (asalMi(sayi1) && asalMi(sayi2)) {
                    if (sayi1 * sayi2 == sayi) {
                    	System.out.print(sayi1 + " * " + sayi2 + " çarpanlarından oluştuğu için chen asalıdır     " );
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
	
	public static int chenAsaliMi(int sayi) {
		if(asalMi(sayi) && asalMi(sayi+2)) {
        	System.out.print(sayi + " asal ve " + (sayi+2) + " de asal olduğu için " + sayi + " Chen asalıdır");
        	return 1;
        }
        else if (asalMi(sayi)) {
        	if(asal2CarpaniVarMi(sayi+2) == 1) {
        		return 1;
        	}
        } 
		return 0;
	}
	
	public static int tumunuYazdir() {
		for(int i= 10; i<100; i++) {
			if(chenAsaliMi(i) == 1) {
				System.out.println("	Sayı: " + i);
			}
		}
		return 0;
	}
}


