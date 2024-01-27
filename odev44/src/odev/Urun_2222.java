package odev;

import java.text.DecimalFormat;
import java.util.List;

public class Urun_2222 {
	
	private String adi;
    private int kategoriIndex;
    private String birimAgirligi;
    private double birimFiyati;
    private int stokMiktari;
    public String yeniDetay;
    
    public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
        this.adi = adi;
        this.kategoriIndex = kategoriIndex;
        this.birimAgirligi = birimAgirligi;
        this.birimFiyati = birimFiyati;
        this.stokMiktari = stokMiktari;
    }
    
    public Urun_2222() {
    	
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
    public String getYeniDetay() {
		return yeniDetay;
	}

	public void setYeniDetay(String yeniDetay) {
		this.yeniDetay = yeniDetay;
	}
	static DecimalFormat df = new DecimalFormat("#.##");
    
    public void StokMiktarinaGoreUrunFiyatlariGuncelle(int stokAdedi, List<List<Urun_2222>> kategoriListeleri) {
        for (List<Urun_2222> kategori : kategoriListeleri) {
            for (Urun_2222 urun : kategori) {
                if (urun.getStokMiktari() < stokAdedi) {
                    double guncelFiyat = urun.getBirimFiyati() * (1 + ((stokAdedi - urun.getStokMiktari()) / 100.0));
                    urun.setBirimFiyati(guncelFiyat);
                    System.out.println(urun.getAdi() + " - Kategori: " + urun.getKategoriIndex() +
                            " - Güncellenmiş Fiyat: " + df.format(guncelFiyat));
                }
            }
        }
    }
    
    public void UrunZamYap(int X, List<List<Urun_2222>> kategoriListeleri) {
        Urun_2222 enDusukFiyatliUrun = null;
        double enDusukFiyat = Double.MAX_VALUE;

        for (List<Urun_2222> kategori : kategoriListeleri) {
            for (Urun_2222 urun : kategori) {
                if (urun.getBirimFiyati() < enDusukFiyat) {
                    enDusukFiyat = urun.getBirimFiyati();
                    enDusukFiyatliUrun = urun;
                }
            }
        }

        if (enDusukFiyatliUrun != null) {
            double yeniFiyat = enDusukFiyatliUrun.getBirimFiyati() * (1 + X / 100.0);
            enDusukFiyatliUrun.setBirimFiyati(yeniFiyat);

            System.out.println(enDusukFiyatliUrun.getAdi() + " - Kategori: " + enDusukFiyatliUrun.getKategoriIndex() +
                    " - Güncellenmiş Fiyat: " + df.format(yeniFiyat));
        } else {
            System.out.println("Ürün bulunamadı.");
        }
    }
	
}
