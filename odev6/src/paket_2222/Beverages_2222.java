package paket_2222;

import java.util.List;

public class Beverages_2222 extends Urun_2222{

	@Override
	public void urunFiyatGuncelle(List<List<Urun_2222>> kategoriListeleri, int oran) {
		/* ürünün stokMiktarı < 20 ise oran/2 ile işlem yap. 20<stokMiktarı<50 ise oran ile
		stokMiktarı >50 ise oran^2 ile işlem yaparak override ediniz*/
		for(Urun_2222 urun: DosyadanOkuma_2222.Beverages) {
			if(urun.getStokMiktari() < 20) {
				double yeniFiyat = urun.getBirimFiyati() * (1 + oran / 200.0);
				urun.setBirimFiyati(yeniFiyat);
			}else if(urun.getStokMiktari()> 20 && urun.getStokMiktari()<50) {
				double yeniFiyat = urun.getBirimFiyati() * (1 + oran / 100.0);
				urun.setBirimFiyati(yeniFiyat);
			}else if(urun.getStokMiktari() >50) {
				double yeniFiyat = urun.getBirimFiyati() * (1 + (oran*oran) / 100.0);
				urun.setBirimFiyati(yeniFiyat);
			}
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex()+ " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}
	
}
