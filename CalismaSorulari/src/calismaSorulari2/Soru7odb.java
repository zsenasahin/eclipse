package calismaSorulari2;

public class Soru7odb {
    public static void main(String[] args) {
    	String kelime = "4525abcxcba3654";
    	int uzunluk = kelime.length();
    	for( int i= 0; i< uzunluk; i++) {
    		if(uzunluk % 2 == 1 && kelime.charAt(i) == kelime.charAt(uzunluk-1-i)) {
    			System.out.print(kelime.charAt(i));
    		}else if(uzunluk % 2 == 0 && kelime.charAt(i) != kelime.charAt(uzunluk-1-i)) {
    			uzunluk--;
    		}
    	}
    }
}
