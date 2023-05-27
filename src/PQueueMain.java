import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class PQueueMain {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("D:\\Java Projects\\Heap\\src\\maxHeapNumbers.txt"));
            FileWriter writer = new FileWriter("output.txt");

            System.out.println("The file has been created!");
            writeInFile(writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInFile(FileWriter writer) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of operations : ");
        int numOperations = scan.nextInt();

        PQueue priorityQueue = new PQueue();

        for (int i = 0; i < numOperations; i++) {
            System.out.print("Enter the operational letter : ");
            char operation = scan.next().charAt(0);
            if (operation == 'A') {
                System.out.print("Enter a number /int/ to add : ");
                int element = scan.nextInt();
                priorityQueue.addElement(element);
            } else if (operation == 'X') {
                int minElement = priorityQueue.extractMinimum();
                if (minElement == -1) {
                    writer.write("*\n");
                } else {
                    writer.write(minElement + "\n");
                }
            } else if (operation == 'D') {
                System.out.print("Enter the index of the element u wanna reduce : ");
                int index = scan.nextInt();
                System.out.print("Enter the new value : ");
                int newValue = scan.nextInt();
                priorityQueue.reduceElement(index, newValue);
            }
        }
        scan.close();
        writer.close();
    }
}
