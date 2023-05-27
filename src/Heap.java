public class Heap {
    private int[] heap;
    private int size;

    public Heap() {
        heap = new int[10000];
        size = 0;
    }

    public void insert(int element) {
        heap[size] = element;
        siftUp(size);
        size++;
    }

    public int removeMin() {
        if (isEmpty()) {
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);

        return min;
    }

    public void reduceKey(int index, int newValue) {
        if (index >= 0 && index < size && newValue < heap[index]) {
            heap[index] = newValue;
            siftUp(index);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] <= heap[index]) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
    }

    private void siftDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if (smallest == index) {
                break;
            }

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
