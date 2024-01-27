package paket2;

import java.util.List;

public class Urun {
	private String adi;
    private int kategoriIndex;
    private String birimAgirligi;
    private double birimFiyati;
    private int stokMiktari;
    public String detay;
    
    public Urun(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        this.adi = adi;
        this.kategoriIndex = kategoriIndex;
        this.birimAgirligi = birimAgirligi;
        this.birimFiyati = birimFiyati;
        this.stokMiktari = stokMiktari;
    }
    
    public Urun() {
    	
    }
    


	public Urun(int kategoriIndex, String adi, String detay) {
		this.kategoriIndex = kategoriIndex;
		this.adi = adi;
		this.detay = detay;
	}




	public String getAdi() {
		return adi;
	}
    
    public int getKategoriIndex() {
		return kategoriIndex;
	}
    
    public String getBirimAgirligi() {
		return birimAgirligi;
	}
    
    public double getBirimFiyati() {
		return birimFiyati;
	}
    
    public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}
    
    public int getStokMiktari() {
		return stokMiktari;
	}
    
    public void setStokMiktari(int stokMiktari) {
        this.stokMiktari = stokMiktari;
    }
    public void setAdi(String adi) {
        this.adi = adi;
    }
    public void setBirimAgirligi(String birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}
    public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}
    public String getDetay() {
		return detay;
	}

	public void setDetay(String yeniDetay) {
		this.detay = yeniDetay;
	}
	
	protected void urunStokGuncelle(List<List<Urun>> kategoriListeleri, String urunAdi, boolean satisMi, int adet) {
	    for (List<Urun> kategoriListesi : kategoriListeleri) {
	        for (Urun urun : kategoriListesi) {
	            if (urun.getAdi().equalsIgnoreCase(urunAdi)) {
	                int eskiStokMiktari = urun.getStokMiktari();

	                if (satisMi) {
	                    urun.setStokMiktari(eskiStokMiktari - adet);
	                } else {
	                    urun.setStokMiktari(eskiStokMiktari + adet);
	                }

	                System.out.println(urunAdi + " isimli ürünün stok miktarı " + urun.getStokMiktari() + " olarak güncellendi.");
	                return; 
	            }
	        }
	    }

	    System.out.println(urunAdi + " isimli ürün bulunamadı.");
	}

	
	protected void urunAdiDegistir(List<List<Urun>> kategoriListeleri, String eskiAd, String yeniAd) {
	    for (List<Urun> kategoriListesi : kategoriListeleri) {
	        for (Urun urun : kategoriListesi) {
	            if (urun.getAdi().equalsIgnoreCase(eskiAd)) {
	                urun.setAdi(yeniAd);
	                System.out.println("Ürün adı " + eskiAd + " isimli üründen " + yeniAd + " olarak güncellendi.\n"
	                        + urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi()
	                        + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
	                return; 
	            }
	        }
	    }

	    System.out.println(eskiAd + " isimli ürün bulunamadı.");
	}

	
}



