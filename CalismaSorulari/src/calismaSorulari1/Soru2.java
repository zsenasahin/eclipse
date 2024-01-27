package calismaSorulari1;
import java.util.Scanner;

public class Soru2 {
	
	public static String onlukToIkili(int onlukSayi) {
	    if (onlukSayi == 0) {
	    	return "0";
	    }
	    
	    String ikiliSayi = "";
	    
	    while(onlukSayi>0) {
	    	int kalan = onlukSayi%2;
	    	ikiliSayi = kalan + ikiliSayi;
	    	onlukSayi = onlukSayi/2;
	    }
	    return ikiliSayi;
	}
	
	public static int ikilikToOndalik(int ikilikDeger){
        int ondalikDeger = 0;
        int katsayi = 1;

        while (ikilikDeger != 0) {
            int sonBasamak = ikilikDeger % 10;
            ondalikDeger += sonBasamak * katsayi;
            katsayi *= 2;
            ikilikDeger /= 10;
        }

        return ondalikDeger;
    }


	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
		System.out.println("ikilik tabana çevirmek istediğiniz sayıyı giriniz: ");
		int onlukToikilik = scanner.nextInt();
		String ikilikSonuc = onlukToIkili(onlukToikilik);
		
		System.out.println("Sonuc: " + ikilikSonuc);
		
		
        System.out.println("Onluk tabana çevirmek istediğiniz sayıyı giriniz: ");
      
        int ikilikSayi = scanner.nextInt();
        int onlukSonuc = ikilikToOndalik(ikilikSayi);
        
        System.out.println("Sonuc: " + onlukSonuc);
	}
}
