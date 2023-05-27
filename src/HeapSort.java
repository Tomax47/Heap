import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort<T extends Comparable<T>> {
    public static void main(String[] args) {
        Integer[] array = readArrayFromFile("D:\\Java Projects\\Heap\\src\\heapSortNumbers.txt");
        if (array.length == 0) {
            System.out.println("Empty path!");
            return;
        }

        System.out.println("Raw Array:");
        printArray(array);

        jSortHeapsort(array);
        System.out.println("\nHeapSorted Array:");
        printArray(array);
    }

    private static <T extends Comparable<T>> void jSortHeapsort(T[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            sortHeapify(array, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            T temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            sortHeapify(array, i, 0);
        }
    }

    private static <T extends Comparable<T>> void sortHeapify(T[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }
        if (right < n && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            T tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            sortHeapify(array, n, largest);
        }
    }

    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    private static Integer[] readArrayFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] elements = line.split(" ");
            Integer[] array = new Integer[elements.length];
            for (int i = 0; i < elements.length; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }
            return array;
        } catch (IOException e) {
            System.out.println("An error occurred reading the file: " + e.getMessage());
            return new Integer[0];
        }
    }
}
