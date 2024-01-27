package lab8_2222;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Urun_2222 implements Serializable {
	static Scanner scanner = new Scanner(System.in);
	private String adi;
	private int kategoriIndex;
	private String birimAgirligi;
	private double birimFiyati;
	private int stokMiktari;
	private boolean satisMi;

	public Urun_2222(String adi, int kategoriIndex, String birimAgirligi, double birimFiyati, int stokMiktari) {
		this.adi = adi;
		this.birimAgirligi = birimAgirligi;
		this.birimFiyati = birimFiyati;
		this.stokMiktari = stokMiktari;
		this.kategoriIndex = kategoriIndex;
	}

	public Urun_2222(String urunAdi, boolean SatisMi, int stokMiktari) {
		this.adi = urunAdi;
		this.satisMi = SatisMi;
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

	public int getStokMiktari() {
		return stokMiktari;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public void setBirimAgirligi(String birimAgirligi) {
		this.birimAgirligi = birimAgirligi;
	}

	public void setBirimFiyati(double birimFiyati) {
		this.birimFiyati = birimFiyati;
	}

	public void setKategoriIndex(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
	}

	public void setSatisMi(boolean satisMi) {
		this.satisMi = satisMi;
	}

	public void setStokMiktari(int stokMiktari) {
		this.stokMiktari = stokMiktari;
	}

	static class Cereals implements Serializable {
		private List<Urun_2222> urunListesi;

		public Cereals() {
			urunListesi = new ArrayList<>();
		}

		public void tahilMinStokEkle(int miktar) {
			int minStok = 9999;
			Urun_2222 minStokluUrun = null;

			for (Urun_2222 urun : VeriGirisIslemleri.urunListesi) {
				if (urun.getKategoriIndex() == 5) {
					if (urun.getStokMiktari() < minStok) {
						minStokluUrun = urun;
						minStok = urun.getStokMiktari();
					}
				}
			}

			if (minStokluUrun != null) {
				minStokluUrun.setStokMiktari(minStokluUrun.getStokMiktari() + miktar);

				System.out.println(minStokluUrun.getAdi() + " " + minStokluUrun.getKategoriIndex() + " "
						+ minStokluUrun.getBirimAgirligi() + " " + minStokluUrun.getBirimFiyati() + " "
						+ minStokluUrun.getStokMiktari());
			} else {
				System.out.println("Tahıl kategorisinde ürün bulunamadı.");
			}
		}
	}
}
