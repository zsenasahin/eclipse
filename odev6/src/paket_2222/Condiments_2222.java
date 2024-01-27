package paket_2222;

public class Condiments_2222 extends Urun_2222{
	public void cesniBirimAgirlikGuncelle(String yeniAgirlik) {
		int enCokStok = 0;
		Urun_2222 enCokStokluUrun = null;
		for(Urun_2222 urun: DosyadanOkuma_2222.Condiments) {
			if(urun.getStokMiktari()> enCokStok) {
				enCokStok = urun.getStokMiktari();
				enCokStokluUrun = urun;
				urun.setBirimAgirligi(yeniAgirlik);
			}
		}
		System.out.println(enCokStokluUrun.getAdi() + " " + enCokStokluUrun.getKategoriIndex()+  " " + enCokStokluUrun.getBirimAgirligi() + " " +enCokStokluUrun.getBirimFiyati() + " " + enCokStokluUrun.getStokMiktari());
	}
	
	
	public static void cesniBirimAgirlikGuncelle(String yeniAgirlik, int stokMiktari) {
		Urun_2222 enYakinUrun = DosyadanOkuma_2222.Condiments.get(0);
        int enKucukUzaklik = Math.abs(stokMiktari - enYakinUrun.getStokMiktari());

        for (Urun_2222 urun : DosyadanOkuma_2222.Condiments) {
            int uzaklik = Math.abs(stokMiktari - urun.getStokMiktari());
            if (uzaklik < enKucukUzaklik) {
                enKucukUzaklik = uzaklik;
                enYakinUrun = urun;
            }
        }

        enYakinUrun.setBirimAgirligi(yeniAgirlik);

        System.out.println("En yakın ürün: " + enYakinUrun.getAdi());
        System.out.println("Yeni Urun Listesi: ");
        for(Urun_2222 urun : DosyadanOkuma_2222.Condiments) {
        	System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
        }
    }
	
}
