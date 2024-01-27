package odev2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fonksiyonlar_2222 {
	
	public String metiniAl() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Metin giriniz: ");
        String metin = scanner.nextLine();
        return metin;
	}
	
	public void yazdir(List<String> heceler) {
    	for (int i = 0; i < heceler.size();  i ++) {
    		System.out.print(heceler.get(i));
    	}
    	System.out.println();

	}

	public List<String> cumlelereAyir(String metin) {
		return Arrays.asList(metin.split("[.!?]\\s*"));

	}

	public List<String> hecelereAyir(String cumle) {
		List<String> heceler = new ArrayList<String>();

		String hece = "";

		for (String kelime : cumle.split(" ")) {
			for (int i = 0; i < kelime.length(); i++) {

				if (unsuzMu(kelime.charAt(i))) {
					hece += kelime.charAt(i);
					continue;
				}

				if (sonraki3KarakterUnsuzMu(kelime, i)) {
					hece += kelime.substring(i, Math.min(i + 3, kelime.length()));
					i += 2;
				}

				else if (sonraki2KarakterUnsuzMu(kelime, i)) {
					hece += kelime.substring(i, Math.min(i + 2, kelime.length()));
					i += 1;
				}

				else if (sonraki1KarakterUnsuzMu(kelime, i)) {
					hece += kelime.substring(i, Math.min(i + 1, kelime.length() + 1));
				} else {
					hece += kelime.charAt(i);
				}

				heceler.add(hece);
				heceler.add("-");
				hece = "";
			}
			heceler.remove(heceler.size() - 1);
			heceler.add(" ");

		}

		return heceler;

	}

	private boolean sonraki3KarakterUnsuzMu(String cumle, int index) {
		if (cumle.length() <= index + 3)
			return false;
		return unsuzMu(cumle.charAt(index + 1)) && unsuzMu(cumle.charAt(index + 2)) && unsuzMu(cumle.charAt(index + 3));
	}

	private boolean sonraki2KarakterUnsuzMu(String cumle, int index) {
		if (cumle.length() <= index + 2)
			return true;
		return unsuzMu(cumle.charAt(index + 1)) && unsuzMu(cumle.charAt(index + 2));
	}

	private boolean sonraki1KarakterUnsuzMu(String cumle, int index) {
		if (cumle.length() <= index + 1)
			return false;
		return unsuzMu(cumle.charAt(index + 1));
	}

	private boolean unluMu(char c) {
		return "aeıioöuü".contains(c + "");
	}

	private boolean unsuzMu(char c) {
		return !unluMu(c);
	}

}
