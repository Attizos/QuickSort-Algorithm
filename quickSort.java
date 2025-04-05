import java.util.Arrays;
import java.util.Scanner;

public class quickSort {
    private static double lastExecutionTime = 0;

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int[] a, int p, int r) {
        int x = a[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            do {
                j--;
            } while (a[j] > x);

            do {
                i++;
            } while (a[i] < x);

            if (i < j) {
                swap(a, i, j);
            } else {
                return j;
            }
        }
    }

    public static void QuickSort(int[] a, int p, int r){

        if ( p < r ){
            int q = partition(a,p,r);

            QuickSort(a,p,q - 1);
            QuickSort(a,q+1,r);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj liczbę elementów: ");
        int liczba = scanner.nextInt();
        System.out.print("Podaj wartość minimalną: ");
        int min = scanner.nextInt();
        System.out.print("Podaj wartość maksymalną: ");
        int max = scanner.nextInt();

        System.out.println("Wybierz tryb generowania: ");
        System.out.println("1 - Losowo");
        System.out.println("2 - Rosnąco");
        System.out.println("3 - Malejąco");
        int wybor = scanner.nextInt();

        int[] wygenerowanaTablica;

        switch (wybor) {
            case 1 -> wygenerowanaTablica = NumGen.generateArray(liczba, min, max);
            case 2 -> wygenerowanaTablica = NumGen.generateAsc(liczba, min, max);
            case 3 -> wygenerowanaTablica = NumGen.generateDesc(liczba, min, max);
            default -> {
                System.out.println("Nieprawidłowy wybór!");
                scanner.close();
                return;
            }
        }

        System.out.println("Wygenerowany wektor: " + Arrays.toString(wygenerowanaTablica));

        long startTime = System.nanoTime();

        QuickSort(wygenerowanaTablica, 0, wygenerowanaTablica.length - 1);

        long endTime = System.nanoTime();
        lastExecutionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Wektor po sortowaniu: " + Arrays.toString(wygenerowanaTablica));

        System.out.println("Czas wykonania w milisekundach: " + lastExecutionTime);

        scanner.close();
    }
}

