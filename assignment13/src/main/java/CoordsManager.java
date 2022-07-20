import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CoordsManager {
    private ArrayList<Coord> coords = new ArrayList<>();

    public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int coordsNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < coordsNum; i++) {
            String[] strs = scanner.nextLine().split(" ");
            Integer[] nums = new Integer[strs.length];

            for (int j = 0; j < strs.length; j++) {
            nums[j] = Integer.parseInt(strs[j]);
            }

            this.coords.add(new Coord(nums[0], nums[1], nums[2]));
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

    private Integer getSquareDistance(int longitude1, int latitude1, int longitude2, int latitude2) {
        return (int)(Math.pow(longitude2 - longitude1, 2) + Math.pow(latitude2 - latitude1, 2));
    }

    public Coord getCoord(int id) {
        for (int i = 0; i < this.coords.size(); i++) {
            Coord coord = this.coords.get(i);
            if (coord.getId() == id) {
                return coord;
            }
        }
        throw new RuntimeException("No such id coordinate exist.");
    }

    public int getClosestNode(int longitude, int latitude) {
        Integer minDistance = Integer.MAX_VALUE;
        int result = -1;

        for (Coord coord : coords) {
            Integer distance = this.getSquareDistance(longitude, latitude,
                coord.getLongitude(), coord.getLatitude());
            if (distance < minDistance) {
                result = coord.getId();
            }
        }

        return result;
    }
}
