package odev3_ZeynepSena_Sahin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UrunListesi_2222 {
	List<Urun_2222> urunList = new ArrayList<>();
	public void listeOlustur() {
		try {
			urunList = new ArrayList<Urun_2222>();
			BufferedReader reader = new BufferedReader(new FileReader("urunListesi.txt"));
            String satir;
            reader.readLine();
            
            while ((satir = reader.readLine()) != null) {
                System.out.println(satir);
                String[] urunBilgileri = satir.split("	");
                String adi = urunBilgileri[0].trim();
                int kategoriIndex = Integer.parseInt(urunBilgileri[1].trim());
                String birimAgirligi = urunBilgileri[2].trim();
                double birimFiyati = Double.parseDouble(urunBilgileri[3].trim());
                int stokMiktari = Integer.parseInt(urunBilgileri[4].trim());
                Urun_2222 urun = new Urun_2222();
                urun.adi = adi;
                urun.birimAgirligi = birimAgirligi;
                urun.kategoriIndex = kategoriIndex;
                urun.birimFiyati = birimFiyati;
                urun.stokMiktari = stokMiktari;
                urunList.add(urun);
            	}
           
	        }catch (IOException e) {
			e.printStackTrace();
	        }
		}	
	public void urunFiyatiGuncelle(int x) {
		enDusukUcretliUrun().urunFiyatiniYuzdeXGuncelle(x);
		enYuksekUcretliUrun().urunFiyatiniYuzdeXGuncelle(-x);
	}
		
	public Urun_2222 enYuksekUcretliUrun() {
		double enDusukUrunFiyati = -1;
		Urun_2222 enDusukFiyatliUrun = null;
		for(Urun_2222 urun : urunList) {
			if(enDusukUrunFiyati <= urun.birimFiyati) {
				enDusukUrunFiyati = urun.birimFiyati;
				enDusukFiyatliUrun = urun;
			}		
		}	
		return enDusukFiyatliUrun;
	}

	public Urun_2222 enDusukUcretliUrun() {
		double enYuksekUrunFiyati = Double.MAX_VALUE;
		Urun_2222 enYuksekFiyatliUrun = null;
		for(Urun_2222 urun : urunList) {
			if(enYuksekUrunFiyati >= urun.birimFiyati) {
				enYuksekUrunFiyati = urun.birimFiyati;
				enYuksekFiyatliUrun = urun;
			}
		}	
		return enYuksekFiyatliUrun;
	}
    
	public void urunGoster() {
		
		for(Urun_2222 urun : urunList) {
			System.out.println(urun.adi + "\t" + urun.kategoriIndex + "\t" + urun.birimAgirligi + "\t" + urun.birimFiyati + "\t" + urun.stokMiktari);
		}
	}
	

	public Urun_2222 enAzStokluUrunAdedi() {
	    int minStok = Integer.MAX_VALUE;
	    Urun_2222 enAzStokluUrun = null;

	    for (Urun_2222 urun : urunList) {
	        if (urun.stokMiktari < minStok) {
	            minStok = urun.stokMiktari;
	            enAzStokluUrun = urun;
	        }
	    }

	    return enAzStokluUrun;
	}

	public Urun_2222 enCokStokluUrunAdedi() {
	    int maxStok = Integer.MIN_VALUE;
	    Urun_2222 enCokStokluUrun = null;

	    for (Urun_2222 urun : urunList) {
	        if (urun.stokMiktari > maxStok) {
	            maxStok = urun.stokMiktari;
	            enCokStokluUrun = urun;
	        }
	    }

	    return enCokStokluUrun;
	}
	
}