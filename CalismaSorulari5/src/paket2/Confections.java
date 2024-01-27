package paket2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Confections extends Urun {
	protected static void urunGrubuOku() {
		try (BufferedReader br = new BufferedReader(new FileReader("urunGrubu.txt"))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] columns = line.split("\t");
				if (columns[0].equals("3")) {
					columns[2] = sekerlemeDetaySil(columns[2]);
					line = String.join("\t", columns);
				}

				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String sekerlemeDetaySil(String details) {
		String[] detailArray = details.split(",");

		for (int i = 0; i < detailArray.length; i++) {
			detailArray[i] = detailArray[i].trim();
		}

		if (detailArray.length > 0) {
			String[] newArray = new String[detailArray.length - 1];
			System.arraycopy(detailArray, 0, newArray, 0, newArray.length);
			details = String.join(", ", newArray);
		}

		return details;
	}
}
