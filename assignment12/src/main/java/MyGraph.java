import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyGraph {
    private final int MAX_NODES_NUM = 50;
    private final int MAX_EDGES_NUM = 100;
    private final Integer MAX_WEIGHT = 9999;
    private final Integer MIN_WEIGHT = 1;

    private LinkedList<MyEdge>[] edges;

    public void readFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int nodeNum = Integer.parseInt(scanner.nextLine());
            int edgeNum = Integer.parseInt(scanner.nextLine());

            if (nodeNum > MAX_NODES_NUM) {
                String message = String.format(
                    "The number of nodes must be less than %d.",
                    MAX_NODES_NUM
                );
                scanner.close();
                throw new RuntimeException(message);
            }
            if (edgeNum > MAX_EDGES_NUM) {
                String message = String.format(
                        "The number of edges must be less than %d.",
                        MAX_EDGES_NUM);
                scanner.close();
                throw new RuntimeException(message);
            }

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

                if (nums[2] > MAX_WEIGHT || nums[2] < MIN_WEIGHT) {
                    String message = String.format(
                        "The weight value must be between %d and %d.",
                        MIN_WEIGHT, MAX_WEIGHT
                    );
                    scanner.close();
                    throw new RuntimeException(message);
                }

                this.edges[nums[0]].add(new MyEdge(nums[0], nums[1], nums[2]));
                this.edges[nums[1]].add(new MyEdge(nums[0], nums[1], nums[2]));
            }

            scanner.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found.");
            System.exit(0);
        }
        catch (NumberFormatException ex) {
            System.out.println("Input must be an integer value.");
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