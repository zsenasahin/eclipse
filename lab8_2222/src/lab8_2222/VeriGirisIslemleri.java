package lab8_2222;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeriGirisIslemleri {
	static List<Urun_2222> urunListesi = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		urunListesi.add(new Urun_2222("Chai", 1, "10 boxes x 20 bags", 18, 39));
		urunListesi.add(new Urun_2222("Chang", 1, "24 - 12 oz bottles", 19, 17));
		urunListesi.add(new Urun_2222("Aniseed Syrup", 2, "12 - 550 ml bottles", 10, 13));
		urunListesi.add(new Urun_2222("Chef Anton's Cajun Seasoning", 2, "48 - 6 oz jars", 22, 53));
		urunListesi.add(new Urun_2222("Chef Anton's Gumbo Mix", 2, "36 boxes", 21.35, 0));
		urunListesi.add(new Urun_2222("Grandma's Boysenberry Spread", 2, "12 - 8 oz jars", 25, 120));
		urunListesi.add(new Urun_2222("Uncle Bob's Organic Dried Pears", 5, "12 - 1 lb pkgs.", 30, 15));
		urunListesi.add(new Urun_2222("Northwoods Cranberry Sauce", 2, "12 - 12 oz jars", 40, 6));
		urunListesi.add(new Urun_2222("Mishi Kobe Niku", 4, "18 - 500 g pkgs.", 97, 29));
		urunListesi.add(new Urun_2222("Ikura", 5, "12 - 200 ml jars", 31, 31));
		urunListesi.add(new Urun_2222("Queso Cabrales", 4, "1 kg pkg.", 21, 22));
		urunListesi.add(new Urun_2222("Queso Manchego La Pastora", 4, "10 - 500 g pkgs.", 38, 86));
		urunListesi.add(new Urun_2222("Konbu", 3, "2 kg box", 6, 24));
		urunListesi.add(new Urun_2222("Tofu", 5, "40 - 100 g pkgs.", 23.25, 35));
		urunListesi.add(new Urun_2222("Genen Shouyu", 2, "24 - 250 ml bottles", 15.5, 39));
		urunListesi.add(new Urun_2222("Pavlova", 3, "32 - 500 g boxes", 17.45, 29));
		urunListesi.add(new Urun_2222("Alice Mutton", 5, "20 - 1 kg tins", 39, 0));
		urunListesi.add(new Urun_2222("Carnarvon Tigers", 5, "16 kg pkg.", 62.5, 42));
		urunListesi.add(new Urun_2222("Teatime Chocolate Biscuits", 3, "10 boxes x 12 pieces", 9.2, 25));
		urunListesi.add(new Urun_2222("Sir Rodney's Marmalade", 3, "30 gift boxes", 81, 40));
		urunListesi.add(new Urun_2222("Sir Rodney's Scones", 3, "24 pkgs. x 4 pieces", 10, 3));
		urunListesi.add(new Urun_2222("Gustaf's Knäckebröd", 5, "24 - 500 g pkgs.", 21, 104));
		urunListesi.add(new Urun_2222("Tunnbröd", 5, "12 - 250 g pkgs.", 9, 61));
		urunListesi.add(new Urun_2222("Guaraná Fantástica", 1, "12 - 355 ml cans", 4.5, 20));
		urunListesi.add(new Urun_2222("NuNuCa Nuß-Nougat-Creme", 3, "20 - 450 g glasses", 14, 76));

		dosyayaYaz("urunler.txt", urunListesi);
		List<Urun_2222> okunanUrunListesi = dosyadanOku("urunler.txt");

		for (Urun_2222 urun : okunanUrunListesi) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}

		System.out.println("\n\n");

		
		System.out.println("Miktar giriniz: ");
		int miktar = scanner.nextInt();
		Urun_2222.Cereals cereals = new Urun_2222.Cereals();
		cereals.tahilMinStokEkle(miktar);
		System.out.println("\n\n");

		dosyayaYaz("sonHali.txt", urunListesi);
		okunanUrunListesi = dosyadanOku("sonHali.txt");
		
		for (Urun_2222 urun : okunanUrunListesi) {
			System.out.println(urun.getAdi() + " " + urun.getKategoriIndex() + " " + urun.getBirimAgirligi() + " " + urun.getBirimFiyati() + " " + urun.getStokMiktari());
		}
	}

	public static void dosyayaYaz(String dosyaAdi, List<Urun_2222> urunListesi) {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dosyaAdi))) {
			objectOutputStream.writeObject(urunListesi);
			System.out.println("Veriler dosyaya yazıldı.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Urun_2222> dosyadanOku(String dosyaAdi) {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(dosyaAdi))) {
			return (List<Urun_2222>) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
