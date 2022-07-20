import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CoordsManager {
  private ArrayList<Integer[]> coords = new ArrayList<>();

  public void readFromFile(String filename) {
    try {
      File file = new File(filename);
      Scanner scanner = new Scanner(file);
      int coordsNum = Integer.parseInt(scanner.nextLine());

      for (int i = 0; i < coordsNum; i++) {
        String[] strs = scanner.nextLine().split(" ");
        Integer[] nums = { Integer.parseInt(strs[1]), Integer.parseInt(strs[2])};

        this.coords.add(nums);
      }

      scanner.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found.");
      System.exit(0);
    } catch (NumberFormatException ex) {
      System.out.println("Input must be an integer value.");
      System.exit(0);
    } catch (RuntimeException ex) {
      System.out.println(ex.getMessage());
      System.exit(0);
    }
  }
}
