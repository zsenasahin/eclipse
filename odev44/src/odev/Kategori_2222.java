package odev;

import java.util.ArrayList;
import java.util.List;

public class Kategori_2222 {	
	List<Urun_2222> Beverages = new ArrayList<>();
    List<Urun_2222> Condiments = new ArrayList<>();
    List<Urun_2222> Confections = new ArrayList<>();
    List<Urun_2222> DairyProducts = new ArrayList<>();
    List<Urun_2222> Cereals = new ArrayList<>();
    
    List<List<Urun_2222>> kategoriListeleri = List.of(Beverages, Condiments, Confections, DairyProducts, Cereals);
    
    public void urunEkle(int kategoriIndex, Urun_2222 urun) {
        switch (kategoriIndex) {
            case 1:
                Beverages.add(urun);
                break;
            case 2:
                Condiments.add(urun);
                break;
            case 3:
                Confections.add(urun);
                break;
            case 4:
                DairyProducts.add(urun);
                break;
            case 5:
                Cereals.add(urun);
                break;
            default:
                System.out.println("Geçersiz kategori indexi.");
                break;
        }
    }
    
    public List<List<Urun_2222>> getKategoriListeleri() {
        return kategoriListeleri;
    }

    public List<Urun_2222> getBeverages() {
        return Beverages;
    }

    public List<Urun_2222> getCondiments() {
        return Condiments;
    }

    public List<Urun_2222> getConfections() {
        return Confections;
    }

    public List<Urun_2222> getDairyProducts() {
        return DairyProducts;
    }

    public List<Urun_2222> getCereals() {
        return Cereals;
    }
    
	public void setBeverages(List<Urun_2222> beverages) {
		Beverages = beverages;
	}
	public void setCondiments(List<Urun_2222> condiments) {
		Condiments = condiments;
	}
	public void setConfections(List<Urun_2222> confections) {
		Confections = confections;
	}
	public void setDairyProducts(List<Urun_2222> dairyProducts) {
		DairyProducts = dairyProducts;
	}
	public void setCereals(List<Urun_2222> cereals) {
		Cereals = cereals;
	}
	public void setKategoriListeleri(List<List<Urun_2222>> kategoriListeleri) {
		this.kategoriListeleri = kategoriListeleri;
	}
}
