package calismaSorulari1;
import java.util.Scanner;

public class Soru5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Karenin kenarını giriniz: ");
		int kenar = scanner.nextInt();
		kareOlustur(kenar);
		
		System.out.println("Dikdörtgenin kısa kenarini giriniz: ");
		int kisaKenar = scanner.nextInt();
		System.out.println("Dikdörtgenin uzun kenarini giriniz: ");
		int uzunKenar = scanner.nextInt();
		dikdortgenOlustur(kisaKenar, uzunKenar);
		
		System.out.println("Eşkenar üçgenin yüksekliğini giriniz: ");
		int eskenar = scanner.nextInt();
		eskenarUcgenOlustur(eskenar);
		
		System.out.println("Dik üçgenin yüksekliğini giriniz: ");
		int dikKenar = scanner.nextInt();
		dikUcgenOlustur(dikKenar);
	
	}
	
	
	
	public static void kareOlustur(int kenar) {
		for(int i = 0; i < kenar; i++) {
			for(int j = 0; j< kenar; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	public static void dikdortgenOlustur(int kisaKenar, int uzunKenar) {
		for(int i = 0; i < kisaKenar; i++) {
			for(int j = 0; j < uzunKenar; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
	
	
	public static void eskenarUcgenOlustur(int yukseklik) {
		for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j < yukseklik - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}
	
	public static void dikUcgenOlustur(int yukseklik) {
		for (int i = 0; i < yukseklik; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}

}
