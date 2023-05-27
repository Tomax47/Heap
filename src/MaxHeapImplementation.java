public class MaxHeapImplementation {
    public static void main(String[] args) {
        MaxHeap firstHeap= new MaxHeap(new int []{13,8,17,2,12,11,15,0,1,4,14,9 });
        System.out.println(firstHeap);
        System.out.println("First heap is a max heap : "+firstHeap.isMaxHeap());

        firstHeap.buildMaxHeap();
        System.out.println("\nModified maxHeap : "+firstHeap);
        System.out.println("First heap is a max heap : "+firstHeap.isMaxHeap());

        MaxHeap secondHeap= new MaxHeap(new int []{20, 12, 11, 7, 11, 3, 2, 1});
        System.out.println("\n\n"+secondHeap);
        System.out.println("Second heap is a max heap : "+secondHeap.isMaxHeap());


        MaxHeap thirdHeap= new MaxHeap();
        thirdHeap.readFromFile("D:\\Java Projects\\Heap\\src\\maxHeapNumbers.txt");
        System.out.println("\n\n"+thirdHeap);
        System.out.println("Third heap is a max heap : "+thirdHeap.isMaxHeap());

    }
}