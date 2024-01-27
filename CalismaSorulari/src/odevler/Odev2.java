package odevler;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Odev2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Metin girin:");
        String metin = scanner.nextLine();

        String[] cumleler = metin.split("\\.");

        for (String cumle : cumleler) {
            cumle = cumle.trim();
            String[] kelimeler = cumle.split(" ");
            for (String kelime : kelimeler) {
                String heceliKelime = heceBol(kelime);
                System.out.print(heceliKelime + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    public static String heceBol(String kelime) {
        Pattern pattern = Pattern.compile("([^aeıioöuü]*[aeıioöuü]+[^aeıioöuü]*)");
        Matcher matcher = pattern.matcher(kelime);

        StringBuilder heceliKelime = new StringBuilder();
        while (matcher.find()) {
            heceliKelime.append(matcher.group(1)).append(" ");
        }

        return heceliKelime.toString().trim();
    }
}
