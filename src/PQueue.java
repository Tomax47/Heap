import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PQueue {
    private Heap heap;

    public PQueue() {
        heap = new Heap();
    }

    public void addElement(int element) {
        heap.insert(element);
    }

    public int extractMinimum() {
        if (heap.isEmpty()) {
            return -1; // Return a negative value to indicate an empty queue
        }
        return heap.removeMin();
    }

    public void reduceElement(int index, int newValue) {
        heap.reduceKey(index, newValue);
    }

}
