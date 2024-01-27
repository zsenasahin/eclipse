package odev3_ZeynepSena_Sahin;

public class KategoriStokMiktari_2222 {
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