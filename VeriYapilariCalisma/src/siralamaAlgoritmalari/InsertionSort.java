package siralamaAlgoritmalari;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6};

        System.out.println("Sıralanmamış dizi:");
        printArray(array);

        insertionSort(array);

        System.out.println("\nSıralı dizi:");
        printArray(array);
    }

    // Insertion sort algoritması
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Anahtar, sıralı kısmın içinde doğru konumunu bulana kadar kaydırılır
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Diziyi ekrana yazdıran yardımcı metot
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
