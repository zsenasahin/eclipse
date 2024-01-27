package paket2_2222;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DairyProducts_2222 extends Urun_2222{
    private static List<String> details = new ArrayList<>();
    protected static void urunGrubuDetayEkle(String newDetail) {
        try (BufferedReader br = new BufferedReader(new FileReader("urunGrubu.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] sutun = line.split("\t");
                if (sutun[0].equals("4")) {
                    sutun[2] += ", " + newDetail;
                    line = String.join("\t", sutun);
                }

                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
