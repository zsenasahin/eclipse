package calismaSorulari1;

import java.util.Scanner;

public class Soru3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int ilkEleman = scanner.nextInt();
		int elemanSayisi = scanner.nextInt();
		int artisMiktari = scanner.nextInt();
        int sonEleman = ilkEleman + (elemanSayisi - 1) * artisMiktari;
        
        System.out.println("Seri Sonucu: " + sonEleman);
	}
}
