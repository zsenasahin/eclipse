package calismaSorulari2;
import java.util.ArrayList;

public class Soru10 {
    public static void main(String[] args) {
    	
        ArrayList<String> isimListesi = new ArrayList<>();
        isimListesi.add("Ahmet");
        isimListesi.add("Ali");
        isimListesi.add("Veli");
        isimListesi.add("fsdmgfd");
        
        
        System.out.println("Orta karakteri 'm' olan isimler:");
        for (String isim : isimListesi) {
            if (isMiddleCharacterM(isim)) {
                System.out.println(isim);
            }
        }
    }

    public static boolean isMiddleCharacterM(String isim) {
        int uzunluk = isim.length();
        if (uzunluk % 2 == 1) {
            int ortaIndex = uzunluk / 2;
            char ortaKarakter = isim.charAt(ortaIndex);
            return ortaKarakter == 'm' || ortaKarakter == 'M';
        }
        return false;
    }
}
