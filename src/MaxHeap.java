import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap {
    private int[] a;
    private int size;

    public MaxHeap() {
    }

    public MaxHeap(int[] a) {
        this.size = a.length;
        this.a = Arrays.copyOf(a, size);
    }

    public MaxHeap(int size) {
        this.a = new int[size];
        this.size = size;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static boolean isMaxHeap(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            if ((2 * i + 1 < a.length && a[i] < a[2 * i + 1]) || (2 * i + 2 < a.length && a[i] < a[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMinHeap(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            if ((2 * i + 1 < a.length && a[i] > a[2 * i + 1]) || (2 * i + 2 < a.length && a[i] > a[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public boolean isMaxHeap() {
        for (int i = 0; i < size / 2; i++) {
            if ((2 * i + 1 < size && a[i] < a[2 * i + 1]) || (2 * i + 2 < size && a[i] < a[2 * i + 2])) {
                return false;
            }
        }
        return true;
    }

    public void buildMaxHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    public void maxHeapify(int ind) {
        int largest = ind;
        int left = 2 * ind + 1;
        int right = 2 * ind + 2;

        if (left < size && a[left] > a[largest]) {
            largest = left;
        }

        if (right < size && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != ind) {
            swap(ind, largest);
            maxHeapify(largest);
        }
    }
    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    @Override
    public String toString() {
        return "MaxHeap = " + Arrays.toString(a);
    }

    public void readFromFile(String path) {
        try (Scanner sc = new Scanner(new File(path))) {
            size = sc.nextInt();
            sc.nextLine();
            a = new int[size];
            for (int i = 0; i < size; i++) {
                a[i] = sc.nextInt();
            }
            if (!isMaxHeap()) {
                buildMaxHeap();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
