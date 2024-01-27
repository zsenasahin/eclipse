package odev2;

import java.util.List;


public class Main_2222 {

	public static void main(String[] args) {
        
		Fonksiyonlar_2222 islemler = new Fonksiyonlar_2222();
		String metin = islemler.metiniAl();
		
        List<String> cumleler = islemler.cumlelereAyir(metin);
        
        for (String cumle: cumleler) {
        	List<String> heceler = islemler.hecelereAyir(cumle);
        	islemler.yazdir(heceler);
        } 
        
	}

}
