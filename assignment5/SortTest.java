import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class SortTest {
    private static final Integer MAX_SIZE = 10000;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        try {
            String fileName = args[0];
            inputArrayListFromFile(fileName, arrayList);
            if (arrayList.size() > MAX_SIZE) {
                String message = String.format(
                    "The number of integers given must be less than or equal to %d.",
                    MAX_SIZE);
                throw new RuntimeException(message);
            }

            InsertSort.sort(arrayList);
            outputArrayListToConsole(arrayList);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("File name not given");
            System.exit(0);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    private static void inputArrayListFromFile(String filename, ArrayList<Integer> arrayList) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            System.out.println(scanner);
            while (scanner.hasNext()) {
                String strNum = scanner.next();
                Integer num = Integer.parseInt(strNum);
                arrayList.add(num);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        } catch (InputMismatchException ex) {
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
            System.out.printf("%11d", integer);
            row++;
        }
        System.out.println("\n");
    }
}
