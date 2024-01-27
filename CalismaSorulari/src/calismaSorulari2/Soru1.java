package calismaSorulari2;

import java.util.Scanner;

public class Soru1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Üçgenin A köşesinin koordinatlarını giriniz: (x,y)");
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		
		System.out.println("Üçgenin B köşesinin koordinatlarını giriniz: (x,y)");
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();
		
		System.out.println("Üçgenin C köşesinin koordinatlarını giriniz: (x,y)");
		int x3 = scanner.nextInt();
		int y3 = scanner.nextInt();
		
		double alan = ucgeninAlaniniHesapla(x1, y1, x2, y2, x3, y3);
		System.out.println("Alan: " +alan);
	}

	public static double ucgeninAlaniniHesapla(int x1, int y1, int x2, int y2, int x3, int y3) {
		double alan = 0.5 * Math.abs((x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1));
		return alan;
		}
}

