import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyGraphTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();
            int start = Integer.parseInt(scanner.nextLine());
            int end = Integer.parseInt(scanner.nextLine());
            scanner.close();

            MyGraph graph = new MyGraph();
            graph.readFromFile(filename);

            Integer[] prevs = graph.getShortestPath(start, end);
            Integer point = end;
            Integer weightSum = 0;
            ArrayList<Integer> path = new ArrayList<>();
            path.add(0, end);

            while (true) {
                if (point == start) {
                    break;
                }

                if (prevs[point] == null) {
                    String message = "The start and end points are not connected.";
                    throw new RuntimeException(message);
                }
                weightSum += graph.getWeight(point, prevs[point]);
                point = prevs[point];
                path.add(0, point);
            }

            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i == path.size() - 1) {
                    System.out.print("\n");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println(weightSum);
        }
        catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        catch (NoSuchElementException ex) {
            System.out.println("The actual number of edges given is less than the number of edges specified in the file.");
            System.exit(0);
        }
        catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
