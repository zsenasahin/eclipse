package paket2_2222;

import java.util.List;

import paket1_2222.DosyadanOku_2222;

public class Condiments_2222 extends Urun_2222{
	protected static void CesniStokGuncelle(int index, boolean SatisMi, int miktar) {
		List<Urun_2222> CondimentsListesi = DosyadanOku_2222.getCondiments();
		if (!CondimentsListesi.isEmpty()) {

			Urun_2222 indexliUrun = CondimentsListesi.get(index);
			int stok = indexliUrun.getStokMiktari();
			if (SatisMi) {
				if (stok > miktar) {
					int yeniStok = (stok - miktar);
					indexliUrun.setStokMiktari(yeniStok);
					System.out.println(indexliUrun.getAdi() + " " + indexliUrun.getKategoriIndex() + " "
							+ indexliUrun.getBirimAgirligi() + " " + indexliUrun.getBirimFiyati() + " " + yeniStok);

				}else {
					System.out.println("Hata. Girilen miktar stoktan küçük olamaz.");
				}
			} else {
				int yeniStok = (stok + miktar);
				indexliUrun.setStokMiktari(yeniStok);
				System.out.println(indexliUrun.getAdi() + " " + indexliUrun.getKategoriIndex() + " "
						+ indexliUrun.getBirimAgirligi() + " " + indexliUrun.getBirimFiyati() + " " + yeniStok);

			}

		} else {
			System.out.println("Beverages listesi boş.");
		}
	}
}