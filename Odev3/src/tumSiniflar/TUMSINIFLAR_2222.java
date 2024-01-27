package tumSiniflar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TUMSINIFLAR_2222 {
	//Main_2222
	public static void main(String[] args) {
		List<Urun_2222> urunList = new ArrayList<>();
		UrunListesi_2222 urun = new UrunListesi_2222();
		Scanner scanner = new Scanner(System.in);
		int secim = 0;

		do {
			System.out.println("------- MENÜ -------");
			System.out.println("1: ListeOlustur");
			System.out.println("2: YeniKategoriListeOlustur");
			System.out.println("3: BirimFiyatGuncelle");
			System.out.println("4: StokGüncelleVeUrunEkle");
			System.out.println("5: UrunSil");
			System.out.println("6: Çıkış");
			System.out.println("--------------------");
			System.out.print("Seçiminizi yapınız: ");
			secim = scanner.nextInt();

			switch (secim) {
			case 1:
				urun.listeOlustur();
				break;
			case 2:
				if (urun.urunList.isEmpty()) {
					System.out.println("Urun listesi boş.");
				} else {
					System.out.println("Listelemek istediğiniz miktarı giriniz: ");
					int N = scanner.nextInt();
					if (N > 5) {
						System.out.println("N sayısı 5ten büyük olamaz.");
					} else {
						Kategori_2222.kategorikGoster(urun.urunList, N);
					}
				}
				break;
			case 3:
				if (urun.urunList.isEmpty()) {
					System.out.println("Urun listesi boş.");
				} else {
					System.out.println("x giriniz: ");
					int x = scanner.nextInt();
					urun.urunFiyatiGuncelle(x);
					urun.urunGoster();
				}
				break;
			case 4:
				if (urun.urunList.isEmpty()) {
					System.out.println("Urun listesi boş.");
				} else {
					System.out.println("Yeni ürün adını giriniz: ");
					String yeniUrunAdi = scanner.next();
					System.out.println("Yeni ürünün birim ağırlığını giriniz: ");
					String yeniUrunBirimAgirligi = scanner.next();
					System.out.println("Yeni ürünün birim fiyatını giriniz :");
					Double yeniUrunBirimFiyati = scanner.nextDouble();
					Kategori_2222.StokGuncelleVeYeniUrunEkle(urun.urunList, yeniUrunAdi, yeniUrunBirimAgirligi,
							yeniUrunBirimFiyati);
				}
				break;
			case 5:
				Kategori_2222.silinecekUrunuBelirle(urun.urunList);
				break;
			case 6:
				System.out.println("Çıkış yapıldı.");
				break;
			default:
				System.out.println("Geçersiz seçim. Tekrar deneyin.");
				break;
			}
		} while (secim != 6);

		scanner.close();
	}
}
//Urun_2222
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
		birimFiyati += birimFiyati * x / 100;
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

//UrunListesi_2222
class UrunListesi_2222 {
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

		} catch (IOException e) {
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
		for (Urun_2222 urun : urunList) {
			if (enDusukUrunFiyati <= urun.birimFiyati) {
				enDusukUrunFiyati = urun.birimFiyati;
				enDusukFiyatliUrun = urun;
			}
		}
		return enDusukFiyatliUrun;
	}

	public Urun_2222 enDusukUcretliUrun() {
		double enYuksekUrunFiyati = Double.MAX_VALUE;
		Urun_2222 enYuksekFiyatliUrun = null;
		for (Urun_2222 urun : urunList) {
			if (enYuksekUrunFiyati >= urun.birimFiyati) {
				enYuksekUrunFiyati = urun.birimFiyati;
				enYuksekFiyatliUrun = urun;
			}
		}
		return enYuksekFiyatliUrun;
	}

	public void urunGoster() {

		for (Urun_2222 urun : urunList) {
			System.out.println(urun.adi + "\t" + urun.kategoriIndex + "\t" + urun.birimAgirligi + "\t"
					+ urun.birimFiyati + "\t" + urun.stokMiktari);
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

//Kategori_2222
class Kategori_2222 {
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

		for (int i = 0; i < N && i < kategoriList.size(); i++) {
			KategoriStokMiktari_2222 kategori = kategoriList.get(i);
			System.out.println(
					"Kategori " + kategori.getKategoriIndex() + ": Toplam Ürün " + kategori.getAdet() + " adet");
		}
	}

	public static KategoriStokMiktari_2222 kategoriIndexiMevcutMu(ArrayList<KategoriStokMiktari_2222> kategoriList,
			int kategoriIndex) {
		for (KategoriStokMiktari_2222 kategoriAdet : kategoriList) {
			if (kategoriAdet.getKategoriIndex() == kategoriIndex) {
				return kategoriAdet;
			}
		}
		return null;
	}

	public static void StokGuncelleVeYeniUrunEkle(List<Urun_2222> urunList, String yeniUrunAdi,
			String yeniUrunBirimAgirligi, double yeniUrunBirimFiyati) {
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
		int yeniUrunStokMiktari = ((enYuksekStokluKategori.getStokMiktari() - enDusukStokluKategori.getStokMiktari()));
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
			if (urun.kategoriIndex == enDusukStokluKategori.getKategoriIndex()
					&& urun.birimFiyati > enYuksekUrunFiyati) {
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

//KategoriStokMiktari_2222
class KategoriStokMiktari_2222 {
	private int kategoriIndex;
	private int adet;
	private int stokMiktari;

	public KategoriStokMiktari_2222(int kategoriIndex) {
		this.kategoriIndex = kategoriIndex;
		this.adet = 0;
		this.stokMiktari = 0;
	}

	public int getKategoriIndex() {
		return kategoriIndex;
	}

	public int getAdet() {
		return adet;
	}

	public int getStokMiktari() {
		return stokMiktari;
	}

	public void artirAdet() {
		adet++;
	}

	public void artirStokMiktari() {
		stokMiktari++;
	}

	public void artirStokMiktari(int miktar) {
		stokMiktari += miktar;
	}

}