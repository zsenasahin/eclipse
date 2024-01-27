package odev3_ZeynepSena_Sahin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kategori_2222 {
	public static void kategorikGoster(List<Urun_2222> urunList, int N) {
			ArrayList<KategoriStokMiktari_2222> kategoriList = new ArrayList<>();
			    
	        for (Urun_2222 urun : urunList) {
	            int kategoriIndex = urun.kategoriIndex;
	            KategoriStokMiktari_2222 kategoriAdet = kategoriIndexiMevcutMu(kategoriList, kategoriIndex);

	            if (kategoriAdet != null) {
	                kategoriAdet.artirAdet();
	            } else {
	                KategoriStokMiktari_2222 yeniKategori = new KategoriStokMiktari_2222(kategoriIndex);
	                yeniKategori.artirAdet();
	                kategoriList.add(yeniKategori);
	            }
	        }
	        
	        Collections.sort(kategoriList, (k1, k2) -> k2.getAdet() - k1.getAdet());
	                
	        for(int i=0; i<N && i<kategoriList.size();i++) {
	        	KategoriStokMiktari_2222 kategori = kategoriList.get(i);
	        	System.out.println("Kategori " + kategori.getKategoriIndex() + ": Toplam Ürün " + kategori.getAdet() + " adet");
	        }
	    }
	
	    public static KategoriStokMiktari_2222 kategoriIndexiMevcutMu(ArrayList<KategoriStokMiktari_2222> kategoriList, int kategoriIndex) {
	        for (KategoriStokMiktari_2222 kategoriAdet : kategoriList) {
	            if (kategoriAdet.getKategoriIndex() == kategoriIndex) {
	                return kategoriAdet;
	            }
	        }
	        return null;
	    }

	    public static void StokGuncelleVeYeniUrunEkle(List<Urun_2222> urunList,String yeniUrunAdi,String yeniUrunBirimAgirligi,double yeniUrunBirimFiyati) {
	        ArrayList<KategoriStokMiktari_2222> kategoriList = new ArrayList<>();
	        
	        
	        for (Urun_2222 urun : urunList) {
	            int kategoriIndex = urun.kategoriIndex;
	            KategoriStokMiktari_2222 kategoriStok = kategoriIndexiMevcutMu(kategoriList, kategoriIndex);
	            if (kategoriStok != null) {
	                kategoriStok.artirStokMiktari(urun.stokMiktari);
	            } else {
	                KategoriStokMiktari_2222 yeniKategori = new KategoriStokMiktari_2222(kategoriIndex);
	                yeniKategori.artirStokMiktari(urun.stokMiktari);
	                kategoriList.add(yeniKategori);
	            }
	        }

	        KategoriStokMiktari_2222 enYuksekStokluKategori = null;
	        KategoriStokMiktari_2222 enDusukStokluKategori = null;

	        for (KategoriStokMiktari_2222 kategori : kategoriList) {
	            if (enYuksekStokluKategori == null || kategori.getStokMiktari() > enYuksekStokluKategori.getStokMiktari()) {
	                enYuksekStokluKategori = kategori;
	            }

	            if (enDusukStokluKategori == null || kategori.getStokMiktari() < enDusukStokluKategori.getStokMiktari()) {
	                enDusukStokluKategori = kategori;
	            }
	        }   
	        int yeniUrunStokMiktari=  ((enYuksekStokluKategori.getStokMiktari() - enDusukStokluKategori.getStokMiktari()));
	        int yeniUrunKategoriIndex = enDusukStokluKategori.getKategoriIndex();

	        Urun_2222 yeniUrun = new Urun_2222();
	        yeniUrun.setAdi(yeniUrunAdi);
	        yeniUrun.setKategoriIndex(yeniUrunKategoriIndex);
	        yeniUrun.setBirimAgirligi(yeniUrunBirimAgirligi);
	        yeniUrun.setBirimFiyati(yeniUrunBirimFiyati);
	        yeniUrun.setStokMiktari(yeniUrunStokMiktari);

	        urunList.add(yeniUrun);
	
	        for (Urun_2222 urun : urunList) {
				System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati
						+ " " + urun.stokMiktari);
			}
	    }
    
	    public static void silinecekUrunuBelirle(List<Urun_2222> urunList) {
	    	ArrayList<KategoriStokMiktari_2222> kategoriList = new ArrayList<>();
	    	 if (urunList.isEmpty()) {
	             System.out.println("Urun listesi boş.");
	         } 
	    	 
	    	for (Urun_2222 urun : urunList) {
	            int kategoriIndex = urun.kategoriIndex;
	            KategoriStokMiktari_2222 kategoriStok = kategoriIndexiMevcutMu(kategoriList, kategoriIndex);
	            if (kategoriStok != null) {
	                kategoriStok.artirStokMiktari(urun.stokMiktari);
	            } else {
	                KategoriStokMiktari_2222 yeniKategori = new KategoriStokMiktari_2222(kategoriIndex);
	                yeniKategori.artirStokMiktari(urun.stokMiktari);
	                kategoriList.add(yeniKategori);
	            }
	        }
	        KategoriStokMiktari_2222 enDusukStokluKategori = null;

	        for (KategoriStokMiktari_2222 kategori : kategoriList) {
	            if (enDusukStokluKategori == null || kategori.getStokMiktari() < enDusukStokluKategori.getStokMiktari()) {
	                enDusukStokluKategori = kategori;
	            }
	        }
	        Urun_2222 enYuksekFiyatliUrun = null;
	        double enYuksekUrunFiyati = Double.MIN_VALUE;

	        for (Urun_2222 urun : urunList) {
	            if (urun.kategoriIndex == enDusukStokluKategori.getKategoriIndex() && urun.birimFiyati > enYuksekUrunFiyati) {
	            	enYuksekUrunFiyati = urun.birimFiyati;
	            	enYuksekFiyatliUrun = urun;
	            }
	        }
	        
	        if (enYuksekFiyatliUrun != null) {
	            urunList.remove(enYuksekFiyatliUrun);
	            
	            System.out.println(enYuksekFiyatliUrun.adi + " adlı ürün silindi. Son durum: \n");
	        } 
	        
	        for (Urun_2222 urun : urunList) {
    			System.out.println(urun.adi + " " + urun.kategoriIndex + " " + urun.birimAgirligi + " " + urun.birimFiyati
    					+ " " + urun.stokMiktari);
    		}   
	    }		
	}