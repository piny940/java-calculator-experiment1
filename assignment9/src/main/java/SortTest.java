import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class SortTest {
    private static Integer MAX_SIZE = 10000;
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();

        try {
            if (args.length < 1) {
                String message = "File name not given";
                throw new RuntimeException(message);
            }
            String fileName = args[0];
            inputArrayListFromFile(fileName, arrayList);

            if (arrayList.size() > MAX_SIZE) {
                String message = String.format(
                    "The number of texts given must be less than %d.",
                    MAX_SIZE);
                throw new RuntimeException(message);
            }

            BucketSort.sort(arrayList);
            outputArrayListToConsole(arrayList);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    private static void inputArrayListFromFile(String filename, ArrayList<String> arrayList) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String string = scanner.next();

                for (String element : string.split("\\.|,| ")) {
                    if (!element.matches("[a-zA-Z]+")) {
                        continue;
                    }
                    element = element.toLowerCase();
                    arrayList.add(element);
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found");
            System.exit(0);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    private static void outputArrayListToConsole(ArrayList<String> arrayList) {
        for (String line : arrayList) {
            System.out.println(line);
        }
    }
}
