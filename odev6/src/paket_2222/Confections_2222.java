package paket_2222;

import java.util.List;

public class Confections_2222 extends Urun_2222{
	
	@Override
	public void urunStokGuncelle(List<List<Urun_2222>> kategoriListeleri, int stokMiktari, boolean girisMi) {
		//stokMiktari > 10 ise çıkış, stokMiktari<20 ise giriş işlemini yap.
		for(Urun_2222 urun: DosyadanOkuma_2222.Confections) {
			if(girisMi) {
				if(stokMiktari > 10) {
					int yeniStok = urun.getStokMiktari() + stokMiktari;
					urun.setStokMiktari(yeniStok);
				}
			}else {
				if(stokMiktari< 20) {
					int yeniStok = urun.getStokMiktari() - stokMiktari;
					urun.setStokMiktari(yeniStok);
				}
			}
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}
}
