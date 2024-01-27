package odev3_ZeynepSena_Sahin;

import java.text.DecimalFormat;

class Urun_2222 {
	public String adi;
	public int kategoriIndex;
	public String birimAgirligi;
	public double birimFiyati;
	public int stokMiktari;
	public String enDusukFiyatliUrun;
	public int kategoriIndexAdeti;
	
	public void urunFiyatiniYuzdeXGuncelle(int x) {
		DecimalFormat df = new DecimalFormat("#.##");
		birimFiyati += birimFiyati*x/100;
		birimFiyati = Double.parseDouble(df.format(birimFiyati));
	}
	
	public void setAdi(String adi) {
        this.adi = adi;
    }

    public void setKategoriIndex(int kategoriIndex) {
        this.kategoriIndex = kategoriIndex;
    }

    public void setBirimAgirligi(String birimAgirligi) {
        this.birimAgirligi = birimAgirligi;
    }

    public void setBirimFiyati(double birimFiyati) {
        this.birimFiyati = birimFiyati;
    }

    public void setStokMiktari(int stokMiktari) {
        this.stokMiktari = stokMiktari;
    }	
}