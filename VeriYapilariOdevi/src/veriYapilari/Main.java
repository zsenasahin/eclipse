package veriYapilari;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AVLTree agac = new AVLTree();
		Scanner scanner = new Scanner(System.in);

		try (BufferedReader br = new BufferedReader(new FileReader("kayit.txt"))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(" ");
				if (tokens.length == 4) {
					int ogrenciNo = Integer.parseInt(tokens[0].trim());
					String isim = tokens[1].trim();
					String soyisim = tokens[2].trim();
					int yas = Integer.parseInt(tokens[3].trim());

					// (a)
					agac.insert(ogrenciNo, isim, soyisim, yas);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int choice;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Inorder Sıralama");
			System.out.println("2. Preorder Sıralama");
			System.out.println("3. Postorder Sıralama");
			System.out.println("4. Kok Silme");
			System.out.println("5. Yaprak Silme");
			System.out.println("6. Sol Cocugu olan ve Sag Cocugu Olmayan Dugum Silme");
			System.out.println("7. Sag Cocugu olan ve Sol Cocugu Olmayan Dugum Silme");
			System.out.println("8. Bir Sag ve bir sol cocugu olan dugum silme");
			System.out.println("9. Subtree boyutu bulma.");
			System.out.println("10. En kucuk ve En buyuk dugumu bulma");
			System.out.println("11. Yapraklari yazdir.");
			System.out.println("0. Exit");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Inorder traversal:");
				agac.inorder(agac.root);
				break;
			case 2:
				System.out.println("\nPreorder traversal:");
				agac.preorder(agac.root);
				break;
			case 3:
				System.out.println("Postorder traversal:");
				agac.postorder(agac.root);
				break;
			case 4:
				Node kok = agac.kokBul(agac.root);
				System.out.println("\n\nKOK:  " + kok.ogrenciNo);
				agac.delete(kok.ogrenciNo, kok.isim, kok.soyisim, kok.yas);
				System.out.println("\nKok silindikten sonra");
				agac.inorder(agac.root);
				break;
			case 5:
				Node yaprak = agac.yaprakBul(agac.root);
				agac.delete(yaprak.ogrenciNo, yaprak.isim, yaprak.soyisim, yaprak.yas);
				agac.inorder(agac.root);
				break;
			case 6:
				Node solvar = agac.solCocukBul(agac.root);
				if (solvar != null) {
					System.out.println("sol Var sag Yok" + solvar.ogrenciNo);
					agac.delete(solvar.ogrenciNo, solvar.isim, solvar.soyisim, solvar.yas);
					agac.inorder(agac.root);
				} else {
					System.out.println("Suanda sol cocugu olan sag cocugu olmayan dugum bulunmamaktadir.");
				}
				break;
			case 7:
				System.out.println("\n");
				Node sagvar = agac.sagCocukBul(agac.root);
				System.out.println("Sag cocugu olan sol olmayan dugum " + sagvar.ogrenciNo);
				agac.delete(sagvar.ogrenciNo, sagvar.isim, sagvar.soyisim, sagvar.yas);
				agac.inorder(agac.root);
				break;
			case 8:
				Node silinecek = agac.birSagVeBirSol(agac.root);
				System.out.println("sag ve sol cocugu olan dugum: " + silinecek.ogrenciNo);
				agac.delete(silinecek.ogrenciNo, silinecek.isim, silinecek.soyisim, silinecek.yas);
				agac.inorder(agac.root);
				break;
			case 9:
				System.out.println("Ogrenci numarasi girin: ");
				int ogrenciNoToFind = scanner.nextInt();

				int subtreeSize = agac.getSubtreeSize(ogrenciNoToFind);
				System.out.println("Subtree Boyutu: " + subtreeSize);
				break;
			case 10:
				System.out.println("en kucuk ve en buyuk dugum gostermek icin numara girin: ");
				int numara = scanner.nextInt();
				agac.findMinMax(numara);
				break;
			case 11:
				System.out.println("\n Yapraklar");
				agac.printLeaves(agac.root);
				break;
			case 0:
				System.out.println("Program sonlandiriliyor..");
				break;
			default:
				System.out.println("Gecersiz secim!");
			}
		} while (choice != 0);

		scanner.close();
	}
}
