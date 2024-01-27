package paket_2222;

public class Cereals_2222 extends Urun_2222 {

	public void tahilUrunEkle(String adi, String birimAgirligi, double birimFiyati, int stokMiktari) {
		Cereals_2222 yeniUrun = new Cereals_2222();
		yeniUrun.setAdi(adi);
		yeniUrun.setBirimAgirligi(birimAgirligi);
		yeniUrun.setBirimFiyati(birimFiyati);
		yeniUrun.setStokMiktari(stokMiktari);
		DosyadanOkuma_2222.Cereals.add(yeniUrun);
		for(Urun_2222 urun : DosyadanOkuma_2222.Cereals) {
			System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}
	
	public void tahilUrunEkle(String adi, double birimFiyati, int stokMiktari) {
		Cereals_2222 yeniUrun = new Cereals_2222();
		yeniUrun.setBirimAgirligi("10");
		yeniUrun.setAdi(adi);
		yeniUrun.setBirimFiyati(birimFiyati);
		yeniUrun.setStokMiktari(stokMiktari);
		DosyadanOkuma_2222.Cereals.add(yeniUrun);
		for(Urun_2222 urun : DosyadanOkuma_2222.Cereals) {
			System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}

	}

	public void tahilUrunEkle(String adi, String birimAgirligi, double birimFiyati, String detay) {
		Cereals_2222 yeniUrun = new Cereals_2222();
		yeniUrun.setBirimAgirligi(birimAgirligi);
		yeniUrun.setAdi(adi);
		yeniUrun.setBirimFiyati(birimFiyati);
		yeniUrun.setStokMiktari(20);
		yeniUrun.setDetay(detay);
		DosyadanOkuma_2222.Cereals.add(yeniUrun);
		
		for(Urun_2222 urun : DosyadanOkuma_2222.Cereals) {
			if(urun.getDetay() == null) {
				System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
			}else {
				System.out.println(urun.getAdi() + " " + "5" + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari() + " " + urun.getDetay() );

			}
		}
	}
}
