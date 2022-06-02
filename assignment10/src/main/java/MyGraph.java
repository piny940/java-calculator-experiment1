import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyGraph {
    private LinkedList<MyEdge>[] edges;

    public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int nodeNum = Integer.parseInt(scanner.nextLine());
            int edgeNum = Integer.parseInt(scanner.nextLine());

            this.edges = new LinkedList[nodeNum];

            for (int i = 0; i < nodeNum; i++) {
                this.edges[i] = new LinkedList<MyEdge>();
            }
            for (int i = 0; i < edgeNum; i++) {
                String[] chars = scanner.nextLine().split(" ");
                Integer[] nums = new Integer[chars.length];

                for (int j = 0; j < chars.length; j++) {
                    nums[j] = Integer.parseInt(chars[j]);
                }

                this.edges[nums[0]].add(new MyEdge(nums[0], nums[1], nums[2]));
                this.edges[nums[1]].add(new MyEdge(nums[0], nums[1], nums[2]));
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public LinkedList<MyEdge> getEdges(int id) {
        return this.edges[id];
    }
}