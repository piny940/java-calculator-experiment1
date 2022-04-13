import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class SortTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        try {
            String fileName = args[0];
            inputArrayListFromFile(fileName, arrayList);
            BubbleSort.sort(arrayList);
            outputArrayListToConsole(arrayList);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("File name not given");
            System.exit(0);
        }
    }

    private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                Integer num = scanner.nextInt();
                arrayList.add(num);
            }
            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        }
        catch (InputMismatchException ex) {
            System.out.println("Only integers are allowed in the input file.");
            System.exit(0);
        }
    }

    private static void outputArrayListToConsole(ArrayList<Integer> arrayList) {
        Integer row = 0;
        for (Integer integer : arrayList) {
            if (row > 9) {
                System.out.println("\n");
                row = 0;
            }
            System.out.printf("%10d", integer);
            row++;
        }
        System.out.println("\n");
    }
}
